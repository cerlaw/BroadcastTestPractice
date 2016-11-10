package com.example.dell.broadcasttestpractice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by DELL on 2016/11/8.
 */

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.addactivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeactivity(this);
    }
}
