package jqchen.dentalforum.common;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jqchen.dentalforum.R;

/**
 * Created by jqchen on 2016/12/5.
 * Use to
 */
public class ForumAlertDialog extends AlertDialog {
    @BindView(R.id.forum_alertdialog_title)
    TextView forumAlertdialogTitle;
    @BindView(R.id.forum_alertdialog_subtitle)
    TextView forumAlertdialogSubtitle;
    @BindView(R.id.forum_alertdialog_cancel)
    TextView forumAlertdialogCancel;
    @BindView(R.id.forum_alertdialog_deal)
    TextView forumAlertdialogDeal;
    private ForumAlertDialogCallBack callBack;

    private String title,subtitle,cancel,deal;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public void setCancel(String cancel) {
        this.cancel = cancel;
    }

    public void setDeal(String deal) {
        this.deal = deal;
    }

    public void setCallBack(ForumAlertDialogCallBack callBack) {
        this.callBack = callBack;
    }

    public ForumAlertDialog(Context context) {
        super(context, R.style.CustomDialog);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forum_alertdialog);
        ButterKnife.bind(this);
        setText();
    }

    private void setText() {
        forumAlertdialogTitle.setText(title);
        if (!TextUtils.isEmpty(subtitle)) {
            forumAlertdialogSubtitle.setVisibility(View.VISIBLE);
            forumAlertdialogSubtitle.setText(subtitle);
        }
        forumAlertdialogCancel.setText(cancel);
        forumAlertdialogDeal.setText(deal);
    }

    @OnClick({R.id.forum_alertdialog_cancel, R.id.forum_alertdialog_deal})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.forum_alertdialog_cancel:
                callBack.cancel();
                this.dismiss();
                break;
            case R.id.forum_alertdialog_deal:
                callBack.deal();
                this.dismiss();
                break;
        }
    }

    @Override
    public void show() {
        super.show();
        Window window = ForumAlertDialog.this.getWindow();
        //设置dialog在屏幕底部
        window.setGravity(Gravity.BOTTOM);
        //设置dialog弹出时的动画效果，从屏幕底部向上弹出
//        window.setWindowAnimations(R.style.dialogStyle);
        //获得window窗口的属性
        WindowManager.LayoutParams lp = window.getAttributes();
        //设置窗口宽度为充满全屏
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        //设置窗口高度为包裹内容
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        //将设置好的属性set回去
        window.setAttributes(lp);
    }

    public interface ForumAlertDialogCallBack {
        void cancel();

        void deal();
    }
}
