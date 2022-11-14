package Emojis;

import java.awt.*;

public class CaraTriste extends DibujarCaraSonriente{
    public void paintComponent( Graphics g )
    {
        super.paintComponent( g );
        g.setColor( Color.YELLOW );
        g.fillOval( 10, 10, 200, 200 );

        g.setColor( Color.BLACK );
        g.fillOval( 55, 65, 30, 30 );
        g.fillOval( 135, 65, 30, 30 );

        g.fillOval( 50, 130, 120, 60 );

        g.setColor( Color.YELLOW );
        g.fillOval( 50, 150, 120, 40 );
    }
}
