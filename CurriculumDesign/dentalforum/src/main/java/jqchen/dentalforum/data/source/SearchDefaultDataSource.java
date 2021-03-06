package jqchen.dentalforum.data.source;

import java.util.List;

import jqchen.dentalforum.base.BaseCallBack;

/**
 * Created by jqchen on 2016/12/8.
 * Use to
 */
public interface SearchDefaultDataSource {
    interface SearchDefaultCallBack extends BaseCallBack {
        void onLoadSearchHot(List<String> hot);

        void onLoadSearchHistory(List<String> history);
    }

    interface DeleteSearchHistoryCallBack {
        void onSuccess();

        void onFail();
    }

    void getSearchHot(SearchDefaultCallBack callBack);

    void getSearchHistory(SearchDefaultCallBack callBack);

    void clearSearchHistory(DeleteSearchHistoryCallBack callBack);

    void deleteSearchHistory(String history, DeleteSearchHistoryCallBack callBack);
}
