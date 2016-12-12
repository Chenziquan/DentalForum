package jqchen.dentalforum.data.source.remote;

import jqchen.dentalforum.app.MyApplication;
import jqchen.dentalforum.data.bean.UserBean;
import jqchen.dentalforum.data.preference.Preference;
import jqchen.dentalforum.data.source.UserDataSource;

/**
 * Created by jqchen on 2016/12/12.
 * Use to
 */
public class RemoteUserDataSource implements UserDataSource {
    @Override
    public void GetSignStatus(UserCallBack callBack) {
        Preference preference = new Preference(MyApplication.getInstance());
        if (preference.getSignStatus()) {
            UserBean userBean = new UserBean();
            userBean.setName(preference.getUserName());
            userBean.setIntegration("1212");
            userBean.setPosts("11");
            userBean.setWealth("22");
            userBean.setCollections("33");
            callBack.onSignIn(userBean);
        } else {
            callBack.onSignOut();
        }
    }

    @Override
    public void SignOut(SignOutCallBack callBack) {
    }

    @Override
    public void SignIn(SignInCallBack callBack) {
        Preference preference = new Preference(MyApplication.getInstance());
        preference.setSignStatus(true);
        preference.setUserName("陈军权");
        UserBean userBean = new UserBean();
        userBean.setName(preference.getUserName());
        userBean.setIntegration("1212");
        userBean.setPosts("11");
        userBean.setWealth("22");
        userBean.setCollections("33");
        callBack.onSuccess(userBean);
    }

}
