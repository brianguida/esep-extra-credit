import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TransferQueue;

public class InMemoryDB {
    private Map<String, Integer> mainState = new HashMap();
    private Map<String, Integer> transactionState = null; //default

    public void begin_transaction() {
        //check if transaction is currently going on
        if(transactionState != null) {
            throw new IllegalStateException("Transaction currently in progress.");
        } else {
            transactionState = new HashMap<>(); //create a new state
        }
    }

    public void put(String key, int value) {
        //check if transaction in progress
        if(transactionState != null) {
            transactionState.put(key, value); //java HashMap creates a new key if one isn't provided
        } else {
            throw new IllegalStateException("No transaction currently in progress.");
        }
    }

    public Integer get(String key) {
        //can be called anytime, no need to check transactionState
        //if key can't be found return null
        return mainState.getOrDefault(key, null); //finds key, if no key found returns null
    }

    public void commit() {
        //check if transaction in progress
        if(transactionState != null) {
            //update mainState
            mainState.putAll(transactionState);

            //reset transactionState
            transactionState = null;
        } else {
            throw new IllegalStateException("No transaction in progress.");
        }
    }

    public void rollback() {
        //check if transaction in progress
        if(transactionState != null) {
            transactionState = null; //reset transactionState
        } else {
            throw new IllegalStateException("No transaction in progress.");
        }
    }
}