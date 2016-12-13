package jqchen.dentalforum.post.post.content;

import jqchen.dentalforum.base.BaseView;

/**
 * Created by jqchen on 2016/12/13.
 * Use to
 */
public interface PostContentContract {
    interface View extends BaseView{
        void showTileNullError();
        void showContentNullError();
    }
}
