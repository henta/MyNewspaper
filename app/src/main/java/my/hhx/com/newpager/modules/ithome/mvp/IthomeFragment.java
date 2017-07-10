package my.hhx.com.newpager.modules.ithome.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import my.hhx.com.newpager.R;

/**
 * Created by hhx on 2017/5/23.
 */

public class IthomeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ithome, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {

    }
}
