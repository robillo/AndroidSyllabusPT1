package com.appbusters.robinkamboj.udacitysyllabuspart1.view.activities.views.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appbusters.robinkamboj.udacitysyllabuspart1.R;
import com.appbusters.robinkamboj.udacitysyllabuspart1.view.activities.model.Data;
import com.appbusters.robinkamboj.udacitysyllabuspart1.view.activities.utils.ItemClickListener;
import com.appbusters.robinkamboj.udacitysyllabuspart1.view.activities.views.holders.OneVH;

import java.util.ArrayList;
import java.util.List;

public class RecyclerOne extends RecyclerView.Adapter<OneVH>{

    private List<Data> list = new ArrayList<>();
    private Context parentContext;

    public RecyclerOne(Context parentContext, List<Data> list) {
        this.list = list;
        this.parentContext = parentContext;
    }

    @Override
    public OneVH onCreateViewHolder(ViewGroup parent, int viewType) {
        parentContext = parent.getContext();
        View v = LayoutInflater.from(parentContext).inflate(R.layout.row_layout, parent, false);
        return new OneVH(v);
    }

    @Override
    public void onBindViewHolder(OneVH holder, int position) {
        holder.heading.setText(list.get(position).getHeading());
        holder.description.setText(list.get(position).getDescription());
        holder.setClickListener(new ItemClickListener() {
            @Override
            public void onClick(View v, int position, boolean isLongClick) {
                switch (v.getId()){

                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
