package com.android.androidappdemos.services;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Log;

public class SampleJobService extends JobService {
    private static final String TAG = "SampleJobService";
    private boolean jobCancelled = false;

    @Override
    public boolean onStartJob(final JobParameters jobParameters) {
        Log.e(TAG, "onStartJob called ###");
        doBackgroundWork(jobParameters);
        return true;
    }

    private void doBackgroundWork(final JobParameters jobParameters) {
        new Thread(new Runnable() {
            @Override
            public void run() {


                for (int i = 0; i < 10; i++) {
                    if (jobCancelled) {
                        return;
                    }
                    Log.e(TAG, "job started with i = " + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                jobFinished(jobParameters, false);

            }
        }).start();
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        Log.e(TAG, "onStopJob called ###");
        jobCancelled = true;
        return true;
    }
}
