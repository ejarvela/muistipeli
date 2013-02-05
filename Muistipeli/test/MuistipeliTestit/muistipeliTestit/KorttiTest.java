package MuistipeliTestit.muistipeliTestit;

import muistipeli.Kortti;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class KorttiTest {

    Kortti kortti1;
    
    @Before
    public void setUp(){
        
        kortti1 = new Kortti("kissa");
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