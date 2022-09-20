package Cajero;

import Cajero.Factura;
import Cajero.MenuCajero;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class VerFacturas extends JFrame{
    private JPanel panel1;
    private JComboBox facturascomboBox1;
    private JButton cancelarBTN;
    private JButton generarBTN;
    private static ArrayList<String> IDfacturas = new ArrayList<>();
    private  String cedula;
    private String rol;
    //METODO CONSTRUCTOR
    public VerFacturas(String cedula,String rol){
        this.cedula=cedula;
        this.rol=rol;
        cargarFacturas();

        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1400, 750);
        setTitle("Buscar Factura");
        setLocationRelativeTo(null);
        setVisible(true);


        cancelarBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaMenuCajero();
            }
        });
        generarBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirFactura();
            }
        });
    }
    //FUNCION PARA VER LA FACTURA
    private void abrirFactura(){
        Factura factura = new Factura(IDfacturas.get(facturascomboBox1.getSelectedIndex()),cedula,rol);
        this.dispose();
    }
    //FUNCION PARA VOLVER AL MENU
    private void ventanaMenuCajero(){
        MenuCajero menuCajero = new MenuCajero(cedula,rol);
        this.dispose();
    }
    //FUNCION PARA CARGAR LAS FACTURAS EN EL COMBO BOX
    private void cargarFacturas(){

        Connection con=null;
        Statement st=null;
        ResultSet rs=null;


        try{


            con= DriverManager.getConnection("jdbc:mysql://mysql-kevin2008.alwaysdata.net/kevin2008_farmacia?serverTimezone=UTC",
                    "kevin2008","LDU2010ldu");
            st=con.createStatement();
            String s="SELECT NUMERO FROM FACTURAS";
            rs=st.executeQuery(s);
            facturascomboBox1.addItem("Ingrese o seleccione la factura...");
            IDfacturas.add("Ingrese o seleccione la factura...");
            while(rs.next()){

                facturascomboBox1.addItem(rs.getString(1));
                IDfacturas.add(rs.getString(1));
            }

            AutoCompleteDecorator.decorate(facturascomboBox1);

        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error");
        }finally {
            try{
                st.close();
                rs.close();
                con.close();
            } catch(Exception e){
                JOptionPane.showMessageDialog(null,"Error cierre");
            }
         }
    }
}
