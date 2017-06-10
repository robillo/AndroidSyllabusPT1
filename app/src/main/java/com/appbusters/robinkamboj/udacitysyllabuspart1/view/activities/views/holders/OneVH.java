package com.appbusters.robinkamboj.udacitysyllabuspart1.view.activities.views.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.appbusters.robinkamboj.udacitysyllabuspart1.R;
import com.appbusters.robinkamboj.udacitysyllabuspart1.view.activities.utils.ItemClickListener;

import butterknife.BindView;

public class OneVH extends RecyclerView.ViewHolder implements View.OnClickListener{

    private ItemClickListener clickListener;

    @BindView(R.id.heading)
    public TextView heading;
    @BindView(R.id.description)
    public TextView description;

    public OneVH(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
    }

    public void setClickListener(ItemClickListener itemClickListener){
        this.clickListener = itemClickListener;
    }

    @Override
    public void onClick(View view) {
        clickListener.onClick(view, getAdapterPosition(), false);
    }
}
