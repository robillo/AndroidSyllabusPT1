package com.appbusters.robinkamboj.udacitysyllabuspart1.view.activities.views.activities;

import android.app.Activity;
import android.content.Intent;
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
import com.appbusters.robinkamboj.udacitysyllabuspart1.view.activities.utils.SharedPrefs;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SettingsActivity extends Activity {

    @BindView(R.id.switch_language)
    Switch switch_language;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        ButterKnife.bind(this);

        if(SharedPrefs.getIsLanguageSet()!=null){
            if(SharedPrefs.getIsLanguageSet().equals(getString(R.string.key_true))){
                switch_language.setChecked(true);
            }
            else {
                switch_language.setChecked(false);
            }
        }

        switch_language.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean situation) {
                if(!situation){
                    Locale l= new Locale("en");
                    Locale.setDefault(l);
                    Configuration configuration = new Configuration();
                    configuration.locale = l;
                    Resources resources = getResources();
                    DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                    resources.updateConfiguration(configuration, displayMetrics);

                    SharedPrefs.setIsLanguageSet(getString(R.string.key_false));
                }
                else {
                    Locale l = new Locale("hi");
                    Locale.setDefault(l);
                    Configuration configuration = new Configuration();
                    configuration.locale = l;
                    Resources resources = getResources();
                    DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                    resources.updateConfiguration(configuration, displayMetrics);

                    SharedPrefs.setIsLanguageSet(getString(R.string.key_true));
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
