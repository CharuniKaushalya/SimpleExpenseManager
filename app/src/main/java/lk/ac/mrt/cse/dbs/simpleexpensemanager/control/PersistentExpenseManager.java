package lk.ac.mrt.cse.dbs.simpleexpensemanager.control;

import lk.ac.mrt.cse.dbs.simpleexpensemanager.control.exception.ExpenseManagerException;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.AccountDAO;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.Impl2.InDatabaseAccountDAO;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.Impl2.InDatabaseTransactinDAO;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.TransactionDAO;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.impl.InMemoryAccountDAO;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.impl.InMemoryTransactionDAO;

/**
 * Created by Charuni on 12/5/2015.
 */
public class PersistentExpenseManager extends ExpenseManager {
    @Override
    public void setup() throws ExpenseManagerException {
        TransactionDAO inDBTransactionDAO = new InDatabaseTransactinDAO();
        setTransactionsDAO(inDBTransactionDAO);

        AccountDAO inDBAccountDAO = new InDatabaseAccountDAO(this);
        setAccountsDAO(inDBAccountDAO);
    }
}
