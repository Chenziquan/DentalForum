package jqchen.dentalforum.data.source;

import jqchen.dentalforum.base.BaseCallBack;
import jqchen.dentalforum.base.SimpleCallBack;
import jqchen.dentalforum.data.bean.UserBean;

/**
 * Created by jqchen on 2016/12/12.
 * Use to
 */
public interface UserDataSource {
    interface UserCallBack extends BaseCallBack {
        void onSignOut();

        void onSignIn(UserBean userBean);
    }
    interface SignOutCallBack extends BaseCallBack{
        void onSuccess();
    }
    interface SignInCallBack extends BaseCallBack{
        void onSuccess(UserBean userBean);
    }

    void GetSignStatus(UserCallBack callBack);

    void SignOut(SignOutCallBack callBack);

    void goUserPosts(SimpleCallBack callBack);

    void goUserCollection(SimpleCallBack callBack);
}
