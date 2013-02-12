package tiedostojenKasittely;

import java.awt.*;
import java.awt.event.*;

/**
 * Avaa kuvan.
 * <p>
 * KuvanAvaus avaa käyttäjän määrittelemässä osoitteessa olevan kuvan erilliseen ikkunaan.
 * @author emilia
 */
public class KuvanAvausVanha extends Frame {

    Image img;

    public KuvanAvausVanha(String kuvanNimi) {
        super("Kuva numero tähän-kuvan-nro-pelilaudalla");
        MediaTracker mt = new MediaTracker(this);
        img = Toolkit.getDefaultToolkit().getImage(kuvanNimi);
        mt.addImage(img, 0);
        setSize(765, 507);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });
    }

    @Override
    public void update(Graphics g) {
        paint(g);
    }

    @Override
    public void paint(Graphics g) {
        if (img != null) {

            g.drawImage(img, 100, 100, this);
        } else {
            g.clearRect(0, 0, getSize().width, getSize().height);
        }
    }
}