package ru.itmo.ekaterinagalak.lab2.pokemons;

import ru.ifmo.se.pokemon.Type;

import ru.itmo.ekaterinagalak.lab2.moves.special.FrostBreath;

public class Glaceon extends Eevee {
    private static final double BASE_STATS_HP = 65;
    private static final double BASE_STATS_ATTACK = 60;
    private static final double BASE_STATS_DEFENSE = 110;
    private static final double BASE_STATS_SPECIAL_ATTACK = 130;
    private static final double BASE_STATS_SPECIAL_DEFENSE = 95;
    private static final double BASE_STATS_SPEED = 65;

    public Glaceon(String name, int level) {
        super(name, level);
        setType(Type.ICE);

        setStats(BASE_STATS_HP, BASE_STATS_ATTACK, BASE_STATS_DEFENSE, 
                 BASE_STATS_SPECIAL_ATTACK, BASE_STATS_SPECIAL_DEFENSE, BASE_STATS_SPEED);
        
        addMove(new FrostBreath());
    }
}
