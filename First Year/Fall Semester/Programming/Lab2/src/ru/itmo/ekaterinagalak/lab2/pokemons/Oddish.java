package ru.itmo.ekaterinagalak.lab2.pokemons;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;
import ru.itmo.ekaterinagalak.lab2.moves.physical.Facade;
import ru.itmo.ekaterinagalak.lab2.moves.status.Swagger;

public class Oddish extends Pokemon {
    private static final double BASE_STATS_HP = 45;
    private static final double BASE_STATS_ATTACK = 50;
    private static final double BASE_STATS_DEFENSE = 55;
    private static final double BASE_STATS_SPECIAL_ATTACK = 75;
    private static final double BASE_STATS_SPECIAL_DEFENSE = 65;
    private static final double BASE_STATS_SPEED = 30;

    public Oddish(String name, int level) {
        super(name, level);

        setStats(BASE_STATS_HP, BASE_STATS_ATTACK, BASE_STATS_DEFENSE, 
                 BASE_STATS_SPECIAL_ATTACK, BASE_STATS_SPECIAL_DEFENSE, BASE_STATS_SPEED);
        
        setType(Type.GRASS, Type.POISON);
        
        setMove(new Swagger(), new Facade());
    }
}
