package jqchen.dentalforum.data.source.local;

import jqchen.dentalforum.app.MyApplication;
import jqchen.dentalforum.data.preference.Preference;
import jqchen.dentalforum.data.source.UserDataSource;

/**
 * Created by jqchen on 2016/12/12.
 * Use to
 */
public class LocalUserDataSource implements UserDataSource {

    @Override
    public void GetSignStatus(UserCallBack callBack) {

    }

    @Override
    public void SignOut(SignOutCallBack callBack) {
        Preference preference = new Preference(MyApplication.getInstance());
        preference.setSignStatus(false);
        callBack.onSuccess();
    }

    @Override
    public void SignIn(SignInCallBack callBack) {

    }

}
