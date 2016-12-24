package jqchen.dentalforum.data.source;

import java.util.List;

import jqchen.dentalforum.base.BaseCallBack;
import jqchen.dentalforum.data.bean.PostBean;

/**
 * Created by jqchen on 2016/12/21.
 * Use to
 */
public interface UserCollectionDataSource {
    interface UserCollectionCallBack extends BaseCallBack {
        void onLoadUserCollection(List<PostBean> list);
        void onLoadFinish();
    }

    void getUserCollection(int page, int size,  UserCollectionCallBack collectionCallBack);
}
