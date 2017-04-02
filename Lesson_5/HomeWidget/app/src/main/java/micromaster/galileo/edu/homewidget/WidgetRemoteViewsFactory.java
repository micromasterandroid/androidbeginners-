package micromaster.galileo.edu.homewidget;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutionException;

/**
 * Created by Byron on 4/2/2017.
 */

public class WidgetRemoteViewsFactory implements RemoteViewsService.RemoteViewsFactory {

    private Context context;
    private ArrayList<String> contactNames;

    public WidgetRemoteViewsFactory(Context context, Intent intent) {
        this.context = context;

    }

    @Override
    public void onCreate() {
        contactNames = new ArrayList<>();
        populateListItem();
    }

    //We are faking data, but this method should be a call to a ContentProvider or a DataBase to get real data
    private void populateListItem() {
        contactNames.add("John");
        contactNames.add("Mary");
        contactNames.add("Emma");
        contactNames.add("William");
        contactNames.add("Noah");
        contactNames.add("Susan");
        contactNames.add("Patricia");
        contactNames.add("Robert");
    }

    @Override
    public void onDataSetChanged() {
        populateListItem();
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public int getCount() {
        return contactNames.size();
    }

    @Override
    public RemoteViews getViewAt(int position) {

        String name = contactNames.get(position);

        RemoteViews mView = new RemoteViews(context.getPackageName(), R.layout.widget_list_row);

        mView.setTextViewText(R.id.contactNameTextView, name);
        return mView;
    }

    @Override
    public RemoteViews getLoadingView() {
        return null;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }
}
