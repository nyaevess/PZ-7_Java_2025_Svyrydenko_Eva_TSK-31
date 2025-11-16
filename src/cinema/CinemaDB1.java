package cinema;

import java.util.*;

public class CinemaDB1 {

    private List<Film> films = new ArrayList<>();
    private List<Actor> actors = new ArrayList<>();

    public void addFilm(Film f) { films.add(f); }
    public void addActor(Actor a) { actors.add(a); }

    // 1
    public boolean hasActorWithoutFilms() {
        Iterator it = actors.iterator();
        while (it.hasNext()) {
            Actor a = (Actor) it.next();
            if (a.getFilms().isEmpty()) return true;
        }
        return false;
    }

    // 2
    public List<Actor> coActors(Actor target) {
        List<Actor> res = new ArrayList<>();

        Iterator itFilms = films.iterator();
        while (itFilms.hasNext()) {
            Film f = (Film) itFilms.next();

            if (f.getActors().contains(target)) {

                Iterator itActors = f.getActors().iterator();
                while (itActors.hasNext()) {
                    Actor a = (Actor) itActors.next();
                    if (!a.equals(target) && !res.contains(a)) {
                        res.add(a);
                    }
                }
            }
        }
        return res;
    }

    // 3
    public Film maxActorsFilm() {
        Film best = null;
        int max = -1;

        Iterator it = films.iterator();
        while (it.hasNext()) {
            Film f = (Film) it.next();
            if (f.getActors().size() > max) {
                max = f.getActors().size();
                best = f;
            }
        }
        return best;
    }
}