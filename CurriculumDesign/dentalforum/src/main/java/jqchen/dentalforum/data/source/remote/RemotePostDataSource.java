package jqchen.dentalforum.data.source.remote;

import java.util.ArrayList;
import java.util.List;

import jqchen.dentalforum.data.source.PostDataSource;

/**
 * Created by jqchen on 2016/12/9.
 * Use to
 */
public class RemotePostDataSource implements PostDataSource {

    @Override
    public void getPost(int page, int size, PostCallBack callBack) {
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            strings.add("帖子" + i);
        }
        callBack.onLoadPost(strings);
    }

    @Override
    public void getHeader(PostCallBack callBack) {

    }
}
