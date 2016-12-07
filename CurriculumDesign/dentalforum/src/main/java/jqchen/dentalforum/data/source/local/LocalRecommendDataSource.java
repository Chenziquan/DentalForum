package jqchen.dentalforum.data.source.local;

import java.util.ArrayList;
import java.util.List;

import jqchen.dentalforum.data.source.RecommendDataSource;

/**
 * Created by jqchen on 2016/12/2.
 * Use to
 */
public class LocalRecommendDataSource implements RecommendDataSource {

    @Override
    public void getRecommend(int page, int size, LoadRecommendCallback callback) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add("位置" + i);
        }
        callback.onRecommendLoad(list);
    }

    @Override
    public void getRecommend(LoadRecommendCallback callback) {
        getRecommend(1, 10, callback);
    }

    @Override
    public void getBanner(LoadRecommendCallback callback) {

    }
}
