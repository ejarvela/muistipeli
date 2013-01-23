package muistipeli;

import java.awt.*;
import javax.swing.*;

public class NaytaKuva extends JPanel{
  Image image; 
  
// Create a constructor method
  public NaytaKuva(){
   super();
   // Load an image file into our Image object. 
   // This file has to be in the same
   // directory as ShowImage.class.
      image = Toolkit.getDefaultToolkit().getImage("binaries.gif");
  }

/* Create a paintComponent() method to override the one in
JPanel.
*/
    @Override
  public void paintComponent(Graphics g){

   // Draw our Image object.
   g.drawImage(image,50,10,200,200, this); // at location 50,10
     // 200 wide and high
  }
    
    @Override
   public String toString(){
       return image.toString();
   }

   public void kuvanAvaus(NaytaKuva kuva){
       
   System.out.println(image.toString());
   
   JFrame frame = new JFrame("Kuvat");
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   frame.setSize(600,400);

  //ShowImage panel = new ShowImage();
   frame.getContentPane().add(kuva);
   frame.setVisible(true); 
  }
}