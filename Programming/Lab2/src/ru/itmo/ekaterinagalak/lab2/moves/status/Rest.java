package ru.itmo.ekaterinagalak.lab2.moves.status;

import ru.ifmo.se.pokemon.*;

/*
 * User sleeps for 2 turns, but user is fully healed.
 */

public final class Rest extends StatusMove {
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
