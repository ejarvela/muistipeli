/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tiedostojenKasittely;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 * Avaa kuvan tietokoneen ruudulle.
 *
 * @author ejarvela
 */
public class KuvanAvaus extends Panel {

    BufferedImage img;
    String kuvanNimi;


    /**
     * Lataa avattavan kuvan nimen perusteella.
     *
     * @param kuvanNimi Avattavan kuvan tiedostonimi.
     */
    public KuvanAvaus(String kuvanNimi) {
            
            this.kuvanNimi = kuvanNimi;
        
            img = null;
            try {
                img = ImageIO.read(new File(kuvanNimi));
            } catch (IOException e) {
            }
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }

    /**
     * Piirtää kuvan parametrien mukaiseen paikkaan ja nimeää kuvan sen pelilautanumeron mukaan.
     * 
     * @param x Kuvan vasemman ylänurkan sijainti x-akselilla.
     * @param y Kuvan vasemman ylänurkan sijainti y-akselilla.
     * @param kuvaNro Kuvan numero pelilaudalla.
     */

    public void kuvanPiirto(Integer x, Integer y, Integer kuvaNro) {
        JFrame frame = new JFrame("Kuva numero " + kuvaNro);
        Panel panel = new KuvanAvaus(kuvanNimi);
        frame.getContentPane().add(panel);
        frame.setSize(765, 507);
        frame.setLocation(x,y);
        frame.setVisible(true);
    }
}
