package prog_lab34.parsingconfigfile;

import java.util.AbstractMap;

import prog_lab34.interaction.community.ShortyGroup;
import prog_lab34.interaction.filmhero.FilmHero;

public interface ObjProvider {
    public AbstractMap.SimpleEntry<ShortyGroup, FilmHero> creator();
    public AbstractMap.SimpleEntry<ShortyGroup, FilmHero> creator(String pathConfigFile);
}
