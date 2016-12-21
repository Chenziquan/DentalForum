package jqchen.dentalforum.user.posts;

import java.util.List;

import jqchen.dentalforum.base.BasePresenter;
import jqchen.dentalforum.base.BaseView;
import jqchen.dentalforum.data.bean.UserPostsBean;

/**
 * Created by jqchen on 2016/12/20.
 * Use to
 */
public interface UserPostsContract {
    interface View extends BaseView {
        void userPostsRefresh(List<UserPostsBean> list);

        void userPostsLoad(List<UserPostsBean> list);
    }

    interface Presenter extends BasePresenter {
        void getUserPosts(int page, int size, boolean isRefresh);
    }
}
