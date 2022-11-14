package Emojis;

import java.awt.*;

public class CaraRenegada extends DibujarCaraSonriente{
    public void paintComponent( Graphics g )
    {
        super.paintComponent( g );
        g.setColor( Color.YELLOW );
        g.fillOval( 10, 10, 200, 200 );

        g.setColor( Color.BLACK );
        g.drawLine(55,65,95,80);
        g.drawLine(55,95,95,80);
        g.drawLine(130,80,175,65);
        g.drawLine(130,80,175,95);
        g.fillOval( 50, 130, 120, 60 );

        g.setColor( Color.YELLOW );
        g.fillOval( 50, 150, 120, 40 );
    }
}
