package jqchen.dentalforum.data.source;

/**
 * Created by jqchen on 2016/12/5.
 * Use to
 */
public interface RegisterDataSource{
    interface RegisterCallBack{
        void onTelNull();
        void onTelFormatError();
        void onTelError();
        void onDataNotAvailable();
        void onNextStep();
    }
    void register(String tel,RegisterCallBack callBack);
}
