package micromaster.galileo.edu.homewidget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.RemoteViews;

/**
 * Created by Byron on 3/24/2017.
 */

public class WidgetContactProvider extends AppWidgetProvider {

    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        final int N = appWidgetIds.length;

        // Perform this loop procedure for each App Widget that belongs to this provider
        for (int i = 0; i < N; i++) {
            int appWidgetId = appWidgetIds[i];

            RemoteViews mView = new RemoteViews(context.getPackageName(), R.layout.widget_layout);

            //create an intent reference WidgetService
            Intent intent = new Intent(context, WidgetService.class);
            intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId);

            intent.setData(Uri.parse(intent.toUri(Intent.URI_INTENT_SCHEME)));
            mView.setRemoteAdapter(appWidgetId, R.id.contactListView, intent);
            appWidgetManager.updateAppWidget(appWidgetId, mView);

        }
        super.onUpdate(context, appWidgetManager, appWidgetIds);
    }


}