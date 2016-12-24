package jqchen.dentalforum.data.source.remote;

import jqchen.dentalforum.base.SimpleCallBack;
import jqchen.dentalforum.data.bean.UserBean;
import jqchen.dentalforum.data.preference.Preference;
import jqchen.dentalforum.data.source.UserDataSource;

/**
 * Created by jqchen on 2016/12/12.
 * Use to
 */
public class RemoteUserDataSource implements UserDataSource {
    Preference preference = Preference.getInstance();

    @Override
    public void GetSignStatus(UserCallBack callBack) {
        if (preference.getSignStatus()) {
            UserBean userBean = new UserBean();
            userBean.setPhone(preference.getUserTel());
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
    public void goUserPosts(SimpleCallBack callBack) {

    }

    @Override
    public void goUserCollection(SimpleCallBack callBack) {

    }

}
