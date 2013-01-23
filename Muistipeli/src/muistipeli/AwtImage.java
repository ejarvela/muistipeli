package muistipeli;

import java.awt.*;
import java.awt.event.*;

public class AwtImage extends Frame {

    Image img;

    public AwtImage() {
        super("Image Frame");
        MediaTracker mt = new MediaTracker(this);
        img = Toolkit.getDefaultToolkit().getImage("binaries.gif");
        mt.addImage(img, 0);
        setSize(600, 600);
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