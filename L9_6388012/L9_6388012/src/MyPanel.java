import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel{


    public void boxOval(Graphics g, Rectangle bb) {
        g.fillOval(bb.x, bb.y, bb.width, bb.height);
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        this.setBackground(Color.DARK_GRAY);

        Graphics2D graphics = (Graphics2D) g;

        int count = 0;
        graphics.setColor(Color.green);
        graphics.draw3DRect(90,90,300,300,true);
        graphics.setColor(Color.PINK);
        graphics.drawString("Ming is handsome",100,100);
        graphics.setColor(Color.MAGENTA);
        graphics.drawRect(100,100,280,280);

//        for(int i = 0 ; i <= 220 ; i+=1){
//            count++;
//            graphics.setColor(Color.green); //Please wear sunglasses before watching it!
//            graphics.drawLine(2,5,500,500);
//            if(i <= 40){
//                graphics.setColor(Color.LIGHT_GRAY);
//            }
//            else if(count % 2 == 0 && count % 3 == 0 && (i > 150)) {
//                graphics.setColor(Color.white);
//                graphics.drawOval(i,i+5,30+i,30+i);
//            }else if(count % 2 == 1 &&  count % 3 == 1 && (i<100 && i > 50) ){
//                graphics.setColor(Color.PINK);
//                graphics.drawOval(i,i+5,30+i,30+i);
//            }else if(count % 2 == 1 && count % 3 == 0 && (i > 50)){
//                graphics.setColor(Color.ORANGE);
//                graphics.drawOval(i,i+5,30+i,30+i);
//            }else if(i>150){
//                graphics.setColor(Color.RED);
//                graphics.drawOval(i,i+5,30+i,30+i);
//            }
//        }

    }
}
