import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Image extends JFrame {
    private ImageIcon image1;
    private JLabel label1;

    Image(){
        setLayout(new FlowLayout());
        image1 = new ImageIcon(getClass().getResource("pmf.jpg"));

        label1 = new JLabel(image1);
        add(label1);
    }
}