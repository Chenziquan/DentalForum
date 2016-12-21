package jqchen.dentalforum.post.post.content;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.finalteam.rxgalleryfinal.RxGalleryFinal;
import cn.finalteam.rxgalleryfinal.bean.MediaBean;
import cn.finalteam.rxgalleryfinal.imageloader.ImageLoaderType;
import cn.finalteam.rxgalleryfinal.rxbus.RxBusResultSubscriber;
import cn.finalteam.rxgalleryfinal.rxbus.event.ImageMultipleResultEvent;
import jqchen.dentalforum.R;
import jqchen.dentalforum.common.ForumAlertDialog;
import jqchen.dentalforum.library.AppActivity;
import jqchen.dentalforum.library.BaseFragment;
import jqchen.dentalforum.util.ShowToast;

public class PostContentActivity extends AppActivity implements PostContentContract.View, ForumAlertDialog.ForumAlertDialogCallBack {

    @BindView(R.id.post_content_toolbar)
    Toolbar postContentToolbar;
    @BindView(R.id.post_content_title)
    EditText postContentTitle;
    @BindView(R.id.post_content_content)
    EditText postContentContent;
    @BindView(R.id.post_content_recycler)
    RecyclerView postContentRecycler;
    private ForumAlertDialog forumAlertDialog;
    private ShowToast mShowToast;
    private PostContentPresenter mPresenter;
    private List<String> localPictures, uploadPicture;
    private PostContentAdapter postContentAdapter;

    @Override
    protected BaseFragment getFirstFragment() {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        initToolBar();
        init();
        mPresenter = new PostContentPresenter(this);
        mPresenter.start();
    }

    private void init() {
        mShowToast = new ShowToast(this);
        forumAlertDialog = new ForumAlertDialog(this);
        forumAlertDialog.setTitle(getString(R.string.post_cancel_title));
        forumAlertDialog.setSubtitle(getString(R.string.post_cancel_content));
        forumAlertDialog.setCancel(getString(R.string.post_cancel_cancel));
        forumAlertDialog.setDeal(getString(R.string.post_cancel_deal));
        forumAlertDialog.setCallBack(this);
        localPictures = new ArrayList<>();
        uploadPicture = new ArrayList<>();
        postContentAdapter = new PostContentAdapter(R.layout.item_post_content_image, localPictures);
        postContentRecycler.setLayoutManager(new GridLayoutManager(this, 3));
        postContentRecycler.setAdapter(postContentAdapter);
    }

    private void initToolBar() {
        setSupportActionBar(postContentToolbar);
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_post_content;
    }


    @OnClick({R.id.post_content_cancel, R.id.post_content_submit, R.id.post_content_imagepicker})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.post_content_cancel:
                forumAlertDialog.show();
                break;
            case R.id.post_content_submit:
                mPresenter.PostSubmit(postContentTitle.getText().toString(),
                        postContentContent.getText().toString(),
                        localPictures);
                break;
            case R.id.post_content_imagepicker:
               /* RxGalleryFinal.with(this)
                        .image()
                        .radio()
                        .crop()
                        .imageLoader(ImageLoaderType.GLIDE)
                        .subscribe(new RxBusResultSubscriber<ImageRadioResultEvent>() {
                            @Override
                            protected void onEvent(ImageRadioResultEvent imageRadioResultEvent) throws Exception {
                                List<String> list = new ArrayList<>();
                                list.add(imageRadioResultEvent.getResult().getOriginalPath());
                                Log.e("path", imageRadioResultEvent.getResult().getOriginalPath());
                                mPresenter.AddPicture(list);
                            }
                        })
                        .openGallery();*/
                RxGalleryFinal.with(this)
                        .image()
                        .multiple()
                        .maxSize(9)
                        .imageLoader(ImageLoaderType.GLIDE)
                        .subscribe(new RxBusResultSubscriber<ImageMultipleResultEvent>() {
                            @Override
                            protected void onEvent(ImageMultipleResultEvent imageMultipleResultEvent) throws Exception {
                                List<String> pictures = new ArrayList<>();
                                for (MediaBean m :
                                        imageMultipleResultEvent.getResult()) {
                                    pictures.add(m.getOriginalPath());
                                }
                                mPresenter.AddPicture(pictures);
                            }
                        })
                        .openGallery();
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            forumAlertDialog.show();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void showTileNullError() {
        postContentTitle.setError(getString(R.string.post_content_null_title_error));
    }

    @Override
    public void showContentNullError() {
        postContentContent.setError(getString(R.string.post_content_null_content_error));
    }

    @Override
    public void showPostSuccess() {
        mShowToast.show(getString(R.string.post_content_post_success));
    }

    @Override
    public void showPicture(List<String> strings) {
        localPictures.addAll(strings);
        postContentAdapter.notifyDataSetChanged();
    }

    @Override
    public void addUploadPicture(String url) {
        uploadPicture.add(url);
        mShowToast.show(url);
    }

    @Override
    public void setPresenter(Object presenter) {

    }

    @Override
    public void showError() {

    }

    @Override
    public void showNormal() {

    }

    @Override
    public void cancel() {

    }

    @Override
    public void deal() {
        finish();
    }
}
