package Procesos;

import Emojis.*;

import javax.swing.*;

public class Procesos {
    private static boolean comprobar(String a){
        int num;
        try{
            num=Integer.parseInt(a);
            return true;
        }
        catch (Exception e )
        {
            return false;
        }
    }
    private static int menu(){
        String op;
        int op2;
        boolean comprobacion;
        do {
            op= JOptionPane.showInputDialog(null,"Seleccione:" +
                    "\n1.-Emoji Sonriente" +
                    "\n2.-Emoji Triste" +
                    "\n3.-Emoji Asustado" +
                    "\n4.-Emoji Serio" +
                    "\n5.-Emoji con Lagrimas" +
                    "\n6.-Emoji Alrevez" +
                    "\n7.-Emoji Enojado" +
                    "\n8.-Emoji Sonrojado" +
                    "\n9.-Emoji con Gafas" +
                    "\n10.-Emoji con Mascarilla" +
                    "\n11.-Emoji Renegado" +
                    "\n12.-Emoji Sacando la lengua" +
                    "\n0.-Salir");
            comprobacion=comprobar(op);
            if(comprobacion){
                op2=Integer.parseInt(op);
            }else{
                op2=-1;
            }
            if (op2<0 || op2>12){
                JOptionPane.showMessageDialog(null,"Error. Intenta Denuevo");
            }
        }while (op2<0 || op2>12);
        return op2;
    }
    public static void proceso(){
        int op;
        do {
            switch (op=menu()){
                case 1:
                {
                    DibujarCaraSonriente caraSonriente = new DibujarCaraSonriente();
                    JFrame aplicacion = new JFrame();
                    aplicacion.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
                    aplicacion.add( caraSonriente );
                    aplicacion.setSize( 230, 250 );
                    aplicacion.setVisible( true );
                    aplicacion.setLocation(650,100);
                    break;
                }
                case 2:
                {
                    CaraTriste caraTriste = new CaraTriste();
                    JFrame aplicacion = new JFrame();
                    aplicacion.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
                    aplicacion.add( caraTriste );
                    aplicacion.setSize( 230, 250 );
                    aplicacion.setVisible( true );
                    aplicacion.setLocation(650,100);
                    break;
                }
                case 3:
                {
                    CaraAsustada caraAsustada = new CaraAsustada();
                    JFrame aplicacion = new JFrame();
                    aplicacion.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
                    aplicacion.add( caraAsustada );
                    aplicacion.setSize( 230, 250 );
                    aplicacion.setVisible( true );
                    aplicacion.setLocation(650,100);
                    break;
                }
                case 4:
                {
                    CaraSeria caraSeria = new CaraSeria();
                    JFrame aplicacion = new JFrame();
                    aplicacion.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
                    aplicacion.add( caraSeria );
                    aplicacion.setSize( 230, 250 );
                    aplicacion.setVisible( true );
                    aplicacion.setLocation(650,100);
                    break;
                }
                case 5:
                {
                    CaraLagrima caraLagrima = new CaraLagrima();
                    JFrame aplicacion = new JFrame();
                    aplicacion.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
                    aplicacion.add( caraLagrima );
                    aplicacion.setSize( 230, 250 );
                    aplicacion.setVisible( true );
                    aplicacion.setLocation(650,100);
                    break;
                }
                case 6:
                {
                    CarasonrienteAlrevez carasonrienteAlrevez=new CarasonrienteAlrevez();
                    JFrame aplicacion = new JFrame();
                    aplicacion.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
                    aplicacion.add( carasonrienteAlrevez );
                    aplicacion.setSize( 230, 250 );
                    aplicacion.setVisible( true );
                    aplicacion.setLocation(650,100);
                    break;
                }
                case 7:
                {
                    CaraEnojada caraEnojada = new CaraEnojada();
                    JFrame aplicacion = new JFrame();
                    aplicacion.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
                    aplicacion.add( caraEnojada );
                    aplicacion.setSize( 230, 250 );
                    aplicacion.setVisible( true );
                    aplicacion.setLocation(650,100);
                    break;
                }
                case 8:
                {
                    CaraSonrojada caraSonrojada = new CaraSonrojada();
                    JFrame aplicacion = new JFrame();
                    aplicacion.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
                    aplicacion.add( caraSonrojada );
                    aplicacion.setSize( 230, 250 );
                    aplicacion.setVisible( true );
                    aplicacion.setLocation(650,100);
                    break;
                }
                case 9:
                {
                    CaraGafas caraGafas = new CaraGafas();
                    JFrame aplicacion = new JFrame();
                    aplicacion.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
                    aplicacion.add( caraGafas );
                    aplicacion.setSize( 230, 250 );
                    aplicacion.setVisible( true );
                    aplicacion.setLocation(650,100);
                    break;
                }
                case 10:
                {
                    CaraMascarilla caraMascarilla = new CaraMascarilla();
                    JFrame aplicacion = new JFrame();
                    aplicacion.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
                    aplicacion.add( caraMascarilla );
                    aplicacion.setSize( 230, 250 );
                    aplicacion.setVisible( true );
                    aplicacion.setLocation(650,100);
                    break;
                }
                case 11:
                {
                    CaraRenegada caraRenegada = new CaraRenegada();
                    JFrame aplicacion = new JFrame();
                    aplicacion.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
                    aplicacion.add( caraRenegada );
                    aplicacion.setSize( 230, 250 );
                    aplicacion.setVisible( true );
                    aplicacion.setLocation(650,100);
                    break;
                }
                case 12:
                {
                    CaraSacandoLengua caraSacandoLengua = new CaraSacandoLengua();
                    JFrame aplicacion = new JFrame();
                    aplicacion.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
                    aplicacion.add( caraSacandoLengua );
                    aplicacion.setSize( 230, 250 );
                    aplicacion.setVisible( true );
                    aplicacion.setLocation(650,100);
                    break;
                }
            }
        }while (op!=0);
    }
}
