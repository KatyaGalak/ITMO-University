package ru.itmo.ekaterinagalak.lab2.moves.status;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.Type;

/*
 * Tail Whip lowers the target's Defense by one stage.
 */

public class TailWhip extends StatusMove {
    private static final double POWER_TAIL_WHIP = 0;
    private static final double ACCURACY_TAIL_WHIP = 100;

    public TailWhip() {
        super(Type.NORMAL, POWER_TAIL_WHIP, ACCURACY_TAIL_WHIP);
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        super.applyOppEffects(p);

        p.setMod(Stat.DEFENSE, -1);
    }

    @Override
    protected String describe() {
        return "виляет хвостом, чтобы ослабить защиту противника";
    }
}
