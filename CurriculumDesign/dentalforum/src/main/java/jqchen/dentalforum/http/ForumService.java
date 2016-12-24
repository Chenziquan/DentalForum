package jqchen.dentalforum.http;

import java.util.List;
import java.util.Map;

import jqchen.dentalforum.data.bean.ADListModel;
import jqchen.dentalforum.data.bean.BaseReturnBean;
import jqchen.dentalforum.data.bean.PostBean;
import jqchen.dentalforum.data.bean.PostCommentBean;
import jqchen.dentalforum.data.bean.RecommendBean;
import jqchen.dentalforum.data.bean.UserBean;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by jqchen on 2016/12/2.
 * Use to 请求的api
 */
public interface ForumService {
    @POST("ad/getAd.tg")
    Observable<ADListModel> getRecommendBanner(@QueryMap Map<String, String> map);

    @GET("api/post/selPost")
    Observable<List<PostBean>> getHomePosts();

    @GET("api/post/selPost/{id}")
    Observable<PostBean> getPostDetail(@Path("id") int postId);

    @GET("api/post/collect/addCollect")
    Observable<BaseReturnBean> addCollect(@QueryMap Map<String, String> map);

    @GET("api/news/all")
    Observable<List<RecommendBean>> getRecommend();

    @GET("api/user/login")
    Observable<UserBean> login(@QueryMap Map<String, String> map);

    @GET("api/user/regist")
    Observable<UserBean> register(@QueryMap Map<String, String> map);

    @GET("api/comment/selComment/{postId}")
    Observable<List<PostCommentBean>> getPostComment(@Path("postId") int postId);

    @GET("api/post/collect/selCollect")
    Observable<List<PostBean>> getUserCollection(@Query("userId") String uerId);
}
