package logiikka;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import muistipeli.Kortti;
import muistipeli.Pelaaja;
import tiedostojenKasittely.TiedostonLukija;

/**
 * Luo kussakin pelissä pelattavan pelilaudan. <p> Pelilauta arpoo yksittäisessä
 * pelissä käytettävät kortit ja niiden paikat pöydällä.
 *
 * @author emilia
 */
public class Pelilauta {

    /**
     * Kertoo, montaako erilaista kuvakorttia muistipelissa käytetään.
     */
    int korttienMaara;
    /**
     * Sisältää kaikkien muistipelissa käytettävien kuvien nimet.
     */
    ArrayList<String> kuvienNimet;
    /**
     * Sisältää tietyllä muistipelikierroksella käytettävien kuvien numerot.
     */
    ArrayList<Integer> kuvienNumerotListassa;
    /**
     * Sisältää tietyllä muistipelikierroksella käytettävät kuvakortit.
     */
    ArrayList<Kortti> kortit;
    /**
     * Sisältää tiedon siitä, millä paikalla pöydällä mikäkin kuvakortti on.
     *
     */
    HashMap<Integer, Kortti> kortitPoydalla;
    /**
     * Tiedostonlukija kuvien nimien tekstitiedostosta lukemista varten.
     */
    TiedostonLukija fileReader;
    
    ArrayList<Integer> pelilaudanNumerot;
    
    Integer vaikeus;
    
    ArrayList<Pelaaja> pelaajat;

     public Pelilauta() {
       
    }
    
    public Pelilauta(ArrayList<Pelaaja> pelaajat) {
        this.pelaajat = pelaajat;
    }

    public void maaritaVaikeus(Integer vaikeus) {
        
        this.vaikeus = vaikeus;

        if (vaikeus == 1) {
            korttienMaara = 6;
        } else if (vaikeus == 2) {
            korttienMaara = 10;
        } else if (vaikeus == 3) {
            korttienMaara = 15;
        } else if (vaikeus == 4) {
            korttienMaara = 21;
        } else {
            korttienMaara = 0;
        }
    }

    public int getKorttienMaara() {
        return korttienMaara;
    }

    public void arvoKuvat(Integer vaikeus) throws Exception {

        kuvienNumerotListassa = new ArrayList<Integer>();
        kuvienNumerotListassa = arvoNumerot(korttienMaara, 21);

        System.out.println(kuvienNumerotListassa.toString());
    }

    /**
     * Metodi arpoo käyttäjän määrittelemän määrän kokonaislukuja väliltä 0 -
     * käyttäjän määrittelemä yläraja.
     *
     * @param maara Korttien määrä.
     * @param ylaraja Isoin mahdollinen numero.
     *
     * @return Arvotut numerot listassa.
     */
    public ArrayList<Integer> arvoNumerot(Integer maara, Integer ylaraja) {

        HashSet<Integer> arvotutNumerot = new HashSet<Integer>();
        ArrayList<Integer> arvotutNumerotListassa = new ArrayList<Integer>();
        Random rand = new Random();
        
        if (maara < 0 || ylaraja < 0 || maara > ylaraja) {
            System.out.println("Määrän ja ylärajan täytyy olla positiivisia lukuja ja ylärajan täytyy olla isompi kuin määrän.");
            return arvotutNumerotListassa;
        } else {
            int randomNumero;
            int i;
            int e;
            int g;

            g = maara;

            //arpoo kuvat       
            for (i = 0; i < g; i++) {
                e = rand.nextInt(ylaraja);
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

    public HashMap<Integer, Kortti> asetaKortitPoydalle() {

        ArrayList<Integer> korttienNumerotPoydalla = new ArrayList<Integer>();
        kortitPoydalla = new HashMap<Integer, Kortti>();

        for (int i = 0; i < korttienMaara * 2; i++) {
            korttienNumerotPoydalla.add(i);
        }

        Collections.shuffle(korttienNumerotPoydalla);

        int korttiNro = 0;
        int kuvaNro = 0;

        while (korttiNro < korttienMaara * 2) {
            kortitPoydalla.put(korttienNumerotPoydalla.get(korttiNro), kortit.get(kuvaNro));
            korttiNro++;
            kortitPoydalla.put(korttienNumerotPoydalla.get(korttiNro), kortit.get(kuvaNro));
            korttiNro++;
            kuvaNro++;

        }
        
        return kortitPoydalla;
    }

    public void tulostaPelilauta() {
        
        pelilaudanNumerot = new ArrayList<Integer>();
        
        for (int i = 1; i < korttienMaara * 2+1; i++) {
            pelilaudanNumerot.add(i);
        }
        
        for(int i = 0; i < korttienMaara*2;i++){
            if (i<9){
            System.out.print(" " + pelilaudanNumerot.get(i) + "  ");
            } else {
                System.out.print(pelilaudanNumerot.get(i) + "  ");
            }
                    if((i+1)%(vaikeus+2)==0){
                        System.out.println("");      
                    }
        }
    }
}
