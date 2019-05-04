package com.amalgama.concerts;

import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;
import concerts.ConcertOnClickListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LayoutInflater layoutInflater = LayoutInflater.from(getBaseContext()); //Objeto que "infla" layouts
        View viewCarajo = layoutInflater.inflate(R.layout.concert_carajo, null, false); //"inflado" de layouts, devuelve un objeto del tipo View
        View viewAbel= layoutInflater.inflate(R.layout.concert_abel, null, false);
        View viewBomba = layoutInflater.inflate(R.layout.concert_bomba, null, false);
        View viewCirse = layoutInflater.inflate(R.layout.concert_cirse, null, false);

        //Desde los activities al hacer findViewById se busca el layout con el id especificado en el que se uso para setContentView
        LinearLayout concertsContainer = (LinearLayout) findViewById(R.id.concerts_container);
        concertsContainer.addView(viewCarajo); //Se agrega el objeto View pasado como parametro a la lista de elementos del LinearLayout
        concertsContainer.addView(viewAbel);
        concertsContainer.addView(viewBomba);
        concertsContainer.addView(viewCirse);

        //Se setea el onClickListener para el objeto View.
        //El OnClickListener define comportamiento para el evento onClick que se efectue sobre la vista (View).
        //Ejemplo definiendo el OnClickListener como clase anonima (inner class)
        viewCarajo.setOnClickListener(new ConcertOnClickListener("Carajo"));
        viewAbel.setOnClickListener(new ConcertOnClickListener("Abel"));
        viewBomba.setOnClickListener(new ConcertOnClickListener("La bomba"));
    }
}
