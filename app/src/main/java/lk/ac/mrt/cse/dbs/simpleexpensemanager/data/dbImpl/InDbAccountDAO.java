package lk.ac.mrt.cse.dbs.simpleexpensemanager.data.dbImpl;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.AccountDAO;

/**
 * Created by Charuni on 12/5/2015.
 */
public class InDbAccountDAO extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "130274U.db";
    public static final String TABLE_NAME = "account_table";
    public static final String COL_1 = "accountNo";
    public static final String COL_2 = "bankName";
    public static final String COL_3 = "accountHolderName";
    public static final String COL_4 = "balance";
    public InDbAccountDAO(Context context) {
        super(context,DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (accountNo VARCHAR(45) PRIMARY KEY NOT NULL,bank TEXT,accountHolderName TEXT,balance DOUBLE)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }
}
