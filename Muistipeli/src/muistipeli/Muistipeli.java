package muistipeli;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import logiikka.Pelilauta;
import logiikka.Pelilogiikka;

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
     * Pelilaudan numerot.
     */
    ArrayList<Integer> pelilaudanNumerot;
    /**
     * Korttien sijainnit pöydällä.
     */
    HashMap<Integer, Kortti> kortitPoydalla;
    /**
     * Montako pelaajaa.
     */
    public int pelaajienMaara;
    /**
     * Pelin vaikeustaso.
     */
    public int vaikeus;

    /**
     * Luo uuden Muistipelin.
     * @param lukija Lukija.
     */
    public Muistipeli(Scanner lukija) {
        this.lukija = lukija;
        pelaajat = new ArrayList<Pelaaja>();
        pelilauta = new Pelilauta(pelaajat);
        pelilaudanNumerot = new ArrayList<Integer>();
    }

    /**
     * Käynnistää Muistipelin.
     *
     * @throws Exception
     */
    public void kaynnista() throws Exception {
        
        String onkoLuku;
        
        System.out.println("Tervetuloa Muistipeliin!\n");
        
        while (true) {
            try {
                System.out.println("Anna pelaajien lukumäärä väliltä 1-4.");
                onkoLuku = lukija.nextLine();
                onkoLuku = onkoLuku.trim();
                pelaajienMaara = Integer.parseInt(onkoLuku);
                if (pelaajienMaara < 5 && pelaajienMaara > 0) {
                    break;
                }
                System.out.println("\nVäärä syöte.");
            } catch (NumberFormatException e) {
                System.out.println("\nVäärä syöte.");
            }
        }

        System.out.println("\nAnna pelaajien nimet yksi kerrallaan.");

        String nimi;

        for (int i = 0; i < pelaajienMaara; i++) {
            System.out.println("\nOsallistujan nimi:");
            nimi = lukija.nextLine();
            pelaajat.add(new Pelaaja(nimi));
        }
        
        while (true) {
            try {
                System.out.println("\nValitse vaikeustaso.");
                System.out.println("1 - 3x4");
                System.out.println("2 - 4x5");
                System.out.println("3 - 5x6");
                System.out.println("4 - 6x7");
                onkoLuku = lukija.nextLine();
                onkoLuku = onkoLuku.trim();
                vaikeus = Integer.parseInt(onkoLuku);
                if (vaikeus < 5 && vaikeus > 0) {
                    break;
                }
                System.out.println("\nVäärä syöte.");
            } catch (NumberFormatException e) {
                System.out.println("\nVäärä syöte.");
            }
        }
        
        pelilauta.maaritaKorttienMaara(vaikeus);
        pelilauta.arvoKuvat(vaikeus);
        pelilauta.luoKortit();
        
        System.out.println("\nPeli alkaa.\n");
        
        kortitPoydalla = pelilauta.asetaKortitPoydalle();
        pelilauta.teePelilaudanNumerot();
        pelilaudanNumerot = pelilauta.getPelilaudanNumerot();
        
        Pelilogiikka kierros = new Pelilogiikka(pelilauta, pelaajat, lukija, kortitPoydalla, pelilaudanNumerot);
        kierros.pelaa();
    }
}