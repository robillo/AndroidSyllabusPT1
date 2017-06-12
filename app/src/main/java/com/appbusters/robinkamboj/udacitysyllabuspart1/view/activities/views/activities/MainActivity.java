package com.appbusters.robinkamboj.udacitysyllabuspart1.view.activities.views.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.appbusters.robinkamboj.udacitysyllabuspart1.R;
import com.appbusters.robinkamboj.udacitysyllabuspart1.view.activities.model.Data;
import com.appbusters.robinkamboj.udacitysyllabuspart1.view.activities.views.fragments.FiveFragment;
import com.appbusters.robinkamboj.udacitysyllabuspart1.view.activities.views.fragments.FourFragment;
import com.appbusters.robinkamboj.udacitysyllabuspart1.view.activities.views.fragments.OneFragment;
import com.appbusters.robinkamboj.udacitysyllabuspart1.view.activities.views.fragments.ThreeFragment;
import com.appbusters.robinkamboj.udacitysyllabuspart1.view.activities.views.fragments.TwoFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.fragment_container)
    FrameLayout container;
    @BindView(R.id.header)
    TextView header;

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

        header.setText(getString(R.string.one));
        addFragment(1);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    public void addFragment(int pos){
        switch (pos){
            case 1:{
                Log.e("ONE FRAGMENT", "BEFORE");
                OneFragment fragment = new OneFragment();
                callFrag(fragment);
                Log.e("ONE FRAGMENT", "AFTER");
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
