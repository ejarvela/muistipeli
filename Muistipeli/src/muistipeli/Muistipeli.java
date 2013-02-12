package muistipeli;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import logiikka.Pelilauta;
import logiikka.kierroksenLogiikka;
import tiedostojenKasittely.KuvanAvaus;

/**
 * Muistipelin käyttöliittymä.
 * <p>
 * Sisältää muistipelin tekstipohjaisen käyttöliittymän.
 * 
 * @author emilia
 */
public class Muistipeli {

    /**
     * Lukija.
     */
    private Scanner lukija;
    /**
     * Lista pelaajista.
     */
    ArrayList<Pelaaja> pelaajat;
    /**
     * Pelattava pelilauta.
     */
    Pelilauta pelilauta;
    /**
     * Korttien sijainnit pöydällä.
     */
    HashMap<Integer, Kortti> kortitPoydalla;

    public Muistipeli(Scanner lukija) {
        this.lukija = lukija;
        pelaajat = new ArrayList<Pelaaja>();
        pelilauta = new Pelilauta(pelaajat);
    }

    /**
     * Käynnistää Muistipelin.
     *
     * @throws Exception
     */
    public void kaynnista() throws Exception {
        
        System.out.println("Tervetuloa Muistipeliin!");
        System.out.println("");
        System.out.println("Montako pelaajaa? (1-4)");

        int pelaajienMaara;

        pelaajienMaara = Integer.parseInt(lukija.nextLine());

        while (pelaajienMaara > 4 || pelaajienMaara < 1) {
            System.out.println("Anna pelaajien lukumäärä väliltä 1-4.");
            pelaajienMaara = Integer.parseInt(lukija.nextLine());
        }

        System.out.println("Anna pelaajien nimet yksi kerrallaan.");
        System.out.println("");

        String nimi;

        for (int i = 0; i < pelaajienMaara; i++) {
            System.out.println("Osallistujan nimi:");
            nimi = lukija.nextLine();
            pelaajat.add(new Pelaaja(nimi));
        }
        
        System.out.println("");
        System.out.println("Valitse vaikeustaso.");
        System.out.println("1 - 3x4");
        System.out.println("2 - 4x5");
        System.out.println("3 - 5x6");
        System.out.println("4 - 6x7");

        int vaikeus;
        vaikeus = Integer.parseInt(lukija.nextLine());

        while (vaikeus > 4 || vaikeus < 1) {
            System.out.println("Valitse vaikeustaso 1, 2, 3 tai 4.");
            vaikeus = Integer.parseInt(lukija.nextLine());
        }
        
        pelilauta.maaritaKorttienMaara(vaikeus);
        
        pelilauta.arvoKuvat(vaikeus);
        pelilauta.luoKortit();

        System.out.println("");
        System.out.println("Peli alkaa.");
        System.out.println("");
        
        kortitPoydalla = pelilauta.asetaKortitPoydalle();
        
        kierroksenLogiikka kierros = new kierroksenLogiikka(pelilauta, pelaajat, lukija, kortitPoydalla);
        kierros.tulostaPelaajienPistetilanne();
        kierros.pelaa();
    }
}