package com.android.androidappdemos.services

import android.app.job.JobParameters
import android.app.job.JobService
import android.util.Log

class ExampleJobService : JobService() {

    override fun onStartJob(jobParameters: JobParameters): Boolean {
        Log.e(TAG, "onStartJob called ###")
        Thread(Runnable {
            for (i in 0..9) {
                if (jobCancelled) {
                    return@Runnable
                }
                Log.e(TAG, "job started with i = $i")
                try {
                    Thread.sleep(1000)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
            jobFinished(jobParameters, false)

        }).start()
        return true
    }

    override fun onStopJob(jobParameters: JobParameters): Boolean {
        Log.e(TAG, "onStopJob called ###")
        jobCancelled = true
        return true
    }

    companion object {
        private const val TAG: String = "ExampleJobService"
        private var jobCancelled: Boolean = false
    }


}
