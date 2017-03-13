package micromaster.galileo.edu.asynctaskloader;


import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import java.util.ArrayList;

/**
 * Created by Byron on 3/12/2017.
 */

public class NamesAsyncTaskLoader extends AsyncTaskLoader<ArrayList<String>> {

    public NamesAsyncTaskLoader(Context context) {
        super(context);
    }

    @Override
    public ArrayList<String> loadInBackground() {
        return loadNamesFromDB();
    }

    //This method simulates a call to a local database
    private ArrayList<String> loadNamesFromDB() {
        ArrayList<String> names = new ArrayList<>();
        names.add("John");
        names.add("Mary");
        names.add("Emma");
        names.add("Emma");
        names.add("Noah");

        return names;
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }
}
