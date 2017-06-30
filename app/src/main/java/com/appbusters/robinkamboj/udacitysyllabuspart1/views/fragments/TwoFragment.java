package com.appbusters.robinkamboj.udacitysyllabuspart1.views.fragments;


import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.appbusters.robinkamboj.udacitysyllabuspart1.R;

import java.io.IOException;
import java.io.InputStream;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class TwoFragment extends Fragment {

    @BindView(R.id.raw)
    ImageView raw;
    @BindView(R.id.res)
    ImageView res;
    @BindView(R.id.asset)
    ImageView asset;

    public TwoFragment() {
        // Required empty public constructor
    }


    @SuppressWarnings("deprecation")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_two, container, false);
        ButterKnife.bind(this, v);

        res.setImageDrawable(getResources().getDrawable(R.drawable.test));

        InputStream inputStream = getResources().openRawResource(R.raw.test);
        Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
        raw.setImageBitmap(bitmap);

        try {
            AssetManager assetManager = getContext().getAssets();
            InputStream inputStream1 = assetManager.open("test.jpg");
            Bitmap bitmap1 = BitmapFactory.decodeStream(inputStream1);
            asset.setImageBitmap(bitmap1);
        }
        catch (IOException e) {
            e.printStackTrace();
        }


        return v;
    }

}
