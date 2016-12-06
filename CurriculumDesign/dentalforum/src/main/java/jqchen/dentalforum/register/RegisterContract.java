package jqchen.dentalforum.register;

import jqchen.dentalforum.base.BasePresenter;
import jqchen.dentalforum.base.BaseView;

/**
 * Created by jqchen on 2016/12/5.
 * Use to
 */
public interface RegisterContract {
    interface View extends BaseView{
        void showTelFormatError();
        void showTelNullError();
        void showTelError();
        void goNextStep();
    }
    interface Preseneter extends BasePresenter{
        void goNextStep(String telnum);
    }
}
