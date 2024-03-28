package com.tencent.yolov8ncnn.refuseclassification;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;

import com.tencent.yolov8ncnn.R;

public class AboutActivity extends BaseActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        toolbar = (Toolbar) findViewById(R.id.about_toolbar);
        toolbar.setTitle("关于我们");
        new setTitleCenter().setTitleCenter(toolbar);
    }
}
