package ru.itmo.ekaterinagalak.lab2.pokemons;

import ru.itmo.ekaterinagalak.lab2.moves.status.Rest;

public final class Vileplume extends Gloom { 
    private static final double BASE_STATS_HP = 60;
    private static final double BASE_STATS_ATTACK = 65;
    private static final double BASE_STATS_DEFENSE = 70;
    private static final double BASE_STATS_SPECIAL_ATTACK = 85;
    private static final double BASE_STATS_SPECIAL_DEFENSE = 75;
    private static final double BASE_STATS_SPEED = 40;

    public Vileplume(String name, int level) {
        super(name, level);

        setStats(BASE_STATS_HP, BASE_STATS_ATTACK, BASE_STATS_DEFENSE, 
                 BASE_STATS_SPECIAL_ATTACK, BASE_STATS_SPECIAL_DEFENSE, BASE_STATS_SPEED);
        
        setMove(new Rest());
    }
}
