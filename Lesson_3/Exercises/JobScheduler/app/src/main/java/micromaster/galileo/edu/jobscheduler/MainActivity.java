package micromaster.galileo.edu.jobscheduler;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final int JOB_ID = 1;
    private static final int REFRESH_INTERVAL = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create JobScheduler
        JobScheduler jobScheduler = (JobScheduler) getSystemService(Context.JOB_SCHEDULER_SERVICE);

        //Create a component passing the JobService that we want to use
        ComponentName jobService =  new ComponentName(getPackageName(), MyJobService.class.getName());

        //Create a JobInfo passing a unique JOB_ID and the jobService
        //also set the periodic time to repeat this job
        JobInfo jobInfo =  new JobInfo.Builder(JOB_ID, jobService)
                .setPeriodic(REFRESH_INTERVAL)
                .build();

        jobScheduler.schedule(jobInfo);

    }
}
