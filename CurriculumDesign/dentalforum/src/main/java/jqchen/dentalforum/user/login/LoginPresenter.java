package jqchen.dentalforum.user.login;

import jqchen.dentalforum.data.source.LoginDataSource;
import jqchen.dentalforum.data.source.repository.LoginRepository;

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
        LoginRepository.getInstance().getUsername(new LoginDataSource.GetUsernameCallBack() {
            @Override
            public void onGetUsername(String username) {
                mView.setUsername(username);
            }

            @Override
            public void onDataNotAvailable() {

            }
        });
    }

    @Override
    public void login(String username, String password) {
        LoginRepository.getInstance().login(username, password, new LoginDataSource.LoginCallback() {

            @Override
            public void onFail() {
                mView.showLoginFail();
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
        LoginRepository.destoryInstance();
    }
}
