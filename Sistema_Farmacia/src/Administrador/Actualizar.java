package Administrador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Actualizar extends JFrame {
    private JPanel MainActualizar;
    private JTextField IdTXT;
    private JTextField NombreTXT;
    private JComboBox RolTXT;
    private JTextField ContraseniaTXT;
    private JButton regresarButton;
    private JButton actualizarButton;
    private JButton buscarButton;
    private JPanel MAIN;
    private String cedula;
    private String rol;
    private static String id2;

    public Actualizar(String cedula,String rol) {
        this.rol=rol; //Información del usuario autenticado
        this.cedula=cedula;//Información del usuario autenticado
        //Configuraiones del formulario
        setContentPane(MAIN);
        setTitle("Actualizar datos de usuarios");
        setSize(1400, 750);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        crearops();
        //Evento que permite ejecutar el método para buscar un usuario
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscar_usuario();
            }
        });
        //Evento que permite ejecutar el método para regresar a la lista de usuarios
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Administrador();
            }
        });
        //Evento que permite ejecutar el método para actualizar un usuario
        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Actualizar();
                Limpiar();
            }
        });
    }

    //Método para presentar las opciones en el combobox
    private  void crearops(){
        RolTXT.addItem("Cajero");
        RolTXT.addItem("Bodeguero");
        RolTXT.addItem("Administrado");
    }

         // Método que permite actualizar un usuario seleccionado
    public void Actualizar() {
        String id, nombre, rol, contrasenia;

        // Se recupera los campos del formulario
        id = IdTXT.getText();
        nombre = NombreTXT.getText();
        rol = String.valueOf(RolTXT.getSelectedIndex()+1);
        contrasenia = ContraseniaTXT.getText();

        //Se verifica que todos los campos del usuario tengan información, sino se despliega un mensaje
        if (id.equals("") || nombre.equals("") || rol.equals("") || contrasenia.equals("")) {
            JOptionPane.showMessageDialog(null, "Llena todos los campos.", "Error", JOptionPane.PLAIN_MESSAGE);
        } else {
            final String DB_URL = "jdbc:mysql://mysql-kevin2008.alwaysdata.net/kevin2008_farmacia?serverTimezone=UTC";
            final String USERNAME = "kevin2008";
            final String PASSWORD = "LDU2010ldu";


            try {
                Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
                Statement stmt = conn.createStatement();

                String sql = "update USUARIOS set CEDULA_USUARIO=?, NOMBRE_USUARIO=?,ROL_USUARIO=?,CONTRASENIA=? where CEDULA_USUARIO=?";
                PreparedStatement pst = conn.prepareStatement(sql);

                // Se define los parámetros de los campos a ser actualizados
                pst.setString(1, IdTXT.getText());
                pst.setString(2, nombre);
                pst.setString(3, rol);
                pst.setString(4, contrasenia);
                pst.setString(5, id2);

                pst.executeUpdate();//Se ejecuta el script

                stmt.close();
                conn.close();

                //Se muestra un mensaje de que el usuario fue actualizado correctamente
                JOptionPane.showMessageDialog(null,
                        "\nUSUARIO ACTUALIZADO" +
                                "\nID Usuario: " + id +
                                "\nNombre : " + nombre +
                                "\nRol : " + rol +
                                "\nContraseña : " + contrasenia, "Actualizado", JOptionPane.INFORMATION_MESSAGE);


            } catch (SQLException ex) {
                // Se muestra un mensaje si ocurre un error en el proceso de actualizar
                ex.printStackTrace();
                System.out.println("SQL incorrecto");

                JOptionPane.showMessageDialog(null,
                        "\nError Base de Datos!!", "ERROR", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }

         // Método para limpiar los campos del formulario

    public void Limpiar() {
        IdTXT.setText("");
        NombreTXT.setText("");
        RolTXT.setSelectedIndex(0);
        ContraseniaTXT.setText("");
    }

         //Método para regresar al formulario Administración

    private void Administrador() {
        Menuadministrador menuAdmin = new Menuadministrador(cedula,rol);
        this.dispose();
    }

     // Método para buscar el usuario que se va a modificar

    public void buscar_usuario() {
        String id = "0";
        id = IdTXT.getText();
        id2=id;
        final String DB_URL = "jdbc:mysql://mysql-kevin2008.alwaysdata.net/kevin2008_farmacia?serverTimezone=UTC";
        final String USERNAME = "kevin2008";
        final String PASSWORD = "LDU2010ldu";

        if (id.equals("")) {// Muestra un mensaje si no se ha ingresado un ID para actualizar
            JOptionPane.showMessageDialog(null, "Escribe el ID del Usuario a buscar.", "Error", JOptionPane.PLAIN_MESSAGE);
        } else {

            try {
                Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);// Crea la instacion de conexión a la base
                Statement stmt = conn.createStatement();// Se conecta a la base
                String sql = "SELECT CEDULA_USUARIO,NOMBRE_USUARIO,ROL_USUARIO, CONTRASENIA FROM USUARIOS where CEDULA_USUARIO=?";// Script SQL para recuperar el producto por ID
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, id);// Se define el parámetro ID de la consulta

                ResultSet rs = pst.executeQuery();//Se ejecuta el script

                if (rs.next() == true) {
                    // Si existe el registro se recuperan los campos
                    String nombre, rol, contrasenia;
                    nombre = rs.getString(2);
                    rol = rs.getString(3);
                    contrasenia = rs.getString(4);

                    // Se asignan los valores a los Jlabels del formulario
                    System.out.println();
                    NombreTXT.setText(nombre);
                    RolTXT.setSelectedIndex(Integer.parseInt(rol)-1);
                    ContraseniaTXT.setText(contrasenia);
                } else {
                    // Si no existe el usuario a buscar, se despliega un mensaje  de aviso
                    JOptionPane.showMessageDialog(null, "Usuario no registrado!! ", "Error", JOptionPane.PLAIN_MESSAGE);
                    Limpiar();
                }
                // Cerramos la conexión a la base
                stmt.close();
                conn.close();

            } catch (SQLException ex) {
                //Para manejo de errores en la conexión a la base
                ex.printStackTrace();
                System.out.println("SQL incorrecto");

            }
        }
    }
}
