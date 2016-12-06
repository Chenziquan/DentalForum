package jqchen.dentalforum.data.source.remote;

import android.text.TextUtils;

import jqchen.dentalforum.data.source.RegisterNextDataSource;
import jqchen.dentalforum.util.StringUtil;

/**
 * Created by jqchen on 2016/12/5.
 * Use to
 */
public class RemoteRegisterNextDataSource implements RegisterNextDataSource {
    @Override
    public void sendCode(String telnum, RegisterSendCodeCallBack callBack) {

    }

    @Override
    public void registerNext(String telnum, String code, RegisterNextCallBack callBack) {
        if (TextUtils.isEmpty(code)){
            callBack.onCodeNullError();
            return;
        }
        if (StringUtil.length(code) != 6){
            callBack.onCodeError();
            return;
        }
        callBack.onRegisterSuccess();
    }
}
