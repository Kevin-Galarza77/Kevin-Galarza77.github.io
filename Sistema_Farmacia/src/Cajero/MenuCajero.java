package Cajero;

import Administrador.Menuadministrador;
import Login.index;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuCajero extends  JFrame{
    public JPanel mainMenuCajero;
    private JButton realizarVentaButton;
    private JButton verProductosButton;
    private JButton verFacturasButton;
    private JButton salirBTN;
    private JButton regresarBTN;
    private String cedula;
    private String rol;


    //METODO CONSTRUCTO
    public MenuCajero(String cedula,String rol){
        setContentPane(mainMenuCajero);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1400, 750);
        setTitle("Cajero");
        setLocationRelativeTo(null);
        setVisible(true);
        this.cedula=cedula;
        this.rol=rol;
        if (rol.equals("3")){
            regresarBTN.setEnabled(true);
        }
        verProductosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaProductos();
            }
        });
        realizarVentaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaFacturacion();
            }
        });
        verFacturasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventaVerFactura();
            }
        });
        salirBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                index salir = new index();
                dispose();
            }
        });
        regresarBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menuadministrador salir = new Menuadministrador(cedula,rol);
                dispose();
            }
        });
    }
    //FUNCION PARA  IR A LA VENTANA LA FACTURA GENERADA
    private void ventaVerFactura(){
        VerFacturas verFacturas = new VerFacturas(cedula,rol);
        this.dispose();
    }
    //FUNCION PARA IR A LA VENTANA VER LOS PRODUCTOS
    private void ventanaProductos(){

        MainUI ui = new MainUI(cedula,rol);

        this.dispose();

    }
    //FUNCION PARA IR A LA VENTANA GENERAR UNA FACTURA
    private void ventanaFacturacion(){

        GenerarFactura generarFactura = new GenerarFactura(cedula,rol);

        this.dispose();

    }

}
