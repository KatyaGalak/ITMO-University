package prog_lab34.interaction.shorty.gamblers;

import java.util.ArrayList;

import prog_lab34.interaction.shorty.Shorty;
import prog_lab34.interaction.shorty.constants.*;
import prog_lab34.interaction.location.Location;

public class Gamblers extends Shorty {
    private ArrayList<CardGame> typesCardGames;

    {
        activityType = ActivityType.CARDS;
        typesCardGames = new ArrayList<>();
    }

    public Gamblers() {}

    public Gamblers(Location location) {
        super(location);
    }

    public Gamblers(TimeSpent timeSpent) {
        super(timeSpent);
    }

    public Gamblers(Location location, TimeSpent timeSpent) {
        super(location, timeSpent);
    }

    @Override
    public <T> void addTypesActivity(T game) {
        if (game instanceof CardGame) {
            typesCardGames.add((CardGame) game);
        } else {
            throw new IllegalArgumentException("В массив с типом данных CardGame был передан аргумент " + game.getClass());
        }
    }

    @Override
    public <T> void addTypesActivity(T[] cardGames) {
        for (T game : cardGames) {
            addTypesActivity(game);
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
        }

        ans.append(" играли в карты");

        if (!typesCardGames.isEmpty()) {
            ans.append(", преимущественно в");
            for (CardGame cardGame : typesCardGames) {
                ans.append(" " + cardGame.name());
                if (cardGame.numParticipants() > 1) {
                    ans.append(" в группах по " + cardGame.numParticipants() + " коротышки,");
                } else {
                    ans.append(",");
                }
            }
            ans.delete(ans.length() - 1, ans.length());
        }
        ans.append(".");

        return ans.toString();
    }
}
