package Bodega;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Eliminar extends JFrame{
    private JTextField IdTXT;
    private JTextField NombreTXT;
    private JTextField PrecioTXT;
    private JTextField StockTXT;
    private JTextField DescripcionTXT;
    private JButton regresarButton;
    private JButton eliminarButton;
    private JButton buscarButton;
    private JPanel MainEliminar;
    private String rol;
    private String cedula;

    public Eliminar (String cedula,String rol) {
        this.cedula=cedula; //Información del usuario autenticado
        this.rol=rol; //Información del usuario autenticado
        //Configuraiones del formulario
        setContentPane(MainEliminar);
        setTitle("Bienvenido");
        setSize(1400, 750);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        //Evento que permite ejecutar el método para buscar un producto
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscar_producto();
            }
        });

        //Evento que permite ejecutar el método para regresar a la lista de productos
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Bodega();
            }
        });

        //Evento que permite ejecutar el método para eliminar un producto
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 Delete();
                 Limpiar();
            }
        });
    }

    /*
    * Método que permite borrar un producto seleccionado
    */
    public void Delete (){
        String id,nombre, precio, stock,descripcion;
        // Se recupera los campos del formulario
        id=IdTXT.getText();
        nombre=NombreTXT.getText();
        precio=PrecioTXT.getText();
        stock=StockTXT.getText();
        descripcion=DescripcionTXT.getText();

        //Se verifica que todos los campos del producto tengan información, sino se despliega un mensaje
        if (id.equals("") ||  nombre.equals("") || precio.equals("") ||  stock.equals("") || descripcion.equals("")){
            JOptionPane.showMessageDialog(null,"Llena todos los campos.","Error",JOptionPane.PLAIN_MESSAGE);
        }else{
            final String DB_URL="jdbc:mysql://mysql-kevin2008.alwaysdata.net/kevin2008_farmacia?serverTimezone=UTC";
            final String USERNAME="kevin2008";
            final String PASSWORD="LDU2010ldu";
            String borrarid=IdTXT.getText();

            try{

                Connection conn= DriverManager.getConnection(DB_URL,USERNAME,PASSWORD); // Crea la instacia de conexión a la base
                Statement stmt= conn.createStatement(); // Se conecta a la base
                String sql="DELETE FROM PRODUCTOS where ID_PRODUCTO=?"; // Script SQL para eliminar el producto por ID
                PreparedStatement pst=conn.prepareStatement(sql);

                pst.setString(1,borrarid); // Se define el parámetro ID de la consulta

                pst.executeUpdate(); //Se ejecuta el script

                // Cerramos la conexión a la base
                stmt.close();
                conn.close();

                //Se muestra un mensaje de que el producto fue eliminado correctamente
                JOptionPane.showMessageDialog(null,"Producto Eliminado","Eliminado",JOptionPane.INFORMATION_MESSAGE);

            } catch(SQLException ex){
                // Se muestra un mensaje si ocurre un error en el proceso de eliminar
                ex.printStackTrace();
                System.out.println("SQL incorrecto");
                JOptionPane.showMessageDialog(null,
                        "\nError Base de Datos!!", "ERROR",JOptionPane.PLAIN_MESSAGE);
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

    /*
    * Método para buscar el producto que se va a eliminar
    */
    public void buscar_producto(){
        String id;
        id=IdTXT.getText();

        final String DB_URL="jdbc:mysql://mysql-kevin2008.alwaysdata.net/kevin2008_farmacia?serverTimezone=UTC";
        final String USERNAME="kevin2008";
        final String PASSWORD="LDU2010ldu";

        if (id.equals("")){ // Muestra un mensaje si no se ha ingresado un ID para buscar
            JOptionPane.showMessageDialog(null,"Escribe el ID del Producto.","Error",JOptionPane.PLAIN_MESSAGE);
        }else{

            try{
                Connection conn= DriverManager.getConnection(DB_URL,USERNAME,PASSWORD); // Crea la instacion de conexión a la base
                Statement stmt= conn.createStatement(); // Se conecta a la base
                String sql="SELECT ID_PRODUCTO,NOMBRE_PRODUCTO,PRECIO_PRODUCTO,STOCK, DESCRIPCION_PRODUCTO FROM PRODUCTOS where ID_PRODUCTO=?"; // Script SQL para recuperar el producto por ID
                PreparedStatement pst=conn.prepareStatement(sql);
                pst.setString(1,id); // Se define el parámetro ID de la consulta

                ResultSet rs=pst.executeQuery(); //Se ejecuta el script

                if(rs.next()==true){
                    // Si existe el registro se recuperan los campos
                    String nombre, precio, stock,descripcion;
                    nombre=rs.getString(2);
                    precio=rs.getString(3);
                    stock=rs.getString(4);
                    descripcion=rs.getString(5);

                    // Se asignan los valores a los Jlabels del formulario
                    System.out.println();
                    NombreTXT.setText(nombre);
                    PrecioTXT.setText(precio);
                    StockTXT.setText(stock);
                    DescripcionTXT.setText(descripcion);
                }
                else {
                    // Si no existe el producto a buscar, se despliega un mensaje  de aviso
                    JOptionPane.showMessageDialog(null,"Producto no registrado!! ","Error",JOptionPane.PLAIN_MESSAGE);
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
