package prog_lab34.interaction.shorty.movielovers;

import java.util.ArrayList;

import prog_lab34.interaction.shorty.Shorty;
import prog_lab34.interaction.shorty.constants.*;
import prog_lab34.interaction.location.Location;
import prog_lab34.interaction.filmhero.AbleWatchFilmHero;
import prog_lab34.interaction.filmhero.FilmHero;

public class MovieLovers extends Shorty implements AbleWatchFilmHero {
    private ArrayList<Movie> typesMovies;

    {
        activityType = ActivityType.CINEMA;
        typesMovies = new ArrayList<>();
    }

    public MovieLovers() {}

    public MovieLovers(Location location) {
        super(location);
    }

    public MovieLovers(TimeSpent timeSpent) {
        super(timeSpent);
    }

    public MovieLovers(Location location, TimeSpent timeSpent) {
        super(location, timeSpent);
    }

    @Override
    public String watchFilmHero(FilmHero filmHero) {
        StringBuilder ans = new StringBuilder();

        if (levelDecreaseIntelligenceLevel < 0) {
            ans.append("Это, однако, ошибка, так как содержание фильмов было слишком бессмысленным, чтобы давать какую-нибудь пищу для ума. ");
        } else {
            ans.append("И, действительно, фильмы помогали киношникам получать бесценную пищу для ума. ");
        }

        ans.append("Киношники, глядя как");

        ans.append(filmHero.performAllActions(levelDecreaseIntelligenceLevel));

        return ans.toString();
    }

    @Override
    public <T> void addTypesActivity(T movie) {
        if (movie instanceof Movie) {
            typesMovies.add((Movie) movie);
        } else {
            throw new IllegalArgumentException("В массив с типом данных Movie был передан аргумент " + movie.getClass());
        }
    }

    @Override
    public <T> void addTypesActivity(T[] movies) {
        for (T movie : movies) {
            addTypesActivity(movie);
        }
    }

    @Override
    public String performActivity() {
        StringBuilder ans = new StringBuilder();
        ans.append(activityType.describe());

        if (timeSpent != null) {
            ans.append(" " + timeSpent.describe());
        }

        if (location != null) {
            ans.append(" " + location.getLocationInfo());
        } else {
            ans.append(" сидели в кинотеатре");
            ans.append(" и");
        }


        ans.append(" смотрели различные фильмы");

        if (!typesMovies.isEmpty()) {
            ans.append(", особенно им нравились");
            for (Movie movie : typesMovies) {
                ans.append(" " + movie.name() + ",");
            }
            ans.delete(ans.length() - 1, ans.length());
        }
        ans.append(".");

        return ans.toString();
    }

}
