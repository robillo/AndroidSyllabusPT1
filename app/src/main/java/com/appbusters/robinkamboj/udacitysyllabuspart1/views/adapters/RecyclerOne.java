package com.appbusters.robinkamboj.udacitysyllabuspart1.views.adapters;

import android.content.Context;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.appbusters.robinkamboj.udacitysyllabuspart1.R;
import com.appbusters.robinkamboj.udacitysyllabuspart1.controller.MyDBHelper;
import com.appbusters.robinkamboj.udacitysyllabuspart1.model.Data;
import com.appbusters.robinkamboj.udacitysyllabuspart1.utils.ItemClickListener;
import com.appbusters.robinkamboj.udacitysyllabuspart1.views.holders.OneVH;

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
    public void onBindViewHolder(final OneVH holder, int position) {
        holder.heading.setText(list.get(position).getHeading());
        holder.description.setText(list.get(position).getDescription());
        holder.setClickListener(new ItemClickListener() {
            @Override
            public void onClick(View v, final int position, boolean isLongClick) {
                if(isLongClick){
                    //IF CLICK WAS LONG PRESS
                    PopupMenu popup = new PopupMenu(parentContext, holder.cardView);
                    popup.inflate(R.menu.menu_rv_one);
                    popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            switch (item.getItemId()){
                                case R.id.delete_item:{
                                    MyDBHelper dbHelper = new MyDBHelper(parentContext);
                                    dbHelper.delete(list.get(position).getHeading());
                                    list.remove(position);
                                    notifyItemRemoved(position);
                                    break;
                                }
                                case R.id.update_item:{

                                    break;
                                }
                            }
                            return true;
                        }
                    });
                    popup.show();
                }
                else {
                    //IF CLICK WAS NOT LONG PRESS
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
