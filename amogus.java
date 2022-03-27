import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class amogus {
    static JLabel jLabel = new JLabel();
    

    public static void changeImage(String image) throws IOException
    {
        String imageDirectory = "images/" + image;
        File file = new File(imageDirectory);
        BufferedImage bufferedImage = ImageIO.read(file);
        ImageIcon imageIcon = new ImageIcon(bufferedImage);
        jLabel.setIcon(imageIcon); 
    }
    
    // public static synchronized void playSound(final String url) {
    //     new Thread(new Runnable() {
    //     // The wrapper thread is unnecessary, unless it blocks on the
    //     // Clip finishing; see comments.
    //       public void run() {
    //         try {
    //           Clip clip = AudioSystem.getClip();
    //           AudioInputStream inputStream = AudioSystem.getAudioInputStream(
    //             Main.class.getResourceAsStream("amogus.wav"));
    //           clip.open(inputStream);
    //           clip.start(); 
    //         } catch (Exception e) {
    //           System.err.println(e.getMessage());
    //         }
    //       }
    //     }).start();
    //   }

      public static void main(String[] args) throws IOException {
        // playSound("amogus.wav");

        File file = new File("images/bruh.png");
        BufferedImage bufferedImage = ImageIO.read(file);

        ImageIcon imageIcon = new ImageIcon(bufferedImage);
        JFrame jFrame = new JFrame();

        jFrame.setLayout(new FlowLayout());
        
        jFrame.setSize(500, 500);
        // JLabel jLabel = new JLabel();

        jLabel.setIcon(imageIcon);
        jFrame.add(jLabel);
        jFrame.setVisible(true);
        // File file2 = new File("images/amogus.png");
        // BufferedImage bufferedImage2 = ImageIO.read(file2);
        // jLabel.setIcon(new ImageIcon(bufferedImage2));

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

