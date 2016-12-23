package jqchen.dentalforum.frame.recommend;

import java.util.List;

import jqchen.dentalforum.base.BasePresenter;
import jqchen.dentalforum.base.BaseView;
import jqchen.dentalforum.data.bean.RecommendBean;

/**
 * Created by jqchen on 2016/12/1.
 * Use to
 */
public interface RecommendContract {
    //    推荐的view 刷新 加载 显示网络错误 显示正常
    interface View extends BaseView {
        void refresh(List<RecommendBean> list);

        void load(List<RecommendBean> list);

        void onLoadFinish();

        void setBanner(List<String> banner);
    }

    interface Presenter extends BasePresenter {
        void getRecommend(int page, int size, boolean isRefresh);

        void getBanner();
    }
}
