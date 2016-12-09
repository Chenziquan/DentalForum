package jqchen.dentalforum.data.source.local;

import java.util.ArrayList;
import java.util.List;

import jqchen.dentalforum.data.source.PostDataSource;

/**
 * Created by jqchen on 2016/12/9.
 * Use to
 */
public class LocalPostDataSource implements PostDataSource {
    @Override
    public void getPost(int page, int size, PostCallBack callBack) {

    }

    @Override
    public void getHeader(PostCallBack callBack) {
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            strings.add("分类" + i);
        }
        callBack.onLoadHeader(strings);
    }
}
