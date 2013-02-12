/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logiikka;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import muistipeli.Kortti;
import muistipeli.Pelaaja;
import tiedostojenKasittely.KuvanAvaus;

/**
 * Sovelluksen logiikka.
 * <p>
 * Pelin logiikka. Nostaa kortit, tarkistaa ovatko kuvat samat, lisää pisteet, jakaa vuorot.
 *
 * @author emilia
 */
public class kierroksenLogiikka {

    /**
     * Pelattava pelilauta.
     */
    Pelilauta pelilauta;
    /**
     * Lista pelaajista.
     */
    ArrayList<Pelaaja> pelaajat;
    /**
     * Lukija.
     */
    Scanner lukija;
    /**
     * Ensimmäinen vuorolla käännettävistä korteista.
     */
    Integer ekaNostettavaKortti;
    /**
     * Toinen vuorolla käännettävistä korteista.
     */
    Integer tokaNostettavaKortti;
    /**
     * Korttien sijainnit pöydällä.
     */
    HashMap<Integer, Kortti> kortitPoydalla;
    
    public kierroksenLogiikka(Pelilauta pelilauta, ArrayList<Pelaaja> pelaajat, Scanner lukija, HashMap<Integer, Kortti> kortitPoydalla){
        this.pelilauta = pelilauta;
        this.pelaajat = pelaajat;
        this.lukija = lukija;
        this.kortitPoydalla = kortitPoydalla;
    }

    /**
     * Käynnistää varsinaiset pelikierrokset.
     *
     * @throws Exception
     */
    public void pelaa() throws Exception{
        pelilauta.tulostaPelilauta();
        System.out.println("Anna nostettavien korttien numerot yksi kerrallaan.");
        ekaNostettavaKortti = Integer.parseInt(lukija.nextLine());
        tokaNostettavaKortti = Integer.parseInt(lukija.nextLine());
        kortitPoydalla.get(ekaNostettavaKortti).nostaKortti(100,200,ekaNostettavaKortti);
        kortitPoydalla.get(tokaNostettavaKortti).nostaKortti(1000,200,tokaNostettavaKortti);       
    }

    /**
     * Tulostaa pelin senhetkisen pistetilanteen.
     */
    public void tulostaPelaajienPistetilanne(){

       for(int i = 0; i < pelaajat.size();i++)
        System.out.println(pelaajat.get(i).getPisteet());
    }
}
