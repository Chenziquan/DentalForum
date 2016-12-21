package jqchen.dentalforum.data.source;

import java.util.List;

import jqchen.dentalforum.base.BaseCallBack;
import jqchen.dentalforum.data.bean.UserCollectionBean;

/**
 * Created by jqchen on 2016/12/21.
 * Use to
 */
public interface UserCollectionDataSource {
    interface UserCollectionCallBack extends BaseCallBack {
        void onLoadUserCollection(List<UserCollectionBean> list);
    }

    void getUserCollection(int page, int size,  UserCollectionCallBack collectionCallBack);
}
