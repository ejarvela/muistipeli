package muistipeli;

import java.util.ArrayList;
import java.util.Scanner;

public class Muistipeli {

    private Scanner lukija;
    ArrayList<Pelaaja> pelaajat;

    public Muistipeli(Scanner lukija) {
        this.lukija = lukija;
        pelaajat = new ArrayList<Pelaaja>();
    }

    public void kaynnista() throws Exception {
        System.out.println("Tervetuloa Muistipeliin!");
        System.out.println("");
        System.out.println("Montako pelaajaa? (1-4)");
        
        int pelaajienMaara;
        
        pelaajienMaara = Integer.parseInt(lukija.nextLine());
        
        while(pelaajienMaara > 4 || pelaajienMaara < 1) {
        System.out.println("Anna pelaajien lukumäärä väliltä 1-4.");
        pelaajienMaara = Integer.parseInt(lukija.nextLine());
        }
        
        System.out.println("Anna pelaajien nimet yksi kerrallaan.");
        System.out.println("");
         
        String nimi;

        for(int i = 0; i < pelaajienMaara; i++){
            System.out.println("Osallistujan nimi:");
            nimi = lukija.nextLine();
                pelaajat.add(new Pelaaja(nimi));
            }
        
        System.out.println("Valitse vaikeustaso.");
        System.out.println("1 - 4x4");
        System.out.println("2 - 6x6");
        System.out.println("3 - 8x8");
        
        int vaikeus;
        vaikeus = Integer.parseInt(lukija.nextLine());
        
        while(vaikeus > 3 || vaikeus < 1) {
        System.out.println("Valitse vaikeustaso 1, 2 tai 3.");
        vaikeus = Integer.parseInt(lukija.nextLine());
        }
        
        System.out.println("");
        System.out.println("Peli alkaa.");
        
        Kortti kortti1 = new Kortti("kissa");
        kortti1.nostaKortti();
        
        System.out.println("Anna numero");
        
        }
    }


    
    

