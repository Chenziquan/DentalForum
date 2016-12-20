package jqchen.dentalforum.data.source;

import jqchen.dentalforum.base.BaseCallBack;
import jqchen.dentalforum.data.bean.UserInfoBean;

/**
 * Created by jqchen on 2016/12/20.
 * Use to
 */
public interface UserInfoDataSource {
    interface UserInfoCallBack extends BaseCallBack {
        void onSuccess(UserInfoBean userInfoBean);
    }

    interface UpdateInfoCallBack extends BaseCallBack {
        void onSuccess(String string);

        void onFail();
    }

    void getUserInfo(UserInfoCallBack callBack);

    void updateProtrait(String url, UpdateInfoCallBack callBack);

    void updateName(String name, UpdateInfoCallBack callBack);
}
