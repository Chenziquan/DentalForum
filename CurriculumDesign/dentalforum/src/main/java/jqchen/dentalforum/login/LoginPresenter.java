package jqchen.dentalforum.login;

import jqchen.dentalforum.data.source.LoginDataSource;
import jqchen.dentalforum.data.source.LoginResponsitory;

/**
 * Created by jqchen on 2016/12/3.
 * Use to
 */
public class LoginPresenter implements LoginContract.Presenter {
    private LoginContract.View mView;

    public LoginPresenter(LoginContract.View mView) {
        this.mView = mView;
    }

    @Override
    public void getUsername() {
        LoginResponsitory.getInstance().getUsername(new LoginDataSource.LoginCallback() {
            @Override
            public void onGetUsername(String username) {
                mView.setUsername(username);
            }

            @Override
            public void onUsernameError() {

            }

            @Override
            public void onPasswordError() {

            }

            @Override
            public void onSuccess() {

            }

            @Override
            public void onDataNotAvailable() {

            }
        });
    }

    @Override
    public void login(String username, String password) {
        LoginResponsitory.getInstance().login(username, password, new LoginDataSource.LoginCallback() {
            @Override
            public void onGetUsername(String username) {
            }

            @Override
            public void onUsernameError() {
                mView.showUsernameError();
            }

            @Override
            public void onPasswordError() {
                mView.showPasswordError();
            }

            @Override
            public void onSuccess() {
                mView.navigateToHome();
            }

            @Override
            public void onDataNotAvailable() {
                mView.showError();
            }
        });
    }

    @Override
    public void start() {
        getUsername();
    }

    @Override
    public void destory() {
        LoginResponsitory.destoryInstance();
    }
}
