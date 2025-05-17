package prog_lab34.interaction.filmhero;

import java.util.ArrayList;
import java.util.Objects;

import prog_lab34.interaction.filmhero.action.*;
import prog_lab34.interaction.filmhero.exceptions.*;

public class FilmHero {
    private ArrayList<Action> actions;

    public FilmHero() {
        this.actions = new ArrayList<>();
    }

    public void addAction(Action... actionHero) throws ActionAlreadyExistsException {
        for (Action action : actionHero) {
            if (actions.contains(action)) {
                throw new ActionAlreadyExistsException(action);
            }
            actions.add(action);
        }
    }

    public String performAllActions(int levelDecreaseIntelligenceLevel) {
        try {
            if (actions.size() == 0) {
                throw new EmptyListException();
            }
        } catch (EmptyListException e) {
            System.out.println(e.getMessage());
        }
        
        StringBuilder ans = new StringBuilder();

        ans.append(" герои кинокартин ");

        for (Action action : actions) {
            ans.append(action.performAction()).append(", ");
        }

        if (levelDecreaseIntelligenceLevel < 0) {
            ans.append("могли лишь поглупеть, но ни в коем случае не поумнеть.");
        } else {
            ans.append("ни в коем случае не могли поглупеть.");
        }

        return ans.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(actions);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof FilmHero)) return false;
        FilmHero other = (FilmHero) obj;
        return Objects.equals(this.actions, other.actions);
    }

    @Override
    public String toString() {
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < ans.length(); ++i) {
            ans.append(actions.get(i).toString());
            if (i != ans.length() - 1) {
                ans.append(", ");
            }
        }

        return ans.append(".").toString();
    }
}
