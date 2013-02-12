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
 *
 * @author emilia
 */
public class kierroksenLogiikka {
    
    Pelilauta pelilauta;
    ArrayList<Pelaaja> pelaajat;
    Scanner lukija;
    Integer ekaNostettavaKortti;
    Integer tokaNostettavaKortti;
    HashMap<Integer, Kortti> kortitPoydalla;
    
    public kierroksenLogiikka(Pelilauta pelilauta, ArrayList<Pelaaja> pelaajat, Scanner lukija, HashMap<Integer, Kortti> kortitPoydalla){
        this.pelilauta = pelilauta;
        this.pelaajat = pelaajat;
        this.lukija = lukija;
        this.kortitPoydalla = kortitPoydalla;
    }
    
    public void pelaa() throws Exception{
        pelilauta.tulostaPelilauta();
        System.out.println("Anna nostettavien korttien numerot yksi kerrallaan.");
        ekaNostettavaKortti = Integer.parseInt(lukija.nextLine());
        tokaNostettavaKortti = Integer.parseInt(lukija.nextLine());
        kortitPoydalla.get(ekaNostettavaKortti).nostaKortti(100,200,ekaNostettavaKortti);
        kortitPoydalla.get(tokaNostettavaKortti).nostaKortti(1000,200,tokaNostettavaKortti);       
    }
    
    public void tulostaPelaajienPistetilanne(){
    System.out.println(pelaajat.toString());
    }
}
