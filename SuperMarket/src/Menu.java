import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Menu extends JFrame{
    private JButton agregarProductoButton;
    public JPanel mainMenu;
    private JButton eliminarProductoButton;
    private JButton actualizarProductoButton;
    private JButton buscarProductoButton;
    private JLabel Nombre_Usuario;


    public Menu(String usuario) {

        setContentPane(mainMenu);
        setTitle("Bienvenido");
        setSize(1200,600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        Nombre_Usuario.setText(usuario);


        agregarProductoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaAdd();
            }
        });

        eliminarProductoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaDelete();
            }
        });

        actualizarProductoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ventanaUpdate();

            }
        });
        buscarProductoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaSearch();
            }
        });
    }

    private void ventanaAdd(){
        Add add = new Add();
        add.setContentPane(add.main_Add);
        add.setTitle("Bienvenido");
        add.setSize(1200,600);
        add.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        add.setLocationRelativeTo(null);
        add.setVisible(true);
        this.dispose();
    }

    private void ventanaDelete(){
        Delete delete = new Delete();
        delete.setContentPane(delete.main_Delete);
        delete.setTitle("Bienvenido");
        delete.setSize(1200,600);
        delete.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        delete.setLocationRelativeTo(null);
        delete.setVisible(true);
        this.dispose();
    }
    private void ventanaSearch(){
        Search search = new Search();
        search.setContentPane(search.main_Search);
        search.setTitle("Bienvenido");
        search.setSize(1200,600);
        search.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        search.setLocationRelativeTo(null);
        search.setVisible(true);
        this.dispose();
    }
    private void ventanaUpdate(){
        UpdateProducts updateProducts = new UpdateProducts();
        updateProducts.setContentPane(updateProducts.main_Update);
        updateProducts.setTitle("Bienvenido");
        updateProducts.setSize(1200,600);
        updateProducts.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        updateProducts.setLocationRelativeTo(null);
        updateProducts.setVisible(true);
        this.dispose();
    }
    public void Connect(){
        final String DB_URL="jdbc:mysql://localhost/supermarket?serverTimezone=UTC";
        final String USERNAME="kg";
        final String PASSWORD="CPuApOBJkiG_uNUH";

        try{
            Connection conn= DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
            Statement stmt= conn.createStatement();

            System.out.println("Conexion exitosa");

        } catch(SQLException ex){
            ex.printStackTrace();
            System.out.println("SQL incorrecto");

        }
    }

    /*public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Menu menu = new Menu();

    }*/
}
