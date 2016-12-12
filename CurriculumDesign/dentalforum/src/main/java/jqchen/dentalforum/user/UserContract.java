package jqchen.dentalforum.user;

import jqchen.dentalforum.base.BasePresenter;
import jqchen.dentalforum.base.BaseView;
import jqchen.dentalforum.data.bean.UserBean;

/**
 * Created by jqchen on 2016/12/12.
 * Use to
 */
public interface UserContract {
    interface View extends BaseView{
        void showSignOut();
        void showSignIn(UserBean bean);
    }
    interface Presenter extends BasePresenter{
        void getSignStatus();
        void signOut();
        void signIn();
    }
}
