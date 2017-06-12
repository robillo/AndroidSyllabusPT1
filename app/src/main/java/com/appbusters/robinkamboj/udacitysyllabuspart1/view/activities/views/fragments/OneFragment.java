package com.appbusters.robinkamboj.udacitysyllabuspart1.view.activities.views.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.appbusters.robinkamboj.udacitysyllabuspart1.R;
import com.appbusters.robinkamboj.udacitysyllabuspart1.view.activities.model.Data;
import com.appbusters.robinkamboj.udacitysyllabuspart1.view.activities.views.adapters.RecyclerOne;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class OneFragment extends Fragment {

    private RecyclerOne adapter;
    List<Data> data = null;

    @BindView(R.id.heading)
    TextView heading;
    @BindView(R.id.description)
    TextView description;
    @BindView(R.id.add)
    Button add;
    @BindView(R.id.recycler)
    RecyclerView recyclerView;

    public OneFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_one, container, false);

        return v;
    }

    @OnClick(R.id.heading)
    public void setHeading(){

    }

    @OnClick(R.id.description)
    public void setDescription(){

    }

    @OnClick(R.id.add)
    public void setAdd(){

    }
}
