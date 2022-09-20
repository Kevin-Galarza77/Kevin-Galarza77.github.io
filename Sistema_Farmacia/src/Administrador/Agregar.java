package Administrador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Agregar extends JFrame{
    private JTextField IdTXT;
    private JTextField NombreTXT;
    private JTextField ContaseniaTXT;
    private JButton regresarButton;
    private JButton agregarButton;
    private JPanel MainIngresar;
    private JComboBox RolTXT;
    private  static  String cedula;
    private static String rol;

    public Agregar(String cedula,String rol){
        this.rol=rol;//Información del usuario autenticado
        this.cedula=cedula;//Información del usuario autenticado
        //Configuraiones del formulario
        setContentPane(MainIngresar);
        setTitle("Agregar Usuario");
        setSize(1400, 750);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        crearops();

        //Evento que permite ejecutar el método para regresar a la lista de usuarios
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Administrador();
            }
        });
        //Evento que permite agregar el método para regresar a la lista de usuarios
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Agregar();
                limpiar();
            }
        });
    }

         // Método para limpiar los campos del formulario
    private  void limpiar(){
        IdTXT.setText("");
        NombreTXT.setText("");
        RolTXT.setSelectedIndex(0);
        ContaseniaTXT.setText("");
    }

            // Método que permite ingresar un usuario
    public void Agregar(){
        String id, nombre, rol, contrasenia;

        // Se recupera los campos del formulario
        id = IdTXT.getText();
        nombre = NombreTXT.getText();
        rol = String.valueOf(RolTXT.getSelectedIndex()+1);
        contrasenia = ContaseniaTXT.getText();

        //Se verifica que todos los campos del usuario tengan información, caso contrario se despliega un mensaje
        if (id.equals("") || nombre.equals("") || rol.equals("") || contrasenia.equals("")) {
            JOptionPane.showMessageDialog(null, "Complete todos los campos.", "Error", JOptionPane.PLAIN_MESSAGE);
        } else {
            final String DB_URL="jdbc:mysql://mysql-kevin2008.alwaysdata.net/kevin2008_farmacia?serverTimezone=UTC";
            final String USERNAME="kevin2008";
            final String PASSWORD="LDU2010ldu";

            try {
                Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);// Crea la instacion de conexión a la base
                Statement stmt = conn.createStatement();// Se conecta a la base

                String sql="INSERT INTO `USUARIOS`(`CEDULA_USUARIO`, `NOMBRE_USUARIO`, `ROL_USUARIO`, `CONTRASENIA`) VALUES (?,?,?,?)";// Script SQL para ingresar el producto
                PreparedStatement pst = conn.prepareStatement(sql);

                // Se define los parámetros de los campos a ser actualizados
                pst.setString(1, id);
                pst.setString(2, nombre);
                pst.setString(3, rol);
                pst.setString(4, contrasenia);

                pst.executeUpdate();//Se ejecuta el script
                // Cerramos la conexión a la base
                stmt.close();
                conn.close();

                //Se muestra un mensaje de que el usuario fue ingresado correctamente
                JOptionPane.showMessageDialog(null,"Usuario creado con exito!", "Creado", JOptionPane.INFORMATION_MESSAGE);

            } catch (SQLException ex) {
                // Se muestra un mensaje si ocurre un error en el proceso de actualizar
                ex.printStackTrace();
                System.out.println("SQL incorrecto");
                JOptionPane.showMessageDialog(null,
                        "\nEl ID: " + id+" ya existe!!", "ERROR", JOptionPane.PLAIN_MESSAGE);
            }

        }

    }

         //Método para presentar las opciones en el combobox

    private  void crearops(){
        RolTXT.addItem("Cajero");
        RolTXT.addItem("Bodeguero");
        RolTXT.addItem("Administrado");
    }

         // Método para regresar al formulario Administración

    private void Administrador(){
        Menuadministrador menuAdmin=new Menuadministrador(cedula,rol);
        this.dispose();
    }
}
