
package muistipeli;

import tiedostojenKasittely.KuvanAvaus;

/**
 * Muistipelin kortti.
 * <p>
 * Kortti sisältää tiedon kortin nimestä ja tiedostonimestä sekä kortin numeron pelissä.
 * @author emilia
 */
public class Kortti {

    /**
     * Kortin nimi.
     */
   private String nimi;
   /**
    * Kuvan avaus;
    */
   KuvanAvaus kuva;
   
   public Kortti (String nimi){
       this.nimi = nimi;
}
   
    @Override
   public String toString(){
       return this.nimi;
    }

    /**
     *
     * @param x Kuvan vasemman ylänurkan sijainti x-akselilla.
     * @param y Kuvan vasemman ylänurkan sijainti y-akselilla.
     * @param kuvaNro Kuvan numero pelilaudalla.
     * @throws Exception
     */
   public void nostaKortti(Integer x, Integer y, Integer kuvaNro) throws Exception{
       
       kuva = new KuvanAvaus(this.nimi);
       kuva.kuvanPiirto(x,y, kuvaNro);
   }
   
   /**
    * Sulkee kortin.
    */
   public void kaannaKorttiTakaisin(){
       kuva.suljeKuva();
   }
  
}
