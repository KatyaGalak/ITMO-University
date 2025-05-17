package prog_lab34.interaction;

import java.util.AbstractMap;

import prog_lab34.interaction.community.ShortyGroup;
import prog_lab34.interaction.shorty.Shorty;
import prog_lab34.interaction.shorty.movielovers.MovieLovers;
import prog_lab34.interaction.filmhero.FilmHero;
import prog_lab34.parsingconfigfile.*;

public class Interaction {
    private ObjProvider objProvider;

    public Interaction(ObjProvider objProvider) {
        this.objProvider = objProvider;
    }

    public String startInteraction(String pathConfigFile) {
        AbstractMap.SimpleEntry<ShortyGroup, FilmHero> characters = objProvider.creator(pathConfigFile);  

        StringBuilder ans = new StringBuilder();
        ans.append(characters.getKey().getInfAboutGroup());
        ans.append(characters.getKey().changesIntelligenceLevel());

        for (Shorty shorty : characters.getKey().getShortyGroup()) {
            if (shorty instanceof MovieLovers) {
                ans.append(characters.getKey().getInfAboutMoreStupid(shorty));
                ans.append(((MovieLovers) shorty).watchFilmHero(characters.getValue()));
                break;
            }
        }

        return ans.toString();
    }

    public String startInteraction() {
        AbstractMap.SimpleEntry<ShortyGroup, FilmHero> characters = objProvider.creator();  

        StringBuilder ans = new StringBuilder();
        ans.append(characters.getKey().getInfAboutGroup());
        ans.append(characters.getKey().changesIntelligenceLevel());

        for (Shorty shorty : characters.getKey().getShortyGroup()) {
            if (shorty instanceof MovieLovers) {
                ans.append(characters.getKey().getInfAboutMoreStupid(shorty));
                ans.append(((MovieLovers) shorty).watchFilmHero(characters.getValue()));
                break;
            }
        }

        return ans.toString();
    }

}
