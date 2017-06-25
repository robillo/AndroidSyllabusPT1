package com.appbusters.robinkamboj.udacitysyllabuspart1.view.activities.views.activities;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.appbusters.robinkamboj.udacitysyllabuspart1.R;
import com.appbusters.robinkamboj.udacitysyllabuspart1.R2;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SettingsActivity extends AppCompatActivity {

    @BindView(R2.id.switch_language)
    Switch switch_language;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        ButterKnife.bind(this);

        switch_language.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean situation) {
                if(situation){
                    Locale locale= new Locale("en");
                    Locale.setDefault(locale);
                    Configuration configuration = new Configuration();
                    configuration.locale = locale;
                    Resources resources = getResources();
                    DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                    resources.updateConfiguration(configuration, displayMetrics);
                }
                else {
                    Locale locale = new Locale("hi");
                    Locale.setDefault(locale);
                    Configuration configuration = new Configuration();
                    configuration.locale = locale;
                    Resources resources = getResources();
                    DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                    resources.updateConfiguration(configuration, displayMetrics);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
