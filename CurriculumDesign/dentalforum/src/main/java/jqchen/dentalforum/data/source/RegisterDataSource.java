package jqchen.dentalforum.data.source;

import jqchen.dentalforum.base.BaseCallBack;

/**
 * Created by jqchen on 2016/12/5.
 * Use to
 */
public interface RegisterDataSource{
    interface RegisterCallBack extends BaseCallBack{
        void onTelNull();
        void onTelFormatError();
        void onTelError();
        void onNextStep();
    }
    void register(String tel,RegisterCallBack callBack);
}
