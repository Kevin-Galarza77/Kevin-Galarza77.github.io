package Emojis;

import java.awt.*;

public class CaraSacandoLengua extends DibujarCaraSonriente{
    public void paintComponent( Graphics g )
    {
        super.paintComponent( g );
        g.setColor( Color.YELLOW );
        g.fillOval( 10, 10, 200, 200 );

        g.setColor( Color.BLACK );
        g.fillOval( 55, 65, 30, 30 );
        g.fillOval( 135, 65, 30, 30 );
        g.fillOval( 50, 110, 120, 60 );
        g.setColor( Color.YELLOW );
        g.fillRect( 50, 110, 120, 30 );
        g.fillOval( 50, 80, 120, 40 );

        g.setColor( Color.RED );
        g.fillRoundRect(95,140,30,60,20,30);
    }
}
