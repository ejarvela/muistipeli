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

public class KuvanAvaus extends Panel {

    BufferedImage img;
    String kuvanNimi;

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

    public void kuvanPiirto(Integer x, Integer y, Integer kuvaNro) {
        JFrame frame = new JFrame("Kuva numero " + kuvaNro);
        Panel panel = new KuvanAvaus(kuvanNimi);
        frame.getContentPane().add(panel);
        frame.setSize(765, 507);
        frame.setLocation(x,y);
        frame.setVisible(true);
    }
}
