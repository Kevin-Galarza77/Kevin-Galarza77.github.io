import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Search extends JFrame{
    public JPanel main_Search;
    private JTextField nombreTXT;
    private JButton buscarButton;
    private JTextField precioTXT;
    private JTextField stockTXT;
    private JTextField descripcionTXT;
    private JTextField idTXT;
    private JButton volverBTN;

    public String id2;


    public Search() {
        volverBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                volver_menu();
            }
        });
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscar_producto();
            }
        });
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
        UpdateProducts updateProducts= new UpdateProducts();
        id2=idTXT.getText();
        String id;
        id=idTXT.getText();

        final String DB_URL="jdbc:mysql://localhost/supermarket?serverTimezone=UTC";
        final String USERNAME="kg";
        final String PASSWORD="CPuApOBJkiG_uNUH";

        if (id.equals("")){
            JOptionPane.showMessageDialog(null,"Escribe el ID del Producto.","Error",JOptionPane.PLAIN_MESSAGE, updateProducts.icono("/Imagenes/cerca.png",50,50));
        }else{

            try{
                Connection conn= DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
                Statement stmt= conn.createStatement();
                String sql="select * from productos where Id_Producto=?";
                PreparedStatement pst=conn.prepareStatement(sql);
                pst.setString(1,id);


                ResultSet rs=pst.executeQuery();


                if(rs.next()){
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
                    JOptionPane.showMessageDialog(null,"Producto no registrado!! ","Error",JOptionPane.PLAIN_MESSAGE, updateProducts.icono("/Imagenes/cerca.png",64,64));
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
    public void Limpiar(){
        idTXT.setText("");
        nombreTXT.setText("");
        precioTXT.setText("");
        stockTXT.setText("");
        descripcionTXT.setText("");
    }
}
