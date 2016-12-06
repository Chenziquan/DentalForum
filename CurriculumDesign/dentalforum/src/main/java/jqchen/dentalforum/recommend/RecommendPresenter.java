package jqchen.dentalforum.recommend;

import java.util.List;

import jqchen.dentalforum.data.source.RecommendDataSource;
import jqchen.dentalforum.data.source.RecommendResponsitory;

/**
 * Created by jqchen on 2016/12/2.
 * Use to
 */
public class RecommendPresenter implements RecommendContract.Presenter {
    private RecommendContract.View mView;
    private RecommendResponsitory mRecommendResponsitory;

    public RecommendPresenter(RecommendContract.View mView) {
        this.mView = mView;
        this.mRecommendResponsitory = new RecommendResponsitory();
    }

    @Override
    public void getRecommend(int page, int size, final boolean isRefresh) {
        mRecommendResponsitory.getRecommend(page, size, new RecommendDataSource.LoadRecommendCallback() {
            @Override
            public void onRecommendLoad(List<String> recommend) {
                if (isRefresh) {
                    mView.refresh(recommend);
                } else {
                    mView.load(recommend);
                }
                mView.showNormal();
            }

            @Override
            public void onDataNotAvailable() {
                if (isRefresh) {
                    mView.showError();
                }
            }
        });
    }

    @Override
    public void start() {
        getRecommend(1, 10, true);
    }

    @Override
    public void destory() {
        RecommendResponsitory.destoryInstance();
    }
}
