package ru.itmo.ekaterinagalak.lab2.pokemons;

import ru.ifmo.se.pokemon.Type;

import ru.itmo.ekaterinagalak.lab2.moves.special.Acid;

public class Gloom extends Oddish {
    private static final double BASE_STATS_HP = 75;
    private static final double BASE_STATS_ATTACK = 80;
    private static final double BASE_STATS_DEFENSE = 85;
    private static final double BASE_STATS_SPECIAL_ATTACK = 110;
    private static final double BASE_STATS_SPECIAL_DEFENSE = 90;
    private static final double BASE_STATS_SPEED = 50;

    public Gloom(String name, int level) {
        super(name, level);

        setType(Type.ICE);

        setStats(BASE_STATS_HP, BASE_STATS_ATTACK, BASE_STATS_DEFENSE, 
                 BASE_STATS_SPECIAL_ATTACK, BASE_STATS_SPECIAL_DEFENSE, BASE_STATS_SPEED);
        
        addMove(new Acid());
    }
}
