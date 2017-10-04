package developer.xander.android_mvp_architecture.data.local;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by tony on 4/10/17.
 */

public class DbSqLiteHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "Astrology.db";

    private static final String TEXT_TYPE = " TEXT";
    private static final String TEXT_TYPE_NOT_NULL = " TEXT NOT NULL";
    private static final String COMMA_SEP = ", ";



    private static final String SCRIPT_CREATE_TABLE_SAMPLE =
            "CREATE TABLE " + DbColumnsHelper.Sample.TABLE_NAME + " (" +
                    DbColumnsHelper.Sample.COLUMN_NAME_ENTRY_ID + TEXT_TYPE + " PRIMARY KEY, " +
                    DbColumnsHelper.Sample.COLUMN_NAME_TITLE + TEXT_TYPE_NOT_NULL + COMMA_SEP +
                    DbColumnsHelper.Sample.COLUMN_NAME_TITLE + TEXT_TYPE +
                    " )";


    public DbSqLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }
}
