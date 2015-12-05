package lk.ac.mrt.cse.dbs.simpleexpensemanager.data.dbImpl;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Charuni on 12/5/2015.
 */

public class InDbTransaction extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "130274U.db";
    public static final String TABLE_NAME = "transaction";

    public InDbTransaction(Context context) {
        super(context,DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (transactionID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,amount DOUBLE,date DATE,FOREIGN KEY (accountNo) REFERENCES account(accountNo),FOREIGN KEY (expense_type_id) REFERENCES expense_type(Id))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }
}
