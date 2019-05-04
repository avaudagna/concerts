
public class ConcertRepository {
    public List<Concert> getConcerts() {
        return Arrays.asList(
                new Concert("Carajo", "25 de Junio", R.drawable.carajo),
                new Concert("Abel Pintos", "28 de Junio", R.drawable.abel),
                new Concert("La bomba del tiempo", "3 de Julio", R.drawable.bomba),
                new Concert("Cirse", "7 de Julio", R.drawable.cirse)
        )
    }
}