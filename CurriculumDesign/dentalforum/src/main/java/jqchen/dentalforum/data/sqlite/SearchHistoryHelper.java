package jqchen.dentalforum.data.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import jqchen.dentalforum.data.bean.SearchHistory;

/**
 * Created by jqchen on 2016/12/8.
 * Use to
 */
public class SearchHistoryHelper extends SQLiteOpenHelper {
    private static final String NAME = "search.db";
    private static final int VERSION = 1;
    private static final String CREATE_TABLE = "CREATE TABLE " + SearchHistory.TABLE_NAME +
            " (" + SearchHistory.SEARCH_ID +
            " INTEGER PRIMARY KEY AUTOINCREMENT," + SearchHistory.SEARCH_CONTENT +
            " TEXT," + SearchHistory.SEARCH_TIME +
            "TEXT)";

    public SearchHistoryHelper(Context context) {
        super(context, NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
