package Emojis;

import java.awt.*;

public class CarasonrienteAlrevez extends  DibujarCaraSonriente{
    public void paintComponent( Graphics g )
    {
        super.paintComponent( g );
        g.setColor( Color.YELLOW );
        g.fillOval( 10, 10, 200, 200 );

        g.setColor( Color.BLACK );
        g.fillOval( 55, 130, 30, 30 );
        g.fillOval( 135, 130, 30, 30 );
        g.fillOval( 40, 45, 140, 60 );

        g.setColor( Color.YELLOW );
        g.fillOval( 40, 65, 140, 70 );

    }
}
