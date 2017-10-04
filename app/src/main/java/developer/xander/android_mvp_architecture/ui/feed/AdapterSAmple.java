package developer.xander.android_mvp_architecture.ui.feed;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import developer.xander.android_mvp_architecture.ui.base.BaseRecyclerViewAdapter;


/**
 * Created by Augtonov on 1/10/17.
 */

public class AdapterSAmple extends BaseRecyclerViewAdapter<AdapterSAmple.ViewHolder> {


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = new TextView(itemView.getContext());
        }
    }
}
