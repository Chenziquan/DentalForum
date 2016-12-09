package jqchen.dentalforum.data.source.local;

import java.util.ArrayList;
import java.util.List;

import jqchen.dentalforum.data.source.SearchContentDataSource;

/**
 * Created by jqchen on 2016/12/9.
 * Use to
 */
public class LocalSearchContentDataSource implements SearchContentDataSource {

    @Override
    public void getSearchContent(int page, int size, String key, SearchContentCallBack callBack) {
        List<String> strings = new ArrayList<>();
        strings.add(key);
        callBack.onSearchContentLoad(strings);
    }
}
