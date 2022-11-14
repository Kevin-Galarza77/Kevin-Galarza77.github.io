import javax.swing.*;
import java.awt.*;

public class Alerta extends JFrame{
    private JPanel panel1;
    private JButton aceptarButton;
    private JLabel mensaje;
    private JPanel sirena1;
    private JPanel sirena2;
    private JPanel sirena3;
    private JPanel sirena4;
    private boolean parpadeo;

    public Alerta(String sms) {
        parpadeo=true;
        setSize(800,300);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setContentPane(panel1);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
        mensaje.setText(sms);
        Timer timer = new Timer(100,e-> parpadear());
        timer.start();
        aceptarButton.addActionListener(e-> {
            timer.stop();
            dispose();
        });
    }
    private void parpadear(){
        if (parpadeo){
            parpadeo=false;
            Color color = new Color(255,255,255);
            sirena1.setBackground(color);
            sirena2.setBackground(color);
            sirena3.setBackground(color);
            sirena4.setBackground(color);
        }else {
            parpadeo=true;
            Color color = new Color(255,0,0);
            sirena1.setBackground(color);
            sirena2.setBackground(color);
            sirena3.setBackground(color);
            sirena4.setBackground(color);
        }
    }




}
