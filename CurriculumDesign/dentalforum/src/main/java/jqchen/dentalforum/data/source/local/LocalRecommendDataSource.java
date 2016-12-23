package jqchen.dentalforum.data.source.local;

import java.util.ArrayList;
import java.util.List;

import jqchen.dentalforum.data.source.RecommendDataSource;

/**
 * Created by jqchen on 2016/12/2.
 * Use to
 */
public class LocalRecommendDataSource implements RecommendDataSource {

    @Override
    public void getRecommend(int page, int size, LoadRecommendCallback callback) {

    }

    @Override
    public void getBanner(LoadBannerCallBack callback) {
        List<String> strings = new ArrayList<>();
        strings.add("http://image101.360doc.com/DownloadImg/2016/11/0218/83610116_3.jpg");
        strings.add("http://pic1.win4000.com/wallpaper/6/5375d1c8ebe63.jpg");
        strings.add("http://tupian.enterdesk.com/2013/xll/010/26/2/5.jpg");
        strings.add("http://image81.360doc.com/DownloadImg/2015/01/1515/49106046_2.jpg");
        callback.onBannerLoad(strings);
    }
}
