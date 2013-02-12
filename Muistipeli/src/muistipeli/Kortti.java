
package muistipeli;

import tiedostojenKasittely.KuvanAvaus;

/**
 * Muistipelin kortti.
 * <p>
 * Kortti sisältää tiedon kortin nimestä ja tiedostonimestä sekä kortin numeron pelissä.
 * @author emilia
 */
public class Kortti {
    
   private String nimi;
   private String tiedostonimi;
   private int kortinNro;
   
   public Kortti (String nimi){
       this.nimi = nimi;
}
   
    @Override
   public String toString(){
       return this.nimi;
   }
   
   public void asetaKortinNro(Integer nro){
       this.kortinNro = nro;
   }
    
   public void nostaKortti(Integer x, Integer y, Integer kuvaNro) throws Exception{
       //nosta kortti
       KuvanAvaus kuva = new KuvanAvaus(this.nimi);
       kuva.kuvanPiirto(x,y, kuvaNro);
       
   }
   public int getKortinNro(){
       return this.kortinNro;
   }
}
