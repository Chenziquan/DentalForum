package jqchen.dentalforum.post.post.content;

import java.util.List;

import jqchen.dentalforum.data.source.PostContentDataSource;
import jqchen.dentalforum.data.source.repository.PostContentRepository;

/**
 * Created by jqchen on 2016/12/15.
 * Use to
 */
public class PostContentPresenter implements PostContentContract.Presenter {
    private PostContentContract.View mView;

    public PostContentPresenter(PostContentContract.View mView) {
        this.mView = mView;
    }

    @Override
    public void PostSubmit(String title, String content, List<String> list) {
        PostContentRepository.getInstance().postSubmit(title, content, list, new PostContentDataSource.PostContentCallBack() {
            @Override
            public void onTitleNullError() {
                mView.showTileNullError();
            }

            @Override
            public void onContentNullError() {
                mView.showContentNullError();
            }

            @Override
            public void onPostSuccess() {
                mView.showPostSuccess();
            }

            @Override
            public void onDataNotAvailable() {
                mView.showError();
            }
        });
    }

    @Override
    public void AddPicture(List<String> strings) {
        PostContentRepository.getInstance().addPicture(strings, new PostContentDataSource.UploadPictureCallBack() {
            @Override
            public void onAddPicture(List<String> strings) {
                mView.showPicture(strings);
            }

            @Override
            public void onUploadSuccess(String url) {
                mView.addUploadPicture(url);
            }

            @Override
            public void onDataNotAvailable() {
                mView.showError();
            }
        });
    }

    @Override
    public void start() {
        mView.showNormal();
    }

    @Override
    public void destory() {
        PostContentRepository.destoryInstance();
    }
}
