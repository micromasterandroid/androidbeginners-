package micromaster.galileo.edu.alarmmanager;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.icu.util.GregorianCalendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 1;
    private static final int TIME_INTERVAL = 50000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intentAlarm = new Intent(this, BroadcastAlarm.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), REQUEST_CODE, intentAlarm, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        //Set the alarm to wake up the device and set the time interval
        //and set the broadcast receiver for this alarm
        alarmManager.set(AlarmManager.RTC_WAKEUP, TIME_INTERVAL, pendingIntent);

    }
}
