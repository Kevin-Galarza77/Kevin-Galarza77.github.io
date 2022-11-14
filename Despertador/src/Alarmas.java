import javax.swing.*;
import java.util.ArrayList;

public class Alarmas extends JFrame {
    private JPanel panel1;
    private JTextField hora_temp;
    private JButton aumenarHora;
    private JButton disminuirHora;
    private JCheckBox lunesCheckBox;
    private JButton empezar_temporizdor;
    private JTextField minutos_temp;
    private JButton aumentarMinutos;
    private JButton disminuirMinutos;
    private JButton cancelar;
    private JCheckBox Martes;
    private JCheckBox Miercoles;
    private JCheckBox Jueves;
    private JCheckBox Viernes;
    private JCheckBox sabado;
    private JCheckBox domingo;
    private final ArrayList<String> alarmas;

    public Alarmas(ArrayList<String> alarmas) {
        this.alarmas = alarmas;
        setTitle("Crear Alarma");
        setSize(1000,400);
        setLocationRelativeTo(null);
        setContentPane(panel1);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setVisible(true);


        hora_temp.setText("00");
        minutos_temp.setText("00");

        aumenarHora.addActionListener(e-> setHora_tempAumentar(1));
        disminuirHora.addActionListener(e-> setHora_tempDisminuir(1));
        aumentarMinutos.addActionListener(e->setHora_tempAumentar(2));
        disminuirMinutos.addActionListener(e->setHora_tempDisminuir(2));
        empezar_temporizdor.addActionListener(e->addAlarma());
        cancelar.addActionListener(e-> cerrar());
    }
    private void cerrar(){
        this.dispose();
        Despertador despertador = new Despertador(alarmas);
    }
    private void addAlarma(){
        try{
            if(lunesCheckBox.isSelected() || Martes.isSelected() || Miercoles.isSelected() || Jueves.isSelected() || Viernes.isSelected() || sabado.isSelected() || domingo.isSelected()){
                if (Double.parseDouble(hora_temp.getText())>23 || Double.parseDouble(hora_temp.getText())<0 || Double.parseDouble(minutos_temp.getText())<0 || Double.parseDouble(minutos_temp.getText())>59 ){
                    JOptionPane.showMessageDialog(null,"Ingresa la hora correctamente","Hora incorrecta",JOptionPane.WARNING_MESSAGE);
                    hora_temp.setText("00");
                    minutos_temp.setText("00");
                }else {

                        alarmas.add(hora_temp.getText()+":"+minutos_temp.getText());
                        alarmas.add(unirDias());
                        Despertador despertador = new Despertador(alarmas);
                        this.dispose();
                }
            }else {
                JOptionPane.showMessageDialog(null,"Por favor selecciona los dias a repetir la alarma","Selccione",JOptionPane.WARNING_MESSAGE);
            }
        }catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Ingresa la hora correctamente","Hora incorrecta",JOptionPane.WARNING_MESSAGE);
        }
    }
    private String unirDias(){
        String dias="";
        if (lunesCheckBox.isSelected()){
            dias+="Lun ";
        }
        if (Martes.isSelected()){
            dias+="Mar ";
        }
        if (Miercoles.isSelected()){
            dias+="Mie ";
        }
        if (Jueves.isSelected()){
            dias+="Jue ";
        }
        if (Viernes.isSelected()){
            dias+="Vie ";
        }
        if (sabado.isSelected()){
            dias+="Sab ";
        }
        if (domingo.isSelected()){
            dias+="Dom ";
        }
        return dias;

    }
    private void setHora_tempDisminuir(int caso){
        try{
            switch (caso) {
                case 1 -> {
                    if (!(Double.parseDouble(hora_temp.getText()) < 1)) {
                        hora_temp.setText((Double.parseDouble(hora_temp.getText()) - 1) < 10 ? "0" + ((int) (Double.parseDouble(hora_temp.getText())) - 1) : "" + ((int) (Double.parseDouble(hora_temp.getText())) - 1));
                    } else {
                        hora_temp.setText("23");
                    }
                }
                case 2 -> {
                    if (!(Double.parseDouble(minutos_temp.getText()) < 1)) {
                        minutos_temp.setText((Double.parseDouble(minutos_temp.getText()) - 1) < 10 ? "0" + ((int) (Double.parseDouble(minutos_temp.getText())) - 1) : "" + ((int) (Double.parseDouble(minutos_temp.getText())) - 1));
                    } else {
                        minutos_temp.setText("59");
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Posibles errores:\n-Ingreso de letras\n-Números Negativos","Error encontrado",JOptionPane.ERROR_MESSAGE);
            hora_temp.setText("00");
            minutos_temp.setText("00");
        }
    }
    private void setHora_tempAumentar(int caso){
        try{
            switch (caso) {
                case 1 -> {
                    if (Double.parseDouble(hora_temp.getText()) > 22) {
                        hora_temp.setText("00");
                    } else {
                        hora_temp.setText((Double.parseDouble(hora_temp.getText()) + 1) < 10 ? "0" + ((int) (Double.parseDouble(hora_temp.getText())) + 1) : "" + ((int) (Double.parseDouble(hora_temp.getText())) + 1));
                    }
                }
                case 2 -> {
                    if (Double.parseDouble(minutos_temp.getText()) > 58) {
                        minutos_temp.setText("00");
                    } else {
                        minutos_temp.setText((Double.parseDouble(minutos_temp.getText()) + 1) < 10 ? "0" + ((int) (Double.parseDouble(minutos_temp.getText())) + 1) : "" + ((int) (Double.parseDouble(minutos_temp.getText())) + 1));
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Posibles errores:\n-Ingreso de letras\n-Números Negativos","Error encontrado",JOptionPane.ERROR_MESSAGE);
            hora_temp.setText("00");
            minutos_temp.setText("00");
        }
    }
}
