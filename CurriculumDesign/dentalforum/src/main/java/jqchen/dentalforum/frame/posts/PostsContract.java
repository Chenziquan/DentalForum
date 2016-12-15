package jqchen.dentalforum.frame.posts;

import java.util.List;

import jqchen.dentalforum.base.BasePresenter;
import jqchen.dentalforum.base.BaseView;
import jqchen.dentalforum.data.bean.PostBean;

/**
 * Created by jqchen on 2016/12/9.
 * Use to
 */
public interface PostsContract {
    interface View extends BaseView {
        void refresh(List<PostBean> posts);

        void load(List<PostBean> posts);

        void setHeader(List<String> header);
    }

    interface Presenter extends BasePresenter {
        void getPost(int page, int size, boolean isRefresh);

        void getHeader();
    }

}
