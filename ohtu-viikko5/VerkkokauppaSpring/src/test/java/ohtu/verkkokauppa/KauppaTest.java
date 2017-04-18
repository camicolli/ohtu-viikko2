/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.verkkokauppa;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author cocacoca
 */
public class KauppaTest {
    
    Kauppa k;
    
   @Test
public void ostoksenPaatyttyaPankinMetodiaTilisiirtoKutsutaan() {
    // luodaan ensin mock-oliot
    Pankki pankki = mock(Pankki.class);
    
    Viitegeneraattori viite = mock(Viitegeneraattori.class);
    // määritellään että viitegeneraattori palauttaa viitten 42
    when(viite.uusi()).thenReturn(42);

    Varasto varasto = mock(Varasto.class);
    // määritellään että tuote numero 1 on maito jonka hinta on 5 ja saldo 10
    when(varasto.saldo(1)).thenReturn(10); 
    when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));

    // sitten testattava kauppa 
    Kauppa k = new Kauppa(varasto, pankki, viite);              

    // tehdään ostokset
    k.aloitaAsiointi();
    k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
    k.tilimaksu("pekka", "12345");

    // sitten suoritetaan varmistus, että pankin metodia tilisiirto on kutsuttu
    verify(pankki).tilisiirto("pekka",42, "12345","33333-44455",5);   
    // toistaiseksi ei välitetty kutsussa käytetyistä parametreista
}

@Test
public void monenOstonPaatyttyaTilisiirtoToimii() {
   
    Pankki pankki = mock(Pankki.class);
    Viitegeneraattori viite = mock(Viitegeneraattori.class);
    when(viite.uusi()).thenReturn(42);

    Varasto varasto = mock(Varasto.class);
    // määritellään että tuote numero 1 on maito jonka hinta on 5 ja saldo 10
    when(varasto.saldo(1)).thenReturn(10); 
    when(varasto.saldo(2)).thenReturn(10);
    when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
    when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "kerma", 5));
    // sitten testattava kauppa 
    Kauppa k = new Kauppa(varasto, pankki, viite);              

    // tehdään ostokset
    k.aloitaAsiointi();
    k.lisaaKoriin(1); 
    k.lisaaKoriin(2);
    k.tilimaksu("pekka", "12345");

    // sitten suoritetaan varmistus, että pankin metodia tilisiirto on kutsuttu
    verify(pankki).tilisiirto("pekka",42, "12345","33333-44455",10);   
}
@Test
public void kahdenSamanTuotteenOstonPaatyttyaTilisiirtoToimii() {
   
    Pankki pankki = mock(Pankki.class);
    Viitegeneraattori viite = mock(Viitegeneraattori.class);
    when(viite.uusi()).thenReturn(42);

    Varasto varasto = mock(Varasto.class);
    // määritellään että tuote numero 1 on maito jonka hinta on 5 ja saldo 10
    when(varasto.saldo(1)).thenReturn(10); 
    when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
   
    Kauppa k = new Kauppa(varasto, pankki, viite);              

    // tehdään ostokset
    k.aloitaAsiointi();
    k.lisaaKoriin(1);
    when(varasto.saldo(1)).thenReturn(9); 
    k.lisaaKoriin(1);
    k.tilimaksu("pekka", "12345");

    // sitten suoritetaan varmistus, että pankin metodia tilisiirto on kutsuttu
    verify(pankki).tilisiirto("pekka",42, "12345","33333-44455",10);   
}
@Test
public void kahdenTuotteenOstonPaatyttyaTilisiirtoToimiiKunToinenOnLoppu() {
   
    Pankki pankki = mock(Pankki.class);
    Viitegeneraattori viite = mock(Viitegeneraattori.class);
    when(viite.uusi()).thenReturn(42);

    Varasto varasto = mock(Varasto.class);
    // määritellään että tuote numero 1 on maito jonka hinta on 5 ja saldo 10
    when(varasto.saldo(1)).thenReturn(10); 
    when(varasto.saldo(2)).thenReturn(0);
    when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
    when(varasto.haeTuote(1)).thenReturn(new Tuote(2, "kerma", 5));
   
    Kauppa k = new Kauppa(varasto, pankki, viite);              

    // tehdään ostokset
    k.aloitaAsiointi();
    k.lisaaKoriin(1);
    k.lisaaKoriin(2);
   
    k.tilimaksu("pekka", "12345");

    // sitten suoritetaan varmistus, että pankin metodia tilisiirto on kutsuttu
    verify(pankki).tilisiirto("pekka",42, "12345","33333-44455",5);   
}
@Test
public void uusiOstosNollaaEdellisenOstonTiedot() {
     Pankki pankki = mock(Pankki.class);
    Viitegeneraattori viite = mock(Viitegeneraattori.class);
    when(viite.uusi()).thenReturn(42);

    Varasto varasto = mock(Varasto.class);
    // määritellään että tuote numero 1 on maito jonka hinta on 5 ja saldo 10
    when(varasto.saldo(1)).thenReturn(10); 
    when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
   
    Kauppa k = new Kauppa(varasto, pankki, viite);              

    // tehdään ostokset
    k.aloitaAsiointi();
    k.lisaaKoriin(1);
    k.tilimaksu("pekka", "12345");

    verify(pankki,times(1)).tilisiirto("pekka", 42,"12345","33333-44455",5);
    k.aloitaAsiointi();
    k.lisaaKoriin(1);
    k.tilimaksu("pekka", "12345");
     verify(pankki,times(2)).tilisiirto("pekka", 42,"12345","33333-44455",5);
}
@Test
public void jokainenOstoSaaOmanViitenumeron() {
     Pankki pankki = mock(Pankki.class);
    Viitegeneraattori viite = mock(Viitegeneraattori.class);
    when(viite.uusi()).
            thenReturn(42).
            thenReturn(43);

    Varasto varasto = mock(Varasto.class);
    // määritellään että tuote numero 1 on maito jonka hinta on 5 ja saldo 10
    when(varasto.saldo(1)).thenReturn(10); 
    when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
   
    Kauppa k = new Kauppa(varasto, pankki, viite);              

    // tehdään ostokset
    k.aloitaAsiointi();
    k.lisaaKoriin(1);
    k.tilimaksu("pekka", "12345");

    verify(pankki).tilisiirto("pekka", 42,"12345","33333-44455",5);
    k.aloitaAsiointi();
    k.lisaaKoriin(1);
    k.tilimaksu("pekka", "12345");
     verify(pankki).tilisiirto("pekka", 43,"12345","33333-44455",5);
}@Test
public void koristaPoistoLisaaTuotteenVarastoon() {
     Pankki pankki = mock(Pankki.class);
    Viitegeneraattori viite = mock(Viitegeneraattori.class);
    when(viite.uusi()).thenReturn(42);
           

    Varasto varasto = mock(Varasto.class);
    // määritellään että tuote numero 1 on maito jonka hinta on 5 ja saldo 10
    when(varasto.saldo(1)).thenReturn(10); 
    Tuote tuote=new Tuote(1, "maito", 5);
    when(varasto.haeTuote(1)).thenReturn(tuote);
   
    Kauppa k = new Kauppa(varasto, pankki, viite);              

    // tehdään ostokset
    k.aloitaAsiointi();
    k.lisaaKoriin(1);
    k.poistaKorista(1);
    verify(varasto,times(1)).palautaVarastoon(tuote);
}
}

  