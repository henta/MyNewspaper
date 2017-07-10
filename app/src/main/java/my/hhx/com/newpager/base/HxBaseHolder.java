package my.hhx.com.newpager.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by hhx on 2017/6/23.
 */

public class HxBaseHolder extends RecyclerView.ViewHolder {
    private View mItemView;

    public HxBaseHolder(View itemView) {
        super(itemView);
        mItemView = itemView;
    }

    public View getItemView() {
        return mItemView;
    }

    public View getView(int resId) {
        View view = mItemView.findViewById(resId);
        return view;
    }
}
