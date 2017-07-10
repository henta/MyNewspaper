package my.hhx.com.newpager.modules.zhihu.mvp;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import my.hhx.com.newpager.api.ApiManager;

/**
 * Created by hhx on 2017/6/18.
 */

public class ZhihuDailyPresenter implements ZhiHuDailyContract.Presenter {
    private ZhiHuDailyContract.View mZhihuDailyView;

    public ZhihuDailyPresenter(ZhiHuDailyContract.View zhihuDailyView) {
        mZhihuDailyView = zhihuDailyView;
    }

    @Override
    public void refreshData() {
        ApiManager.getInstence()
                .getmZhihuDailyService()
                .getZhiHuDaily()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ZhihuDaily>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ZhihuDaily zhihuDaily) {
                        mZhihuDailyView.refreshSuccess(zhihuDaily);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        mZhihuDailyView.refreshFail();
                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }

    @Override
    public void loadData() {
        ApiManager.getInstence()
                .getmZhihuDailyService()
                .getZhiHuDaily()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ZhihuDaily>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ZhihuDaily zhihuDaily) {

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    @Override
    public void loadCache() {

    }

}
