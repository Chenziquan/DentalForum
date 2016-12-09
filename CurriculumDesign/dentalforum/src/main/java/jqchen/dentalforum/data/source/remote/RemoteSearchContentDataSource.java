package jqchen.dentalforum.data.source.remote;

import java.util.ArrayList;
import java.util.List;

import jqchen.dentalforum.data.source.SearchContentDataSource;

/**
 * Created by jqchen on 2016/12/9.
 * Use to
 */
public class RemoteSearchContentDataSource implements SearchContentDataSource {

    @Override
    public void getSearchContent(int page, int size, String key, SearchContentCallBack callBack) {
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            strings.add("搜索结果" + i);
        }
        callBack.onSearchContentLoad(strings);
    }
}
