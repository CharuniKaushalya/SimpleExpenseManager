package lk.ac.mrt.cse.dbs.simpleexpensemanager.data.Impl2;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.AccountDAO;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.dbImpl.MySQLiteHelper;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.exception.InvalidAccountException;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.model.Account;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.model.ExpenseType;

/**
 * Created by Charuni on 12/5/2015.
 */
public class InDatabaseAccountDAO implements AccountDAO {
    private final Map<String, Account> accounts;
    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;
    private String[] allColumns = { MySQLiteHelper.T1_COL_1,
            MySQLiteHelper.T1_COL_2, MySQLiteHelper.T1_COL_3,MySQLiteHelper.T1_COL_4};
    private String[] accColumn = { MySQLiteHelper.T1_COL_1};

    public InDatabaseAccountDAO(Context context) {
        accounts = null;
        dbHelper = new MySQLiteHelper(context);
    }

    @Override
    public List<String> getAccountNumbersList() {
        List<String> accounts = new ArrayList<String>();

        Cursor cursor = database.query(MySQLiteHelper.TABLE_NAME_1,
                accColumn , null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String account = cursor.getString(0);
            accounts.add(account);
            cursor.moveToNext();
        }
        // make sure to close the cursor
        cursor.close();
        return accounts;
    }

    @Override
    public List<Account> getAccountsList() {
        List<Account> accounts = new ArrayList<Account>();

        Cursor cursor = database.query(MySQLiteHelper.TABLE_NAME_1,
                allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Account account = cursorToAccount(cursor);
            accounts.add(account);
            cursor.moveToNext();
        }
        // make sure to close the cursor
        cursor.close();
        return accounts;
    }
    private Account cursorToAccount(Cursor cursor) {
        Account comment = new Account(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getDouble(3));
        return comment;
    }

    @Override
    public Account getAccount(String accountNo) throws InvalidAccountException {
        return null;
    }

    @Override
    public void addAccount(Account account) {

    }

    @Override
    public void removeAccount(String accountNo) throws InvalidAccountException {

    }

    @Override
    public void updateBalance(String accountNo, ExpenseType expenseType, double amount) throws InvalidAccountException {

    }
}
