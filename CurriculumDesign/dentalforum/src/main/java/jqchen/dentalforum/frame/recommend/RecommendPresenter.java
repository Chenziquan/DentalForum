package jqchen.dentalforum.frame.recommend;

import java.util.List;

import jqchen.dentalforum.data.bean.RecommendBean;
import jqchen.dentalforum.data.source.RecommendDataSource;
import jqchen.dentalforum.data.source.repository.RecommendRepository;

/**
 * Created by jqchen on 2016/12/2.
 * Use to
 */
public class RecommendPresenter implements RecommendContract.Presenter {
    private RecommendContract.View mView;

    public RecommendPresenter(RecommendContract.View mView) {
        this.mView = mView;
    }

    @Override
    public void getRecommend(int page, int size, final boolean isRefresh) {
        RecommendRepository.getInstance().getRecommend(page, size, new RecommendDataSource.LoadRecommendCallback() {
            @Override
            public void onRecommendLoad(List<RecommendBean> recommend) {
                if (isRefresh){
                    mView.refresh(recommend);
                }else {
                    mView.load(recommend);
                }
            }

            @Override
            public void onRecommendFinish() {
                mView.onLoadFinish();
            }

            @Override
            public void onDataNotAvailable() {
                mView.showError();
            }
        });
    }

    @Override
    public void getBanner() {
        RecommendRepository.getInstance().getBanner(new RecommendDataSource.LoadBannerCallBack() {
            @Override
            public void onBannerLoad(List<String> banner) {
                mView.setBanner(banner);
            }

            @Override
            public void onDataNotAvailable() {
                mView.showError();
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
