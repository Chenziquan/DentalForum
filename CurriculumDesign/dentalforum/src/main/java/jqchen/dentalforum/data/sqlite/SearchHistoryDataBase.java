package jqchen.dentalforum.data.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import jqchen.dentalforum.app.MyApplication;
import jqchen.dentalforum.data.bean.SearchHistory;

/**
 * Created by jqchen on 2016/12/8.
 * Use to
 */
public class SearchHistoryDataBase {
    private static SearchHistoryDataBase Instance;
    private SearchHistoryHelper historyHelper;
    private SQLiteDatabase sqLiteDatabase;

    public SearchHistoryDataBase(Context context) {
        historyHelper = new SearchHistoryHelper(context);
    }

    public static SearchHistoryDataBase getInstance() {
        if (Instance == null) {
            Instance = new SearchHistoryDataBase(MyApplication.getInstance());
        }
        return Instance;
    }

    public static void destoryInstance() {
        Instance = null;
    }

    private boolean insert(String content) {
        sqLiteDatabase = historyHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SearchHistory.SEARCH_CONTENT, content);
        contentValues.put(SearchHistory.SEARCH_TIME, String.valueOf(System.currentTimeMillis()));
        sqLiteDatabase.insert(SearchHistory.TABLE_NAME, null, contentValues);
        return true;
    }

    public boolean delete(String content) {
        sqLiteDatabase = historyHelper.getWritableDatabase();
        String where = "" + SearchHistory.SEARCH_CONTENT +
                " = ?";
        sqLiteDatabase.delete(SearchHistory.TABLE_NAME, where, new String[]{content});
        return true;
    }

    public boolean clear() {
        sqLiteDatabase = historyHelper.getWritableDatabase();
        sqLiteDatabase.delete(SearchHistory.TABLE_NAME, null, null);
        return true;
    }

    private boolean isContain(String content) {
        sqLiteDatabase = historyHelper.getReadableDatabase();
        String sql = "SELECT * FROM " + SearchHistory.TABLE_NAME +
                " WHERE " + SearchHistory.SEARCH_CONTENT +
                " = ?";
        Cursor cursor = sqLiteDatabase.rawQuery(sql, new String[]{content});
        if (cursor.moveToFirst()) {
            cursor.close();
            return true;
        } else {
            cursor.close();
            return false;
        }
    }

    public List<String> getSearchHistory() {
        List<String> strings = new ArrayList<>();
        sqLiteDatabase = historyHelper.getReadableDatabase();
        String sql = "SELECT " + SearchHistory.SEARCH_CONTENT +
                " FROM " + SearchHistory.TABLE_NAME +
                " ORDER BY " + SearchHistory.SEARCH_TIME +
                " DESC";
        Cursor cursor = sqLiteDatabase.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            strings.add(cursor.getString(cursor.getColumnIndex(SearchHistory.SEARCH_CONTENT)));
        }
        cursor.close();
        return strings;
    }

    private boolean update(String previous, String current) {
        sqLiteDatabase = historyHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SearchHistory.SEARCH_CONTENT, current);
        contentValues.put(SearchHistory.SEARCH_TIME, String.valueOf(System.currentTimeMillis()));
        String where = "" + SearchHistory.SEARCH_CONTENT +
                " = ?";
        sqLiteDatabase.update(SearchHistory.TABLE_NAME, contentValues, where, new String[]{previous});
        return true;
    }

    public boolean InsertSearchHistory(String content) {
        if (isContain(content)) {
            return update(content, content);
        } else {
            List<String> list = getSearchHistory();
            if (list.size() >= SearchHistory.SEARCH_NUM) {
                return update(list.get(list.size() - 1), content);
            } else {
                insert(content);
                return true;
//                return insert(content);
            }
        }
    }
}
