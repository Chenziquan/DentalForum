package jqchen.dentalforum.data.source.remote;

import android.text.TextUtils;

import jqchen.dentalforum.data.source.RegisterDataSource;
import jqchen.dentalforum.util.PhoneNumUtil;

/**
 * Created by jqchen on 2016/12/5.
 * Use to
 */
public class RemoteRegisterDataSource implements RegisterDataSource {
    @Override
    public void register(String tel, RegisterCallBack callBack) {
        if (TextUtils.isEmpty(tel)) {
            callBack.onTelNull();
            return;
        }
        if (!PhoneNumUtil.isFormatNum(tel)) {
            callBack.onTelFormatError();
            return;
        }
        callBack.onNextStep();

    }
}
