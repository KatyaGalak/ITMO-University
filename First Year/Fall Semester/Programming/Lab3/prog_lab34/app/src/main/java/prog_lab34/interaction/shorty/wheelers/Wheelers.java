package prog_lab34.interaction.shorty.wheelers;

import java.util.ArrayList;

import prog_lab34.interaction.shorty.Shorty;
import prog_lab34.interaction.shorty.constants.*;
import prog_lab34.interaction.location.Location;
import prog_lab34.interaction.location.parkattractionlocation.ParkAttractionLocation;
import prog_lab34.interaction.shorty.wheelers.exception.*;

public class Wheelers extends Shorty {
    private ArrayList<Wheel> typesWheels;

    {
        activityType = ActivityType.WHEEL;
        typesWheels = new ArrayList<>();
    }

    public Wheelers() {}

    private void checkCorrectnessLocation(Location location) {
        if (!(location instanceof ParkAttractionLocation)) {
            throw new WheelersArentInAttractionParkException();
        }
    }

    public Wheelers(Location location) {
        super(location);

        checkCorrectnessLocation(location);
    }

    public Wheelers(TimeSpent timeSpent) {
        super(timeSpent);
    }

    public Wheelers(Location location, TimeSpent timeSpent) {
        super(location, timeSpent);

        checkCorrectnessLocation(location);
    }

    @Override
    public void setLocation(Location location) {
        checkCorrectnessLocation(location);
        
        this.location = location;
    }

    @Override
    public <T> void addTypesActivity(T wheel) {
        if (wheel instanceof Wheel) {
            typesWheels.add((Wheel) wheel);
        } else {
            throw new IllegalArgumentException("В массив с типом данных Wheel был передан аргумент " + wheel.getClass());
        }
    }

    @Override
    public <T> void addTypesActivity(T[] wheels) {
        for (T wheel : wheels) {
            addTypesActivity(wheel);
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

        ans.append(" вертелись на чертовом колесе");

        if (!typesWheels.isEmpty()) {
            ans.append(", а самыми любимыми были");
            for (Wheel wheel : typesWheels) {
                ans.append(" " + wheel.name());
                if (wheel.numParticipants() > 1) {
                    ans.append(", в кабинку которого помещалось " + wheel.numParticipants() + " коротышки,");
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
