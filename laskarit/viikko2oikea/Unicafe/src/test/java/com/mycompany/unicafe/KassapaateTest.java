package com.mycompany.unicafe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KassapaateTest {

    Kassapaate kassa;

    public KassapaateTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.kassa = new Kassapaate();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void alustusOikein() {
        assertEquals(100000, kassa.kassassaRahaa());
        assertEquals(0, kassa.maukkaitaLounaitaMyyty() + kassa.edullisiaLounaitaMyyty());
    }

    @Test
    public void kateisostoToimii() {
        kassa.syoEdullisesti(240);
        assertEquals(100240, kassa.kassassaRahaa());
        kassa.syoMaukkaasti(400);
        assertEquals(100640, kassa.kassassaRahaa());
    }

    @Test
    public void vaihtorahaToimii() {
        assertEquals(60, kassa.syoEdullisesti(300));
        assertEquals(600, kassa.syoMaukkaasti(1000));
    }

    @Test
    public void josMaksuRiittavaLounaidenMaaraKasvaa() {
        kassa.syoMaukkaasti(1000);
        kassa.syoEdullisesti(1000);
        kassa.syoMaukkaasti(600);
        kassa.syoEdullisesti(240);
        assertEquals(2, kassa.edullisiaLounaitaMyyty());
        assertEquals(2, kassa.maukkaitaLounaitaMyyty());
    }

    @Test
    public void josMaksuEiRiittavaRahamaaraEiMuutu() {
        kassa.syoEdullisesti(200);
        kassa.syoMaukkaasti(-20);
        kassa.syoMaukkaasti(4);
        assertEquals(100000, kassa.kassassaRahaa());
    }

    @Test
    public void josMaksuEiRiitaLounaidenLkmPysyy() {
        kassa.syoEdullisesti(240);
        kassa.syoMaukkaasti(600);
        kassa.syoEdullisesti(200);
        kassa.syoMaukkaasti(-20);
        kassa.syoMaukkaasti(4);
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
    }

    @Test
    public void josMaaraEiRiitaRahatPalautetaanVaihtorahana() {
        assertEquals(200, kassa.syoEdullisesti(200));
        assertEquals(0, kassa.syoMaukkaasti(0));
    }

    @Test
    public void korttiostoToimiiEdullisellaJaRahatRiittävät() {
        Maksukortti kortti = new Maksukortti(1000);
        assertEquals(true, kassa.syoEdullisesti(kortti));
        Maksukortti kortti2 = new Maksukortti(240);
        assertEquals(true, kassa.syoEdullisesti(kortti));
    }

    @Test
    public void korttiostoToimiiMaukkaallaJaRahatRiittavat() {
        Maksukortti kortti = new Maksukortti(1000);
        assertEquals(true, kassa.syoMaukkaasti(kortti));
        assertEquals(true, kassa.syoMaukkaasti(kortti));
    }

    @Test
    public void josKortillaEiTarpeeksiRahaaKortinRahamaaraEiMuutu() {
        Maksukortti kortti = new Maksukortti(10);
        kassa.syoEdullisesti(kortti);
        kassa.syoMaukkaasti(kortti);
        assertEquals(10, kortti.saldo());
    }

    @Test
    public void josKortinRahaEiRiitaPalautetaanFalse() {
        Maksukortti kortti = new Maksukortti(10);
        kassa.syoEdullisesti(kortti);
        assertEquals(false, kassa.syoEdullisesti(kortti));
        kassa.syoMaukkaasti(kortti);
        assertEquals(false, kassa.syoMaukkaasti(kortti));
    }

    @Test
    public void josKortillaRahaaLounaidenMaaraKasvaa() {
        Maksukortti kortti = new Maksukortti(1000);
        kassa.syoMaukkaasti(kortti);
        kassa.syoEdullisesti(kortti);
        assertEquals(2, kassa.maukkaitaLounaitaMyyty() + kassa.edullisiaLounaitaMyyty());
    }

    @Test
    public void josKortinRahatEiRiitaLounaidenMaaraEiKasva() {
        Maksukortti kortti = new Maksukortti(100);
        kassa.syoEdullisesti(kortti);
        kassa.syoMaukkaasti(kortti);
        assertEquals(0, kassa.maukkaitaLounaitaMyyty() + kassa.edullisiaLounaitaMyyty());

    }

    @Test
    public void kassanRahamaaraEiMuutuKortillaOstettaessa() {
        Maksukortti kortti = new Maksukortti(100);
        kassa.syoEdullisesti(kortti);
        kassa.syoMaukkaasti(kortti);
        assertEquals(100000, kassa.kassassaRahaa());
    }

    @Test
    public void kunKortilleLadataanRahaaKortinSaldoMuuttuu() {
        Maksukortti kortti = new Maksukortti(100);
        kassa.lataaRahaaKortille(kortti, 1000);
        assertEquals(1100, kortti.saldo());
    }

    @Test
    public void negatiivinenLatausEiMuutaKortinSaldoa() {
        Maksukortti kortti = new Maksukortti(1000);
        kassa.lataaRahaaKortille(kortti, -10);
        assertEquals(1000, kortti.saldo());
    }

    @Test
    public void kunKortilleLadataanRahaaKassanRahamaaraKasvaaLadatullaSummalla() {
        Maksukortti kortti = new Maksukortti(1000);
        kassa.lataaRahaaKortille(kortti, 1000);
        assertEquals(101000, kassa.kassassaRahaa());
    }

    @Test
    public void negatiivinenLatausEiMuutaKassanRahamaaraa() {
        Maksukortti kortti = new Maksukortti(1000);
        kassa.lataaRahaaKortille(kortti, -10);
        assertEquals(100000, kassa.kassassaRahaa());
    }

}
