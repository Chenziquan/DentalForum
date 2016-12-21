package jqchen.dentalforum.data.source.remote;

import java.util.ArrayList;
import java.util.List;

import jqchen.dentalforum.data.bean.UserCollectionBean;
import jqchen.dentalforum.data.source.UserCollectionDataSource;

/**
 * Created by jqchen on 2016/12/21.
 * Use to
 */
public class RemoteUserCollectionDataSource implements UserCollectionDataSource {
    @Override
    public void getUserCollection(int page, int size, UserCollectionCallBack collectionCallBack) {
        List<UserCollectionBean> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            UserCollectionBean bean = new UserCollectionBean();
            bean.setTitle("我的收藏");
            bean.setPostId("2");
            bean.setThem("主题");
            bean.setTime("2016 12-12");
            list.add(bean);
        }
        collectionCallBack.onLoadUserCollection(list);
    }
}
