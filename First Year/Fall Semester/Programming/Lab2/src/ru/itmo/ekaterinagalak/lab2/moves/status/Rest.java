package ru.itmo.ekaterinagalak.lab2.moves.status;

import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Pokemon;
//import ru.ifmo.se.pokemon.Status;
import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.Type;

/*
 * User sleeps for 2 turns, but user is fully healed.
 */

public class Rest extends StatusMove {
    private static final double POWER_REST = 0;
    private static final double ACCURACY_REST = 100;

    public Rest() {
        super(Type.PSYCHIC, POWER_REST, ACCURACY_REST);
    }

    @Override
    protected void applySelfEffects(Pokemon p) {
        super.applySelfEffects(p);

        p.restore();
        Effect e = new Effect().turns(2);
        e.sleep(p);
    }

    @Override
    protected String describe() {
        return "спит в течение 2 ходов, чтобы полностью восстановить здоровье и устранить все проблемы со статусом";
    }
}
