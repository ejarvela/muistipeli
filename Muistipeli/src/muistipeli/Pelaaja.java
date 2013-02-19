
package muistipeli;

/**
 * Muistipelin pelaaja.
 * <p>
 * Pelaaja sisältää tiedon pelaajan nimestä ja hänen pistetilanteestaan.
 * @author emilia
 */

public class Pelaaja {

   /**
    * Pelaajan nimi.
    */
   private String nimi;
   /**
    * Pelaajan pisteet.
    */
   private int pisteet;
   
   /**
    * Luo uuden pelaajan ja asettaa nimeksi parametrina annetun nimen.
    * @param nimi Pelaajan nimi.
    */
   public Pelaaja (String nimi){
       this.nimi = nimi;
       this.pisteet = 0;
   }
   
   @Override
   public String toString(){
       return this.nimi;
   }

   /**
    * Lisää pisteen pelaajalle.
    */
   public void lisaaPiste(){
       pisteet++;
   }
   
   public int getPisteet(){
       return this.pisteet;
   }
    
}
