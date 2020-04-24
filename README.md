
# Ohjelmistotekniikka, harjoitustyö

## Matematiikkasovellus

Sovellus tarjoaa mahdollisuuden harjoitella päässälaskutaitoja, yhteen- ja vähennyslaskuilla.
Käyttäjä voi itse valita lukujen ala- ja ylärajan, jolloin vaikeustason määrittäminen on helppoa.
Sovellus arpoo luvut, joten jokaisessa testissä on vaihtelevuutta.

### Dokumentaatio

[Käyttöohje](dokumentaatio/kayttoohje.md)

[Vaatimusmäärittely](dokumentaatio/vaatimusmäärittely.md)

[Arkkitehtuurikuvaus](dokumentaatio/arkkitehtuuri.md)

[Työaikakirjanpito](dokumentaatio/tuntikirjanpito.md)

### Releaset

[Viikko 5](https://github.com/heiniauvinen/ot-harjoitustyo/releases/tag/Viikko5)

### Komentorivitoiminnot

Suoritetaan kansiossa MatematiikkaSovellus.

#### Ohjelman ajaminen komentorivillä

Komennolla:

```
mvn compile exec:java -Dexec.mainClass=app.Matikkapeli
```


#### Testaus

Testit on mahdollista suorittaa komennolla:

```
mvn test
```
Testikattavuusraportti saadaan komennolla:

```
mvn jacoco:report
```

Testikattavuusraportin voi avata myös selaimessa avaamalla tiedoston _target/site/jacoco/index.html_

#### Suoritettavan jarin generointi

Komennolla:

```
mvn package
```

#### Checkstyle

Tiedostoon [checkstyle.xml](MatematiikkaSovellus/checkstyle.xml) määrittelemät tarkistukset suoritetaan komennolla:

```
 mvn jxr:jxr checkstyle:checkstyle
```

Mahdolliset virheilmoitukset selviävät avaamalla selaimella tiedosto _target/site/checkstyle.html_

#### JavaDoc

JavaDoc generoidaan komennolla:

```
mvn javadoc:javadoc
```

JavaDocin voi avata selaimella avaamalla tiedoston _target/site/apidocs/index.html_.









  


