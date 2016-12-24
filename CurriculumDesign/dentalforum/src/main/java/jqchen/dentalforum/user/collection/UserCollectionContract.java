package jqchen.dentalforum.user.collection;

import java.util.List;

import jqchen.dentalforum.base.BasePresenter;
import jqchen.dentalforum.base.BaseView;
import jqchen.dentalforum.data.bean.PostBean;

/**
 * Created by jqchen on 2016/12/21.
 * Use to
 */
public interface UserCollectionContract {
    interface View extends BaseView {
        void userCollectionRefresh(List<PostBean> list);

        void userCollectionLoad(List<PostBean> list);

        void onLoadFinish();
    }

    interface Presenter extends BasePresenter {
        void getUserCollection(int page, int size, boolean isRefresh);
    }
}
