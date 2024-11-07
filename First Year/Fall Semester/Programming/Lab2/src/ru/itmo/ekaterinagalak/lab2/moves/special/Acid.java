package ru.itmo.ekaterinagalak.lab2.moves.special;

import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.Type;

/*
 * Acid deals damage and has 
 * a 10% chance of lowering the target's Special Defense by one stage.
 */

public class Acid extends SpecialMove {
    private static final double POWER_ACID = 40;
    private static final double ACCURACY_ACID = 100;

    public Acid() {
        super(Type.POISON, POWER_ACID, ACCURACY_ACID);
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        super.applyOppEffects(p);

        Effect effectObject = new Effect().chance(0.1).stat(Stat.SPECIAL_DEFENSE, 1);
        p.addEffect(effectObject);
    }

    @Override
    protected String describe() {
        return "распыляет разъедающую кожу кислоту. Может снизить специальную защиту.";
    }
}
