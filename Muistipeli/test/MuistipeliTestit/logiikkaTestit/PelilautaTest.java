package MuistipeliTestit.logiikkaTestit;

import java.util.ArrayList;
import java.util.Collections;
import logiikka.Pelilauta;
import muistipeli.Kortti;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class PelilautaTest {

    Pelilauta lauta;
    ArrayList<Integer> numerolista;
    int korttienMaara;
    ArrayList<Kortti> kortit;

    public PelilautaTest() {
    }

    @Before
    public void setUp() {

        lauta = new Pelilauta();
        numerolista = new ArrayList<Integer>();
        kortit = new ArrayList<Kortti>();
    }

    @Test
    public void maarittaaKorttimaaranOikein() {
        lauta.maaritaKorttienMaara(3);
        assertEquals(15, lauta.getKorttienMaara());

    }

    @Test
    public void toimiiOikeinJosAnnettuaVaikeustasoaEiOle() {

        lauta.maaritaKorttienMaara(5);
        assertEquals(0, lauta.getKorttienMaara());

    }

    @Test
    public void toimiiOikeinJosAnnettuVaikeustasoaNegatiivinen() {

        lauta.maaritaKorttienMaara(-5);
        assertEquals(0, lauta.getKorttienMaara());

    }

    @Test
    public void arpooOikeanMaaranNumeroita() {
        numerolista = lauta.arvoNumerot(10, 22);
        assertEquals(10, numerolista.size());
    }

    @Test
    public void arpooOikeanMaaranNumeroita2() {
        numerolista = lauta.arvoNumerot(10, -10);
        assertEquals(0, numerolista.size());
    }

    @Test
    public void arpooOikeanMaaranNumeroita3() {
        numerolista = lauta.arvoNumerot(-10, 13);
        assertEquals(0, numerolista.size());
    }

    @Test
    public void arpooOikeanMaaranNumeroita4() {
        numerolista = lauta.arvoNumerot(30, 13);
        assertEquals(0, numerolista.size());
    }

    @Test
    public void isoinNumeroOikein() {
        numerolista = lauta.arvoNumerot(13, 13);
        int max = Collections.max(numerolista);
        assertEquals(12, max);
    }

    @Test
    public void pieninNumeroOikein() {
        numerolista = lauta.arvoNumerot(13, 13);
        int min = Collections.min(numerolista);
        assertEquals(0, min);
    }
}
