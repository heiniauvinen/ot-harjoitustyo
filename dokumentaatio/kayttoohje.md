# Käyttöohje

Lataa tiedosto [MatematiikkaSovellus-1.0-SNAPSHOT.jar](https://github.com/heiniauvinen/ot-harjoitustyo/releases/tag/Viikko5).

## Ohjelman käynnistäminen

Sovellus käynnistetään komennolla:
```
java -jar MatematiikkaSovellus-1.0-SNAPSHOT.jar
```

## Harjoituksen valinta

Sovellus käynnistyy näkymään, jossa käyttäjä voi valita harjoituksen. 
Harjoitus valitaan painamalla sitä nappia, jonka haluaa suorittaa.

## Yhteen- ja vähennyslaskuharjoituksen asetukset

Harjoituksen valinnan jälkeen aukeaa näkymä, jossa käyttäjä voi asettaa 
harjoituksen luvuille ylä- ja alarajan, jolloin tällä on mahdollisuus 
säätää itse harjoituksen vaativuustasoa. Lisäksi tulee valita kysymysten määrä 
väliltä 1-20. Kun asetukset on käyttäjälle mieluiset, hän pääsee eteenpäin painamalla OK -nappia.

## Yhteen- ja vähennyslaskuharjoituksen harjoitusnäkymä

Asetusten valinnan jälkeen käyttäjälle aukeaa harjoitusnäkymä, joka on joka kerralla 
uniikki. Kun käyttäjä on tehnyt harjoituksen, sovellus tarkistaa oikeiden vastausten määrän.
Tämä tapahtuu painamalla OK -nappia. Tällöin napin viereen ilmestyy tulokset muodossa 
_oikeiden vastausten lukumäärä / kysymysten lukumäärä_.

Käyttäjä pääsee takaisin harjoituksen valintaan painamalla Takaisin valintaan -nappia.
 
## Oman kokeen luominen

Oman kokeen luonti tapahtuu aloitusnäkmässä painamalla "Luo oma kysymys" -nappia.
Näin aukeaa näkymä, jossa käyttäjä voi tallettaa omia kysymyksiä tietokantaan. 
Jos kysymys- tai vastauskohdassa ei ole tekstiä, tietokantaan ei tallenneta kysymystä, ja sovellus varoittaa tästä.
Takaisin valintaan -nappia painamalla pääset takaisin aloitussivulle.
Tietokanta ei säilytä kysymyksiä, vaan jokaisella sovelluksen avauskerralla tulee luoda uudet kysymykset.


## Oman kokeen tekeminen

Omista kysymyksistä kootun kokeen voi aloittaa painamalla "Aloita oma koe" -nappia aloitusnäkymässä.
Sovellus arpoo satunnaisessa järjestyksessä itse tehtyjä kysymyksiä. Kokeeseen tulee kuitenkin
maksimissaan 10 kysymystä. 
Painamalla OK -nappia kokeen tulos näytetään kyseisen napin oikealla puolella. 
Takaisin valintaan -nappia painamalla pääset takaisin aloitussivulle.

