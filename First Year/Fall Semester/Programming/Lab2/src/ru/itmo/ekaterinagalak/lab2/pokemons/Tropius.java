package ru.itmo.ekaterinagalak.lab2.pokemons;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;
import ru.itmo.ekaterinagalak.lab2.moves.physical.AerialAce;
import ru.itmo.ekaterinagalak.lab2.moves.physical.Bulldoze;
import ru.itmo.ekaterinagalak.lab2.moves.physical.Headbutt;
import ru.itmo.ekaterinagalak.lab2.moves.physical.RazorLeaf;

public class Tropius extends Pokemon {
    private static final double BASE_STATS_HP = 99;
    private static final double BASE_STATS_ATTACK = 68;
    private static final double BASE_STATS_DEFENSE = 83;
    private static final double BASE_STATS_SPECIAL_ATTACK = 72;
    private static final double BASE_STATS_SPECIAL_DEFENSE = 87;
    private static final double BASE_STATS_SPEED = 51;

    public Tropius(String name, int level) {
        super(name, level);

        setStats(BASE_STATS_HP, BASE_STATS_ATTACK, BASE_STATS_DEFENSE, 
                 BASE_STATS_SPECIAL_ATTACK, BASE_STATS_SPECIAL_DEFENSE, BASE_STATS_SPEED);
        
        setType(Type.GRASS, Type.FLYING);

        setMove(new Headbutt(), new Bulldoze(), new AerialAce(), new RazorLeaf());
        //setMove(new AerialAce());
    }
}
