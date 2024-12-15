#!/usr/bin/bash

cd lab0

# Step_2 (настройка прав)

# exeggutor4: r-x--x-w-
chmod u=rx,g=x,o=w exeggutor4

# beartic: владелец должен читать, записывать директорию и переходить в нее;
# группа-владелец должна записывать директорию и переходить в нее; 
# остальные пользователи должны читать, записывать директорию и переходить в нее
chmod 737 exeggutor4/beartic

# shiftry: права 315
chmod 315 exeggutor4/shiftry

# samurott: права 664
chmod 664 exeggutor4/samurott

# graveler0: r-xrwx-wx
chmod u=rx,g=rwx,o=wx graveler0

# mantyke: права 664
chmod 664 graveler0/mantyke

# tyranitar: r-xrwxrwx
chmod 577 graveler0/tyranitar

# pelipper: права 440
chmod u=r,g=r,o= graveler0/pelipper

# wobbuffet: владелец должен читать и записывать файл; 
# группа-владелец должна записывать файл; остальные пользователи должны читать файл
chmod u=rw,g=w,o=r graveler0/wobbuffet

# darumaka: -wx-wx-wx
chmod 333 graveler0/darumaka

# kingdra: владелец должен записывать директорию и переходить в нее; 
# группа-владелец должна записывать директорию и переходить в нее; 
# остальные пользователи должны читать директорию и переходить в нее
chmod 335 graveler0/kingdra

# grotle8: владелец должен не иметь никаких прав; 
# группа-владелец должна читать файл; остальные пользователи должны читать и записывать файл
chmod u=,g=r,o=rw grotle8

# kirlia4: владелец должен читать файл; 
# группа-владелец должна не иметь никаких прав; остальные пользователи должны читать файл
chmod 404 kirlia4

# ninjask1: права 711
chmod 711 ninjask1

# grumpig: права 404
chmod 404 ninjask1/grumpig

# watchog: права 666
chmod u=rw,g=rw,o=rw ninjask1/watchog

# barboach: владелец должен не иметь никаких прав; 
# группа-владелец должна читать и записывать файл; остальные пользователи должны записывать файл
chmod 062 ninjask1/barboach

# vanilluxe: права 555
chmod u=rx,g=rx,o=rx ninjask1/vanilluxe

# poochyena: владелец должен читать файл; 
# группа-владелец должна читать файл; остальные пользователи должны не иметь никаких прав
chmod u=r,g=r,o= ninjask1/poochyena

# emoraid7: rw--w-r--
chmod 624 remoraid7