package prog_lab34.parsingconfigfile;

import java.util.AbstractMap;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import prog_lab34.interaction.community.ShortyGroup;
import prog_lab34.interaction.filmhero.FilmHero;

import prog_lab34.interaction.filmhero.action.*;
import prog_lab34.interaction.location.grasslocation.GrassLocation;
import prog_lab34.interaction.location.grasslocation.GrassType;
import prog_lab34.interaction.location.parkattractionlocation.*;
import prog_lab34.interaction.location.tablelocation.*;
import prog_lab34.interaction.location.Location;
import prog_lab34.interaction.filmhero.exceptions.ActionAlreadyExistsException;

import prog_lab34.interaction.shorty.gamblers.*;
import prog_lab34.interaction.shorty.leapfrogplayers.*;
import prog_lab34.interaction.shorty.Shorty;
import prog_lab34.interaction.shorty.carouselers.*;
import prog_lab34.interaction.shorty.constants.TimeSpent;
import prog_lab34.interaction.shorty.dominolovers.*;
import prog_lab34.interaction.shorty.sharashniki.*;
import prog_lab34.interaction.community.exceptions.ShortyAlreadyExistsException;

import prog_lab34.interaction.shorty.wheelers.*;
import prog_lab34.interaction.shorty.movielovers.*;

import prog_lab34.interaction.location.cinemalocation.*;

public class FileObjProvider implements ObjProvider {
    @Override
    public AbstractMap.SimpleEntry<ShortyGroup, FilmHero> creator(){
        throw new IllegalArgumentException("[Error] The path to the config file for FileObjProvider was not passed.");
    }

    class Root {
        List<Activity> shorties;
        List<String> filmHero;
    }
    
    class Activity {
        String activityType;
        String timeSpent;
        ParsingLocation location;
        Integer levelDecreaseIntelligenceLevel;
        List<ParsingTypeActivity> typesActivity;
    }
    
    class ParsingLocation {
        String nameLocation;
        String name;
        String type;
    }
    
    class ParsingTypeActivity {
        String name;
        Integer numParticipants;
    }

    private Shorty parsingActivityType(String activityType) {
        if (activityType.equals("Gamblers")) {
            return new Gamblers();
        } else if (activityType.equals("Carouselers")) {
            return new Carouselers();
        } else if (activityType.equals("DominoLovers")) {
            return new DominoLovers();
        } else if (activityType.equals("LeapfrogPlayers")) {
            return new LeapfrogPlayers();
        } else if (activityType.equals("MovieLovers")) {
            return new MovieLovers();
        } else if (activityType.equals("Wheelers")) {
            return new Wheelers();
        } else if (activityType.equals("Sharashniki")) {
            return new Sharashniki();
        } else {
            throw new IllegalArgumentException("Нет персонажа с таким типом активности: " + activityType);
        }
    }

    private Location parsingTableLocation(String name, String type) {
        TableLocation location = new TableLocation();

        if (type != null) {
            if (type.equals("bar")) {
                location.setType(TableType.BAR_TABLE);
            } else if (type.equals("garden")) {
                location.setType(TableType.GARDEN_TABLE);
            } else if (type.equals("coffe")) {
                location.setType(TableType.COFFE_TABLE);
            } else if (type.equals("dinning")) {
                location.setType(TableType.DINNING_TABLE);
            } else if (type.equals("work")) {
                location.setType(TableType.WORK_TABLE);
            } else {
                throw new IllegalArgumentException("Нет локации с таким типом: " + type);
            }
        }

        if (name != null) {
            location.setName(name);
        }

        return location;
    }

    private Location parseGrassLocation(String name, String type) {
        GrassLocation location = new GrassLocation();

        if (type != null) {
            if (type.equals("lawn")) {
                location.setType(GrassType.LAWN);
            } else if (type.equals("meadow grass")) {
                location.setType(GrassType.MEADOW_GRASS);
            } else if (type.equals("mix grass")) {
                location.setType(GrassType.MIX_GRASS);
            } else if (type.equals("small leaved grass")) {
                location.setType(GrassType.SMALL_LEAVED_GRASS);
            } else if (type.equals("weeds")) {
                location.setType(GrassType.WEEDS);
            } else {
                throw new IllegalArgumentException("Нет локации с таким типом: " + type);
            }
        }

        if (name != null) {
            location.setName(name);
        }

        return location;
    }

    private Location parsingParkAttractionLocation(String name, String type) {
        ParkAttractionLocation location = new ParkAttractionLocation();
        
        if (type != null) {
            if (type.equals("entertainment park")) {
                location.setType(ParkAttractionType.ENTERTAINMENT_PARK);
            } else if (type.equals("megapark")) {
                location.setType(ParkAttractionType.MEGAPARK);
            } else if (type.equals("safari")) {
                location.setType(ParkAttractionType.SAFARI);
            } else {
                throw new IllegalArgumentException("Нет локации с таким типом: " + type);
            }
        }
        
        if (name != null) {
            location.setName(name);
        }

        return location;
    }

    private Location parsingCinemaLocation(String name, String type) {
        CinemaLocation location = new CinemaLocation();
        
        if (type != null) {
            if (type.equals("cinema 3D")) {
                location.setType(CinemaType.CINEMA_3D);
            } else if (type.equals("cinema 5D")) {
                location.setType(CinemaType.CINEMA_5D);
            } else if (type.equals("classic cinema")) {
                location.setType(CinemaType.CLASSIC_CINEMA);
            } else if (type.equals("home cinema")) {
                location.setType(CinemaType.HOME_CINEMA);
            } else if (type.equals("open air cinema")) {
                location.setType(CinemaType.OPEN_AIR_CINEMA);
            } else {
                throw new IllegalArgumentException("Нет локации с таким типом: " + type);
            }
        }
        

        if (name != null) {
            location.setName(name);
        }

        return location;
    }

    private Location parsingLocation(String nameLocation, String name, String type) {
        if (nameLocation.equals("table")) {
            return parsingTableLocation(name, type);
        } else if (nameLocation.equals("grass")) {
            return parseGrassLocation(name, type);
        } else if (nameLocation.equals("park attraction"))  {
            return parsingParkAttractionLocation(name, type);
        } else if (nameLocation.equals("cinema")) {
            return parsingCinemaLocation(name, type);
        } else {
            throw new IllegalArgumentException("Нет локации с таким именем: " + nameLocation);
        }
    }

    private TimeSpent parsingTimeSpent(String timeSpent) {
        if (timeSpent.equals("day to day")) {
            return TimeSpent.DAY_TO_DAY;
        } else if (timeSpent.equals("all day long")) {
            return TimeSpent.ALL_DAY_LONG;
        } else if (timeSpent.equals("every morning")) {
            return TimeSpent.EVERY_MORNING;
        } else if (timeSpent.equals("from morning to evening")) {
            return TimeSpent.FROM_MORNING_TO_EVENING;
        } else if (timeSpent.equals("once a week")) {
            return TimeSpent.ONCE_A_WEEK;
        } else if (timeSpent.equals("once a year")) {
            return TimeSpent.ONCE_A_YEAR;
        } else if (timeSpent.equals("whole day")) {
            return TimeSpent.WHOLE_DAY;
        } else {
            throw new IllegalArgumentException("Нет указания времени с таким именем");
        }
    }

    private Action parsingFilmHeroAction(String action) {
        if (action.equals("бегать")) {
            return new RunAction();
        } else if (action.equals("прыгать")) {
            return new JumpAction();
        } else if (action.equals("падать")) {
            return new FallAction();
        } else if (action.equals("палить из пистолета")) {
            return new ShootAction();
        } else if (action.equals("кувыркаться")) {
            return new TumbleAction();
        } else {
            throw new IllegalArgumentException("Для героев фильмов нет действия с таким именем: " + action);
        }
    }

    @Override
    public AbstractMap.SimpleEntry<ShortyGroup, FilmHero> creator(String filePath) {
        Gson gson = new GsonBuilder().create();

        ShortyGroup myGroup = new ShortyGroup();
        FilmHero hero = new FilmHero();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            Root root = gson.fromJson(reader, Root.class);

            for (Activity activity : root.shorties) {
                Shorty parsingShorty = parsingActivityType(activity.activityType);

                try {
                    myGroup.addShorty(parsingShorty);
                } catch (ShortyAlreadyExistsException e) {
                    System.out.println(e.getMessage());
                    continue;
                }

                if (activity.location != null) {
                    parsingShorty.setLocation(parsingLocation(activity.location.nameLocation, 
                                                                activity.location.name, activity.location.type));
                }

                if (activity.levelDecreaseIntelligenceLevel != null) {
                    parsingShorty.setLevelDecreaseIntelligenceLevel(activity.levelDecreaseIntelligenceLevel);
                }

                if (activity.timeSpent != null) {
                    parsingShorty.setTimeSpent(parsingTimeSpent(activity.timeSpent));
                }

                if (activity.typesActivity != null) {
                    for (ParsingTypeActivity type : activity.typesActivity) {
                        if (activity.activityType.equals("Gamblers")) {
                            if (type.numParticipants != null) {
                                parsingShorty.addTypesActivity(new CardGame(type.name, type.numParticipants));
                            } else {
                                parsingShorty.addTypesActivity(new CardGame(type.name));
                            }
                        } else if (activity.activityType.equals("Carouselers")) {
                            if (type.numParticipants != null) {
                                parsingShorty.addTypesActivity(new Carousel(type.name, type.numParticipants));
                            } else {
                                parsingShorty.addTypesActivity(new Carousel(type.name));
                            }
                        } else if (activity.activityType.equals("DominoLovers")) {
                            if (type.numParticipants != null) {
                                parsingShorty.addTypesActivity(new DominoGame(type.name, type.numParticipants));
                            } else {
                                parsingShorty.addTypesActivity(new DominoGame(type.name));
                            }
                        } else if (activity.activityType.equals("LeapfrogPlayers")) {
                            if (type.numParticipants != null) {
                                parsingShorty.addTypesActivity(new LeapfrogGame(type.name, type.numParticipants));
                            } else {
                                parsingShorty.addTypesActivity(new LeapfrogGame(type.name));
                            }
                        } else if (activity.activityType.equals("MovieLovers")) {
                            parsingShorty.addTypesActivity(new Movie(type.name));
                        } else if (activity.activityType.equals("Wheelers")) {
                            if (type.numParticipants != null) {
                                parsingShorty.addTypesActivity(new Wheel(type.name, type.numParticipants));
                            } else {
                                parsingShorty.addTypesActivity(new Wheel(type.name));
                            }
                        } else if (activity.activityType.equals("Sharashniki")) {
                            if (type.numParticipants != null) {
                                parsingShorty.addTypesActivity(new Sharashka(type.name, type.numParticipants));
                            } else {
                                parsingShorty.addTypesActivity(new Sharashka(type.name));
                            }
                        }
                    }
                }
                
            }

            for (String action : root.filmHero) {
                try {
                    hero.addAction(parsingFilmHeroAction(action));
                } catch (ActionAlreadyExistsException e) {
                    System.out.println(e.getMessage());
                    continue;
                }
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new AbstractMap.SimpleEntry<>(myGroup, hero);
    }
}

