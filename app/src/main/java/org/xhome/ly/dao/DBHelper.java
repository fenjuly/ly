package org.xhome.ly.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by liurongchan on 14/10/26.
 */
public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "case1.db";

    private static final int VERSION = 1;

    public DBHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Case1DataHelper.Case1DB.TABLE.create(sqLiteDatabase);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }
}
