package jqchen.dentalforum.post.post.them;

import java.util.List;

import jqchen.dentalforum.data.bean.PostThemBean;
import jqchen.dentalforum.data.source.PostThemDataSource;
import jqchen.dentalforum.data.source.repository.PostThemRepository;

/**
 * Created by jqchen on 2016/12/13.
 * Use to
 */
public class PostThemPresenter implements PostThemContract.Presenter {
    private PostThemContract.View mView;

    public PostThemPresenter(PostThemContract.View mView) {
        this.mView = mView;
    }

    @Override
    public void getPostThem() {
        PostThemRepository.getInstance().getPostThem(new PostThemDataSource.PostThemCallBack() {
            @Override
            public void onLoad(List<PostThemBean> themBeen) {
                mView.load(themBeen);
                mView.showNormal();
            }

            @Override
            public void onDataNotAvailable() {
                mView.showError();
            }
        });
    }

    @Override
    public void setClick(int position, List<PostThemBean> themBeen) {
        if (themBeen.get(position).isSelected()) {
            themBeen.get(position).setSelected(false);
            mView.setUnDeal();
        } else {
            for (int i = 0; i < themBeen.size(); i++) {
                themBeen.get(i).setSelected(i == position);
            }
            mView.setDeal();
        }
        mView.refresh();
    }

    @Override
    public void start() {
        getPostThem();
    }

    @Override
    public void destory() {
        PostThemRepository.destoryInstance();
    }
}
