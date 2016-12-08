package jqchen.dentalforum.data.source.remote;

import java.util.ArrayList;
import java.util.List;

import jqchen.dentalforum.data.source.SearchDefaultDataSource;

/**
 * Created by jqchen on 2016/12/8.
 * Use to
 */
public class RemoteSearchDefaultDataSource implements SearchDefaultDataSource {
    @Override
    public void getSearchHot(SearchDefaultCallBack callBack) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            list.add("热门搜索"+i);
        }
        callBack.onLoadSearchHot(list);
    }

    @Override
    public void getSearchHistory(SearchDefaultCallBack callBack) {

    }

    @Override
    public void clearSearchHistory(DeleteSearchHistoryCallBack callBack) {

    }

    @Override
    public void deleteSearchHistory(String history, DeleteSearchHistoryCallBack callBack) {

    }
}
