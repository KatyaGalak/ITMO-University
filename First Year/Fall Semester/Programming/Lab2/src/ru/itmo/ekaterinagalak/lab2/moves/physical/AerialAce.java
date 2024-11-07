package ru.itmo.ekaterinagalak.lab2.moves.physical;

import ru.ifmo.se.pokemon.*;

/*
 * Aerial Ace deals damage and ignores changes to the Accuracy and Evasion stats
 */

public class AerialAce extends PhysicalMove {
    private static final double POWER_AERIAL_ACE = 60;
    private static final double ACCURACY_AERIAL_ACE = 100;

    public AerialAce() {
        super(Type.FLYING, POWER_AERIAL_ACE, ACCURACY_AERIAL_ACE);
    }

    @Override
    protected void applySelfEffects(Pokemon p) {
        super.applySelfEffects(p);

        Effect ef = new Effect().attack(1).turns(1);
        p.addEffect(ef);
    }

    @Override
    protected String describe() {
        return "сбивает противника с толку своей скоростью, а затем наносит удар";
    }
}
