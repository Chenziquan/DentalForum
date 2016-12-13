package jqchen.dentalforum.function.search.search_content;

import java.util.List;

import jqchen.dentalforum.data.source.SearchContentDataSource;
import jqchen.dentalforum.data.source.repository.SearchContentRepository;

/**
 * Created by jqchen on 2016/12/9.
 * Use to
 */
public class SearchContentPresenter implements SearchContentContract.Presenter {
    private SearchContentContract.View mView;

    public SearchContentPresenter(SearchContentContract.View mView) {
        this.mView = mView;
    }

    @Override
    public void getSearchContent(int page, int size, final boolean isRefresh, String key) {
        SearchContentRepository.getInstance().getSearchContent(page, size, key, new SearchContentDataSource.SearchContentCallBack() {
            @Override
            public void onSearchContentLoad(List<String> content) {
                if (isRefresh){
                    mView.refresh(content);
                }else {
                    mView.load(content);
                }
                mView.showNormal();
            }

            @Override
            public void onDataNotAvailable() {
                mView.showError();
            }
        });
    }

    @Override
    public void start() {

    }

    @Override
    public void destory() {
        SearchContentRepository.destoryInstance();
    }
}
