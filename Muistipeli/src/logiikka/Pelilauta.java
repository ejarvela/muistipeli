package logiikka;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import muistipeli.Kortti;
import tiedostojenKasittely.TiedostonLukija;

public class Pelilauta {

    int korttienMaara;
    ArrayList<String> kuvienNimet;
    ArrayList<Integer> kuvienNumerotListassa;
    ArrayList<Kortti> kortit;
    HashMap<Integer,Kortti> kortitPoydalla;
    TiedostonLukija fileReader;

    public Pelilauta() {
    }

    public void maaritaVaikeus(Integer vaikeus) {

        if (vaikeus == 1) {
            korttienMaara = 6;
        } else if (vaikeus == 2) {
            korttienMaara = 10;
        } else if (vaikeus == 3) {
            korttienMaara = 15;
        } else {
            korttienMaara = 21;
        }
    }

    public void arvoKuvat(Integer vaikeus) throws Exception {

        kuvienNumerotListassa = new ArrayList<Integer>();
        kuvienNumerotListassa = arvoNumerot(korttienMaara);
        
        System.out.println(kuvienNumerotListassa.toString());
    }
    
    public ArrayList<Integer> arvoNumerot(Integer maara){
        
        HashSet<Integer> arvotutNumerot = new HashSet<Integer>();
        ArrayList<Integer> arvotutNumerotListassa = new ArrayList<Integer>();
        Random rand = new Random();

        int randomNumero;
        int i;
        int e;
        int g;

        g = maara;

        //arpoo kuvat       
        for (i = 0; i < g; i++) {
            e = rand.nextInt(21);
            arvotutNumerot.add(e);
            if (arvotutNumerot.size() <= maara) {
                if (arvotutNumerot.size() == maara) {
                    g = maara;
                }
                g++;
                arvotutNumerot.add(e);
            }
        }

        // muuttaa Set -> List
        arvotutNumerotListassa.addAll(arvotutNumerot);
        
        return arvotutNumerotListassa;
    }
        
    


    public void luoKortit() throws Exception {

        //lukee kuvien nimet tiedostosta        
        File tiedosto = new File("src/muistipeli/kuvat.txt");
        kortit = new ArrayList<Kortti>();
        fileReader = new TiedostonLukija(tiedosto);
        kuvienNimet = fileReader.haeKuvat();

        String kortinNimi;
        String kortinNimi2;

        //luo kortit      
        for (int i = 0; i < kuvienNumerotListassa.size(); i++) {
            int a = kuvienNumerotListassa.get(i);
            kortinNimi = kuvienNimet.get(a);
            kortinNimi2 = kuvienNimet.get(a);
            Kortti KortinNimi = new Kortti(kortinNimi2);
            kortit.add(KortinNimi);

        }

        //   System.out.println(kortit.toString());

    }
    
    public void asetaKortitPoydalle(){
        
        ArrayList<Integer> korttienNumerotPoydalla = new ArrayList<Integer>();
        kortitPoydalla = new HashMap<Integer, Kortti>();
        
        for(int i = 0; i < korttienMaara*2;i++){
            korttienNumerotPoydalla.add(i);
        }
        
        System.out.println(korttienNumerotPoydalla.toString());
        
        Collections.shuffle(korttienNumerotPoydalla);
        
        System.out.println(korttienNumerotPoydalla.toString());
        
        
        int korttiNro = 0;
        int kuvaNro = 0;
        
        while(korttiNro<korttienMaara*2){
        kortitPoydalla.put(korttienNumerotPoydalla.get(korttiNro), kortit.get(kuvaNro));
        korttiNro++;
        kortitPoydalla.put(korttienNumerotPoydalla.get(korttiNro), kortit.get(kuvaNro));
        korttiNro++;
        kuvaNro++;
        
        }
        
        System.out.println(kortitPoydalla.toString());
        System.out.println(kortitPoydalla.keySet());
    }
}
