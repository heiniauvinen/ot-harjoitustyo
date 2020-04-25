# Vaatimusmäärittely

## Sovellus

Sovellus tarjoaa käyttäjälleen mahdollisuuden kerrata päässälaskuja ja luoda oman harjoituksen. Käyttäjä pystyy itse asettamaan vaativuustason harjoitukselle
asettamalla ylä- ja alarajan ja valitsemalla kysyttövien kysymysten määrän. Sovelluksessa voi luoda omia kysymyksiä ja tehdä omista kysymyksistä koostuvan kokeen.

## Käyttöliittymäluonnos

Käyttäjälle avautuu näkymä, jossa hän voi valita minkä aihealueen harjoituksia hän haluaa tehdä. 
Aloitusnäkymässä hän voi myös valita, luoko hän omia kysymyksiä ja tekee näistä koostuvan kokeen. 
Yhteen- ja vähennyslaskukokeissa käyttäjä pystyy asettamaan ylä- ja alarajan luvuille. 
Näiden asettamisen jälkeen käyttäjälle avautuu itse harjoitusnäkymä.
Käyttäjä voi koota oman kokeen luomalla omia kysymyksiä siihen tarkoitetussa näkymässä.
Kysymysten luonnin jälkeen käyttäjä voi tehdä näistä koostuvan kokeen tähän tarkoitetussa harjoitusnäkymässä.

Sovelluksesta tulee siis löytymään seitsemän näkymää:
- Harjoituksen valintaan tarkoitettu näkymä
- Ylä- ja alarajan asettamiseen tarkoitettu näkymä yhteenlaskukokeelle
- Ylä- ja alarajan asettamiseen tarkoitettu näkymä vähennyslaskukokeelle
- Yhteenlaskujen harjoitusnäkymä
- Vähennyslaskujen harjoitusnäkymä
- Oman harjoituksen harjoitusnäkymä
- Omien kysymyksien luontiin tarkoitettu näkymä

## Sovelluksen tarjoama toiminnallisuus

Käyttäjälle aukeaa harjoitusten valintaan tarkoitettu näkymä, josta käyttäjä voi valita, mitä hän haluaa harjoitella.
Käyttäjälle tarjotaan myös mahdollisuus luoda oma koe ja suorittaa se.
Jos käyttäjä valitsee yhteen- tai vähennyslakukokeen käyttäjälle avautuu näkymä, jossa hän voi itse säädellä laskuharjoituksen vaativuustasoa ja valita kysymysten määrän.
Valinnan jälkeen avautuu harjoitusnäkymä. Kun harjoitus on tehty loppuun, palataan _Takaisin valintaan_ -nappia painamalla valintanäkymään.

Käyttäjä voi luoda omia kysymyksiä painamalla valintanäkymässä _Luo oma kysymys_ -nappia. Tässä näkymässä on mahdollisuus tallentaa kysymykset tietokantaan.
Oman kokeen voi suorittaa valitsemalla valintanäkymässä _Aloita oma koe_. Oma koe toimii niin, että se satunnaisessa järjestyksessä
antaa itse luotuja kysymyksiä. Jos kysymyksiä on yli kymmenen, sovellus arpoo niistä kymmenen kokeeseen.

## Kehitysehdotuksia
- Tulosten tarkastelu. Tulos -sivulla ohjelma näyttää käyttäjän parhaan tuloksen jokaisesta eri harjoituksesta. 
- Useamman tuloksen tarkastelu. Tulos -sivulla näkyisi esimerkiksi kymmenen viimeisintä harjoituskertaa tietystä harjoituksesta. Tällöin kehityksen seuraaminen olisi helpompaa.
- Ajanotto. Sovellus voisi säilyttää testien suoritukseen kuluvia aikoja.
- Useampie erilaisten laskuharjoitusten lisäys. Esimerkiksi kerto- ja jakolaskut.

## Sovelluksen edistyminen

### Viikko 4
- Sovelluksesta löytyy harjoituksen valinta -näkymä, ylä- ja alarajan asettamisnäkymä sekä harjoitusnäkymä.
- Näkymissä on napit siirtymiä varten. Sovelluksessa siis pystyy etenemään, muttei palaamaan.
- Ylä- ja alarajan asettaminen toimii
- Vähennyslaskutestiin on lisätty toiminto, joka näyttää oikeiden vastausten lukumäärän, kun painaa OK -nappia.

### Viikko 5
- Yhteenlaskutestiin lisätty toiminto, joka näyttää oikeiden vastausten lukumäärän, kun painaa OK -nappia.
- Takaisin valintaan nappi toimii, muttei vielä nollaa edellisiä testejä.
- Testien tulos näkyy nyt muodossa: "oikeat vastaukset / laskujen lukumäärä".

### Viikko 6
- Kysymysten lukumäärän saa nyt valita itse.
- Tietokantaan voi tallentaa kysymyksiä ja tietokannasta voidaan palauttaa lista kysymyksistä.
- _Luo oma kysymys_- ja _Aloita oma koe_ -toiminnot lisätty.
- Oman kokeen tarkistustoiminto lisätty.

