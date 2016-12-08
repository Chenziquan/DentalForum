package jqchen.dentalforum.data.source;

import jqchen.dentalforum.library.BaseFragment;

/**
 * Created by jqchen on 2016/12/8.
 * Use to
 */
public interface SearchDataSource {
    interface SearchCallBack{
        void onKeyNullError();
        void onSearch(BaseFragment baseFragment);
    }
    void search(String key,SearchCallBack callBack);

}
