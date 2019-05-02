package com.amalgama.concerts;

import android.content.Intent;
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

        View viewCarajo = createConcertView(new Concert("Carajo", "25 de Junio", R.drawable.carajo));
        View viewAbel = createConcertView(new Concert("Abel Pintos", "28 de Junio", R.drawable.abel));
        View viewBomba = createConcertView(new Concert("La bomba del tiempo", "3 de Julio", R.drawable.bomba));
        View viewCirse = createConcertView(new Concert("Cirse", "7 de Julio", R.drawable.cirse));

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
        final View concertItem = LayoutInflater.from(getBaseContext()).inflate(R.layout.concert_item, null, false);
        ((TextView) concertItem.findViewById(R.id.title)).setText(concert.getTitle()); //Para el TextView nos interesa setear el texto
        ((ImageView) concertItem.findViewById(R.id.image)).setImageResource(concert.getImageId()); //Para el ImageView el resourceId de la imagen (resourceId porque tenemos guardada la imagen en el proyecto, sino esto seria diferente)
        ((TextView) concertItem.findViewById(R.id.fecha)).setText(String.valueOf(concert.getFecha()));
        concertItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(concertItem.getContext(), concert.getTitle(), Toast.LENGTH_SHORT).show();
                //Se crea un intent especificando el contexto del que se parte y el .class del activity destino.
                Intent intent = new Intent(concertItem.getContext(), DetailsActivity.class);
                //Agregar extras es opcional, pero necesario para pasar informacion entre acitivties (este es un metodo, hay otros, ya los veremos).
                intent.putExtra("titulo", concert.getTitle());
                intent.putExtra("imagenId", concert.getImageId());
                intent.putExtra("fecha", concert.getFecha());
                //Con este metodo se inicia la transicion del intent y queda en el backstack el activity del que venimos para ser recuperado con la
                //accion backpress.
                concertItem.getContext().startActivity(intent);
            }
        });

        return concertItem;
    }
}
