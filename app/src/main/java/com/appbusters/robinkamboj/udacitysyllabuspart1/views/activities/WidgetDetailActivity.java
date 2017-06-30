package com.appbusters.robinkamboj.udacitysyllabuspart1.views.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.appbusters.robinkamboj.udacitysyllabuspart1.R;

import butterknife.BindView;

public class WidgetDetailActivity extends AppCompatActivity {

    private String head, desc;

    @BindView(R.id.heading)
    TextView heading;
    @BindView(R.id.description)
    TextView description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget_detail);

        head = getIntent().getStringExtra("heading");
        desc = getIntent().getStringExtra("desc");

        if(head!=null){
            heading.setText(head);
            description.setText(desc);
        }
    }
}
