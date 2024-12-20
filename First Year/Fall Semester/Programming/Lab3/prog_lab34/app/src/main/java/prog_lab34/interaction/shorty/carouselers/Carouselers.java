package prog_lab34.interaction.shorty.carouselers;

import java.util.ArrayList;

import prog_lab34.interaction.shorty.Shorty;
import prog_lab34.interaction.shorty.constants.*;
import prog_lab34.interaction.location.Location;
import prog_lab34.interaction.location.parkattractionlocation.*;
import prog_lab34.interaction.shorty.carouselers.exception.*;

public class Carouselers extends Shorty {
    private ArrayList<Carousel> typesCarousels;

    {
        activityType = ActivityType.CAROUSEL;
        typesCarousels = new ArrayList<>();
    }

    public Carouselers() {}

    private void checkCorrectnessLocation(Location location) {
        if (!(location instanceof ParkAttractionLocation)) {
            throw new CarouselersArentInAttractionParkException();
        }
        
    }

    @Override
    public void setLocation(Location location) {
        checkCorrectnessLocation(location);
        
        this.location = location;
    }

    public Carouselers(Location location) {
        super(location);

        checkCorrectnessLocation(location);
    }

    public Carouselers(TimeSpent timeSpent) {
        super(timeSpent);
    }

    public Carouselers(Location location, TimeSpent timeSpent) {
        super(location, timeSpent);

        checkCorrectnessLocation(location);
    }

    @Override
    public <T> void addTypesActivity(T carousel) {
        if (carousel instanceof Carousel) {
            typesCarousels.add((Carousel) carousel);
        } else {
            throw new IllegalArgumentException("В массив с типом данных Carousel был передан аргумент " + carousel.getClass());
        }
    }

    @Override
    public <T> void addTypesActivity(T[] carousels) {
        for (T carousel : carousels) {
            addTypesActivity(carousel);
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

        ans.append(" вертелись на каруселях");

        if (!typesCarousels.isEmpty()) {
            ans.append(", но самыми любимыми были");
            for (Carousel carousel : typesCarousels) {
                ans.append(" " + carousel.name());
                if (carousel.numParticipants() > 1) {
                    ans.append(", в кабинку которого помещалось " + carousel.numParticipants() + " коротышки,");
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