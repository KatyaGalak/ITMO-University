package ru.itmo.ekaterinagalak.lab2.moves.status;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.Type;

/*
 * Work Up raises the user's Attack and Special Attack by one stage each.
 */

public class WorkUp extends StatusMove {
    private static final double POWER_WORK_UP = 0;
    private static final double ACCURACY_WORK_UP = 100;

    public WorkUp() {
        super(Type.NORMAL, POWER_WORK_UP, ACCURACY_WORK_UP);
    }

    @Override
    protected void applySelfEffects(Pokemon p) {
        super.applySelfEffects(p);

        p.setMod(Stat.SPECIAL_ATTACK, 1);
        p.setMod(Stat.ATTACK, 1);
    }

    @Override
    protected String describe() {
        return "пробуждается, его показатели атаки и специальной атаки увеличиваются";
    }
}
