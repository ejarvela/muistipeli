package MuistipeliTestit.logiikkaTestit;

import java.util.ArrayList;
import java.util.Collections;
import logiikka.Pelilauta;
import muistipeli.Pelaaja;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class PelilautaTest {

    Pelilauta lauta;
    ArrayList<Integer> kuvienNumerotListassa;

    public PelilautaTest() {
    }

    @Before
    public void setUp() {

        lauta = new Pelilauta();
        kuvienNumerotListassa = new ArrayList<Integer>();
    }

    @Test
    public void maarittaaKorttimaaranOikein() {
        lauta.maaritaVaikeus(3);
        assertEquals(15, lauta.getKorttienMaara());

    }
    
    @Test
    public void toimiiOikeinJosAnnettuaVaikeustasoaEiOle() {
        
       lauta.maaritaVaikeus(5);
       assertEquals(0,lauta.getKorttienMaara());

    }
    
     @Test
    public void toimiiOikeinJosAnnettuVaikeustasoaNegatiivinen() {
        
       lauta.maaritaVaikeus(-5);
       assertEquals(0,lauta.getKorttienMaara());

    }
     
     @Test
     public void arpooOikeanMaaranNumeroita(){
         kuvienNumerotListassa = lauta.arvoNumerot(10, 22);
         assertEquals(10,kuvienNumerotListassa.size());
     }
     
     @Test
     public void arpooOikeanMaaranNumeroita2(){
         kuvienNumerotListassa = lauta.arvoNumerot(10, -10);
         assertEquals(0,kuvienNumerotListassa.size());
     }
    
     @Test
     public void arpooOikeanMaaranNumeroita3(){
         kuvienNumerotListassa = lauta.arvoNumerot(-10, 13);
         assertEquals(0,kuvienNumerotListassa.size());
     }
     
      @Test
     public void arpooOikeanMaaranNumeroita4(){
         kuvienNumerotListassa = lauta.arvoNumerot(30, 13);
         assertEquals(0,kuvienNumerotListassa.size());
     }
    
     @Test
     public void isoinNumeroOikein(){
         kuvienNumerotListassa = lauta.arvoNumerot(13, 13);
         int max = Collections.max(kuvienNumerotListassa);
         assertEquals(12,max);
     }
     
     @Test
     public void pieninNumeroOikein(){
         kuvienNumerotListassa = lauta.arvoNumerot(13, 13);
         int min = Collections.min(kuvienNumerotListassa);
         assertEquals(0,min);
     }
}
