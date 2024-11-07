package ru.itmo.ekaterinagalak.lab2;

import ru.ifmo.se.pokemon.Battle;

import ru.itmo.ekaterinagalak.lab2.pokemons.Eevee;
import ru.itmo.ekaterinagalak.lab2.pokemons.Glaceon;
import ru.itmo.ekaterinagalak.lab2.pokemons.Gloom;
import ru.itmo.ekaterinagalak.lab2.pokemons.Oddish;
import ru.itmo.ekaterinagalak.lab2.pokemons.Tropius;
import ru.itmo.ekaterinagalak.lab2.pokemons.Vileplume;

public class Main {
    public static void main(String[] args) {
        Battle battle = new Battle();

        Vileplume p1 = new Vileplume("Тучка", 1);
        Glaceon p2 = new Glaceon("Звёздочка", 1);
        Tropius p3 = new Tropius("Солнышко", 1);
        Gloom p4 = new Gloom("Льдинка", 1);
        Eevee p5 = new Eevee("Снежинка", 1);
        Oddish p6 = new Oddish("Цветочек", 1);
        battle.addAlly(p1);
        battle.addAlly(p3);
        battle.addAlly(p5);

        battle.addFoe(p2);
        battle.addFoe(p4);
        battle.addFoe(p6);

        battle.go();
    }
}