package jqchen.dentalforum.data.source;

import java.util.List;

import jqchen.dentalforum.base.BaseCallBack;

/**
 * Created by jqchen on 2016/12/9.
 * Use to
 */
public interface PostDataSource {
    interface PostCallBack extends BaseCallBack {
        void onLoadHeader(List<String> header);

        void onLoadPost(List<String> posts);
    }

    void getPost(int page,int size,PostCallBack callBack);

    void getHeader(PostCallBack callBack);
}
