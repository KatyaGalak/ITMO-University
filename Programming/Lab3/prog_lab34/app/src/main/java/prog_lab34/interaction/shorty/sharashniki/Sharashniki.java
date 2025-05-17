package prog_lab34.interaction.shorty.sharashniki;

import java.util.ArrayList;

import prog_lab34.interaction.shorty.Shorty;
import prog_lab34.interaction.shorty.constants.*;
import prog_lab34.interaction.location.Location;

public class Sharashniki extends Shorty {
    private ArrayList<Sharashka> typesSharashki;

    {
        activityType = ActivityType.SHARASHKA;
        typesSharashki = new ArrayList<>();
    }

    public Sharashniki() {}

    public Sharashniki(Location location) {
        super(location);
    }

    public Sharashniki(TimeSpent timeSpent) {
        super(timeSpent);
    }

    public Sharashniki(Location location, TimeSpent timeSpent) {
        super(location, timeSpent);
    }

    @Override
    public <T> void addTypesActivity(T game) {
        if (game instanceof Sharashka) {
            typesSharashki.add((Sharashka) game);
        } else {
            throw new IllegalArgumentException("В массив с типом данных Sharashka был передан аргумент " + game.getClass());
        }
    }

    @Override
    public <T> void addTypesActivity(T[] sharashki) {
        for (T game : sharashki) {
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

        ans.append(" занимались различными изобретиниями и научными экспериментами");

        if (!typesSharashki.isEmpty()) {
            ans.append(", преимущественно");
            for (Sharashka sharashka : typesSharashki) {
                ans.append(" " + sharashka.name());
                if (sharashka.numParticipants() > 1) {
                    ans.append(" в группах по " + sharashka.numParticipants() + " коротышки,");
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
