package jqchen.dentalforum.data.source.remote;

import java.util.ArrayList;
import java.util.List;

import jqchen.dentalforum.data.bean.UserPostsBean;
import jqchen.dentalforum.data.source.UserPostsDataSource;

/**
 * Created by jqchen on 2016/12/21.
 * Use to
 */
public class RemoteUserPostsDataSource implements UserPostsDataSource {
    @Override
    public void getUserPosts(int page, int size, UserPostsCallBack callBack) {
        List<UserPostsBean> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            UserPostsBean bean = new UserPostsBean();
            bean.setTitle("我的帖子");
            bean.setPostId("1");
            bean.setTime("2016 12-21");
            bean.setThem("资源帖");
            list.add(bean);
        }
        callBack.onLoadUserPosts(list);
    }
}
