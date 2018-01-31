package by.testsqlite1.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Home911 on 23.01.2018.
 */

public class HotelDBHelper extends SQLiteOpenHelper {

    public static final String LOG_TAG = HotelDBHelper.class.getSimpleName();

    private static final String DATABASE_NAME = "hotel.db";     // imia faila DB
    private static final int DATABASE_VERSION = 1;      //

    public HotelDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        // Stroka dla sozdanija tablicy
        String SQL_CREATE_GUESTS_TABLE = "CREATE TABLE" + HotelContract.GuestEntry.TABLE_NAME + " ("
                + HotelContract.GuestEntry._ID + "INTEGER PRIMARY KEY AUTOINCREMENT, "
                + HotelContract.GuestEntry.COLUMN_NAME + " TEXT NOT NULL, "
                + HotelContract.GuestEntry.COLUMN_CITY + " TEXT NOT NULL, "
                + HotelContract.GuestEntry.COLUMN_GENDER + " INTEGER NOT NULL DEFAULT 3, "
                + HotelContract.GuestEntry.COLUMN_AGE + " INTEGER NOT NULL DEFAULT 0);";
        db.execSQL(SQL_CREATE_GUESTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
