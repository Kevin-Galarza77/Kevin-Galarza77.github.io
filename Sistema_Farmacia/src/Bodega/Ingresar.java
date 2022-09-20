package Bodega;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Ingresar extends JFrame{
    private JTextField IdTXT;
    private JTextField NombreTXT;
    private JTextField PrecioTXT;
    private JTextField StockTXT;
    private JTextField DescripcionTXT;
    private JButton regresarButton;
    private JButton agregarButton;
    private JPanel MainIngresar;
    private String rol;
    private String cedula;

    public Ingresar(String cedula,String rol) {
        this.cedula=cedula; //Información del usuario autenticado
        this.rol=rol; //Información del usuario autenticado
        //Configuraiones del formulario
        setContentPane(MainIngresar);
        setTitle("Bienvenido");
        setSize(1400, 750);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

            //Evento que permite ejecutar el método para regresar a la lista de productos
            regresarButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Bodega();
                }
            });

             //Evento que permite agregar el método para regresar a la lista de productos
            agregarButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Ingresar();
                    Limpiar();
                }
            });
        }

        /*
        * Método que permite ingresar un producto
        */
        public void Ingresar() {
            String id, nombre, precio, stock, descripcion;

            // Se recupera los campos del formulario
            id = IdTXT.getText();
            nombre = NombreTXT.getText();
            precio = PrecioTXT.getText();
            stock = StockTXT.getText();
            descripcion = DescripcionTXT.getText();

            //Se verifica que todos los campos del producto tengan información, sino se despliega un mensaje
            if (id.equals("") || nombre.equals("") || precio.equals("") || stock.equals("") || descripcion.equals("")) {
                JOptionPane.showMessageDialog(null, "Complete todos los campos.", "Error", JOptionPane.PLAIN_MESSAGE);
            } else {
                final String DB_URL="jdbc:mysql://mysql-kevin2008.alwaysdata.net/kevin2008_farmacia?serverTimezone=UTC";
                final String USERNAME="kevin2008";
                final String PASSWORD="LDU2010ldu";

                try {
                    Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD); // Crea la instacion de conexión a la base
                    Statement stmt = conn.createStatement(); // Se conecta a la base
                    String sql="INSERT INTO PRODUCTOS(ID_PRODUCTO, NOMBRE_PRODUCTO,PRECIO_PRODUCTO,DESCRIPCION_PRODUCTO,STOCK) VALUES(?,?,?,?,?)"; // Script SQL para ingresar el producto
                    PreparedStatement pst = conn.prepareStatement(sql);

                    // Se define los parámetros de los campos a ser actualizados
                    pst.setString(1, id);
                    pst.setString(2, nombre);
                    pst.setString(3, precio);
                    pst.setString(4, descripcion);
                    pst.setString(5, stock);

                    pst.executeUpdate(); //Se ejecuta el script

                    // Cerramos la conexión a la base
                    stmt.close();
                    conn.close();

                    //Se muestra un mensaje de que el producto fue ingresado correctamente
                    JOptionPane.showMessageDialog(null,"Producto agregado correctamente!","Agregado",JOptionPane.INFORMATION_MESSAGE);

                } catch (SQLException ex) {
                    // Se muestra un mensaje si ocurre un error en el proceso de actualizar
                    ex.printStackTrace();
                    System.out.println("SQL incorrecto");
                    JOptionPane.showMessageDialog(null,
                            "\nEl ID: " + id+" ya existe!!", "ERROR", JOptionPane.PLAIN_MESSAGE);
                }
            }
        }

    /*
     * Método para limpiar los campos del formulario
    */
    public void Limpiar(){
        IdTXT.setText("");
        NombreTXT.setText("");
        PrecioTXT.setText("");
        StockTXT.setText("");
        DescripcionTXT.setText("");
    }

    /*
     * Método para regresar al formulario Bodega
    */
    private void Bodega(){
        MenuBodega menuBodega=new MenuBodega(cedula,rol);
        this.dispose();
    }
}
