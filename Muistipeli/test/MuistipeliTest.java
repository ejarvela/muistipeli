/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import muistipeli.Kortti;
import muistipeli.Pelaaja;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author emilia
 */
public class MuistipeliTest {
    
    Pelaaja pelaaja1;
    Kortti kortti1;
    
    @Before
    public void setUp(){
        pelaaja1 = new Pelaaja("ziltoid");
        kortti1 = new Kortti("kissa");
    }
    
//    public MuistipeliTest() {
//    }
    
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
    
    @Test
    public void konstruktoriNimeaaKortinOikein(){
        assertEquals("kissa",kortti1.toString());
    }
    
    @Test
    public void asettaaKortinNronOikein(){
        kortti1.asetaKortinNro(3);
        assertEquals(3,kortti1.getKortinNro());
    }
}
