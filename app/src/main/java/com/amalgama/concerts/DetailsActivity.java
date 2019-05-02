package com.amalgama.concerts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Inflamos el layout adecuado
        setContentView(R.layout.activity_details);

        //Obtenemos los argumentos que pasamos como extras en al intent.
        Bundle extras = getIntent().getExtras();

        //Recobramos cada uno de los valores con el metodo adecuado al tipo de dato.
        String nombre = extras.getString("titulo");
        //No necesitamos recuperarlos en el mismo orden al ingresado, eso es indistinto.
        String fecha = extras.getString("fecha");
        int fotoID = extras.getInt("imagenId");

        //Usamos la informacion recabada para popular de informacion los elementos visuales.
        ImageView fotoIv = (ImageView) findViewById(R.id.imagen);
        fotoIv.setImageResource(fotoID);
        TextView nombreTv = (TextView) findViewById(R.id.titulo);
        nombreTv.setText(nombre);
        TextView fechaTv = (TextView) findViewById(R.id.fecha);
        fechaTv.setText(fecha);
    }
}

