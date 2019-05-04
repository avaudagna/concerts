
import android.view.View;

public class ConcertOnClickListener implements View.OnClickListener {
    private String mensaje;

    public ConcertOnClickListener(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(getBaseContext(), mensaje, Toast.LENGTH_SHORT).show();
    }
}