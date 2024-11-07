package ru.itmo.ekaterinagalak.lab2.moves.physical;

import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Headbutt extends PhysicalMove {
    private static final double POWER_HEADBUTT = 70;
    private static final double ACCURACY_HEADBUTT = 100;

    public Headbutt() {
        super(Type.NORMAL, POWER_HEADBUTT, ACCURACY_HEADBUTT);
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        super.applyOppEffects(p);

        if (Math.random() <= 0.3) {
            Effect.flinch(p);
        }
    }

    @Override
    protected String describe() {
        return "наносит удар головой";
    }
}
