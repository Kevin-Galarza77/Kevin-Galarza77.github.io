package Administrador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Eliminar extends JFrame{
    private JTextField IdTXT;
    private JTextField NombreTXT;
    private JTextField RolTXT;
    private JTextField ContraseniaTXT;
    private JButton regresarButton;
    private JButton eliminarButton;
    private JButton buscarButton;
    private JPanel MainEliminar;
    private String cedula;
    private String rol;

    public Eliminar(String cedula,String rol){
        this.rol=rol;//Información del usuario autenticado
        this.cedula=cedula;//Información del usuario autenticado
        //Configuraiones del formulario
        setContentPane(MainEliminar);
        setTitle("Eliminar Usuario");
        setSize(1400, 750);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
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
        //Evento que permite ejecutar el método para eliminar un usuario
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Eliminar();
            }
        });
    }

        // Método que permite borrar un usuario seleccionado
    public void Eliminar () {
        String id, nombre, rol, contrasenia;
        // Se recupera los campos del formulario
        id=IdTXT.getText();
        nombre=NombreTXT.getText();
        rol= RolTXT.getText();
        contrasenia= ContraseniaTXT.getText();

        //Se verifica que todos los campos del usuario tengan información, caso contrario se despliega un mensaje
        if (id.equals("") ||  nombre.equals("") || rol.equals("") ||  contrasenia.equals("")){
            JOptionPane.showMessageDialog(null,"Llena todos los campos.","Error",JOptionPane.PLAIN_MESSAGE);
        }else{
            final String DB_URL="jdbc:mysql://mysql-kevin2008.alwaysdata.net/kevin2008_farmacia?serverTimezone=UTC";
            final String USERNAME="kevin2008";
            final String PASSWORD="LDU2010ldu";
            String borrarid=IdTXT.getText();

            try{

                Connection conn= DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);// Crea la instacia de conexión a la base
                Statement stmt= conn.createStatement(); // Se conecta a la base
                String sql="DELETE FROM `USUARIOS` WHERE CEDULA_USUARIO=?"; // Script SQL para eliminar el producto por ID
                PreparedStatement pst=conn.prepareStatement(sql);

                pst.setString(1,borrarid);// Se define el parámetro ID de la consulta

                pst.executeUpdate();//Se ejecuta el script

                // Cerramos la conexión a la base
                stmt.close();
                conn.close();

                //Se muestra un mensaje de que el usuario fue eliminado correctamente
                JOptionPane.showMessageDialog(null,
                        "Usuario eliminado! " ,"Eliminado",JOptionPane.INFORMATION_MESSAGE);

            } catch(SQLException ex){
                // Se muestra un mensaje si ocurre un error en el proceso de eliminar
                ex.printStackTrace();
                System.out.println("SQL incorrecto");
                JOptionPane.showMessageDialog(null,
                        "\nError Base de Datos!!", "ERROR",JOptionPane.PLAIN_MESSAGE);
            }
        }
    }

        // Método para limpiar los campos del formulario

    public void Limpiar(){
        IdTXT.setText("");
        NombreTXT.setText("");
        RolTXT.setText("");
        ContraseniaTXT.setText("");
    }

         // Método para regresar al formulario Administración

    private void Administrador(){
        Menuadministrador menuAdmin=new Menuadministrador(cedula,rol);
        this.dispose();
    }

        // Método para buscar el usuario que se va a eliminar
    public void buscar_usuario(){
        String id = "0";
        id=IdTXT.getText();

        final String DB_URL="jdbc:mysql://mysql-kevin2008.alwaysdata.net/kevin2008_farmacia?serverTimezone=UTC";
        final String USERNAME="kevin2008";
        final String PASSWORD="LDU2010ldu";

        if (id.equals("")){//Muestra un mensaje si no se ha ingresado un ID para buscar
            JOptionPane.showMessageDialog(null,"Escribe el ID del Usuario a buscar.","Error",JOptionPane.PLAIN_MESSAGE);
        }else{

            try{
                Connection conn= DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);// Crea la instacion de conexión a la base
                Statement stmt= conn.createStatement();// Se conecta a la base
                String sql="SELECT CEDULA_USUARIO,NOMBRE_USUARIO,ROL_USUARIO, CONTRASENIA FROM USUARIOS where CEDULA_USUARIO=?";// Script SQL para recuperar el producto por ID
                PreparedStatement pst=conn.prepareStatement(sql);
                pst.setString(1,id);// Se define el parámetro ID de la consulta

                ResultSet rs=pst.executeQuery();//Se ejecuta el script

                if(rs.next()==true){
                    // Si existe el registro se recuperan los campos
                    String nombre, rol, contrasenia;
                    nombre=rs.getString(2);
                    rol=rs.getString(3);
                    contrasenia=rs.getString(4);

                    // Se asignan los valores a los Jlabels del formulario
                    System.out.println();
                    NombreTXT.setText(nombre);
                    RolTXT.setText(rol);
                    ContraseniaTXT.setText(contrasenia);
                }
                else {
                    // Si no existe el usuario a buscar, se despliega un mensaje  de aviso
                    JOptionPane.showMessageDialog(null,"Usuario no registrado!! ","Error",JOptionPane.PLAIN_MESSAGE);
                    Limpiar();
                }
                // Cerramos la conexión a la base
                stmt.close();
                conn.close();

            } catch(SQLException ex){
                //Para manejo de errores en la conexión a la base
                ex.printStackTrace();
                System.out.println("SQL incorrecto");

            }
        }
    }
}
