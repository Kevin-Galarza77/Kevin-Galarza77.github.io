package Bodega;

import Administrador.Menuadministrador;
import Login.index;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

public class MenuBodega extends JFrame{
    private JButton ingresarProductosButton;
    private JButton modificarProductosButton;
    private JButton eliminarProductosButton;
    private JPanel BodegaJF;
    private JTable table1;
    private JButton salirBTN;
    private JButton regresarBTN;
    private String cedula;
    private String rol;

    public MenuBodega(String cedula,String rol) {
        this.rol=rol; //Información del usuario autenticado
        this.cedula=cedula; //Información del usuario autenticado
        createtable(); // Llama al método que permite crear la tabla que lista los productos

        //Configuraciones del formulario
        setContentPane(BodegaJF);
        setTitle("Bienvenido");
        setSize(1400, 750);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        if (rol.equals("3")){ // Deshabilita el botón regresar para el Rol de Bodeguero
            regresarBTN.setEnabled(true);
        }

        //Evento que permite ejecutar el método para ingresar un producto
        ingresarProductosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ingresar();
            }
        });

        //Evento que permite ejecutar el método para eliminar un producto
        eliminarProductosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Eliminar();
            }
        });

        //Evento que permite ejecutar el método para modificar un producto
        modificarProductosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Modificar();
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

        //Evento que permite ejecutar el método para regresar al menú del administrador
        regresarBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menuadministrador salir = new Menuadministrador(cedula,rol);
                dispose();
            }
        });
    }

    /*
     * Método que dirige al formulario para ingresar productos
    */
    private void Ingresar(){
        Ingresar ingresar = new Ingresar(cedula,rol);
        this.dispose();
    }

    /*
     * Método que dirige al formulario para eliminar productos
     */
    private void Eliminar(){
        Eliminar eliminar = new Eliminar(cedula,rol);
        this.dispose();
    }

    /*
     * Método que dirige al formulario para modificar productos
     */
    private void Modificar(){
        Modificar modificar = new Modificar(cedula,rol);
        this.dispose();
    }

    /*
     * Método que permite crear la tabla que lista los productos, define propiedades de Jtable
    */
    public void createtable(){
        table1.setModel(new DefaultTableModel(buildTableModel(),columnas()));
        table1.setBackground(Color.LIGHT_GRAY);
        table1.setGridColor(Color.white);
        table1.setRowHeight(30);
    }

    /*
    * Método para crear la cabecera de la tabla productos
    */
    public static Vector<String> columnas(){
        Vector<String> columnNames = new Vector<String>();
        columnNames.add("ID");
        columnNames.add("NOMBRE");
        columnNames.add("PRECIO UNITARIO");
        columnNames.add("DESCRIPCION");
        columnNames.add("STOCK");
        return columnNames;
    }

    /*
     * Método que permite recuperar los productos desde base e insertar en un Jtable
    */
    public  Vector<Vector<Object>> buildTableModel()  {

        try{
            Connection conn= DriverManager.getConnection("jdbc:mysql://mysql-kevin2008.alwaysdata.net/kevin2008_farmacia?serverTimezone=UTC",
                    "kevin2008","LDU2010ldu"); // Crea la instacion de conexión a la base
            Statement stmt= conn.createStatement(); // Se conecta a la base
            ResultSet rs = stmt.executeQuery("SELECT * FROM PRODUCTOS"); // Script SQL para recuperar todos los productos
            ResultSetMetaData metaData = rs.getMetaData();

            // Numero de columnas de la tabla productos
            int columnCount = metaData.getColumnCount();

            // Inserta los productos recuperados de base en el Jtable
            Vector<Vector<Object>> data = new Vector<Vector<Object>>();
            while (rs.next()) { // Se recorre los elementos recuperados del SQL
                Vector<Object> vector = new Vector<Object>();
                for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                    vector.add(rs.getObject(columnIndex));
                }
                data.add(vector); // Se añade un item al Jtable
            }
            return data;

        }catch (Exception e ){
            //Para manejo de errores en la conexión a la base
            System.out.println(e);
            return  null;
        }
    }
}
