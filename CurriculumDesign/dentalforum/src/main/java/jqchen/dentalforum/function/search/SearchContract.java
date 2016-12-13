package jqchen.dentalforum.function.search;

import jqchen.dentalforum.base.BasePresenter;
import jqchen.dentalforum.base.BaseView;
import jqchen.dentalforum.library.BaseFragment;

/**
 * Created by jqchen on 2016/12/8.
 * Use to
 */
public interface SearchContract {
    interface View extends BaseView {
        void showKeyNullError();

        void showSearchContent(BaseFragment baseFragment);
    }

    interface Presenter extends BasePresenter {
        void search(String key);
    }
}
