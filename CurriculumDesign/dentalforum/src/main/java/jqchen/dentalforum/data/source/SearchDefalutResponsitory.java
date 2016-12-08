package jqchen.dentalforum.data.source;

import jqchen.dentalforum.data.source.local.LocalSearchDefaultDataSource;
import jqchen.dentalforum.data.source.remote.RemoteSearchDefaultDataSource;

/**
 * Created by jqchen on 2016/12/8.
 * Use to
 */
public class SearchDefalutResponsitory implements SearchDefaultDataSource {
    private static SearchDefalutResponsitory Instance;
    private LocalSearchDefaultDataSource localSearchDefaultDataSource;
    private RemoteSearchDefaultDataSource remoteSearchDefaultDataSource;

    public SearchDefalutResponsitory() {
        this.localSearchDefaultDataSource = new LocalSearchDefaultDataSource();
        this.remoteSearchDefaultDataSource = new RemoteSearchDefaultDataSource();
    }

    public static SearchDefalutResponsitory getInstance() {
        if (Instance == null) {
            Instance = new SearchDefalutResponsitory();
        }
        return Instance;
    }

    public static void destoryInstance() {
        Instance = null;
    }

    @Override
    public void getSearchHot(SearchDefaultCallBack callBack) {
        remoteSearchDefaultDataSource.getSearchHot(callBack);
    }

    @Override
    public void getSearchHistory(SearchDefaultCallBack callBack) {
        localSearchDefaultDataSource.getSearchHistory(callBack);
    }

    @Override
    public void clearSearchHistory(DeleteSearchHistoryCallBack callBack) {
        localSearchDefaultDataSource.clearSearchHistory(callBack);
    }

    @Override
    public void deleteSearchHistory(String history, DeleteSearchHistoryCallBack callBack) {
        localSearchDefaultDataSource.deleteSearchHistory(history, callBack);
    }
}
