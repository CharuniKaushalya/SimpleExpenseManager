package lk.ac.mrt.cse.dbs.simpleexpensemanager.data.dbImpl;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Charuni on 12/5/2015.
 */
public class InDbExpenseType extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "130274U.db";
    public static final String TABLE_NAME = "expense_type";

    public InDbExpenseType(Context context) {
        super(context,DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (Id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,name TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }
}
