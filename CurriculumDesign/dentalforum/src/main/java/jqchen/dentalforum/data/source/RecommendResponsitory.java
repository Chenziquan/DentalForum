package jqchen.dentalforum.data.source;

import jqchen.dentalforum.data.source.local.LocalRecommendDataSource;
import jqchen.dentalforum.data.source.remote.RemoteRecommendDataSource;

/**
 * Created by jqchen on 2016/12/2.
 * Use to
 */
public class RecommendResponsitory implements RecommendDataSource {
    public static RecommendResponsitory INSTANCE = null;
    private LocalRecommendDataSource localRecommendDataSource;
    private RemoteRecommendDataSource remoteRecommendDataSource;

    public RecommendResponsitory() {
        this.localRecommendDataSource = new LocalRecommendDataSource();
        this.remoteRecommendDataSource = new RemoteRecommendDataSource();
    }

    public static RecommendResponsitory getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new RecommendResponsitory();
        }
        return INSTANCE;
    }

    public static void destoryInstance(){
        INSTANCE = null;
    }

    @Override
    public void getRecommend(int page, int size, LoadRecommendCallback callback) {
        localRecommendDataSource.getRecommend(page, size, callback);
    }

    @Override
    public void getRecommend(LoadRecommendCallback callback) {
        localRecommendDataSource.getRecommend(callback);
    }
}
