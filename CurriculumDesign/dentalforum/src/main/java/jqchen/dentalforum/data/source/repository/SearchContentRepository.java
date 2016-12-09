package jqchen.dentalforum.data.source.repository;

import jqchen.dentalforum.data.source.SearchContentDataSource;
import jqchen.dentalforum.data.source.local.LocalSearchContentDataSource;
import jqchen.dentalforum.data.source.remote.RemoteSearchContentDataSource;

/**
 * Created by jqchen on 2016/12/9.
 * Use to
 */
public class SearchContentRepository implements SearchContentDataSource {
    private static SearchContentRepository Instance;
    private LocalSearchContentDataSource localSearchContentDataSource;
    private RemoteSearchContentDataSource remoteSearchContentDataSource;

    public static SearchContentRepository getInstance() {
        if (Instance == null) {
            Instance = new SearchContentRepository();
        }
        return Instance;
    }

    public static void destoryInstance() {
        Instance = null;
    }

    public SearchContentRepository() {
        this.localSearchContentDataSource = new LocalSearchContentDataSource();
        this.remoteSearchContentDataSource = new RemoteSearchContentDataSource();
    }

    @Override
    public void getSearchContent(int page, int size, String key, SearchContentCallBack callBack) {
        localSearchContentDataSource.getSearchContent(page, size, key, callBack);
    }
}
