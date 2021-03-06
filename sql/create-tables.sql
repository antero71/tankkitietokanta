create table kayttaja(
id serial primary key,
nimi varchar(80),
tunnus varchar(80),
salasana varchar(80));

create table tankki (
uid serial primary key,
nimi varchar(100),
tyyppi varchar(100),
tykki varchar(50),
pituus int,
leveys int,
korkeus int,
runko_etu int,
runko_sivu int,
runko_taka int,
torni_etu int,
torni_sivu int,
torni_taka int,
paino int,
moottori varchar(50),
teho int,
lisatietoja varchar(512));

create table valmistaja (
uid serial primary key,
nimi varchar(256),
paikkakunta varchar(256));

create table osanvalmistaja (
osaid int,
valmistajaid int,
osannimi varchar(100),
valmistus_alkoi int,
valmistus_paattyi int);