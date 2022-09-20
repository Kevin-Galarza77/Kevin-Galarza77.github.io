package Cajero;

import Cajero.MenuCajero;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

public class MainUI extends  JFrame{
    private JPanel rootPanel;
    private JTable table1;
    private JScrollPane episodeButton;
    private JButton regresarButton;
    private String cedula;
    private  String rol;
    //METODO CONSTRUCTOR
    public MainUI(String cedula,String rol){
        this.rol=rol;

        this.cedula = cedula;

        createtable();

        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaMenuCajero();
            }
        });

        setContentPane(rootPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1400, 750);
        setTitle("Productos");
        setLocationRelativeTo(null);
        setVisible(true);
    }
    //FUNCION PARA VOLVER AL MENU
    private void ventanaMenuCajero(){
        this.dispose();
        MenuCajero menuCajero = new MenuCajero(cedula,rol);
    }
    //FUNCION PARA CREAR EL MODELO DE LA TABLA
    private   void  createtable(){
        table1.setModel(new DefaultTableModel(buildTableModel(),columnas()));
        table1.setBackground(Color.LIGHT_GRAY);
        table1.setGridColor(Color.white);
        table1.setRowHeight(30);
    }
    //FUNCION PARA CREAR LAS COLUMNAS DE LA TABLA
    private static Vector<String> columnas(){
        Vector<String> columnNames = new Vector<String>();
        columnNames.add("ID");
        columnNames.add("NOMBRE");
        columnNames.add("PRECIO UNITARIO");
        columnNames.add("DESCRIPCION");
        columnNames.add("STOCK");
        return columnNames;
    }
    //FUNCION PARA GENERAR LAS FILAS QUE IRAN EN LA TABLA
    private   Vector<Vector<Object>> buildTableModel()  {

        try{

            Connection conn= DriverManager.getConnection("jdbc:mysql://mysql-kevin2008.alwaysdata.net/kevin2008_farmacia?serverTimezone=UTC",
                    "kevin2008","LDU2010ldu");
            Statement stmt= conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM PRODUCTOS");

            ResultSetMetaData metaData = rs.getMetaData();

            // names of columns
            int columnCount = metaData.getColumnCount();

            // data of the table
            Vector<Vector<Object>> data = new Vector<Vector<Object>>();
            while (rs.next()) {
                Vector<Object> vector = new Vector<Object>();
                for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                    vector.add(rs.getObject(columnIndex));
                }
                data.add(vector);
            }

            return data;

        }catch (Exception e ){
            System.out.println(e);
            return  null;
        }
    }

}
