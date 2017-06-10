package com.appbusters.robinkamboj.udacitysyllabuspart1;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.one:{
                    mTextMessage.setText(R.string.one);
                    return true;
                }
                case R.id.two:{
                    mTextMessage.setText(R.string.two);
                    return true;
                }
                case R.id.three:{
                    mTextMessage.setText(R.string.three);
                    return true;
                }
                case R.id.four:{
                    mTextMessage.setText(R.string.four);
                    return true;
                }
                case R.id.five:{
                    mTextMessage.setText(R.string.five);
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

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
