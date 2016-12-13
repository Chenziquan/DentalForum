package jqchen.dentalforum.post.post.them;

import java.util.List;

import jqchen.dentalforum.base.BasePresenter;
import jqchen.dentalforum.base.BaseView;
import jqchen.dentalforum.data.bean.PostThemBean;

/**
 * Created by jqchen on 2016/12/13.
 * Use to
 */
public interface PostThemContract {
    interface View extends BaseView {
        void load(List<PostThemBean> themBeen);

        void refresh();

        void setDeal();

        void setUnDeal();
    }

    interface Presenter extends BasePresenter {
        void getPostThem();

        void setClick(int position, List<PostThemBean> themBeen);
    }
}
