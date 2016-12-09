package jqchen.dentalforum.data.source;

import java.util.List;

import jqchen.dentalforum.base.BaseCallBack;

/**
 * Created by jqchen on 2016/12/9.
 * Use to
 */
public interface SearchContentDataSource {
    interface SearchContentCallBack extends BaseCallBack {
        void onSearchContentLoad(List<String> content);
    }

    void getSearchContent(int page, int size, String key, SearchContentCallBack callBack);
}
