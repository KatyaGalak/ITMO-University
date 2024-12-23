package ru.itmo.ekaterinagalak.lab2.moves.physical;

import ru.ifmo.se.pokemon.*;

/*
 * Bulldoze deals damage and lowers the target's Speed by one stage.
 */

public final class Bulldoze extends PhysicalMove {
    private static final double POWER_BULLDOZE = 60;
    private static final double ACCURACY_BULLDOZE = 100;

    public Bulldoze() {
        super(Type.GROUND, POWER_BULLDOZE, ACCURACY_BULLDOZE);
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        super.applyOppEffects(p);

        Effect e = new Effect().stat(Stat.SPEED, -1).turns(1);
        p.addEffect(e);
    }

    @Override
    protected String describe() {
        return "топчет землю и атакует всё вокруг";
    }
}
