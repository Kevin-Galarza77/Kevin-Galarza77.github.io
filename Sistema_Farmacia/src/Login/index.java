package Login;

import Administrador.Menuadministrador;
import Bodega.MenuBodega;
import Cajero.MenuCajero;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class index extends JFrame{
    private JPanel login;
    private JTextField cedulaTXT;
    private JButton iniciarSesiónButton;
    private JPasswordField contraseñaTXT;
    private JButton salirBNT;


    public index() {

        setContentPane(login);
        setTitle("Iniciar Sesión");
        setSize(1400, 750);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);


        iniciarSesiónButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });
        salirBNT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    private void login(){
        final String DB_URL = "jdbc:mysql://mysql-kevin2008.alwaysdata.net/kevin2008_farmacia?serverTimezone=UTC";
        final String USERNAME = "kevin2008";
        final String PASSWORD = "LDU2010ldu";

        try{
            System.out.println("Autenticando");
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement stnt = conn.createStatement();
            String sql = "SELECT CEDULA_USUARIO,ROL_USUARIO FROM USUARIOS WHERE CEDULA_USUARIO = ? AND CONTRASENIA=?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, cedulaTXT.getText());
            preparedStatement.setString(2, contraseñaTXT.getText());
            System.out.println("Conexion ok");
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                String rol=resultSet.getString("ROL_USUARIO");
                String cedula=resultSet.getString("CEDULA_USUARIO");
                switch (rol){
                    case "1":
                    {
                        MenuCajero menuCajero = new MenuCajero(cedula,rol);
                        this.dispose();
                        break;
                    }
                    case "2":
                    {
                        MenuBodega menuBodega = new MenuBodega(cedula,rol);
                        this.dispose();
                        break;
                    }
                    case "3":
                    {
                        Menuadministrador menuadministrador = new Menuadministrador(cedula,rol);
                        this.dispose();
                        break;
                    }
                }
            }else {
                JOptionPane.showMessageDialog(null,"Cédula o contraseña incorrectos!","Advertencia",JOptionPane.WARNING_MESSAGE);
            }
            stnt.close();
            conn.close();

        }catch(Exception e){
            e.printStackTrace();
            System.out.println("No se autentico");
        }
    }

    public static void main(String[] args) {
        index Index= new index();
    }

}
