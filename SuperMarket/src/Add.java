import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class Add extends JFrame{
    public JPanel main_Add;
    private JTextField nombreTXT;
    private JButton agregarButton;
    private JTextField precioTXT;
    private JTextField stockTXT;
    private JTextField descripcionTXT;
    private JTextField idTXT;
    private JButton volverBTN;
    private String id2;

    public Add() {
        volverBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                volver_menu();
            }
        });
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Add();
            }
        });
    }
    public void Add() {
        String id, nombre, precio, stock, descripcion;

        id = idTXT.getText();
        nombre = nombreTXT.getText();
        precio = precioTXT.getText();
        stock = stockTXT.getText();
        descripcion = descripcionTXT.getText();

        if (id.equals("") || nombre.equals("") || precio.equals("") || stock.equals("") || descripcion.equals("")) {
            JOptionPane.showMessageDialog(null, "Complete todos los campos.", "Error", JOptionPane.PLAIN_MESSAGE, icono("/Imagenes/cerca.png", 64, 64));
        } else {
            final String DB_URL = "jdbc:mysql://localhost/supermarket?serverTimezone=UTC";
            final String USERNAME = "kg";
            final String PASSWORD = "CPuApOBJkiG_uNUH";


            try {
                Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
                Statement stmt = conn.createStatement();

                String sql="insert into productos(Id_Producto, Nombre_Producto,Precio__Producto,Stock_Producto,Descripcion__Producto)values(?,?,?,?,?)";
                PreparedStatement pst = conn.prepareStatement(sql);

                pst.setString(1, id);
                pst.setString(2, nombre);
                pst.setString(3, precio);
                pst.setString(4, stock);
                pst.setString(5, descripcion);
                //pst.setString(6, id2);

                JOptionPane.showMessageDialog(null,
                        "\nID Producto: " + id +
                                "\nNombre : " + nombre +
                                "\nPrecio : " + precio +
                                "\nStock : " + stock +
                                "\nDescipción : " + descripcion, "Actualizado", JOptionPane.PLAIN_MESSAGE, icono("/Imagenes/comprobado.png", 64, 64));


                pst.executeUpdate();
                stmt.close();
                conn.close();


            } catch (SQLException ex) {
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
}