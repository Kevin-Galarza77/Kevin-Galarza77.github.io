package Cajero;

import Cajero.MenuCajero;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

public class Factura extends JFrame {
    private JPanel panel1;
    private JTable table1;
    private JLabel ivaTXT;
    private JLabel totalTxt;
    private JLabel cedulacliTXT;
    private JLabel nombrecliTXT;
    private JLabel cedulaempTXT;
    private JScrollPane scrollproductos;
    private JLabel numerofacturaTXT;
    private JButton OKButton;
    private DefaultTableModel tableModel;
    private String cedula;
    private String rol;
    //METODO CONSTRUCTOR
    public Factura(String numero,String cedula,String rol){
        this.cedula=cedula;
        this.rol=rol;

        createtable(numero);
        cargarDatos(numero);
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Factura");
        setSize(1400, 750);
        setLocationRelativeTo(null);
        setVisible(true);

        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaMenu();
            }
        });
    }
    //FUNCION PARA REGRESAR AL MENU
    private void ventanaMenu(){
        MenuCajero menuCajero = new MenuCajero(cedula,rol);
        dispose();
    }
    //FUNCION PARA CARGAR LOS DATOS DE LA CABEZERA DE LA FACTURA
    private void cargarDatos(String numero){
        try{

            Connection conn= DriverManager.getConnection("jdbc:mysql://mysql-kevin2008.alwaysdata.net/kevin2008_farmacia?serverTimezone=UTC",
                    "kevin2008","LDU2010ldu");
            Statement stmt= conn.createStatement();
            String sql="SELECT CEDULA_USUARIO,CEDULACLIENTE,NOMBRECLIENTE,IVA,TOTALFACTURA FROM FACTURAS WHERE NUMERO= ?";
            PreparedStatement pst=conn.prepareStatement(sql);
            pst.setString(1,numero);
            ResultSet rs=pst.executeQuery();
            rs.next();

            cedulaempTXT.setText(rs.getString(1));
            cedulacliTXT.setText(rs.getString(2));
            nombrecliTXT.setText(rs.getString(3));
            ivaTXT.setText(rs.getString(4));
            totalTxt.setText(rs.getString(5));
            numerofacturaTXT.setText(numero);

        }catch (Exception e ){
            System.out.println(e);
        }
    }
    //FUNCION PARA CREAR LA TABLA EN EL CONSTRUCTOR
    private  void  createtable(String numero){
        tableModel= new DefaultTableModel(buildTableModel(numero),columnas());
        table1.setModel(tableModel);
        table1.setBackground(Color.LIGHT_GRAY);
        table1.setGridColor(Color.white);
        table1.setRowHeight(30);
    }
    //FUNCION PARA DEVOLVER LOS NOMBES DE LAS COLUMNAS DE LAS TABLAS
    private static Vector<String> columnas(){
        Vector<String> columnNames = new Vector<String>();
        columnNames.add("PRODUCTO");
        columnNames.add("CANTIDAD");
        columnNames.add("PRECIO UNITARIO");
        columnNames.add("TOTAL PARCIAL");
        return columnNames;
    }
    //FUNCION PARA DEVOLVER LAS FILAS O PRODUCTOS COMPRADOS PARA INSERTARLOS EN LA TABLA
    private  Vector<Vector<Object>> buildTableModel(String numero)  {

        try{

            Connection conn= DriverManager.getConnection("jdbc:mysql://mysql-kevin2008.alwaysdata.net/kevin2008_farmacia?serverTimezone=UTC",
                    "kevin2008","LDU2010ldu");
            Statement stmt= conn.createStatement();
            PreparedStatement pst = conn.prepareStatement("SELECT PRODUCTOS.NOMBRE_PRODUCTO,DETALLES.CANTIDAD,PRODUCTOS.PRECIO_PRODUCTO,DETALLES.TOTALDETALLE FROM FACTURAS,DETALLES,PRODUCTOS WHERE FACTURAS.NUMERO=? AND FACTURAS.NUMERO=DETALLES.NUMERO AND DETALLES.ID_PRODUCTO=PRODUCTOS.ID_PRODUCTO");
            pst.setString(1,numero);

            ResultSet rs = pst.executeQuery();




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
