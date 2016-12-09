package jqchen.dentalforum.search.search_content;

import java.util.List;

import jqchen.dentalforum.base.BasePresenter;
import jqchen.dentalforum.base.BaseView;

/**
 * Created by jqchen on 2016/12/9.
 * Use to
 */
public interface SearchContentContract {
    interface View extends BaseView {
        void refresh(List<String> content);

        void load(List<String> content);
    }

    interface Presenter extends BasePresenter {
        void getSearchContent(int page, int size, boolean isRefresh, String key);
    }
}
