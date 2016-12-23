package jqchen.dentalforum.data.source.repository;

import android.support.annotation.NonNull;

import jqchen.dentalforum.data.source.RecommendDataSource;
import jqchen.dentalforum.data.source.local.LocalRecommendDataSource;
import jqchen.dentalforum.data.source.remote.RemoteRecommendDataSource;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by jqchen on 2016/12/2.
 * Use to
 */
public class RecommendRepository implements RecommendDataSource {
    public static RecommendRepository INSTANCE = null;
    private LocalRecommendDataSource localRecommendDataSource;
    private RemoteRecommendDataSource remoteRecommendDataSource;

    public RecommendRepository() {
        this.localRecommendDataSource = new LocalRecommendDataSource();
        this.remoteRecommendDataSource = new RemoteRecommendDataSource();
    }

    public static RecommendRepository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new RecommendRepository();
        }
        return INSTANCE;
    }

    public static void destoryInstance() {
        INSTANCE = null;
    }

    @Override
    public void getRecommend(int page, int size, @NonNull LoadRecommendCallback callback) {
        checkNotNull(page);
        checkNotNull(size);
        checkNotNull(callback);
        this.remoteRecommendDataSource.getRecommend(page, size, callback);
    }

    @Override
    public void getBanner(LoadBannerCallBack callback) {
        this.localRecommendDataSource.getBanner(callback);
    }

}
