package micromaster.galileo.edu.homewidget;

import android.content.Intent;
import android.widget.RemoteViewsService;

/**
 * Created by Byron on 4/2/2017.
 */

public class WidgetService extends RemoteViewsService {

    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {

        WidgetRemoteViewsFactory dataProvider = new WidgetRemoteViewsFactory(
                getApplicationContext(), intent);
        return dataProvider;
    }

}