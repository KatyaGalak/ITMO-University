package prog_lab34.parsingconfigfile;

import java.util.AbstractMap;

import prog_lab34.interaction.community.ShortyGroup;
import prog_lab34.interaction.community.exceptions.ShortyAlreadyExistsException;
import prog_lab34.interaction.filmhero.FilmHero;
import prog_lab34.interaction.filmhero.action.FallAction;
import prog_lab34.interaction.filmhero.action.JumpAction;
import prog_lab34.interaction.filmhero.action.RunAction;
import prog_lab34.interaction.filmhero.exceptions.ActionAlreadyExistsException;
import prog_lab34.interaction.location.tablelocation.TableLocation;
import prog_lab34.interaction.location.tablelocation.TableType;
import prog_lab34.interaction.shorty.Shorty;
import prog_lab34.interaction.shorty.constants.TimeSpent;
import prog_lab34.interaction.shorty.gamblers.Gamblers;
import prog_lab34.interaction.shorty.movielovers.Movie;
import prog_lab34.interaction.shorty.movielovers.MovieLovers;
import prog_lab34.interaction.shorty.wheelers.Wheelers;

public class SimpleObjProvider implements ObjProvider {
    @Override
    public AbstractMap.SimpleEntry<ShortyGroup, FilmHero> creator(String pathFile){
        throw new IllegalArgumentException("[Error] SimpleObjProvider does not support working with a config file.");
    }

    @Override
    public AbstractMap.SimpleEntry<ShortyGroup, FilmHero> creator() {

        FilmHero hero = new FilmHero();
        try {
            hero.addAction(new FallAction(), new JumpAction(), new RunAction());
        } catch (ActionAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }

        Shorty sh = new MovieLovers(TimeSpent.FROM_MORNING_TO_EVENING);

        ShortyGroup myGroup = new ShortyGroup();

        try {
            myGroup.addShorty(sh, new Gamblers(new TableLocation(TableType.DINNING_TABLE)), new Wheelers(TimeSpent.FROM_MORNING_TO_EVENING));
        } catch (ShortyAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }
        sh.addTypesActivity(new Movie("фантастические"));
        return new AbstractMap.SimpleEntry<>(myGroup, hero);
    }
}
