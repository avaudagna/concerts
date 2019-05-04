
import android.view.View;

public class ConcertOnClickListener implements View.OnClickListener {
    private Concert concert;

    public ConcertOnClickListener(Concert concert) {
        this.concert = concert;
    }

    @Override
    public void onClick(View view) {
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
}