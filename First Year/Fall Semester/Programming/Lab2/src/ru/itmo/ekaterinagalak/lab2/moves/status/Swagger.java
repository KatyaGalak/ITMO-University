package ru.itmo.ekaterinagalak.lab2.moves.status;

import ru.ifmo.se.pokemon.*;

/*
 * Swagger confuses the target and raises its Attack by two stages.
 */

public final class Swagger extends StatusMove {
    private static final double POWER_SWAGGER = 0;
    private static final double ACCURACY_SWAGGER = 85;

    public Swagger() {
        super(Type.NORMAL, POWER_SWAGGER, ACCURACY_SWAGGER);
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        super.applyOppEffects(p);

        Effect.confuse(p);
        p.setMod(Stat.ATTACK, 2);
    }

    @Override
    protected String describe() {
        return "вызывает замешательство и резко усиливает атаку.";
    }
}
