# Arkkitehtuurikuvaus

## Rakenne

Sovelluksen pakkausrakenne on seuraava: 

- Pakkaus _ui_ sisältää sovelluksen graafisen käyttöliittymän.
- Pakkaus _dao_ sisältää pysyväistallennuksesta huolehtivan koodin.
- Pakkaus _logic_ sisältää sovelluslogiikan.

![Luokkakaavio1](kuvat/luokkakaavio.jpg)

## Käyttöliittymä

Käyttöliittymä sisältää seitsemän erilaista näkymää.

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

Pakkauksen _dao_ luokka _CreateDatabase_ luo uuden tietokannan sovelluksen ensimmäisellä käynnistyskerralla. 
Luokka _QuestionDao_ huolehtii kysymysten tallennuksesta ja tietokannasta lukemisesta.
Luokat noudattavat Data Access Object -suunnittelumallia. 

### Tietokanta
 
Tietokantaan tallennetaan kysymys-vastaus -pareja kysymysten luontiin tarkoitetussa näkymässä.
Tietokantaan voidaan tallentaa dataa ja sieltä palautetaan lista kysymyksiä.




