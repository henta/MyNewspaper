package my.hhx.com.newpager.modules.zhihu.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import my.hhx.com.newpager.R;
import my.hhx.com.newpager.base.Card;
import my.hhx.com.newpager.base.HxBaseRecyclerAdapter;
import my.hhx.com.newpager.base.ZhihuDailyCard;

/**
 * Created by hhx on 2017/5/23.
 */

public class ZhiHuDailyFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener, ZhiHuDailyContract.View {
    @BindView(R.id.zhihu_daily_swipe)
    SwipeRefreshLayout zhihuDailySwipe;
    @BindView(R.id.no_see_tv)
    TextView noSeeTv;
    @BindView(R.id.zhihu_daily_recycler)
    RecyclerView zhihuDailyRecycler;
    private ZhihuDailyPresenter zhihuDailyPresenter = new ZhihuDailyPresenter(this);
    private ArrayList<ZhihuDaily.StoriesBean> mList;
    private HxBaseRecyclerAdapter mAdapter;

    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_zhihu_daily, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    public void initView() {
        mList = new ArrayList<>();
        zhihuDailyRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        zhihuDailySwipe.setColorSchemeResources(R.color.md_pink_100_color_code,
                R.color.md_pink_200_color_code,
                R.color.md_pink_300_color_code,
                R.color.md_pink_400_color_code);
        zhihuDailySwipe.setOnRefreshListener(this);
        mAdapter = new HxBaseRecyclerAdapter();
        refreshData();
    }


    @Override
    public void refreshFail() {
        //没数据时才会显示无数据，有数据不变
        if (mList == null) {
            noSeeTv.setVisibility(View.VISIBLE);
            zhihuDailySwipe.setVisibility(View.INVISIBLE);
        }

    }

    @Override
    public void refreshData() {
        zhihuDailyPresenter.refreshData();
    }

    @Override
    public void refreshSuccess(ZhihuDaily zhihuDaily) {
        if (zhihuDaily == null) {
            noSeeTv.setVisibility(View.VISIBLE);
            zhihuDailySwipe.requestFocus();
            return;
        } else {
            noSeeTv.setVisibility(View.GONE);
        }
        if (mList != null) {
            mList.clear();
        }
        mAdapter.clear();
        mList.addAll(zhihuDaily.getStories());
        mAdapter.setData(getCard(zhihuDaily));
        mAdapter.notifyDataSetChanged();
        zhihuDailyRecycler.setAdapter(mAdapter);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onRefresh() {
        refreshData();
        zhihuDailySwipe.setRefreshing(false);
    }

    public List<Card> getCard(ZhihuDaily zhihuDaily) {
        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < mList.size(); i++) {
            cards.add(new ZhihuDailyCard(mList.get(i)));
        }
        return cards;
    }
}
