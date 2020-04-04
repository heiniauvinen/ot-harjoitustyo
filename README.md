
# Matematiikkasovellus

Sovellus tarjoaa mahdollisuuden harjoitella päässälaskutaitoja, yhteen- ja vähennyslaskuilla.
Käyttäjä voi itse valita lukujen ala- ja ylärajan, jolloin vaikeustason määrittäminen on helppoa.
Sovellus arpoo luvut, joten jokaisessa testissä on vaihtelevuutta.

## Dokumentaatio

[Vaatimusmäärittely](dokumentointi/vaatimusmäärittely.md)

[Arkkitehtuurikuvaus](dokumentointi/arkkitehtuuri.md)

[Työaikakirjanpito](dokumentointi/tuntikirjanpito.md)

## Komentorivitoiminnot

Suoritetaan kansiossa MatematiikkaSovellus.

### Ohjelman ajaminen komentorivillä

Komennolla:

```
mvn compile exec:java -Dexec.mainClass=app.Matikkapeli
```


### Testaus

Testit on mahdollista suorittaa komennolla:

```
mvn test
```
Testikattavuusraportti saadaan komennolla:

```
mvn jacoco:report
```

Testikattavuusraportin voi avata myös selaimessa avaamalla tiedoston target/site/jacoco/index.html.

### Suoritettavan jarin generointi

Komennolla:

```
mvn package
```












  


