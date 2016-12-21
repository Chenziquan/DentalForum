package jqchen.dentalforum.data.source;

import java.util.List;

import jqchen.dentalforum.base.BaseCallBack;
import jqchen.dentalforum.data.bean.UserPostsBean;

/**
 * Created by jqchen on 2016/12/21.
 * Use to
 */
public interface UserPostsDataSource {
    interface UserPostsCallBack  extends BaseCallBack{
        void onLoadUserPosts(List<UserPostsBean> list);
    }

    void getUserPosts(int page, int size, UserPostsCallBack callBack);
}
