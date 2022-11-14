package Emojis;

import java.awt.*;

public class CaraMascarilla extends DibujarCaraSonriente{
    public void paintComponent( Graphics g )
    {
        super.paintComponent( g );
        g.setColor( Color.YELLOW );
        g.fillOval( 10, 10, 200, 200 );

        g.setColor( Color.BLACK );
        g.fillOval( 55, 65, 30, 30 );
        g.fillOval( 135, 65, 30, 30 );

        g.setColor( Color.WHITE );
        g.fillRect( 50, 110, 120, 60 );
        g.drawLine(50,110,12,90);
        g.drawLine(50,170,18,150);
        g.drawLine(170,110,210,90);
        g.drawLine(170,170,200,150);
    }
}
