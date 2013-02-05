
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

    private File tiedosto;
    private ArrayList<String> kuvalista;

    public TiedostonLukija(File tiedosto) throws Exception {
        this.tiedosto = tiedosto;
        this.kuvalista = new ArrayList<String>();
    }

    public ArrayList haeKuvat() throws Exception {
        Scanner lukija = new Scanner(this.tiedosto);
        int i = 0;
        while (lukija.hasNextLine()) {
            String rivi = lukija.nextLine();
            i++;
            kuvalista.add(rivi);
        }
        
        lukija.close();

        return kuvalista;
    }
}
