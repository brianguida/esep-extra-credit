**In Memory Key-Value Database**  
This project implements an in-memory key-value database with transaction support in Java. This project allows users to perform
basic operations such as storing and retrieving data from a database as wel as managing transactions.

Features:  
- Key-Value Storage:
    - Keys are of type String and Values are of type Integer.
    - Allows for the creating, updating, and retrieving of key-value pairs.

- Transaction Support:
    - `begin_transaction()` starts transactions
    - `put(key, value)` makes changes to the transaction
    - `get(key)` can be called at any time, returns the value associated with the given key
    - `commit()` commits changes to mainState database
    - `rollback()` aborts changes before they are committed to mainState

How to Run
Requirements:
    - Java 17 or later
    - IDE or terminal with javac and java commands available

Steps to Run:  
1. Clone this repository  
`git clone https://github.com/brianguida/esep-extra-credit.git`

2. cd into the repository directory  
`cd esep-extra-credit`

3. Compile the code using terminal  
`javac main.java inMemoryDB.java`

4. Run the program  
`java main`

5. Observe the output in terminal. main.java is currently set to perform the tests from the project documentation.

How to Test:  
Edit main.java, ensure you recompile before running `java main` again!

Improvements:  
This assignment is a great way to test everything we've learned this semester with creating a github repo, adding/committing to it, and testing code.  
If this assignment were to become an official assignment consider adding the following:  
    - Implement a delete(key) method to remove key-value pairs from the database (should only perform operations on mainState)
    - Provide more test scenarios or require the creation of additional test units