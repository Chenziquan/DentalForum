package jqchen.dentalforum.user.login;

import jqchen.dentalforum.base.BasePresenter;
import jqchen.dentalforum.base.BaseView;

/**
 * Created by jqchen on 2016/12/3.
 * Use to
 */
public interface LoginContract {
    interface View extends BaseView {
        void setUsername(String username);

        void showUsernameError();

        void showPasswordError();

        void navigateToHome();

        void showLoginFail();
    }

    interface Presenter extends BasePresenter {
        void getUsername();

        void login(String username, String password);
    }
}
