import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class UpdateProducts extends JFrame{
    public JPanel main_Update;
    private JTextField nombreTXT;
    private JButton actualizarButton;
    private JTextField idTXT;
    private JTextField precioTXT;
    private JTextField stockTXT;
    private JTextField descripcionTXT;
    private JButton volverBTN;
    private JButton buscarButton;
    private String id2;

    public UpdateProducts() {
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscar_producto();
            }
        });
        volverBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                volver_menu();
            }
        });
        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Update();
            }
        });
    }
    public void Update(){
        String id,nombre, precio, stock,descripcion;

        id=idTXT.getText();
        nombre=nombreTXT.getText();
        precio=precioTXT.getText();
        stock=stockTXT.getText();
        descripcion=descripcionTXT.getText();

        if (id.equals("") ||  nombre.equals("") || precio.equals("") ||  stock.equals("") || descripcion.equals("")){
            JOptionPane.showMessageDialog(null,"Llena todos los campos.","Error",JOptionPane.PLAIN_MESSAGE, icono("/Imagenes/cerca.png",64,64));
        }else{
            final String DB_URL="jdbc:mysql://localhost/supermarket?serverTimezone=UTC";
            final String USERNAME="kg";
            final String PASSWORD="CPuApOBJkiG_uNUH";


            try{
                Connection conn= DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
                Statement stmt= conn.createStatement();

                String sql="update productos set Id_Producto=?, Nombre_Producto=?,Precio__Producto=?,Stock_Producto=?,Descripcion__Producto=? where Id_Producto=?";

                PreparedStatement pst=conn.prepareStatement(sql);

                pst.setString(1,id);
                pst.setString(2,nombre);
                pst.setString(3,precio);
                pst.setString(4,stock);
                pst.setString(5,descripcion);
                pst.setString(6,id2);

                //ResultSet resultSet=pst.executeQuery();
               // if (resultSet.next()==true){
                    JOptionPane.showMessageDialog(null,
                            "\nID Producto: "+id+
                            "\nNombre : "+nombre+
                            "\nPrecio : "+precio+
                            "\nStock : "+stock+
                            "\nDescipción : "+descripcion,"Actualizado",JOptionPane.PLAIN_MESSAGE, icono("/Imagenes/comprobado.png",64,64));
                /*}else {
                    JOptionPane.showMessageDialog(null,"Producto no registrado!! ","Error",JOptionPane.PLAIN_MESSAGE, icono("/Imagenes/cerca.png",64,64));
                }*/

                pst.executeUpdate();
                stmt.close();
                conn.close();



            } catch(SQLException ex){
                ex.printStackTrace();
                System.out.println("SQL incorrecto");
            }


        }

    }
    public Icon icono(String direccion, int wid, int heig){
        Icon img=new ImageIcon(new ImageIcon(getClass().getResource(direccion)).getImage().getScaledInstance(wid,heig, Image.SCALE_SMOOTH));
        return img;
    }
    public void Limpiar(){
        idTXT.setText("");
        nombreTXT.setText("");
        precioTXT.setText("");
        stockTXT.setText("");
        descripcionTXT.setText("");
    }
    private void volver_menu(){
        Menu updateProducts = new Menu(null);
        updateProducts.setContentPane(updateProducts.mainMenu);
        updateProducts.setTitle("Bienvenido");
        updateProducts.setSize(1200,600);
        updateProducts.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        updateProducts.setLocationRelativeTo(null);
        updateProducts.setVisible(true);
        this.dispose();
    }
    public void buscar_producto(){
        id2=idTXT.getText();
        String id="0";
        id=idTXT.getText();

        final String DB_URL="jdbc:mysql://localhost/supermarket?serverTimezone=UTC";
        final String USERNAME="kg";
        final String PASSWORD="CPuApOBJkiG_uNUH";

        if (id.equals("")){
            JOptionPane.showMessageDialog(null,"Escribe el ID del Producto.","Error",JOptionPane.PLAIN_MESSAGE, icono("/Imagenes/cerca.png",50,50));
        }else{

            try{
                Connection conn= DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
                Statement stmt= conn.createStatement();
                String sql="select * from productos where Id_Producto=?";
                PreparedStatement pst=conn.prepareStatement(sql);
                pst.setString(1,id);


                ResultSet rs=pst.executeQuery();


                if(rs.next()==true){
                    String nombre, precio, stock,descripcion;
                    nombre=rs.getString(2);
                    precio=rs.getString(3);
                    stock=rs.getString(4);
                    descripcion=rs.getString(5);

                    System.out.println();
                    nombreTXT.setText(nombre);
                    precioTXT.setText(precio);
                    stockTXT.setText(stock);
                    descripcionTXT.setText(descripcion);
                }
                else {
                    //textMensaje.setText("no se encuentra el producto")  ;
                    JOptionPane.showMessageDialog(null,"Producto no registrado!! ","Error",JOptionPane.PLAIN_MESSAGE, icono("/Imagenes/cerca.png",64,64));
                    Limpiar();
                }
                stmt.close();
                conn.close();

            } catch(SQLException ex){
                ex.printStackTrace();
                System.out.println("SQL incorrecto");

            }
        }

    }
}
