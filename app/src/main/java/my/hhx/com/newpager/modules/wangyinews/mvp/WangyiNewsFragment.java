package my.hhx.com.newpager.modules.wangyinews.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import my.hhx.com.newpager.R;

/**
 * Created by hhx on 2017/5/23.
 */

public class WangyiNewsFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_wangyi_news, container, false);
        initView(view);
        Log.e("hhx","wangyi");
        return view;
    }

    private void initView(View view) {

    }
}
