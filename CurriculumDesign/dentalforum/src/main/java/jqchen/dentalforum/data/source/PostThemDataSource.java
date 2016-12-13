package jqchen.dentalforum.data.source;

import java.util.List;

import jqchen.dentalforum.base.BaseCallBack;
import jqchen.dentalforum.data.bean.PostThemBean;

/**
 * Created by jqchen on 2016/12/13.
 * Use to
 */
public interface PostThemDataSource {
    interface PostThemCallBack extends BaseCallBack {
        void onLoad(List<PostThemBean> themBeen);
    }

    void getPostThem(PostThemCallBack callBack);
}
