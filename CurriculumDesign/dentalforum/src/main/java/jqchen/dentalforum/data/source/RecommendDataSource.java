package jqchen.dentalforum.data.source;

import java.util.List;

/**
 * Created by jqchen on 2016/12/2.
 * Use to
 */
public interface RecommendDataSource {
    interface LoadRecommendCallback {
        void onRecommendLoad(List<String> recommend);

        void onDataNotAvailable();
    }

    void getRecommend(int page, int size, LoadRecommendCallback callback);

    void getRecommend(LoadRecommendCallback callback);
}
