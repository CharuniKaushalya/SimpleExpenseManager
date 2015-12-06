package lk.ac.mrt.cse.dbs.simpleexpensemanager.data.Impl2;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.TransactionDAO;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.dbImpl.MySQLiteHelper;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.model.Account;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.model.ExpenseType;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.model.Transaction;

/**
 * Created by Charuni on 12/5/2015.
 */
public class InDatabaseTransactinDAO implements TransactionDAO {

    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;
    private String[] allColumns = { MySQLiteHelper.T3_COL_1,
            MySQLiteHelper.T3_COL_2, MySQLiteHelper.T3_COL_3,MySQLiteHelper.T3_COL_4 ,MySQLiteHelper.T3_COL_5};

    @Override
    public void logTransaction(Date date, String accountNo, ExpenseType expenseType, double amount) {

    }

    @Override
    public List<Transaction> getAllTransactionLogs() {
        List<Transaction> tansactions = new ArrayList<Transaction>();

        Cursor cursor = database.query(MySQLiteHelper.TABLE_NAME_1,
                allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Transaction tansaction = cursorToTransaction(cursor);
            tansactions.add(tansaction);
            cursor.moveToNext();
        }
        // make sure to close the cursor
        cursor.close();
        return tansactions;
    }

    private Transaction cursorToTransaction(Cursor cursor) {
        Transaction tansaction = new Transaction(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getDouble(3));
        return tansaction;
    }

    @Override
    public List<Transaction> getPaginatedTransactionLogs(int limit) {
        return null;
    }
}
