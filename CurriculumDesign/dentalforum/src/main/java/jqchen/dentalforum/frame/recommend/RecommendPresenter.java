package jqchen.dentalforum.frame.recommend;

import java.util.List;

import jqchen.dentalforum.data.bean.ADListModel;
import jqchen.dentalforum.data.source.RecommendDataSource;
import jqchen.dentalforum.data.source.repository.RecommendRepository;

/**
 * Created by jqchen on 2016/12/2.
 * Use to
 */
public class RecommendPresenter implements RecommendContract.Presenter {
    private RecommendContract.View mView;
    private RecommendRepository mRecommendResponsitory;

    public RecommendPresenter(RecommendContract.View mView) {
        this.mView = mView;
        this.mRecommendResponsitory = new RecommendRepository();
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
            public void onBannerLoad(List<ADListModel.InfoBean> banner) {

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
    public void getBanner() {
        mRecommendResponsitory.getBanner(new RecommendDataSource.LoadRecommendCallback() {
            @Override
            public void onRecommendLoad(List<String> recommend) {

            }

            @Override
            public void onBannerLoad(List<ADListModel.InfoBean> banner) {
                mView.setBanner(banner);
            }

            @Override
            public void onDataNotAvailable() {

            }
        });
    }

    @Override
    public void start() {
        getRecommend(1, 10, true);
        getBanner();
    }

    @Override
    public void destory() {
        RecommendRepository.destoryInstance();
    }
}
