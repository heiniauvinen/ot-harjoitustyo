# Arkkitehtuurikuvaus

## Rakenne

![Luokkakaavio](kuvat/MatematiikkaSovellusluokkakaavio.jpg)

![Luokkakaavio1](kuvat/luokkakaavio.jpg)

## Sovelluslogiikka

### Päätoiminnallisuudet

#### Yhteen- ja vähennyslaskutestin luonti & tarkistus

Seuraavissa sekvenssikaavioissa on kuvaus siitä, kuinka sovellus luo yhteen- ja vähennyslaskutestin 
ja tarkistaa ne.

![Sekvenssikaavio1](kuvat/yhteenlasku.png)

![Sekvenssikaavio2](kuvat/vahennyslaskutsekvenssikaavio.png)

#### Omien kysymysten luominen

![Sekvenssikaavio3](kuvat/luoOmaKysymys.png)

Omien kysymysten luominen ja tallentaminen tietokantaan tapahtuu ylläolevan sekvenssikaavion mukaisesti.

## Tietojen tallennus

Pakkauksen _dao_ luokka _CreateDatabase_ luo uuden tietokannan jokaisella sovelluksen käynnistyskerralla. 
Luokka _QuestionDao_ huolehtii kysymysten tallennuksesta ja tietokannasta lukemisesta.
Luokat noudattavat Data Access Object -suunnittelumallia. 

### Tietokanta

Uusi tietokanta luodaan jokaisella sovelluksen käynnistyskerralla, 
ja vanha poistetaan. 
Tietokantaan tallennetaan kysymys-vastaus -pareja.
Tietokantaan voidaan tallentaa dataa ja sieltä palautetaan lista kysymyksiä.




