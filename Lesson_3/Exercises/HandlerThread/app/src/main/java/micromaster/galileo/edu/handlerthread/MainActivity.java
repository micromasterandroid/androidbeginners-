package micromaster.galileo.edu.handlerthread;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    HandlerThread handlerThread;
    Handler handler;
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


        // Create a new handlerThread
        handlerThread = new HandlerThread("MyHandler");
        handlerThread.start();

        //Attached a handler
        handler = new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(Message msg) {
                Bundle bundle = msg.getData();
                String message = bundle.getString("message");
                pokemonList.add(message) ;
                recyclerViewAdapter.notifyDataSetChanged();
                Log.d("message", "" + message);
            }
        };

        final Button button = (Button) findViewById(R.id.pokemonButton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sendNewMessage();
            }
        });

    }

    //This method simulate that a sender send a new pokemon name to the app
    //then we send a message to the HandlerThread
    private void sendNewMessage() {
        Message message = handler.obtainMessage();

        ArrayList<String> listNewPokemons = new ArrayList<String>();
        listNewPokemons.add("Pikachu");
        listNewPokemons.add("Bulbasaur");
        listNewPokemons.add("Charmander");

        int index = new Random().nextInt(listNewPokemons.size());
        String pokemonName = listNewPokemons.get(index);

        Bundle b = new Bundle();
        b.putString("message", pokemonName);

        message.setData(b);
        handler.sendMessage(message);
    }

    @Override
    protected void onStop() {
        super.onStop();
        handlerThread.quit();
    }
}
