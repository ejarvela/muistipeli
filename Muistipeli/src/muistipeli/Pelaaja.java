
package muistipeli;

import java.util.ArrayList;


public class Pelaaja {
    
   private String nimi;
   private int pisteet;
   
   public Pelaaja (String nimi){
       this.nimi = nimi;
       this.pisteet = 0;
   }
   
    @Override
   public String toString(){
       return this.nimi;
   }
    
   public void lisaaPiste(){
       pisteet++;
   }
   
   public int getPisteet(){
       return this.pisteet;
   }
    
}
