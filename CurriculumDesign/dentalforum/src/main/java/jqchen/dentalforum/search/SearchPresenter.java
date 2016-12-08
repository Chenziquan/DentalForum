package jqchen.dentalforum.search;

import jqchen.dentalforum.data.source.SearchDataSource;
import jqchen.dentalforum.data.source.SearchResponsitory;
import jqchen.dentalforum.library.BaseFragment;

/**
 * Created by jqchen on 2016/12/8.
 * Use to
 */
public class SearchPresenter implements SearchContract.Presenter {
    private SearchContract.View mView;

    public SearchPresenter(SearchContract.View mView) {
        this.mView = mView;
    }

    @Override
    public void search(String key) {
        SearchResponsitory.getInstance().search(key, new SearchDataSource.SearchCallBack() {
            @Override
            public void onKeyNullError() {
                mView.showKeyNullError();
            }

            @Override
            public void onSearch(BaseFragment baseFragment) {
                mView.showSearchContent(baseFragment);
            }
        });
    }

    @Override
    public void start() {
        mView.showNormal();
    }

    @Override
    public void destory() {
        SearchResponsitory.destoryInstance();
    }
}
