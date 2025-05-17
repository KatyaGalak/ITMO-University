package ru.itmo.ekaterinagalak.lab2.moves.special;

import ru.ifmo.se.pokemon.*;

/*
 * Frost Breath deals damage and always results in a critical hit.
 */

public final class FrostBreath extends SpecialMove {
    private static final double POWER_FROST_BREATH = 60;
    private static final double ACCURACY_FROST_BREATH = 90;

    public FrostBreath() {
        super(Type.ICE, POWER_FROST_BREATH, ACCURACY_FROST_BREATH);
    }

    @Override
    protected double calcCriticalHit(Pokemon a, Pokemon b) {
        return 2.0;
    }

    @Override
    protected String describe() {
        return "выдыхает на цель холодное дыхание. Эта атака всегда приводит к критическому удару";
    }
}
