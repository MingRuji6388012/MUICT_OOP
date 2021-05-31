import javax.swing.*;

public class MingFrame extends JFrame {
    MyPanel panel = new MyPanel();

    public MingFrame(){
        this.setSize(500,500);
//        this.setName("6388012's Frame");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
