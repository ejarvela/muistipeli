package muistipeli;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
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

        //luodaan pelattavat kortit
        
        luoKortit(vaikeus);

        System.out.println("");
        System.out.println("Peli alkaa.");

       Kortti kortti1 = new Kortti("lumi");

    }

    public void luoKortit(Integer vaikeus) throws Exception {

        ArrayList<String> kuvat = new ArrayList<String>();
        HashSet<Integer> kuvienNumerot = new HashSet<Integer>();
        Random rand = new Random();
        
        int korttienMaara;
        int randomNumero;
        int i;
        int e;
        int g;

        if (vaikeus == 1) {
            korttienMaara = 6;
        } else if (vaikeus == 2) {
            korttienMaara = 10;
        } else if (vaikeus == 3) {
            korttienMaara = 15;
        } else {
            korttienMaara = 21;
        }

        g=korttienMaara;

        
        //arpoo kuvat
        
        for (i = 0; i < g; i++) {
            e = rand.nextInt(21);
            kuvienNumerot.add(e);
            if (kuvienNumerot.size() <= korttienMaara) {
                if (kuvienNumerot.size() == korttienMaara) {
                    g = korttienMaara;
                }
                g++;
                kuvienNumerot.add(e);
            }
        }
        System.out.println("Ten Unique random numbers from 1 to 20 are  : " + kuvienNumerot);
        

        //lukee kuvien nimet tiedostosta
        
        File tiedosto = new File("src/muistipeli/kuvat.txt");

        TiedostonLukija fileReader = new TiedostonLukija(tiedosto);
        kuvat = fileReader.haeKuvat();
        
        //luo kortit
        
        
        
//        for (i=0;i<kuvienNumerot.size();i++){
//            String kortinNimi = kuvat.get(kuvienNumerot.get)
//            Kortti 
//        }
        
        

    }
}
