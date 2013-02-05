
package muistipeli;

import java.util.Scanner;

/**
 * Käynnistää muistipelin.
 * @author emilia
 */
public class Main {


    public static void main(String[] args) throws Exception {
      
        
         Scanner lukija = new Scanner(System.in);
        
        Muistipeli peli = new Muistipeli(lukija);
        peli.kaynnista();
    }
}
