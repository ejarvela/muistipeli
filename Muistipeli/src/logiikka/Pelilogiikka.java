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

/**
 * Sovelluksen logiikka. <p> Pelin logiikka. Nostaa kortit, tarkistaa ovatko
 * kuvat samat, lisää pisteet, jakaa vuorot.
 *
 * @author emilia
 */
public class Pelilogiikka {

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
    /**
     * Ensimmäisenä nostetun kortin numero. Apumuuttuja.
     */
    public int apuEkaNostettu;
    /**
     * Pitää kirjaa siitä, monennenko pelaajan vuoro on.
     */
    public int pelaajaJonkaVuoroOn;

    /**
     * Uusi peli annetuilla parametreilla.
     * 
     * @param pelilauta Pelattava pelilauta.
     * @param pelaajat Lista pelaajista.
     * @param lukija Lukija.
     * @param kortitPoydalla Korttien paikat pöydällä.
     * @param pelilaudanNumerot Pelilaudan numerot.
     */
    public Pelilogiikka(Pelilauta pelilauta, ArrayList<Pelaaja> pelaajat, Scanner lukija, HashMap<Integer, Kortti> kortitPoydalla, ArrayList<Integer> pelilaudanNumerot) {
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

        String onkoLuku;
        String apuVastaus;
        pelaajaJonkaVuoroOn = 0;
        kierrosLaskuri = 1;
        nostoLaskuri = 0;
        jaljellaOlevienKorttienMaara = pelilauta.getKorttienMaara();

        while (jaljellaOlevienKorttienMaara > 0) {

            pelilauta.tulostaPelilauta();
            System.out.println("\nPelaajan " + pelaajat.get(pelaajaJonkaVuoroOn).toString() + " vuoro.\n ");
            System.out.println("Anna nostettavien korttien numerot yksi kerrallaan.\n ");

            boolean voikoNostaa = false;
            while (voikoNostaa == false) {
                              
                while (true) {
                    try {
                        onkoLuku = lukija.nextLine();
                        onkoLuku = onkoLuku.trim();
                        ekaNostettavaKortti = Integer.parseInt(onkoLuku);
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("\nVäärä syöte. Anna nostettavan kortin numero.");
                    }
                }
                  voikoNostaa = tarkistaEttaKortinVoiNostaa(ekaNostettavaKortti);
            }

            kortitPoydalla.get(ekaNostettavaKortti - 1).nostaKortti(100, 100, ekaNostettavaKortti - 1);
            apuEkaNostettu = ekaNostettavaKortti;

            voikoNostaa = false;
            while (voikoNostaa == false) {     
                  while (true) {
                    try {
                        onkoLuku = lukija.nextLine();
                        onkoLuku = onkoLuku.trim();
                        tokaNostettavaKortti = Integer.parseInt(onkoLuku);
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("\nVäärä syöte. Anna nostettavan kortin numero.");
                    }
                }
                voikoNostaa = tarkistaEttaKortinVoiNostaa(tokaNostettavaKortti);
            }

            kortitPoydalla.get(tokaNostettavaKortti - 1).nostaKortti(1000, 100, tokaNostettavaKortti - 1);
            apuEkaNostettu = -1;

            onkoSamatKortit();

            System.out.println("\nPaina enter kun olet valmis seuraavaan kierrokseen.");
            apuVastaus = lukija.nextLine();
            System.out.println(" ");
            kaannaKortitTakaisin();
        }
        
        lopetaPeli();
    }

    /**
     * Tulostaa pelin senhetkisen pistetilanteen keskellä peliä tai pelin
     * lopuksi.
     *
     * @param milloin Pistetilanne keskellä peliä vai pelin lopussa.
     */
    public void tulostaPelaajienPistetilanne(String milloin) {

        if (milloin.equals("pelissa")) {
            System.out.println("\nPelaajien pistetilanne tällä hetkellä:");
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
     * Tarkistaa, että kortin voi nostaa.
     *
     * @param nostettavanKortinNumero Nostettavan kortin numero.
     * @return Voi / ei voi nostaa.
     */
    public boolean tarkistaEttaKortinVoiNostaa(Integer nostettavanKortinNumero) {

        if (nostettavanKortinNumero == 0) {
            System.out.println("\nKortti on jo nostettu. Anna uusi numero.");
            return false;
        } else if (nostettavanKortinNumero < 0 || nostettavanKortinNumero > pelilaudanNumerot.size() || nostettavanKortinNumero == apuEkaNostettu) {
            System.out.println("\nAnna pöydällä olevan kortin numero väliltä 1-" + pelilaudanNumerot.size());
            return false;
        } else {
            return true;
        }
    }

    /**
     * Määrittää, kuka voitti Muistipelin.
     *
     * @return Voittajan nimi.
     */
    public String kukaVoitti() {

        int maxPisteet = 0;
        int voittajanNumero = 0;

        if (pelaajat.size() == 1) {
            return pelaajat.get(0).toString();
        }

        for (int i = 0; i < pelaajat.size() - 1; i++) {
            maxPisteet = pelaajat.get(i).getPisteet();
            voittajanNumero = i;
            if (pelaajat.get(i + 1).getPisteet() > pelaajat.get(i).getPisteet()) {
                maxPisteet = pelaajat.get(i + 1).getPisteet();
                voittajanNumero = i + 1;
                i++;
            }
        }
        return pelaajat.get(voittajanNumero).toString();
    }

    /**
     * Tarkistaa alkaako uusi kierros.
     */
    public void menikoKierros() {

        if (pelaajaJonkaVuoroOn > pelaajat.size() - 1) {
            pelaajaJonkaVuoroOn = 0;
            kierrosLaskuri++;
        }
    }

    /**
     * Tarkistaa, ovatko nostetut kortit samat vai erit.
     */
    public void onkoSamatKortit() {

        if ((kortitPoydalla.get(ekaNostettavaKortti - 1).toString()).equals(kortitPoydalla.get(tokaNostettavaKortti - 1).toString())) {

            System.out.println("\nSamat kortit! Saat uuden vuoron.\n");
            pelaajat.get(pelaajaJonkaVuoroOn).lisaaPiste();
            jaljellaOlevienKorttienMaara--;
            nostoLaskuri++;

            pelilaudanNumerot.set(ekaNostettavaKortti - 1, 0);
            pelilaudanNumerot.set(tokaNostettavaKortti - 1, 0);

        } else {

            System.out.println("\nEri kortit! \n");
            pelaajaJonkaVuoroOn++;
            nostoLaskuri++;

            menikoKierros();

            tulostaPelaajienPistetilanne("pelissa");
            System.out.println(" ");
        }
    }

    /**
     * Tulostaa lopullisen pistetilanteen, kertoo voittajan ja lopettaa pelin.
     */
    public void lopetaPeli() {
        System.out.println("Peli loppui! Lopullinen pistetilanne:");
        tulostaPelaajienPistetilanne("lopussa");
        System.out.println("\nPelin voitti " + kukaVoitti());
        System.out.println(" ");
        System.out.println("Pelattiin yhteensä " + kierrosLaskuri + " kierrosta ja " + nostoLaskuri + " nostokertaa.");
    }

    /**
     * Kääntää avatut kortit takaisin kiinni.
     */
    public void kaannaKortitTakaisin() {

        Frame[] activeFrames = Frame.getFrames();

        for (int i = 0; i < activeFrames.length; i++) {
            activeFrames[i].dispose();
        }
    }
}
