package com.appbusters.robinkamboj.udacitysyllabuspart1.view.activities.views.fragments;


import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.appbusters.robinkamboj.udacitysyllabuspart1.R;
import com.appbusters.robinkamboj.udacitysyllabuspart1.R2;
import com.appbusters.robinkamboj.udacitysyllabuspart1.view.activities.controller.MyDBHelper;
import com.appbusters.robinkamboj.udacitysyllabuspart1.view.activities.model.Data;
import com.appbusters.robinkamboj.udacitysyllabuspart1.view.activities.views.activities.MainActivity;
import com.appbusters.robinkamboj.udacitysyllabuspart1.view.activities.views.adapters.RecyclerOne;
import com.bumptech.glide.Glide;

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
    private String iHeading = null, iDesc = null;
    private NotificationManager notificationManager = null;

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
    @BindView(R.id.image)
    ImageView imageView;

    public OneFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_one, container, false);

        ButterKnife.bind(this, v);
        notificationManager = (NotificationManager) getActivity().getSystemService(Context.NOTIFICATION_SERVICE);

        data = new ArrayList<>();
        dbHelper = new MyDBHelper(getActivity());
        refreshRV();

        return v;
    }

    private void refreshRV(){
        data = dbHelper.getAllData();

        if(data.size()>1){
            alternate.setVisibility(View.GONE);
            adapter = new RecyclerOne(getActivity(), data);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerView.setAdapter(adapter);
        }
    }

    @OnClick(R.id.heading)
    public void setHeading(){
        new MaterialDialog.Builder(getActivity())
                .title(R.string.write_header)
                .content(R.string.heading_desc)
                .inputType(InputType.TYPE_CLASS_TEXT)
                .input(getString(R.string.hint_heading), null, new MaterialDialog.InputCallback() {
                    @Override
                    public void onInput(@NonNull MaterialDialog dialog, CharSequence input) {
                        if(input.toString().length()>5){
//                            Toast.makeText(getActivity(), R.string.heading_set, Toast.LENGTH_SHORT).show();
                            heading.setText(input);
                            iHeading = input.toString();
                        }
                        else {
                            Toast.makeText(getActivity(), R.string.please, Toast.LENGTH_SHORT).show();
                        }
                    }
                }).show();
    }

    @OnClick(R.id.description)
    public void setDescription(){
        new MaterialDialog.Builder(getActivity())
                .title(R.string.write_description)
                .content(R.string.description_desc)
                .inputType(InputType.TYPE_CLASS_TEXT)
                .input(getString(R.string.hint_description), null, new MaterialDialog.InputCallback() {
                    @Override
                    public void onInput(@NonNull MaterialDialog dialog, CharSequence input) {
                        if(input.toString().length()>5){
//                            Toast.makeText(getActivity(), R.string.desc_set, Toast.LENGTH_SHORT).show();
                            description.setText(input);
                            iDesc = input.toString();
                        }
                        else {
                            Toast.makeText(getActivity(), R.string.please, Toast.LENGTH_SHORT).show();
                        }
                    }
                }).show();
    }

    @OnClick(R.id.add)
    public void setAdd(){
        if(validateInput()){
            dbHelper.createItem(iHeading, iDesc);
            displayNotification(iHeading, iDesc);
            iHeading = null;
            iDesc = null;
            refreshRV();
            heading.setText(getString(R.string.enter_list_heading));
            description.setText(getString(R.string.enter_description_here));
        }
        else {
            Toast.makeText(getActivity(), R.string.complete_details, Toast.LENGTH_SHORT).show();
        }
    }

    private void displayNotification(String h, String d){
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(getActivity())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(getString(R.string.heading_set) + " " + h)
                .setContentText(getString(R.string.desc_set) + " " + d);

        String[] events = new String[6];
        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
        inboxStyle.setBigContentTitle("TESTING BIG CONTENT TEXT");

        for (int i = 0; i<6; i++){
            events[i] = "ROBILLO";
        }

        // Moves events into the expanded layout
        for (String event : events) {
            inboxStyle.addLine(event);
        }

        Intent resultIntent = new Intent(getActivity(), MainActivity.class);
        PendingIntent intent = PendingIntent.getActivity(getActivity(), 0, resultIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setStyle(inboxStyle);
        mBuilder.setContentIntent(intent);
        mBuilder.setAutoCancel(true);

        notificationManager.notify(0, mBuilder.build());
    }

    private boolean validateInput(){
        if(iHeading!=null && iDesc!=null){
            refreshRV();
            return true;
        }
        else {
            return false;
        }
    }
}
