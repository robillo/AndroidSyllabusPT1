package com.appbusters.robinkamboj.udacitysyllabuspart1.view.activities.views.activities;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.appbusters.robinkamboj.udacitysyllabuspart1.R;
import com.appbusters.robinkamboj.udacitysyllabuspart1.R2;
import com.appbusters.robinkamboj.udacitysyllabuspart1.view.activities.utils.SharedPrefs;
import com.appbusters.robinkamboj.udacitysyllabuspart1.view.activities.views.fragments.FiveFragment;
import com.appbusters.robinkamboj.udacitysyllabuspart1.view.activities.views.fragments.FourFragment;
import com.appbusters.robinkamboj.udacitysyllabuspart1.view.activities.views.fragments.OneFragment;
import com.appbusters.robinkamboj.udacitysyllabuspart1.view.activities.views.fragments.ThreeFragment;
import com.appbusters.robinkamboj.udacitysyllabuspart1.view.activities.views.fragments.TwoFragment;
import com.squareup.leakcanary.LeakCanary;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R2.id.fragment_container)
    FrameLayout container;
    @BindView(R2.id.header)
    TextView header;
    @BindView(R2.id.switch_bg)
    Switch switch_bg;
    @BindView(R2.id.switch_language)
    Switch switch_language;

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

        header.setText(getString(R.string.one));
        addFragment(1);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        if(SharedPrefs.getIsToggleTrue()!=null){
            if(SharedPrefs.getIsToggleTrue().equals(getString(R.string.key_true))){
                switch_bg.setBackgroundColor(getResources().getColor(R.color.white));
                switch_bg.setChecked(true);
            }
            else {
                switch_bg.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                switch_bg.setChecked(false);
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

        switch_language.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean situation) {
                if(situation){
                    Handler handler = new Handler();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Locale locale= new Locale("en");
                            Locale.setDefault(locale);
                            Configuration configuration = new Configuration();
                            configuration.locale = locale;
                            Resources resources = getResources();
                            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                            resources.updateConfiguration(configuration, displayMetrics);
                        }
                    });
                }
                else {
                    Handler handler = new Handler();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Locale locale = new Locale("hi");
                            Locale.setDefault(locale);
                            Configuration configuration = new Configuration();
                            configuration.locale = locale;
                            Resources resources = getResources();
                            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                            resources.updateConfiguration(configuration, displayMetrics);
                        }
                    });
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
}
