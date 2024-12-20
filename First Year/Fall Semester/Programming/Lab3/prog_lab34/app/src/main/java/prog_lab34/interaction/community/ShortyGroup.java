package prog_lab34.interaction.community;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

import prog_lab34.interaction.shorty.Shorty;
import prog_lab34.interaction.shorty.constants.IntelligenceLevel;
import prog_lab34.interaction.community.exceptions.*;

public class ShortyGroup {
    private ArrayList<Shorty> shorties;

    public ShortyGroup() {
        shorties = new ArrayList<>();
    }

    public ArrayList<Shorty> getShortyGroup() {
        return shorties;
    }

    public void addShorty(Shorty... addShorties) throws ShortyAlreadyExistsException {
        for (Shorty shorty : addShorties) {
            if (shorties.contains(shorty)) {
                throw new ShortyAlreadyExistsException(shorty);
            }
            shorties.add(shorty);
        }
    }

    public String getInfAboutGroup() {
        StringBuilder ans = new StringBuilder();

        if (shorties.isEmpty()) {
            return "";
        }

        ans.append("К тому времени все коротышки разделились, если можно так выразиться, по интересам. Здесь были ");

        for (Shorty shorty : shorties) {
            ans.append(shorty.getActivityType().describe() + ", ");
        }

        ans.delete(ans.length() - 2, ans.length());
        ans.append(". ");

        for (Shorty shorty : shorties) {
            ans.append(shorty.performActivity() + " ");
        }

        return ans.delete(ans.length() - 1, ans.length()).toString();
    }

    public String changesIntelligenceLevel() {
        if (shorties.isEmpty()) {
            return "";
        }

        StringBuilder ans = new StringBuilder();

        for (Shorty shorty : shorties) {
            if (!shorty.checkIncreaseIntelligenceLevel()) {
                ans.append(" Нечего, конечно, и говорить, что такое однообразие в занятиях ");
                ans.append("притупляло умственные способности коротышек");
                ans.append(", исподволь подготавливая переход их в " + IntelligenceLevel.ANIMAL_STATE.describe());
                break;
            }
        }

        boolean flagIncrease = false;
        for (Shorty shorty : shorties) {
            if (shorty.checkIncreaseIntelligenceLevel()) {
                if (!flagIncrease) {
                    ans.append(" (однако, ");
                }

                ans.append(shorty.getActivityType().describe() + ", ");
                flagIncrease = true;
            }

        }

        if (flagIncrease) {
            ans.delete(ans.length() - 2, ans.length());
            ans.append(" , наоборот, повышали уровень своего интеллекта, переходя в " + IntelligenceLevel.GENIUS.describe() + ").");
        }

        for (Shorty shorty : shorties) {
            shorty.changesIntelligenceLevelAfterActivity();
        }

        return ans.append(".").toString();
    }

    public String getSmartestShorties() {
        StringBuilder ans = new StringBuilder();

        ArrayList<Shorty> sortShorties = shorties;
        Collections.sort(sortShorties, new Comparator<Shorty>() {
            @Override
            public int compare(Shorty f, Shorty s) {
                return Integer.compare(f.getIntelligenceLevelNum(), s.getIntelligenceLevelNum());
            }
        });

        for (Shorty shorty : shorties) {
            ans.append(shorty.getActivityType().describe() + ", ");
        }

        return ans.toString();
    }

    public String getInfAboutMoreStupid(Shorty smartShorty) {
        StringBuilder ans = new StringBuilder();

        ArrayList<Shorty> sortShorties = shorties;

        Collections.sort(sortShorties, new Comparator<Shorty>() {
            @Override
            public int compare(Shorty f, Shorty s) {
                return Integer.compare(s.getIntelligenceLevelNum(), f.getIntelligenceLevelNum());
            }
        });

        boolean flagStart = false;
        boolean wasAdd = false;
        for (Shorty shorty : shorties) {
            if (flagStart) {
                ans.append(shorty.getActivityType().describe() + ", ");
                wasAdd = true;
            }
            
            if (shorty.getActivityType().describe().equals(smartShorty.getActivityType().describe())) {
                ans.append(" Считалось, между прочим, что " + smartShorty.getActivityType().describe());
                ans.append(" занимаются более интеллектуальным занятием, чем ");
                flagStart = true;
            }
        }
        if (wasAdd) {
            ans.delete(ans.length() - 2, ans.length());
        } else {
            ans.append("те, кто вообще ничего не делал");
        }
        

        return ans.append(". ").toString();
    }

    @Override
    public String toString() {
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < ans.length(); ++i) {
            ans.append(shorties.get(i).toString());
            if (i != ans.length() - 1) {
                ans.append(", ");
            }
        }

        return ans.append(".").toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(shorties);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ShortyGroup)) return false;
        ShortyGroup other = (ShortyGroup) obj;
        return Objects.equals(this.shorties, other.shorties);
    }
}
