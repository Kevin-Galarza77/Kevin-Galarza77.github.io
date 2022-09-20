package Administrador;

import Bodega.MenuBodega;
import Cajero.MenuCajero;
import Login.index;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

public class Menuadministrador extends JFrame{
    private JPanel AdminstradorJF;
    private JButton actualizarUsuariosButton;
    private JButton eliminarUsuariosButton;
    private JTable table1;
    private JButton ingresarUsuariosButton;
    private JButton bodegueroButton;
    private JButton cajeroButton;
    private JButton salirBTN;
    private static String cedula;
    private String rol;

    public Menuadministrador (String cedula,String rol){
        this.cedula=cedula;//Información del usuario autenticado
        createtable();// Llama al método que permite crear la tabla que lista los productos
        this.rol=rol; //Información del usuario autenticado

        //Configuraciones del formulario
        setContentPane(AdminstradorJF);
        setTitle("Administrador");
        setSize(1400,750);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        //Evento que permite ejecutar el método para ingresar un usuario
        ingresarUsuariosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Agregar();
            }
        });
        //Evento que permite ejecutar el método para eliminar un usuario
        eliminarUsuariosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Eliminar();
            }
        });
        //Evento que permite ejecutar el método para modificar un usuario
        actualizarUsuariosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Actualizar();
            }
        });
        //Evento que permite ejecutar el menú de bodeguero

        bodegueroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuBodega();
            }
        });
        //Evento que permite ejecutar el menú de cajero

        cajeroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuCajero();
            }
        });
        //Evento que permite ejecutar el método para salir a la pantalla inicial
        salirBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                index salir = new index();
                dispose();
            }
        });
    }

         // Método que dirige al formulario para agregar usuario

    private void Agregar(){
        Agregar agregar = new Agregar(cedula,rol);
        this.dispose();
    }

         // Método que dirige al formulario para eliminar usuario

    private void Eliminar(){
        Eliminar eliminar = new Eliminar(cedula,rol);
        this.dispose();
    }

         // Método que dirige al formulario para actualizar usuario

    private void Actualizar(){
        Actualizar actualizar = new Actualizar(cedula,rol);
        this.dispose();
    }
    // Método que dirige al formulario de Bodeguero

    private void MenuBodega(){
        MenuBodega menuBod = new MenuBodega(cedula,rol);
        this.dispose();
    }
    // Método que dirige al formulario de Cajero
    private void MenuCajero(){
        MenuCajero menuCaj = new MenuCajero(cedula,rol);
        this.dispose();
    }

    // Método que permite la coneccion a la BDD
    public void Connect(){
        final String DB_URL="jdbc:mysql://mysql-kevin2008.alwaysdata.net/kevin2008_farmacia?serverTimezone=UTC";
        final String USERNAME="kevin2008";
        final String PASSWORD="LDU2010ldu";

        try{
            Connection conn= DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
            Statement stmt= conn.createStatement();

            System.out.println("Conexion exitosa");

        } catch(SQLException ex){
            ex.printStackTrace();
            System.out.println("SQL incorrecto");

        }
    }

         // Método que permite crear la tabla que lista los productos, define propiedades de Jtable

    public  void  createtable(){
        table1.setModel(new DefaultTableModel(buildTableModel(),columnas()));
        table1.setBackground(Color.LIGHT_GRAY);
        table1.setGridColor(Color.white);
        table1.setRowHeight(30);
    }

        // Método para crear la cabecera de la tabla usuarios
    public static Vector<String> columnas(){
        Vector<String> columnNames = new Vector<String>();
        columnNames.add("CEDULA");
        columnNames.add("NOMBRE");
        columnNames.add("ROL");
        columnNames.add("CONTRASEÑA");
        return columnNames;
    }


         // Método que permite recuperar los usuarios desde base e insertar en un Jtable

    public  Vector<Vector<Object>> buildTableModel()  {

        try{

            Connection conn= DriverManager.getConnection("jdbc:mysql://mysql-kevin2008.alwaysdata.net/kevin2008_farmacia?serverTimezone=UTC",
                    "kevin2008","LDU2010ldu");// Crea la instacion de conexión a la base
            Statement stmt= conn.createStatement();// Se conecta a la base

            ResultSet rs = stmt.executeQuery("SELECT * FROM USUARIOS");// Script SQL para recuperar todos los usuarios

            ResultSetMetaData metaData = rs.getMetaData();

            // Numero de columnas de la tabla usuarios
            int columnCount = metaData.getColumnCount();

            // Inserta los usuarios recuperados de base en el Jtable
            Vector<Vector<Object>> data = new Vector<Vector<Object>>();
            while (rs.next()) {// Se recorre los elementos recuperados del SQL
                Vector<Object> vector = new Vector<Object>();
                for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                    vector.add(rs.getObject(columnIndex));
                }
                data.add(vector);// Se añade un item al Jtable
            }

            return data;

        }catch (Exception e ){
            //Para manejo de errores en la conexión a la base
            System.out.println(e);
            return  null;
        }
    }
}
