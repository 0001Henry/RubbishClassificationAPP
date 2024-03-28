package com.tencent.yolov8ncnn.refuseclassification;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;

import com.tencent.yolov8ncnn.R;

public class NotificationActivity extends BaseActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        toolbar = (Toolbar) findViewById(R.id.notification_toolbar);
        toolbar.setTitle("通知");
        new setTitleCenter().setTitleCenter(toolbar);
    }
}
