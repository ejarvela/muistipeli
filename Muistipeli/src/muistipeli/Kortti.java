
package muistipeli;

import tiedostojenKasittely.KuvanAvaus;


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
    
   public void nostaKortti() throws Exception{
       //nosta kortti
       KuvanAvaus kuva = new KuvanAvaus(this.nimi);
       
   }
   public int getKortinNro(){
       return this.kortinNro;
   }
}
