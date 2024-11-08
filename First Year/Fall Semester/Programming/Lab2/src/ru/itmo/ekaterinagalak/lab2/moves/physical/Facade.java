package ru.itmo.ekaterinagalak.lab2.moves.physical;

import ru.ifmo.se.pokemon.*;

/*
 * Facade deals damage, and hits with double power (140) 
 * if the user is burned, poisoned or paralyzed.
 * In the case of a burn, the usual attack-halving 
 * still occurs so Facade hits with an effective power of 70.
 */

public final class Facade extends PhysicalMove {
    private static final double POWER_FACADE = 70;
    private static final double ACCURACY_FACADE = 100;

    public Facade() {
        super(Type.NORMAL, POWER_FACADE, ACCURACY_FACADE);
    }

    @Override
    protected void applyOppDamage(Pokemon p, double damage) {
        if (p.getCondition() == Status.POISON || p.getCondition() == Status.PARALYZE
            || p.getCondition() == Status.BURN) {
            
            p.setMod(Stat.HP, (int) Math.round(damage * 2));
        } else {
            p.setMod(Stat.HP, (int) Math.round(damage));
        }
    }

    @Override
    protected String describe() {
        return "использует аттакующий приём, который удваивает силу, если пользователь отравлен, обожжён или парализован.";
    }
}
