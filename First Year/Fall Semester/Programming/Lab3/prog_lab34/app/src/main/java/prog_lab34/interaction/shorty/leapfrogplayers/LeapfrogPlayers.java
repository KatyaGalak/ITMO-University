package prog_lab34.interaction.shorty.leapfrogplayers;

import java.util.ArrayList;

import prog_lab34.interaction.shorty.Shorty;
import prog_lab34.interaction.shorty.constants.*;
import prog_lab34.interaction.location.Location;
import prog_lab34.interaction.location.tablelocation.TableLocation;
import prog_lab34.interaction.shorty.leapfrogplayers.exception.*;

public class LeapfrogPlayers extends Shorty {
    private ArrayList<LeapfrogGame> typesLeapfrog;

    {
        activityType = ActivityType.LEAPFROG;
        typesLeapfrog = new ArrayList<>();
    }

    public LeapfrogPlayers() {}

    private void checkCorrectnessLocation(Location location) {
        if (location instanceof TableLocation) {
            throw new LeapfrogPlayersCannotBeInTableLocation();
        }
    }

    @Override
    public void setLocation(Location location) {
        checkCorrectnessLocation(location);
        
        this.location = location;
    }

    public LeapfrogPlayers(Location location) {
        super(location);

        checkCorrectnessLocation(location);
    }

    public LeapfrogPlayers(TimeSpent timeSpent) {
        super(timeSpent);
    }

    public LeapfrogPlayers(Location location, TimeSpent timeSpent) {
        super(location, timeSpent);

        checkCorrectnessLocation(location);
    }

    @Override
    public <T> void addTypesActivity(T game) {
        if (game instanceof LeapfrogGame) {
            typesLeapfrog.add((LeapfrogGame) game);
        } else {
            throw new IllegalArgumentException("В массив с типом данных LeapfrogGame был передан аргумент " 
                                                + game.getClass());
        }
    }

    @Override
    public <T> void addTypesActivity(T[] leapfrogs) {
        for (T game : leapfrogs) {
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

        ans.append(" не признавали ничего, кроме игры в чехарду");

        if (!typesLeapfrog.isEmpty()) {
            ans.append(", а чаще всего играли в");
            for (LeapfrogGame leapfrog : typesLeapfrog) {
                ans.append(" " + leapfrog.name());
                if (leapfrog.numParticipants() > 1) {
                    ans.append(" в группах по " + leapfrog.numParticipants() + " коротышки,");
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