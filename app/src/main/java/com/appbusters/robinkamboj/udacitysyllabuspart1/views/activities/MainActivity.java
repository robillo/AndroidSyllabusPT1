package com.appbusters.robinkamboj.udacitysyllabuspart1.views.activities;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.appbusters.robinkamboj.udacitysyllabuspart1.R;
import com.appbusters.robinkamboj.udacitysyllabuspart1.R2;
import com.appbusters.robinkamboj.udacitysyllabuspart1.utils.SharedPrefs;
import com.appbusters.robinkamboj.udacitysyllabuspart1.views.fragments.FiveFragment;
import com.appbusters.robinkamboj.udacitysyllabuspart1.views.fragments.FourFragment;
import com.appbusters.robinkamboj.udacitysyllabuspart1.views.fragments.OneFragment;
import com.appbusters.robinkamboj.udacitysyllabuspart1.views.fragments.ThreeFragment;
import com.appbusters.robinkamboj.udacitysyllabuspart1.views.fragments.TwoFragment;
import com.squareup.leakcanary.LeakCanary;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.fragment_container)
    FrameLayout container;
    @BindView(R.id.header)
    TextView header;
    @BindView(R.id.switch_bg)
    Switch switch_bg;
    @BindView(R.id.settings)
    Button settings;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.one:{
                    header.setText(getString(R.string.one));
                    addFragment(1);
                    return true;
                }
                case R.id.two:{
                    header.setText(getString(R.string.two));
                    addFragment(2);
                    return true;
                }
                case R.id.three:{
                    header.setText(getString(R.string.three));
                    addFragment(3);
                    return true;
                }
                case R.id.four:{
                    header.setText(getString(R.string.four));
                    addFragment(4);
                    return true;
                }
                case R.id.five:{
                    header.setText(getString(R.string.five));
                    addFragment(5);
                    return true;
                }
            }
            return false;
        }

    };

    @SuppressWarnings("deprecation")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(getApplication());

        if(SharedPrefs.getIsLanguageSet()!=null){
            if(SharedPrefs.getIsLanguageSet().equals(getString(R.string.key_true))){
                Locale l = new Locale("hi");
                Locale.setDefault(l);
                Configuration configuration = new Configuration();
                configuration.locale = l;
                Resources resources = getResources();
                DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                resources.updateConfiguration(configuration, displayMetrics);
            }
            else {
                Locale l= new Locale("en");
                Locale.setDefault(l);
                Configuration configuration = new Configuration();
                configuration.locale = l;
                Resources resources = getResources();
                DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                resources.updateConfiguration(configuration, displayMetrics);
            }
        }

        header.setText(getString(R.string.one));
        addFragment(1);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        if(SharedPrefs.getIsToggleTrue()!=null){
            if(SharedPrefs.getIsToggleTrue().equals(getString(R.string.key_true))){
                switch_bg.setBackgroundColor(getResources().getColor(R.color.white));
                switch_bg.setChecked(true);
                switch_bg.setContentDescription("COLOR CHANGED TO WHITE");
            }
            else {
                switch_bg.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                switch_bg.setChecked(false);
                switch_bg.setContentDescription("COLOR CHANGED TO PRIMARY DARK");
            }
        }

        switch_bg.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean situation) {
                if(situation){
                    SharedPrefs.setIsToggleTrue(getString(R.string.key_true));
                    switch_bg.setBackgroundColor(getResources().getColor(R.color.white));
                }
                else {
                    SharedPrefs.setIsToggleTrue(getString(R.string.key_false));
                    switch_bg.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                }
            }
        });
    }

    public void addFragment(int pos){
        switch (pos){
            case 1:{
                OneFragment fragment = new OneFragment();
                callFrag(fragment);
                break;
            }
            case 2:{
                TwoFragment fragment = new TwoFragment();
                callFrag(fragment);
                break;
            }
            case 3:{
                ThreeFragment fragment = new ThreeFragment();
                callFrag(fragment);
                break;
            }
            case 4:{
                FourFragment fragment = new FourFragment();
                callFrag(fragment);
                break;
            }
            case 5:{
                FiveFragment fragment = new FiveFragment();
                callFrag(fragment);
                break;
            }
        }
    }

    private void callFrag(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @OnClick(R2.id.settings)
    public void setSettings(){
        startActivity(new Intent(this, SettingsActivity.class));
    }
}
