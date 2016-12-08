package jqchen.dentalforum.search;

import java.util.List;

import jqchen.dentalforum.base.BasePresenter;
import jqchen.dentalforum.base.BaseView;

/**
 * Created by jqchen on 2016/12/8.
 * Use to
 */
public interface SearchDefaultContract {
    interface View extends BaseView {
        void showSearchHot(List<String> hot);


        void showSearchHistory(List<String> history);

    }

    interface Presenter extends BasePresenter {
        void getSearchHot();

        void getSearchHistory();

        void clearSearchHistory();

        void deleteSearchHistory(String history);
    }
}
