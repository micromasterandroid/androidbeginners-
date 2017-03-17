package micromaster.galileo.edu.alarmmanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Byron on 3/13/2017.
 */

public class BroadcastAlarm extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "alarm started", Toast.LENGTH_SHORT).show();
    }

}
