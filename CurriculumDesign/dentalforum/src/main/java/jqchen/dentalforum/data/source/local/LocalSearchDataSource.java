package jqchen.dentalforum.data.source.local;

import android.os.Bundle;
import android.text.TextUtils;

import jqchen.dentalforum.data.source.SearchDataSource;
import jqchen.dentalforum.data.sqlite.SearchHistoryDataBase;
import jqchen.dentalforum.function.search.search_content.SearchContentFragment;

/**
 * Created by jqchen on 2016/12/8.
 * Use to
 */
public class LocalSearchDataSource implements SearchDataSource {
    @Override
    public void search(String key, SearchCallBack callBack) {
        if (TextUtils.isEmpty(key)) {
            callBack.onKeyNullError();
            return;
        }
        if (SearchHistoryDataBase.getInstance().InsertSearchHistory(key)) {
            SearchHistoryDataBase.destoryInstance();
        }
        Bundle bundle = new Bundle();
        bundle.putString("search_key", key);
        SearchContentFragment contentFragment = new SearchContentFragment();
        contentFragment.setArguments(bundle);
        callBack.onSearch(contentFragment);
    }
}
