package prog_lab34.interaction.shorty;

import prog_lab34.interaction.shorty.constants.*;
import prog_lab34.interaction.location.Location;

public abstract class Shorty {
    protected ActivityType activityType;
    protected IntelligenceLevel intelligenceLevel;
    protected int intelligenceLevelNum = 7;
    protected Location location;
    protected TimeSpent timeSpent;

    protected int levelDecreaseIntelligenceLevel = -1;

    {
        intelligenceLevel = IntelligenceLevel.fromLevel(intelligenceLevelNum);
    }

    public Shorty() {}

    public Shorty(Location location, TimeSpent timeSpent) {
        this.location = location;
        this.timeSpent = timeSpent;
    } 

    public Shorty(TimeSpent timeSpent) {
        this.timeSpent = timeSpent;
    } 

    public Shorty(Location location) {
        this.location = location;
    } 

    public ActivityType getActivityType() {
        return activityType;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public void setTimeSpent(TimeSpent timeSpent) {
        this.timeSpent = timeSpent;
    }

    public TimeSpent getTimeSpent() {
        return timeSpent;
    }

    public IntelligenceLevel getIntelligenceLevel() {
        return intelligenceLevel;
    }

    public void setLevelDecreaseIntelligenceLevel(int level) {
        levelDecreaseIntelligenceLevel = level;
    }

    public int getIntelligenceLevelNum() {
        return intelligenceLevelNum;
    }

    public boolean checkIncreaseIntelligenceLevel() {
        return (levelDecreaseIntelligenceLevel >= 0);
    }

    public void changesIntelligenceLevelAfterActivity() {
        int modifiedLevel = intelligenceLevelNum + levelDecreaseIntelligenceLevel;
        intelligenceLevelNum = modifiedLevel < 0 ? 0 : modifiedLevel;
        intelligenceLevelNum = intelligenceLevelNum > 10 ? 10 : intelligenceLevelNum;
        intelligenceLevel = IntelligenceLevel.fromLevel(intelligenceLevelNum);
    }

    public abstract String performActivity();
    public abstract <T> void addTypesActivity(T[] typesActivity);
    public abstract <T> void addTypesActivity(T typesActivity);

    @Override
    public String toString() {
        return this.activityType.describe();
    }

    @Override
    public int hashCode() {
        return this.activityType.describe().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (!(obj instanceof Shorty)) {
            return false;
        }
        Shorty person = (Shorty) obj;
        return this.activityType.describe().equals(person.activityType.describe());
    }
}
