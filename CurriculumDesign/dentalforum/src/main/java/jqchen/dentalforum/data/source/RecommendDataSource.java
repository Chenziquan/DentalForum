package jqchen.dentalforum.data.source;

import java.util.List;

import jqchen.dentalforum.base.BaseCallBack;
import jqchen.dentalforum.data.bean.RecommendBean;

/**
 * Created by jqchen on 2016/12/2.
 * Use to
 */
public interface RecommendDataSource {

    interface LoadRecommendCallback extends BaseCallBack {
        void onRecommendLoad(List<RecommendBean> recommend);
        void onRecommendFinish();
    }

    interface LoadBannerCallBack extends BaseCallBack {
        void onBannerLoad(List<String> banner);
    }

    void getRecommend(int page, int size, LoadRecommendCallback callback);


    void getBanner(LoadBannerCallBack callback);
}
