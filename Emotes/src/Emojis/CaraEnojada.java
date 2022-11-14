package Emojis;

import java.awt.*;

public class CaraEnojada extends  DibujarCaraSonriente{
    public void paintComponent( Graphics g )
    {
        super.paintComponent( g );
        g.setColor( Color.YELLOW );
        g.fillOval( 10, 10, 200, 200 );

        g.setColor( Color.BLACK );
        g.fillOval( 55, 65, 30, 30 );
        g.fillOval( 135, 65, 30, 30 );
        g.fillRect( 70, 140, 80, 10 );
        g.drawLine(55,50,95,65);
        g.drawLine(125,65,170,50);
    }
}
