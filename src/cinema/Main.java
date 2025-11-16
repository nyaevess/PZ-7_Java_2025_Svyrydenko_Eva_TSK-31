package cinema;

public class Main {
    public static void main(String[] args) {

        Actor a1 = new Actor("Tom");
        Actor a2 = new Actor("Bob");
        Actor a3 = new Actor("Anna");

        Film f1 = new Film("Movie1");
        Film f2 = new Film("Movie2");

        // додавання акторів у фільми
        f1.addActor(a1);
        f1.addActor(a2);
        f2.addActor(a2);
        f2.addActor(a3);

        // додавання фільмів у акторів
        a1.addFilm(f1);
        a2.addFilm(f1);
        a2.addFilm(f2);
        a3.addFilm(f2);

        // тестуємо наприклад варіант 3
        CinemaDB3 db = new CinemaDB3();

        db.addActor(a1);
        db.addActor(a2);
        db.addActor(a3);

        db.addFilm(f1);
        db.addFilm(f2);

        System.out.println("Актор без фільмів: " + db.hasActorWithoutFilms());
        System.out.println("Ко-актори Toma: " + db.coActors(a1));
        System.out.println("Фільм з найбільшою кількістю акторів: " + db.maxActorsFilm());
    }
}