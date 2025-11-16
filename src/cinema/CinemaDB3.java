package cinema;

import java.util.*;

public class CinemaDB3 {

    private List<Film> films = new ArrayList<>();
    private List<Actor> actors = new ArrayList<>();

    public void addFilm(Film f) { films.add(f); }
    public void addActor(Actor a) { actors.add(a); }

    // 1
    public boolean hasActorWithoutFilms() {
        for (Actor a : actors) {
            if (a.getFilms().isEmpty()) return true;
        }
        return false;
    }

    // 2
    public List<Actor> coActors(Actor target) {
        List<Actor> res = new ArrayList<>();

        for (Film f : films) {
            if (f.getActors().contains(target)) {
                for (Actor a : f.getActors()) {
                    if (!a.equals(target) && !res.contains(a)) res.add(a);
                }
            }
        }
        return res;
    }

    // 3
    public Film maxActorsFilm() {
        Film best = null;
        int max = -1;

        for (Film f : films) {
            if (f.getActors().size() > max) {
                max = f.getActors().size();
                best = f;
            }
        }
        return best;
    }
}