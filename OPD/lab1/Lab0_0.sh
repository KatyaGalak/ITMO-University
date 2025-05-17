#!/usr/bin/bash


mkdir lab0
cd lab0

#Step_1

mkdir -p exeggutor4/beartic
mkdir exeggutor4/shiftry
touch exeggutor4/samurott

mkdir -p graveler0/tyranitar
mkdir graveler0/darumaka
mkdir graveler0/kingdra
touch graveler0/mantyke
touch graveler0/pelipper
touch graveler0/wobbuffet

touch grotle8
touch kirlia4

mkdir -p ninjask1/vanilluxe
touch ninjask1/grumpig
touch ninjask1/watchog
touch ninjask1/barboach
touch ninjask1/poochyena

touch remoraid7

# -e - включить интерпретацию escape-последовательностей при выводе текста
# Escspe-последовательности - это спец комбинации символов, которые используются
# для представления непечатаемых символов (например, табуляция или новая строка)
# или спец действий (например, изменение цвета текста) 

echo 'Способности  Tail Whip Water Gun Water Sport Focus Energy
Razor Shell Fury Cutter Water Pulse Reverge Aqua Jet Slash Encore Aqua
Tail Retaliate Swords Dance Hydro Pump' >> exeggutor4/samurott

echo -e 'Живет\nOcean' >> graveler0/mantyke

echo -e 'Возможности  Overland=6 Surface=10 Underwater=7 Sky=8
Jump=2 Power=3 Intelligence=4' >> graveler0/pelipper

echo -e 'satk=3 sdef=6\nspd=3' >> graveler0/wobbuffet

echo 'Тип диеты  Herbivore Phototroph' >> grotle8

echo 'Способности
Confusion Double Team Teleport Lucky Chant Magical Leaf Heal Pulse
Calm Mind Psychic Imprison Future Sight Charm Hypnosis Dream Eater
Stored Power' >> kirlia4

echo -e 'Возможности  Overland=6 Surface=6 Jump=6 Power=3\nIntelligence=4' >> ninjask1/grumpig

echo 'Ходы  After You Aqua Tail Covet Endeavor Fire
Punch Gunk Shot Helping Hand Ice Punch Iron Tail Knock Off Last Resort
Low Kick| Seed Bomb Signal Beam Sleep Talk Snore Super Fang
Thunderpunch Zen Headbutt' >> ninjask1/watchog

echo -e 'weight=4.2 height=16.0 atk=5\ndef=4' >> ninjask1/barboach

echo 'Способности  Tackle Howl Sand-Attack Bite Odor Sleuth
Roar Swagger Assurance Scary Face Taunt Embargo Take Down Sucker Punch
Crunch' >> ninjask1/poochyena

echo 'Тип диеты  Herbivore' >> remoraid7
