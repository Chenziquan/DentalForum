package jqchen.dentalforum.data.source.remote;

import android.support.v4.util.ArrayMap;
import android.text.TextUtils;

import java.util.Map;

import jqchen.dentalforum.base.SimpleCallBack;
import jqchen.dentalforum.data.bean.UserBean;
import jqchen.dentalforum.data.preference.Preference;
import jqchen.dentalforum.data.source.RegisterNextDataSource;
import jqchen.dentalforum.http.ForumRetrofit;
import jqchen.dentalforum.http.ForumService;
import jqchen.dentalforum.util.StringUtil;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by jqchen on 2016/12/5.
 * Use to
 */
public class RemoteRegisterNextDataSource implements RegisterNextDataSource {

    @Override
    public void sendCode(String telnum, SimpleCallBack callBack) {

    }

    @Override
    public void registerNext(final String telnum, String code, String passowrd, final RegisterNextCallBack callBack) {
        if (TextUtils.isEmpty(code)) {
            callBack.onCodeNullError();
            return;
        }
        if (TextUtils.isEmpty(passowrd)) {
            callBack.onPassowrdNullError();
            return;
        } else if (StringUtil.length(passowrd) < 6) {
            callBack.onPasswordLengthError();
            return;
        }
        Map<String, String> map = new ArrayMap<>();
        map.put("phone", telnum);
        map.put("passwrod", passowrd);
        ForumRetrofit.getRetrofit()
                .create(ForumService.class)
                .register(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onDataNotAvailable();
                    }

                    @Override
                    public void onNext(UserBean userBean) {
                        if (StringUtil.isEmpty(userBean.getId())){
                            callBack.onRegisterFail();
                            return;
                        }
                        Preference preference = Preference.getInstance();
                        preference.setUserId(userBean.getId());
                        preference.setUserName(userBean.getPhone());
                        preference.setSignStatus(true);
                        preference.setUserTel(userBean.getPhone());
                        callBack.onRegisterSuccess();
                    }
                });
    }
}
