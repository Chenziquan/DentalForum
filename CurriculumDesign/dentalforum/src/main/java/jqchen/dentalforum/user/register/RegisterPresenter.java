package jqchen.dentalforum.user.register;

import jqchen.dentalforum.data.source.RegisterDataSource;
import jqchen.dentalforum.data.source.repository.RegisterRepository;

/**
 * Created by jqchen on 2016/12/5.
 * Use to
 */
public class RegisterPresenter implements RegisterContract.Preseneter {
    private RegisterContract.View mView;

    public RegisterPresenter(RegisterContract.View mView) {
        this.mView = mView;
    }

    @Override
    public void goNextStep(String telnum) {
        RegisterRepository.getInstance().register(telnum, new RegisterDataSource.RegisterCallBack() {
            @Override
            public void onTelNull() {
                mView.showTelNullError();
            }

            @Override
            public void onTelFormatError() {
                mView.showTelFormatError();
            }

            @Override
            public void onTelError() {
                mView.showTelError();
            }

            @Override
            public void onDataNotAvailable() {
                mView.showError();
            }

            @Override
            public void onNextStep() {
                mView.goNextStep();
            }
        });
    }

    @Override
    public void start() {
        mView.showNormal();
    }

    @Override
    public void destory() {
        RegisterRepository.destoryInstance();
    }
}
