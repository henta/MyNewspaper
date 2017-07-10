package my.hhx.com.newpager.api;

import my.hhx.com.newpager.config.Config;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hhx on 2017/5/23.
 */

public class ApiManager {
    private ZhihuDailyApi mZhihuDailyApi;
    private static ApiManager sApiManager;

    private ApiManager() {

    }

    /**
     * 单例模式
     */
    public static ApiManager getInstence() {
        if (sApiManager == null) {
            synchronized (ApiManager.class) {
                if (sApiManager == null) {
                    sApiManager = new ApiManager();
                }
            }
        }
        return sApiManager;
    }

    /**
     * 封装知乎日报Api
     */
    public ZhihuDailyApi getmZhihuDailyService() {
        if (mZhihuDailyApi == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Config.ZHIHU_DAILY_API_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            mZhihuDailyApi = retrofit.create(ZhihuDailyApi.class);
        }
        return  mZhihuDailyApi;
    }

}
