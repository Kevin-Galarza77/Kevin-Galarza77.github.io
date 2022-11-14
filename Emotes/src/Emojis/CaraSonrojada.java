package Emojis;

import java.awt.*;

public class CaraSonrojada extends DibujarCaraSonriente{
    public void paintComponent( Graphics g )
    {
        super.paintComponent( g );
        g.setColor( Color.YELLOW );
        g.fillOval( 10, 10, 200, 200 );

        g.setColor( Color.BLACK );
        g.fillOval( 55, 65, 30, 30 );
        g.fillOval( 135, 65, 30, 30 );

        g.fillOval( 50, 110, 110, 60 );

        g.setColor( Color.YELLOW );
        g.fillRect( 50, 110, 120, 30 );
        g.fillOval( 50, 120, 120, 40 );

        g.setColor( Color.PINK );
        g.fillOval( 40, 98, 60, 20 );
        g.fillOval( 120, 98, 60, 20 );
    }
}
