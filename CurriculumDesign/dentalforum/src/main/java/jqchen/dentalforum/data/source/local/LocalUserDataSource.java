package jqchen.dentalforum.data.source.local;

import jqchen.dentalforum.app.MyApplication;
import jqchen.dentalforum.base.SimpleCallBack;
import jqchen.dentalforum.data.preference.Preference;
import jqchen.dentalforum.data.source.UserDataSource;

/**
 * Created by jqchen on 2016/12/12.
 * Use to
 */
public class LocalUserDataSource implements UserDataSource {
    Preference preference = new Preference(MyApplication.getInstance());
    @Override
    public void GetSignStatus(UserCallBack callBack) {

    }

    @Override
    public void SignOut(SignOutCallBack callBack) {
        preference.setSignStatus(false);
        callBack.onSuccess();
    }


    @Override
    public void goUserPosts(SimpleCallBack callBack) {
        if (preference.getSignStatus()){
            callBack.onSuccess();
        }else {
            callBack.onFail();
        }
    }

    @Override
    public void goUserCollection(SimpleCallBack callBack) {
        if (preference.getSignStatus()){
            callBack.onSuccess();
        }else {
            callBack.onFail();
        }
    }

}
