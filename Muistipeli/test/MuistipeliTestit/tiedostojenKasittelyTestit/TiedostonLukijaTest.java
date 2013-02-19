/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MuistipeliTestit.tiedostojenKasittelyTestit;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import tiedostojenKasittely.TiedostonLukija;

/**
 *
 * @author emilia
 */
public class TiedostonLukijaTest {
    
    TiedostonLukija lukija;
    File tiedosto;
    ArrayList<String> kuvienNimet;
    
    
    @Before
    public void setUp() throws Exception {
        
        tiedosto = new File("/home/emilia/muistipeli/Muistipeli/src/muistipeli/kuvat.txt");
        lukija = new TiedostonLukija(tiedosto);
        kuvienNimet = new ArrayList<String>();
                
    }
    
    @Test
    public void lukeeEkanRivinOikein() throws Exception{
        
        kuvienNimet = lukija.haeKuvat();
        assertEquals("apilat.JPG", kuvienNimet.get(0));        
    }
    
    @Test
    public void lukeeVikanRivinOikein() throws Exception{
        
        kuvienNimet = lukija.haeKuvat();
        assertEquals("torsti.JPG", kuvienNimet.get(20));        
    }

   
}
