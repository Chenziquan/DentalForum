package jqchen.dentalforum.data.source.remote;

import jqchen.dentalforum.data.bean.UserInfoBean;
import jqchen.dentalforum.data.source.UserInfoDataSource;

/**
 * Created by jqchen on 2016/12/20.
 * Use to
 */
public class RemoteUserInfoDataSource implements UserInfoDataSource {
    @Override
    public void getUserInfo(UserInfoCallBack callBack) {
        UserInfoBean userInfoBean = new UserInfoBean();
        userInfoBean.setuImage("http://dentalforum-1253177711.costj.myqcloud.com/image/Screenshot_2016-12-15-13-41-59-400_com.miui.miuib.png");
        userInfoBean.setuName("陈军权");
        callBack.onSuccess(userInfoBean);
    }

    @Override
    public void updateProtrait(String url, UpdateInfoCallBack callBack) {

    }

    @Override
    public void updateName(String name, UpdateInfoCallBack callBack) {

    }
}
