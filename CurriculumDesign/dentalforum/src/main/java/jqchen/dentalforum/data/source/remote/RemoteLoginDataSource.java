package jqchen.dentalforum.data.source.remote;

import android.support.v4.util.ArrayMap;
import android.text.TextUtils;

import java.util.Map;

import jqchen.dentalforum.app.MyApplication;
import jqchen.dentalforum.data.bean.UserBean;
import jqchen.dentalforum.data.preference.Preference;
import jqchen.dentalforum.data.source.LoginDataSource;
import jqchen.dentalforum.http.ForumRetrofit;
import jqchen.dentalforum.http.ForumService;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by jqchen on 2016/12/3.
 * Use to
 */
public class RemoteLoginDataSource implements LoginDataSource {
    @Override
    public void getUsername(LoginCallback callback) {

    }

    @Override
    public void login(String username, String password, final LoginCallback callback) {
        if (TextUtils.isEmpty(username)) {
            callback.onUsernameError();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            callback.onPasswordError();
            return;
        }
        Map<String,String> map = new ArrayMap<>();
        map.put("phone",username);
        map.put("password",password);
        ForumRetrofit.getRetrofit()
                .create(ForumService.class)
                .login(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onDataNotAvailable();
                    }

                    @Override
                    public void onNext(UserBean userBean) {
                        callback.onSuccess();
                        Preference preference = new Preference(MyApplication.getInstance());
                        preference.setSignStatus(true);
                        preference.setUserName(userBean.getName());
                        preference.setUserId(userBean.getId());
                        callback.onSuccess();
                    }
                });


    }
}
