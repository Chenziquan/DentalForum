package jqchen.dentalforum.function.search.search_content;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import jqchen.dentalforum.R;
import jqchen.dentalforum.library.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchContentFragment extends BaseFragment implements SearchContentContract.View {
    @BindView(R.id.text)
    TextView text;
    @BindView(R.id.network_error_layout)
    ViewStub networkErrorLayout;
    private Unbinder unbinder;
    private String searchKey;
    private SearchContentPresenter mPresenter;
    private String key;
    private View networkErrorView;

    public SearchContentFragment() {
        // Required empty public constructor
    }

    public static SearchContentFragment getInstance(Bundle bundle) {
        SearchContentFragment contentFragment = new SearchContentFragment();
        contentFragment.setArguments(bundle);
        return contentFragment;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        unbinder = ButterKnife.bind(this, view);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
        mPresenter.destory();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_search_content;
    }

    @Override
    public void initData() {
        mPresenter = new SearchContentPresenter(this);
        key = getArguments().getString("search_key");
        mPresenter.getSearchContent(1, 10, true, key);
    }


    @Override
    public void refresh(List<String> content) {
        text.setText(content.get(0));
    }

    @Override
    public void load(List<String> content) {

    }

    @Override
    public void setPresenter(Object presenter) {

    }

    @Override
    public void showError() {
        if (networkErrorView != null){
            networkErrorView.setVisibility(View.VISIBLE);
            return;
        }
        networkErrorView = networkErrorLayout.inflate();
    }

    @Override
    public void showNormal() {
        if (networkErrorView != null){
            networkErrorView.setVisibility(View.GONE);
        }
    }

}
