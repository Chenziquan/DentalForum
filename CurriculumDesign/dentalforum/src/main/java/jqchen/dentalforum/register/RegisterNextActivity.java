package jqchen.dentalforum.register;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jqchen.dentalforum.R;
import jqchen.dentalforum.common.ForumAlertDialog;
import jqchen.dentalforum.library.AppActivity;
import jqchen.dentalforum.library.BaseFragment;

public class RegisterNextActivity extends AppActivity {

    @BindView(R.id.register_toolbar)
    Toolbar registerToolbar;
    private ForumAlertDialog forumAlertDialog;

    @Override
    protected BaseFragment getFirstFragment() {
        RegisterNextFragment nextFragment = new RegisterNextFragment();
        Bundle bundle = new Bundle();
        bundle.putString(getString(R.string.transfer_tel),getIntent().getStringExtra(getString(R.string.transfer_tel)));
        nextFragment.setArguments(bundle);
        return nextFragment;
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_register;
    }

    @Override
    protected int getFragmentContentId() {
        return R.id.register_fragment;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        setSupportActionBar(registerToolbar);
        setForumAlertDialog();
    }

    private void setForumAlertDialog() {
        forumAlertDialog = new ForumAlertDialog(this);
        forumAlertDialog.setTitle(getString(R.string.register_back_title));
        forumAlertDialog.setSubtitle(getString(R.string.register_back_subtitle));
        forumAlertDialog.setCancel(getString(R.string.register_back_cancel));
        forumAlertDialog.setDeal(getString(R.string.register_back_deal));
        forumAlertDialog.setCallBack(new ForumAlertDialog.ForumAlertDialogCallBack() {
            @Override
            public void cancel() {
                forumAlertDialog.dismiss();
            }

            @Override
            public void deal() {
                finish();
            }
        });
    }

    @Override
    public void onClick(View view) {

    }

    @OnClick(R.id.register_back)
    public void onClick() {
        forumAlertDialog.show();
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN){
            setAlertDialogShow();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void setAlertDialogShow() {
        if (forumAlertDialog.isShowing()){
            forumAlertDialog.dismiss();
        }else {
            forumAlertDialog.show();
        }
    }
}
