package MuistipeliTestit.muistipeliTestit;


import muistipeli.Pelaaja;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class PelaajaTest {
    
    Pelaaja pelaaja1;
    
    @Before
    public void setUp(){
        pelaaja1 = new Pelaaja("ziltoid");
    }

    
    @Test
    public void konstruktoriAsettaaNimenOikein() {
      assertEquals("ziltoid", pelaaja1.toString());
  }
    
    @Test
    public void pisteLisataanOikein(){
        pelaaja1.lisaaPiste();
        assertEquals(1,pelaaja1.getPisteet());       
    }
    
    @Test
    public void montaPistettaLisataanOikein(){
        
        for(int i = 0; i < 4; i++){
        pelaaja1.lisaaPiste();
        }
    
        assertEquals(4,pelaaja1.getPisteet());
    }
}