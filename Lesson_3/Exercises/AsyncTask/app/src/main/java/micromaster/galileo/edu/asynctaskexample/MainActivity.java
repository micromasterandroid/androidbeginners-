package micromaster.galileo.edu.asynctaskexample;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;
    ArrayList<String> pokemonList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview1);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerViewAdapter = new RecyclerViewAdapter(pokemonList);
        recyclerView.setAdapter(recyclerViewAdapter);


        final Button button = (Button) findViewById(R.id.pokemonButton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                new DownloadPokemonTask(MainActivity.this).execute();
            }
        });

    }


    private class DownloadPokemonTask extends AsyncTask<Void, Integer, ArrayList<String>> {

        private ProgressDialog dialog;

        public DownloadPokemonTask (Context context) {
            this.dialog =  new ProgressDialog(context);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            this.dialog.setMessage("Downloading data...");
            dialog.show();
        }


        @Override
        protected ArrayList<String> doInBackground(Void... params) {
            ArrayList<String> newPokemonList = new ArrayList<>();
            for (int i = 1; i <= 3; i++) {
                try {
                    Thread.sleep(1000);
                    newPokemonList.add(simulateCalltoAPI(i));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return newPokemonList;
        }

        //This method simulate a call to API
        private String simulateCalltoAPI(int i){
            switch (i) {
                case 1:
                    return "Bulbasaur";
                case 2:
                    return "Ivysaur";
                case 3:
                    return "Venusaur";
                default:
                    return "Invalid number";
            }
        }

        @Override
        protected void onPostExecute(ArrayList<String> result) {
            super.onPostExecute(result);
            pokemonList.clear();
            pokemonList.addAll(result) ;
            recyclerViewAdapter.notifyDataSetChanged();
            dialog.dismiss();
        }
    }
}
