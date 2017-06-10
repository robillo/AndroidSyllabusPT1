package com.appbusters.robinkamboj.udacitysyllabuspart1.view.activities.views.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.appbusters.robinkamboj.udacitysyllabuspart1.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
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

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    public void addFragment(int pos){
        switch (pos){
            case 1:{

                break;
            }
            case 2:{

                break;
            }
            case 3:{

                break;
            }
            case 4:{

                break;
            }
            case 5:{

                break;
            }
        }
    }
}
