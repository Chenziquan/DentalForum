package jqchen.dentalforum.post.post.content;

import java.util.List;

import jqchen.dentalforum.base.BasePresenter;
import jqchen.dentalforum.base.BaseView;

/**
 * Created by jqchen on 2016/12/13.
 * Use to
 */
public interface PostContentContract {
    interface View extends BaseView{
        void showTileNullError();
        void showContentNullError();
        void showPostSuccess();
        void showPicture(List<String> strings);
    }
    interface Presenter extends BasePresenter{
        void PostSubmit(String title,String content,List<String> list);
        void AddPicture(List<String> strings);
    }
}
