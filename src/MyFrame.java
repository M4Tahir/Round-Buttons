import javax.swing.*;
import java.awt.*;


public class MyFrame extends JFrame {
    MyFrame(){
        this.setUndecorated(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(720, 480);
        this.add(new MyButton("Click Me!",200,100,120,80,new Color(0xB420FF),new Color(0xFFFFFF)));
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(0x4F4F4F));
        this.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(()-> new MyFrame());
    }
}
