import android.view.View;

public class ConcertOnClickListener implements View.OnClickListener {
    private Concert concert;

    public ConcertOnClickListener(Concert concert) {
        this.concert = concert;
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(concertItem.getContext(), concert.getTitle(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(concertItem.getContext(), DetailsActivity.class);
        intent.putExtra("titulo", concert.getTitle());
        intent.putExtra("imagenId", concert.getImageId());
        intent.putExtra("fecha", concert.getFecha());
        concertItem.getContext().startActivity(intent);
    }
}