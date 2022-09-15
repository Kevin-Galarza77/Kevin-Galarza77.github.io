import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Usuarios extends JDialog{
    private JPasswordField passTF;
    private JButton ingresarButton;
    private JTextField emailTF;
    private JButton salirButton;
    private JPanel loginPanel;

    public static void main(String[] args) {
        System.out.println("Ejecutando");
        Usuarios usuario = new Usuarios(null);

    }

    public Usuarios(JFrame parent){
        super(parent); //hereda de
        setTitle("Login");
        setContentPane(loginPanel);
        setSize(1200,600);
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setDefaultLookAndFeelDecorated(true);

        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailTF.getText();
                String password = String.valueOf(passTF.getPassword());

                User user = getAuthenticationUser(email, password);
                if (user!=null){
                    dispose();
                    Menu menu = new Menu(user.Nombre_Usuario);
                }
                else{
                    JOptionPane.showMessageDialog(
                            Usuarios.this,"email o password incorrectos",
                            "intente nuevamente",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });

        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();

            }
        });
        setVisible(true);
    }

    private User getAuthenticationUser(String email, String password){
        User user = null;
        final String DB_URL="jdbc:mysql://localhost/supermarket?serverTimezone=UTC";
        final String USERNAME="kg";
        final String PASSWORD="CPuApOBJkiG_uNUH";

        try{
            System.out.println("Autenticando");
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement stnt = conn.createStatement();
            String sql = "SELECT * FROM usuarios WHERE Email_Usuario=? AND Password_Usuario=?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            System.out.println("Conexion ok");
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                user = new User();
                user.Email_Usuario = resultSet.getString("Email_Usuario");
                user.Password_Usuario = resultSet.getString("Password_Usuario");
                user.Cedula_Usuario = resultSet.getString("Cedula_Usuario");
                user.Celular_Usuario = resultSet.getString("Celular_Usuario");
                user.Nombre_Usuario = resultSet.getString("Nombre_Usuario");
            }
            stnt.close();
            conn.close();

        }catch(Exception e){
            e.printStackTrace();
            System.out.println("No se autentico");
        }
        return user;
    }
}