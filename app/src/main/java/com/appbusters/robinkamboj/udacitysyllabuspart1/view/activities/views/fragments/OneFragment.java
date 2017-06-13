package com.appbusters.robinkamboj.udacitysyllabuspart1.view.activities.views.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.appbusters.robinkamboj.udacitysyllabuspart1.R;
import com.appbusters.robinkamboj.udacitysyllabuspart1.R2;
import com.appbusters.robinkamboj.udacitysyllabuspart1.view.activities.controller.MyDBHelper;
import com.appbusters.robinkamboj.udacitysyllabuspart1.view.activities.model.Data;
import com.appbusters.robinkamboj.udacitysyllabuspart1.view.activities.views.adapters.RecyclerOne;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class OneFragment extends Fragment {

    private RecyclerOne adapter;
    private List<Data> data = null;
    private MyDBHelper dbHelper;

    @BindView(R.id.heading)
    TextView heading;
    @BindView(R.id.description)
    TextView description;
    @BindView(R.id.add)
    Button add;
    @BindView(R.id.recycler)
    RecyclerView recyclerView;
    @BindView(R.id.alternate)
    LinearLayout alternate;

    public OneFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_one, container, false);

        ButterKnife.bind(this, v);

        data = new ArrayList<>();
        dbHelper = new MyDBHelper(getActivity());
        data = dbHelper.getAllData();

        if(data.size()>1){
            alternate.setVisibility(View.GONE);
            adapter = new RecyclerOne(getActivity(), data);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerView.setAdapter(adapter);
        }

        return v;
    }

//    private List<Data> fillWithData(){
//        List<Data> data = new ArrayList<>();
//
//        return data;
//    }

    @OnClick(R2.id.heading)
    public void setHeading(){
        new MaterialDialog.Builder(getActivity())
                .title(R.string.write_header)
                .content(R.string.heading_desc)
                .inputType(InputType.TYPE_CLASS_TEXT)
                .input(getString(R.string.hint_heading), null, new MaterialDialog.InputCallback() {
                    @Override
                    public void onInput(@NonNull MaterialDialog dialog, CharSequence input) {
                        if(input.length()>5){
                            Toast.makeText(getActivity(), input, Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(getActivity(), R.string.please, Toast.LENGTH_SHORT).show();
                        }
                    }
                }).show();
    }

    @OnClick(R2.id.description)
    public void setDescription(){
        new MaterialDialog.Builder(getActivity())
                .title(R.string.write_description)
                .content(R.string.description_desc)
                .inputType(InputType.TYPE_CLASS_TEXT)
                .input(getString(R.string.hint_description), null, new MaterialDialog.InputCallback() {
                    @Override
                    public void onInput(@NonNull MaterialDialog dialog, CharSequence input) {
                        if(input.length()>5){
                            Toast.makeText(getActivity(), input, Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(getActivity(), R.string.please, Toast.LENGTH_SHORT).show();
                        }
                    }
                }).show();
    }

    @OnClick(R2.id.add)
    public void setAdd(){

    }
}
