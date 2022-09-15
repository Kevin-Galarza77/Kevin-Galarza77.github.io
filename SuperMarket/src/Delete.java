import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Delete extends JFrame{
    public JPanel main_Delete;
    private JButton deleteButton;
    private JTextField idTXT;
    private JButton volverBTN;
    private JButton buscarButton;
    private JTextField nombreTXT;
    private JTextField precioTXT;
    private JTextField stockTXT;
    private JTextField descripcionTXT;
    public String id2;

    public Delete() {
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
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Delete();
            }
        });
    }
    public Icon icono(String direccion, int wid, int heig){
        Icon img=new ImageIcon(new ImageIcon(getClass().getResource(direccion)).getImage().getScaledInstance(wid,heig, Image.SCALE_SMOOTH));
        return img;
    }
    public void Delete (){
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
            String borrarid=idTXT.getText();


            try{
                Connection conn= DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
                Statement stmt= conn.createStatement();
                String sql="delete from productos where Id_Producto=?";
                PreparedStatement pst=conn.prepareStatement(sql);
                pst.setString(1,borrarid);
                System.out.println("Borrado");
                pst.executeUpdate();
                stmt.close();
                conn.close();

                JOptionPane.showMessageDialog(null,"Producto Eliminado");

            } catch(SQLException ex){
                ex.printStackTrace();
                System.out.println("SQL incorrecto");
            }


        }

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
    public void buscar_producto() {
        id2 = idTXT.getText();
        String id = "0";
        id = idTXT.getText();

        final String DB_URL = "jdbc:mysql://localhost/supermarket?serverTimezone=UTC";
        final String USERNAME = "kg";
        final String PASSWORD = "CPuApOBJkiG_uNUH";

        if (id.equals("")) {
            JOptionPane.showMessageDialog(null, "Escribe el ID del Producto.", "Error", JOptionPane.PLAIN_MESSAGE, icono("/Imagenes/cerca.png", 50, 50));
        } else {

            try {
                Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
                Statement stmt = conn.createStatement();
                String sql = "select * from productos where Id_Producto=?";
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, id);


                ResultSet rs = pst.executeQuery();


                if (rs.next() == true) {
                    String nombre, precio, stock, descripcion;
                    nombre = rs.getString(2);
                    precio = rs.getString(3);
                    stock = rs.getString(4);
                    descripcion = rs.getString(5);

                    System.out.println();
                    nombreTXT.setText(nombre);
                    precioTXT.setText(precio);
                    stockTXT.setText(stock);
                    descripcionTXT.setText(descripcion);
                } else {
                    //textMensaje.setText("no se encuentra el producto")  ;
                    JOptionPane.showMessageDialog(null, "Producto no registrado!! ", "Error", JOptionPane.PLAIN_MESSAGE, icono("/Imagenes/cerca.png", 64, 64));
                    Limpiar();
                }
                stmt.close();
                conn.close();

            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println("SQL incorrecto");

            }
        }
    }
}
