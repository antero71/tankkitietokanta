create table kayttaja(
nimi varchar(80),
tunnus varchar(80),
salasana varchar(80));

create table tankki (
uid int,
nimi varchar(100),
tyyppi varhchar(100),
tykki vharchar(50),
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
varchar(50) moottori,
int teho
lisatietoja varchar(512));

create table valmistaja (
uid int,
nimi varchar(256),
paikkakunta varchar(256));

create table osanvalmistaja (
osaid int,
valmistajaid int,
osannimi varchar(100),
valmistus_alkoi int,
valmistus_paattyi int
)