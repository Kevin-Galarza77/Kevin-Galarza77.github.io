import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class monedas {
    private JTextField origenTF;
    private JTextField destinoTF;
    private JButton convertirBTN;
    private JComboBox origenBox;
    private JComboBox finalBox;
    private JLabel origenTxt;
    private JLabel destinoTxt;

    private JPanel mainPanel;

    public monedas() {
        convertirBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                proceso();
            }
        });
    }

    private void proceso (){
        if (comprobador(origenTF.getText())){
            switch (origenBox.getSelectedIndex()){
                case 0:
                {
                    double[] tarifasDolares={20.28,4438.50,1,3.92,1.43};
                    double tarifaseleccionada=tarifasDolares[finalBox.getSelectedIndex()];
                    double resultado=Double.parseDouble(origenTF.getText())*tarifaseleccionada;
                    destinoTF.setText(""+resultado);
                    break;
                }
                case 1:
                {
                    double[] tarifasMexico={1,215.74,0.049,0.19 ,0.071 };
                    double tarifaseleccionada=tarifasMexico[finalBox.getSelectedIndex()];
                    double resultado=Double.parseDouble(origenTF.getText())*tarifaseleccionada;
                    destinoTF.setText(""+resultado);
                    break;
                }
                case 2:
                {
                    double[] tarifasColombia={0.0046 ,1,0.00023,0.00089,0.00033 };
                    double tarifaseleccionada=tarifasColombia[finalBox.getSelectedIndex()];
                    double resultado=Double.parseDouble(origenTF.getText())*tarifaseleccionada;
                    destinoTF.setText(""+resultado);
                    break;
                }
                case 3:
                {
                    double[] tarifasSOl={5.17,1115.44 ,0.25 ,1,0.36  };
                    double tarifaseleccionada=tarifasSOl[finalBox.getSelectedIndex()];
                    double resultado=Double.parseDouble(origenTF.getText())*tarifaseleccionada;
                    destinoTF.setText(""+resultado);
                    break;
                }
                case 4:
                {
                    double[] tarifasAustralia={14.20,3056.61,0.70,2.74 ,1};
                    double tarifaseleccionada=tarifasAustralia[finalBox.getSelectedIndex()];
                    double resultado=Double.parseDouble(origenTF.getText())*tarifaseleccionada;
                    destinoTF.setText(""+resultado);
                    break;
                }
            }
        }
    }

    private boolean comprobador (String number){

        try{

            double a= Double.parseDouble(number);

            return true;

        }catch (Exception e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null,"Error en el ingreso de datos.","Error",JOptionPane.WARNING_MESSAGE);
            return  false;
        }
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Convertidor de Divisas");
        frame.setContentPane(new monedas().mainPanel);
        frame.setSize(1200,600);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
