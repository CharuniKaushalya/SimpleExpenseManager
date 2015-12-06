package lk.ac.mrt.cse.dbs.simpleexpensemanager.data.dbImpl;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Charuni on 12/5/2015.
 */
public class MySQLiteHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "130274U.db";
    public static final String TABLE_NAME_1 = "account";
    public static final String TABLE_NAME_2 = "transaction";
    public static final String TABLE_NAME_3 = "expense_type";

    public static final String T1_COL_1 = "accountNo";
    public static final String T1_COL_2 = "bank";
    public static final String T1_COL_3 = "accountHolderName";
    public static final String T1_COL_4 = "balance";

    public static final String T3_COL_1 = "transactionID";
    public static final String T3_COL_2 = "amount";
    public static final String T3_COL_3 = "date";
    public static final String T3_COL_4 = "accountNo";
    public static final String T3_COL_5 = "expense_type_id";

    public MySQLiteHelper(Context context) {
        super(context,DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME_1 +" (accountNo VARCHAR(45) PRIMARY KEY NOT NULL,bank TEXT,accountHolderName TEXT,balance DOUBLE)");
        db.execSQL("create table " + TABLE_NAME_3 +" (Id INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,name TEXT)");
        db.execSQL("create table " + TABLE_NAME_2 +" (transactionID INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,amount DOUBLE,date DATE,FOREIGN KEY (accountNo) REFERENCES account(accountNo),FOREIGN KEY (expense_type_id) REFERENCES expense_type(Id))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME_1);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME_3);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME_2);
        onCreate(db);
    }
}
