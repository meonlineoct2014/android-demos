package com.android.androidappdemos.views;

import androidx.appcompat.app.AppCompatActivity;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.androidappdemos.R;
import com.android.androidappdemos.services.SampleJobService;

public class SchedulerDemoActivity extends AppCompatActivity {

    Button startButton;
    Button stopButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scheduler_demo);
        startButton = findViewById(R.id.java_start_button);
        stopButton = findViewById(R.id.java_stop_button);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startJobService(view);
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopJobService();
            }
        });

    }

    private void stopJobService() {
        Log.e("SchedulerDemoActivity" , "stopJobService is called###");
        JobScheduler scheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
        scheduler.cancel(1234);
    }

    private void startJobService(View view) {
        Log.e("SchedulerDemoActivity" , "startJobSchedulerService is called###");
        ComponentName componentName = new ComponentName(this, SampleJobService.class);
        JobInfo info = new JobInfo.Builder(1234, componentName)
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED)
                .setPersisted(true)
                .setPeriodic(15 * 60 * 1000)
                .build();
        JobScheduler scheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
        scheduler.schedule(info);

    }
}