package com.appbusters.robinkamboj.udacitysyllabuspart1.views.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.appbusters.robinkamboj.udacitysyllabuspart1.R;
import com.appbusters.robinkamboj.udacitysyllabuspart1.views.customviews.CustomView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class FourFragment extends Fragment {

    @BindView(R.id.swap)
    Button swap;
    @BindView(R.id.custom)
    CustomView customView;

    public FourFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_four, container, false);
        ButterKnife.bind(this, v);

        return v;
    }

    @OnClick(R.id.swap)
    public void setSwap(){
        customView.swapColor();
    }
}
