package ru.itmo.ekaterinagalak.lab2.moves.physical;

import ru.ifmo.se.pokemon.*;

/*
 * Razor Leaf deals damage and has 
 * an increased critical hit ratio (1⁄8 instead of 1⁄24).
 */

public final class RazorLeaf extends PhysicalMove {
    private static final double POWER_RAZOR_LEAF = 55;
    private static final double ACCURACY_RAZOR_LEAF = 95;

    public RazorLeaf() {
        super(Type.GRASS, POWER_RAZOR_LEAF, ACCURACY_RAZOR_LEAF);
    }

    @Override
    protected double calcCriticalHit(Pokemon a, Pokemon b) {
        if (3 * a.getStat(Stat.SPEED) / 512.0 > Math.random()) {
            return 2.0;
        }
        
        return 1.0;
    }

    @Override
    protected String describe() {
        return "режет врага листьями. У него высокий процент критических попаданий";
    }
}
