package jqchen.dentalforum.data.source;

import jqchen.dentalforum.data.source.local.LocalSearchDataSource;
import jqchen.dentalforum.data.source.remote.RemoteSearchDataSource;

/**
 * Created by jqchen on 2016/12/8.
 * Use to
 */
public class SearchResponsitory implements SearchDataSource {
    private static SearchResponsitory INSTANCE;
    private LocalSearchDataSource localSearchDataSource;
    private RemoteSearchDataSource remoteSearchDataSource;

    public SearchResponsitory() {
        this.localSearchDataSource = new LocalSearchDataSource();
        this.remoteSearchDataSource = new RemoteSearchDataSource();
    }

    public static SearchResponsitory getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SearchResponsitory();
        }
        return INSTANCE;
    }

    public static void destoryInstance() {
        INSTANCE = null;
    }

    @Override
    public void search(String key, SearchCallBack callBack) {
        localSearchDataSource.search(key, callBack);
    }
}
