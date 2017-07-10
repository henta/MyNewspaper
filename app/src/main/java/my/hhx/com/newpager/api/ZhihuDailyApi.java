package my.hhx.com.newpager.api;

import io.reactivex.Observable;
import my.hhx.com.newpager.modules.zhihu.mvp.ZhihuDaily;
import retrofit2.http.GET;

/**
 * Created by hhx on 2017/5/23.
 */

public interface ZhihuDailyApi {
    //最近的日报
    @GET("news/latest")
    Observable<ZhihuDaily> getZhiHuDaily();
}
