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
    
    
}