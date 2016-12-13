package jqchen.dentalforum.data.source.remote;

import java.util.ArrayList;
import java.util.List;

import jqchen.dentalforum.data.bean.PostThemBean;
import jqchen.dentalforum.data.source.PostThemDataSource;

/**
 * Created by jqchen on 2016/12/13.
 * Use to
 */
public class RemotePostThemDataSource implements PostThemDataSource {
    @Override
    public void getPostThem(PostThemCallBack callBack) {
        List<PostThemBean> list = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            PostThemBean bean = new PostThemBean();
            bean.setSelected(false);
            bean.setThem("主题" + i);
            list.add(bean);
        }
        callBack.onLoad(list);
    }
}
