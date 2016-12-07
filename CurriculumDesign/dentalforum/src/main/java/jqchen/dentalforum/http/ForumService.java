package jqchen.dentalforum.http;

import java.util.Map;

import jqchen.dentalforum.data.bean.ADListModel;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by jqchen on 2016/12/2.
 * Use to 请求的api
 */
public interface ForumService {
    @POST("ad/getAd.tg")
    Observable<ADListModel> getRecommendBanner(@QueryMap Map<String, String> map);
}
