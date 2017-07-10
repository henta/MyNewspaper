package my.hhx.com.newpager.modules.zhihu.mvp;

/**
 * Created by hhx on 2017/5/27.
 */

public interface ZhiHuDailyContract {
    interface View {
        void initView();

        void refreshFail();

        void refreshData();

        void refreshSuccess(ZhihuDaily zhihuDaily);
    }

    interface Presenter {
        void loadData();

        void loadCache();

        void refreshData();
    }
}
