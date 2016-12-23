package jqchen.dentalforum.data.source.local;

import android.text.TextUtils;

import jqchen.dentalforum.base.SimpleCallBack;
import jqchen.dentalforum.data.source.RegisterNextDataSource;

/**
 * Created by jqchen on 2016/12/5.
 * Use to
 */
public class LocalRegisterNextDataSource implements RegisterNextDataSource {

    @Override
    public void sendCode(String telnum, SimpleCallBack callBack) {
        if (TextUtils.isEmpty(telnum)){
            callBack.onFail();
            return;
        }
        callBack.onSuccess();
    }

    @Override
    public void registerNext(String telnum, String code, String passowrd, RegisterNextCallBack callBack) {

    }
}
