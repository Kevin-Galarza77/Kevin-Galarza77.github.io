package Emojis;

import java.awt.*;

public class CaraGafas extends DibujarCaraSonriente{
    public void paintComponent( Graphics g )
    {
        super.paintComponent( g );
        g.setColor( Color.YELLOW );
        g.fillOval( 10, 10, 200, 200 );

        g.setColor( Color.BLACK );
        g.fillOval( 55, 65, 30, 30 );
        g.fillOval( 135, 65, 30, 30 );

        g.fillRect(130, 65, 60, 40);
        g.fillRect(35, 65, 60, 40);
        g.fillOval( 50, 110, 100, 60 );
        g.drawLine(35,85,130,85);

        g.setColor( Color.YELLOW );
        g.fillRect( 50, 110, 120, 30 );
        g.fillOval( 50, 120, 120, 40 );
    }
}
