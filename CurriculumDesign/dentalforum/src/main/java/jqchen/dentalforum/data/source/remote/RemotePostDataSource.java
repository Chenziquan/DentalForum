package jqchen.dentalforum.data.source.remote;

import java.util.ArrayList;
import java.util.List;

import jqchen.dentalforum.data.bean.PostBean;
import jqchen.dentalforum.data.source.PostDataSource;

/**
 * Created by jqchen on 2016/12/9.
 * Use to
 */
public class RemotePostDataSource implements PostDataSource {

    @Override
    public void getPost(int page, int size, PostCallBack callBack) {
        List<PostBean> strings = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            PostBean postBean = new PostBean();
            postBean.setTitle("帖子" + i);
            postBean.setUname("陈军权");
            postBean.setUgroup("达人");
            postBean.setThem("主题");
            postBean.setContent("帖子正文");
            postBean.setTime("25s前");
            postBean.setViewnum("20");
            postBean.setCommentnum("33");
            strings.add(postBean);
        }
        callBack.onLoadPost(strings);
    }

    @Override
    public void getHeader(PostCallBack callBack) {

    }
}
