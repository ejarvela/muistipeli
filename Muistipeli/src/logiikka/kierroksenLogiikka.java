/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logiikka;

import java.awt.Frame;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import muistipeli.Kortti;
import muistipeli.Pelaaja;
import tiedostojenKasittely.KuvanAvaus;

/**
 * Sovelluksen logiikka. <p> Pelin logiikka. Nostaa kortit, tarkistaa ovatko
 * kuvat samat, lisää pisteet, jakaa vuorot.
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
    /**
     * Pöydällä jäljellä olevien korttien määrä.
     */
    int jaljellaOlevienKorttienMaara;
    /**
     * Pelilaudan numerot.
     */
    ArrayList<Integer> pelilaudanNumerot;
    /**
     * Pitää kirjaa siitä, montako kierrosta on pelattu.
     */
    public int kierrosLaskuri;
    /**
     * Pitää kirjaa siitä, montako nostoa (korttipari) on suoritettu.
     */
    public int nostoLaskuri;
    
    public kierroksenLogiikka(Pelilauta pelilauta, ArrayList<Pelaaja> pelaajat, Scanner lukija, HashMap<Integer, Kortti> kortitPoydalla, ArrayList<Integer> pelilaudanNumerot) {
        this.pelilauta = pelilauta;
        this.pelaajat = pelaajat;
        this.lukija = lukija;
        this.kortitPoydalla = kortitPoydalla;
        this.pelilaudanNumerot = pelilaudanNumerot;
    }

    /**
     * Käynnistää varsinaiset pelikierrokset.
     *
     * @throws Exception
     */
    public void pelaa() throws Exception {

        String vastaus;
        int pelaajaJonkaVuoroOn = 0;
        kierrosLaskuri = 0;
        nostoLaskuri = 0;
        
        jaljellaOlevienKorttienMaara = pelilauta.getKorttienMaara();

        
        while (jaljellaOlevienKorttienMaara > 0) {

            pelilauta.tulostaPelilauta();

            System.out.println(" ");
            System.out.println("Pelaajan " + pelaajat.get(pelaajaJonkaVuoroOn).toString() + " vuoro. \n ");
            System.out.println("Anna nostettavien korttien numerot yksi kerrallaan. \n ");

            boolean voikoNostaa = false;

            while (voikoNostaa == false) {
                ekaNostettavaKortti = Integer.parseInt(lukija.nextLine());
                voikoNostaa = tarkistaEttaKortinVoiNostaa(ekaNostettavaKortti);
            }

            kortitPoydalla.get(ekaNostettavaKortti-1).nostaKortti(100, 200, ekaNostettavaKortti-1);
            
            voikoNostaa = false;
            while (voikoNostaa == false) {
                tokaNostettavaKortti = Integer.parseInt(lukija.nextLine());
                voikoNostaa = tarkistaEttaKortinVoiNostaa(tokaNostettavaKortti);
            }
            
            kortitPoydalla.get(tokaNostettavaKortti-1).nostaKortti(1000, 200, tokaNostettavaKortti-1);

            if ((kortitPoydalla.get(ekaNostettavaKortti-1).toString()).equals(kortitPoydalla.get(tokaNostettavaKortti-1).toString())) {

                System.out.println("Samat kortit! Saat uuden vuoron.");
                pelaajat.get(pelaajaJonkaVuoroOn).lisaaPiste();
                jaljellaOlevienKorttienMaara--;
                nostoLaskuri++;
                
                pelilaudanNumerot.set(ekaNostettavaKortti-1, 0);
                pelilaudanNumerot.set(tokaNostettavaKortti-1, 0);

            } else {

                System.out.println("Eri kortit!");
                System.out.println("");
                pelaajaJonkaVuoroOn++;
                nostoLaskuri++;

                if (pelaajaJonkaVuoroOn > pelaajat.size() - 1) {
                    pelaajaJonkaVuoroOn = 0;
                    kierrosLaskuri++;
                }

                tulostaPelaajienPistetilanne("pelissa");
                System.out.println(" ");
            }

            System.out.println("Paina enter kun olet valmis seuraavaan kierrokseen.");
            vastaus = lukija.nextLine();
            System.out.println(" ");

            System.out.println(ekaNostettavaKortti + " " + tokaNostettavaKortti);
            kortitPoydalla.get(ekaNostettavaKortti-1).kaannaKorttiTakaisin();
            kortitPoydalla.get(tokaNostettavaKortti-1).kaannaKorttiTakaisin();
           
            

        }
        
        String voittaja = kukaVoitti();
        
        System.out.println("Peli loppui! Lopullinen pistetilanne:");
        tulostaPelaajienPistetilanne("lopussa");
        System.out.println(" ");
        
        System.out.println("Pelin voitti " + voittaja);
        System.out.println("Pelattiin yhteensä " + kierrosLaskuri + " kierrosta ja " + nostoLaskuri + " nostokertaa.");
    }

    /**
     * Tulostaa pelin senhetkisen pistetilanteen.
     */
    public void tulostaPelaajienPistetilanne(String milloin) {

   
        if (milloin.equals("pelissa")) {
            System.out.println("Pelaajien pistetilanne tällä hetkellä:");
            for (int i = 0; i < pelaajat.size(); i++) {
                System.out.println(pelaajat.get(i).toString() + " " + pelaajat.get(i).getPisteet() + " pistettä.");
            } 
        } else if (milloin.equals("lopussa")) {
            for (int i = 0; i < pelaajat.size(); i++) {
                System.out.println(pelaajat.get(i).toString() + " " + pelaajat.get(i).getPisteet() + " pistettä.");
            }
        }
    }
    

    /**
     * Tarkistaa että kortin voi nostaa.
     *
     * @param nostettavanKortinNumero Nostettavan kortin numero.
     * @return Voi / ei voi nostaa.
     */
    public boolean tarkistaEttaKortinVoiNostaa(Integer nostettavanKortinNumero) {

        if (nostettavanKortinNumero == 0) {
            System.out.println("Kortti on jo nostettu. Anna uusi numero.");
            return false;
        } else if (nostettavanKortinNumero < 0 || nostettavanKortinNumero > pelilaudanNumerot.size()) {
            System.out.println("Anna numero väliltä 1-" + pelilaudanNumerot.size());
            return false;
        } else {
            return true;
        }
    }
    
    public String kukaVoitti(){
         
        int maxPisteet = 0;
        int voittajanNumero = 0;
        
        if(pelaajat.size()==1){
            return pelaajat.get(0).toString();
        }
        
        for(int i = 0; i < pelaajat.size()-1;i++){
            maxPisteet = pelaajat.get(i).getPisteet();
            voittajanNumero = i;
            if(pelaajat.get(i+1).getPisteet() > pelaajat.get(i).getPisteet()){
                maxPisteet = pelaajat.get(i+1).getPisteet();
                voittajanNumero = i+1;
                i++;
            }
        }
            return pelaajat.get(voittajanNumero).toString();
        
    }
}