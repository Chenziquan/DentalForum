package jqchen.dentalforum.data.source.local;

import jqchen.dentalforum.data.source.SearchDefaultDataSource;
import jqchen.dentalforum.data.sqlite.SearchHistoryDataBase;

/**
 * Created by jqchen on 2016/12/8.
 * Use to
 */
public class LocalSearchDefaultDataSource implements SearchDefaultDataSource {
    @Override
    public void getSearchHot(SearchDefaultCallBack callBack) {

    }

    @Override
    public void getSearchHistory(SearchDefaultCallBack callBack) {
        callBack.onLoadSearchHistory(SearchHistoryDataBase.getInstance().getSearchHistory());
        SearchHistoryDataBase.destoryInstance();
    }

    @Override
    public void clearSearchHistory(DeleteSearchHistoryCallBack callBack) {
        if (SearchHistoryDataBase.getInstance().clear()){
            callBack.onSuccess();
        }else {
            callBack.onFail();
        }
        SearchHistoryDataBase.destoryInstance();
    }

    @Override
    public void deleteSearchHistory(String history, DeleteSearchHistoryCallBack callBack) {
        if (SearchHistoryDataBase.getInstance().delete(history)){
            callBack.onSuccess();
        }else {
            callBack.onFail();
        }
        SearchHistoryDataBase.destoryInstance();
    }
}
