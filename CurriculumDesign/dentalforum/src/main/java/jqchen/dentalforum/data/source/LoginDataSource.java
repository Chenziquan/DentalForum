package jqchen.dentalforum.data.source;

/**
 * Created by jqchen on 2016/12/3.
 * Use to
 */
public interface LoginDataSource {
    interface LoginCallback {
        void onGetUsername(String username);

        void onUsernameError();

        void onPasswordError();

        void onSuccess();

        void onDataNotAvailable();
    }

    void getUsername(LoginCallback callback);

    void login(String username, String password, LoginCallback callback);
}
