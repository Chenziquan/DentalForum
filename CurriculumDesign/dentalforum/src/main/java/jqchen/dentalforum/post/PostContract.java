package jqchen.dentalforum.post;

import java.util.List;

import jqchen.dentalforum.base.BasePresenter;
import jqchen.dentalforum.base.BaseView;

/**
 * Created by jqchen on 2016/12/9.
 * Use to
 */
public interface PostContract {
    interface View extends BaseView {
        void refresh(List<String> posts);

        void load(List<String> posts);

        void setHeader(List<String> header);
    }
    interface Presenter extends BasePresenter{
        void getPost(int page,int size,boolean isRefresh);

        void getHeader();
    }

}
