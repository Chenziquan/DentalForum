package jqchen.dentalforum.search;

import java.util.List;

import jqchen.dentalforum.data.source.SearchDefalutResponsitory;
import jqchen.dentalforum.data.source.SearchDefaultDataSource;

/**
 * Created by jqchen on 2016/12/8.
 * Use to
 */
public class SearchDefaultPresenter implements SearchDefaultContract.Presenter {
    private SearchDefaultContract.View mView;

    public SearchDefaultPresenter(SearchDefaultContract.View mView) {
        this.mView = mView;
    }

    @Override
    public void getSearchHot() {
        SearchDefalutResponsitory.getInstance().getSearchHot(new SearchDefaultDataSource.SearchDefaultCallBack() {
            @Override
            public void onLoadSearchHot(List<String> hot) {
                mView.showSearchHot(hot);
            }

            @Override
            public void onLoadSearchHistory(List<String> history) {

            }

            @Override
            public void onDataNotAvailable() {
                mView.showError();
            }
        });
    }

    @Override
    public void getSearchHistory() {
        SearchDefalutResponsitory.getInstance().getSearchHistory(new SearchDefaultDataSource.SearchDefaultCallBack() {
            @Override
            public void onLoadSearchHot(List<String> hot) {

            }

            @Override
            public void onLoadSearchHistory(List<String> history) {
                mView.showSearchHistory(history);
            }

            @Override
            public void onDataNotAvailable() {
                mView.showError();
            }
        });
    }

    @Override
    public void clearSearchHistory() {
        SearchDefalutResponsitory.getInstance().clearSearchHistory(new SearchDefaultDataSource.DeleteSearchHistoryCallBack() {
            @Override
            public void onSuccess() {
                getSearchHistory();
            }

            @Override
            public void onFail() {
                mView.showError();
            }
        });
    }

    @Override
    public void deleteSearchHistory(String history) {
        SearchDefalutResponsitory.getInstance().deleteSearchHistory(history, new SearchDefaultDataSource.DeleteSearchHistoryCallBack() {
            @Override
            public void onSuccess() {
                getSearchHistory();
            }

            @Override
            public void onFail() {
                mView.showError();
            }
        });
    }


    @Override
    public void start() {
        mView.showNormal();
        getSearchHot();
        getSearchHistory();
    }


    @Override
    public void destory() {
        SearchDefalutResponsitory.destoryInstance();
    }
}
