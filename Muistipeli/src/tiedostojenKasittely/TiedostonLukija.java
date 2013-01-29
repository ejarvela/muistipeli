
package tiedostojenKasittely;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

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
