package com.android.androidappdemos.views

import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.android.androidappdemos.R
import com.android.androidappdemos.services.ExampleJobService
import com.android.androidappdemos.services.SampleJobService
import kotlinx.android.synthetic.main.activity_snack_bar_demo.*

class SnackBarDemoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_snack_bar_demo)

        button_start_job.setOnClickListener {
            startJobSchedulerService()
        }
        button_stop_job.setOnClickListener {
            stopJobSchedulerService()
        }
        //showLongBottomSnackbar(this, "This is snackbar text with context")
    }



    private fun startJobSchedulerService() {
        Log.e("SnackBarDemoActivity", "startJobSchedulerService is called###")
        val componentName = ComponentName(this, ExampleJobService::class.java)
        val jobInfo = JobInfo.Builder(1234, componentName)
            .setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED)
            .setPersisted(true)
            .setPeriodic(15 *60 * 1000)
            .build()
        val scheduler = getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler
        val resultCode = scheduler.schedule(jobInfo)

        if (resultCode == JobScheduler.RESULT_SUCCESS) {
            Log.e("SnackBarDemoActivity", "startJobSchedulerService success")
        } else {
            Log.e("SnackBarDemoActivity", "startJobSchedulerService failed")
        }
    }

    private fun stopJobSchedulerService() {
        Log.e("SnackBarDemoActivity", "stopJobSchedulerService is called###")
        val scheduler = getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler
        scheduler.cancel(1234)
    }
}