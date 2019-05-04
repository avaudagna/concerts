package com.amalgama.concerts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Instancio un nuevo Concierto con los datos que cada una especifica y uso un metodo que me
        //permite generar una vista de concierto en funcion de los datos de una que le pase por parametro.
        View viewCarajo = createConcertView(new Concert("Carajo", "25 de Junio", R.drawable.carajo));
        View viewAbel = createConcertView(new Concert("Abel Pintos", "28 de Junio", R.drawable.abel));
        View viewBomba = createConcertView(new Concert("La bomba del tiempo", "3 de Julio", R.drawable.bomba));
        View viewCirse = createConcertView(new Concert("Cirse", "7 de Julio", R.drawable.cirse));

        //TODO: El metodo createConcertView esta bueno, pero no se si es el mejor lugar para ponerlo aca...
        //TODO: Pensemos, el Activity, ¿deberia ser responsable de saber "inflar" un objeto Concert a su representacion como View?
        //TODO: De solo formularse la pregunta ya suena que esto es algo que estaria mejor modelado en otro lado...

        LinearLayout concertContainer = (LinearLayout) findViewById(R.id.concerts_container);
        concertContainer.addView(viewCarajo);
        concertContainer.addView(viewAbel);
        concertContainer.addView(viewBomba);
        concertContainer.addView(viewCirse);
    }


    /**
     * Recibe la representacion de un concierto y devuelve la vista con sus datos.
     * @param concert el concierto a representar en la vista
     * @return la vista con los datos del concierto
     */
    private View createConcertView(final Concert concert) {
        //Se "infla" el template del item de concierto.
        View concertItem = LayoutInflater.from(getBaseContext()).inflate(R.layout.concert_item, null, false);
        //Se castea lo devuelto por findViewById al objeto visual que sabemos que es realmente y lo configuramos con la data del concierto.
        ((TextView) concertItem.findViewById(R.id.title)).setText(concert.getTitle()); //Para el TextView nos interesa setear el texto
        ((ImageView) concertItem.findViewById(R.id.image)).setImageResource(concert.getImageId()); //Para el ImageView el resourceId de la imagen (resourceId porque tenemos guardada la imagen en el proyecto, sino esto seria diferente)
        ((TextView) concertItem.findViewById(R.id.fecha)).setText(String.valueOf(concert.getFecha()));
        //Le agregamos el listener de OnClick a la vista.
        concertItem.setOnClickListener(new ConcertOnClickListener(concert.getTitle()));
        return concertItem;
    }
}
