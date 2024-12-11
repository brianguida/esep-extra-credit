public class main {
    public static void main(String[] args) {
        InMemoryDB db = new InMemoryDB(); //init database

        //runs tests from project doc

        //tests
        try {
            System.out.println(db.get("A")); // should return null, because A doesn’t exist in the DB yet
            
            try {
                db.put("A", 5); // should throw an error because a transaction is not in progress
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }

            db.begin_transaction();
            db.put("A", 5);
            System.out.println(db.get("A")); // should return null, because updates to A are not committed yet
            db.put("A", 6);
            db.commit();
            System.out.println(db.get("A")); // should return 6, that was the last value of A to be committed

            try {
                db.commit();
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage()); // throws an error, because there is no open transaction
            }

            try {
                db.rollback();
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage()); // throws an error because there is no ongoing transaction
            }

            System.out.println(db.get("B")); // should return null because B does not exist in the database
            db.begin_transaction();
            db.put("B", 10);
            db.rollback();
            System.out.println(db.get("B")); // Should return null because changes to B were rolled back
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
