package prog_lab34.interaction.shorty.dominolovers;

import java.util.ArrayList;

import prog_lab34.interaction.shorty.Shorty;
import prog_lab34.interaction.shorty.constants.*;
import prog_lab34.interaction.location.Location;

public class DominoLovers extends Shorty {
    private ArrayList<DominoGame> typesDominoGames;

    {
        activityType = ActivityType.DOMINO;
        typesDominoGames = new ArrayList<>();
    }

    public DominoLovers() {}

    public DominoLovers(Location location) {
        super(location);
    }

    public DominoLovers(TimeSpent timeSpent) {
        super(timeSpent);
    }

    public DominoLovers(Location location, TimeSpent timeSpent) {
        super(location, timeSpent);
    }

    @Override
    public <T> void addTypesActivity(T game) {
        if (game instanceof DominoGame) {
            typesDominoGames.add((DominoGame) game);
        } else {
            throw new IllegalArgumentException("В массив с типом данных DominoGame был передан аргумент " + game.getClass());
        }
    }

    @Override
    public <T> void addTypesActivity(T[] dominoGames) {
        for (T game : dominoGames) {
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

        ans.append(" стучали костяшками домино");

        if (!typesDominoGames.isEmpty()) {
            ans.append(", в особенности в");
            for (DominoGame dominoGame : typesDominoGames) {
                ans.append(" " + dominoGame.name());
                if (dominoGame.numParticipants() > 1) {
                    ans.append(" в группах по " + dominoGame.numParticipants() + " коротышки,");
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
