package jqchen.dentalforum.frame.user;

import jqchen.dentalforum.data.bean.UserBean;
import jqchen.dentalforum.data.source.UserDataSource;
import jqchen.dentalforum.data.source.repository.UserRepository;

/**
 * Created by jqchen on 2016/12/12.
 * Use to
 */
public class UserPresenter implements UserContract.Presenter {
    private UserContract.View mView;

    public UserPresenter(UserContract.View mView) {
        this.mView = mView;
    }

    @Override
    public void getSignStatus() {
        UserRepository.getInstance().GetSignStatus(new UserDataSource.UserCallBack() {
            @Override
            public void onSignOut() {
                mView.showSignOut();
                mView.showNormal();
            }

            @Override
            public void onSignIn(UserBean userBean) {
                mView.showSignIn(userBean);
                mView.showNormal();
            }

            @Override
            public void onDataNotAvailable() {
                mView.showError();
            }
        });
    }

    @Override
    public void signOut() {
        UserRepository.getInstance().SignOut(new UserDataSource.SignOutCallBack() {
            @Override
            public void onSuccess() {
                mView.showSignOut();
            }

            @Override
            public void onDataNotAvailable() {
                mView.showError();
            }
        });
    }

    @Override
    public void signIn() {
        UserRepository.getInstance().SignIn(new UserDataSource.SignInCallBack() {
            @Override
            public void onSuccess(UserBean userBean) {
                mView.showSignIn(userBean);
            }

            @Override
            public void onDataNotAvailable() {
                mView.showError();
            }
        });
    }

    @Override
    public void start() {
        getSignStatus();
    }

    @Override
    public void destory() {
        UserRepository.destoryInstance();
    }
}
