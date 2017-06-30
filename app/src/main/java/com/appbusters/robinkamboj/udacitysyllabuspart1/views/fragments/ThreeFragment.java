package com.appbusters.robinkamboj.udacitysyllabuspart1.views.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.appbusters.robinkamboj.udacitysyllabuspart1.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ThreeFragment extends Fragment {

    @BindView(R.id.asset)
    TextView asset;
    @BindView(R.id.raw)
    TextView raw;

    public ThreeFragment() {
        // Required empty public constructor
    }


    @SuppressWarnings("ResultOfMethodCallIgnored")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_three, container, false);
        ButterKnife.bind(this, v);

        StringBuilder buffer = new StringBuilder();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(getContext().getAssets().open("text.txt")));
            String temp;
            while ((temp = reader.readLine())!=null){
                buffer.append(temp);
            }
            asset.setText(buffer.toString());
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            try {
                assert reader != null;
                reader.close();
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }

        try {
            // get input stream for text
            InputStream is = getResources().openRawResource(R.raw.text);
            // check size
            int size = is.available();
            // create buffer for IO
            byte[] buffer1 = new byte[size];
            // get data to buffer
            is.read(buffer1);
            // close stream
            is.close();
            // set result to TextView
            raw.setText(new String(buffer));
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return v;
    }

}
