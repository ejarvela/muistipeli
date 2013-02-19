
package tiedostojenKasittely;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Tiedostonlukija lukee annetun tekstitiedoston.
 * <p>
 * Tiedostonlukija lukee annetun tekstitiedoston rivi kerrallaan. Lukija sijoittaa kunkin
 * rivin tekstin listan alkioon. Lukija palauttaa listan, jonka alkioina ovat tiedostosta
 * luetut rivit.
 * 
 * @author emilia
 */
public class TiedostonLukija {

    /**
     * Luettava tiedosto.
     */
    private File tiedosto;
    /**
     * Lista kuvien tiedostonimistä.
     */
    private ArrayList<String> kuvalista;
    /**
     * Listassa olevien kuvien määrä.
     */
    int kuvienMaara;
    
    /**
     * Luo uuden tiedostonlukijan.
     * @param tiedosto Luettava tiedosto.
     * @throws Exception 
     */
    public TiedostonLukija(File tiedosto) throws Exception {
        this.tiedosto = tiedosto;
        this.kuvalista = new ArrayList<String>();
    }

    /**
     * Lukee kuvien tiedostonimet tekstitiedostosta ja pistää ne listaan.
     *
     * @return Lista kuvien tiedostonimistä.
     * @throws Exception
     */
    public ArrayList haeKuvat() throws Exception {
        Scanner lukija = new Scanner(this.tiedosto);
        kuvienMaara = 0;
        while (lukija.hasNextLine()) {
            String rivi = lukija.nextLine();
            kuvienMaara++;
            kuvalista.add(rivi);
        }
        
        lukija.close();

        return kuvalista;
    }
    
    public int getKuvienMaara(){
        return kuvienMaara;
    }
}
