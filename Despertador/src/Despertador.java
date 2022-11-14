import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

public class Despertador extends JFrame {
    private JPanel panel1;
    private JLabel hora;
    private JLabel minutos;
    private JLabel segundos;
    private JLabel dia;
    private JLabel numeroDia;
    private JLabel mes;
    private JLabel anio;
    private JLabel puntos1;
    private JLabel puntos2;
    private JButton pausarButton;
    private JButton iniciarButton;
    private JButton detenerButton;
    private JLabel hora_crono_form;
    private JLabel min_cro_form;
    private JLabel seg_cron_form;
    private JTextField minutos_temp;
    private JButton aumentarMinutos;
    private JButton disminuirMinutos;
    private JButton aumenarHora;
    private JButton disminuirHora;
    private JButton disminuirSegundos;
    private JButton aumentarSegundos;
    private JTextField hora_temp;
    private JTextField segundos_temp;
    private JPanel panel_confg_temp;
    private JPanel panel_contador_temp;
    private JButton empezar_temporizdor;
    private JLabel hora_run_tem;
    private JLabel minutos_run_tem;
    private JLabel segundos_run_tem;
    private JPanel table_alarmas;
    private JTable table1;
    private JButton agregarAlarma;
    private JButton eliminarAlarma;
    private boolean parpadeo;
    private int horas_cronometro;
    private int minutos_cronometro;
    private int segundos_cronometro;
    private int horas_temporizador;
    private int minutos_temporizador;
    private int segundos_temporizador;
    private DefaultTableModel tableModel;
    private final ArrayList<String> alarmas;
    private final Timer cronometro = new Timer(1000, e-> conteoCronometro());
    private final Timer temporizador = new Timer(1000,e->conteoTemporizador());
    public Despertador(ArrayList<String> alarmas) {

        this.alarmas=alarmas;
        setSize(1000,600);
        setLocationRelativeTo(null);
        setContentPane(panel1);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/icono.png")).getImage());
        setTitle("Despertador");
        setVisible(true);
        setHora();
        horas_cronometro=0;
        minutos_cronometro=0;
        segundos_cronometro=0;
        parpadeo=true;
        pausarButton.setVisible(false);
        detenerButton.setVisible(false);
        panel_contador_temp.setVisible(false);
        hora_temp.setText("00");
        minutos_temp.setText("00");
        segundos_temp.setText("00");
        createtable();
        cargarAlarmas();

        Timer timer = new Timer(1000, newe -> setHora());
        timer.start();

        iniciarButton.addActionListener(e->{
                activarBotones();
                empezarCronometro();
        });
        detenerButton.addActionListener(e-> cancelar());
        pausarButton.addActionListener(e-> pausarCronometro());
        aumenarHora.addActionListener(e->setHora_tempAumentar(1));
        disminuirHora.addActionListener(e->setHora_tempDisminuir(1));
        aumentarMinutos.addActionListener(e->setHora_tempAumentar(2));
        aumentarSegundos.addActionListener(e->setHora_tempAumentar(3));
        disminuirMinutos.addActionListener(e->setHora_tempDisminuir(2));
        disminuirSegundos.addActionListener(e->setHora_tempDisminuir(3));
        empezar_temporizdor.addActionListener(e->empezar_temporizdor());
        agregarAlarma.addActionListener(e->crearAlarmas());
        eliminarAlarma.addActionListener(e->eliminarAlarma());

    }

    private void sonarAlarma(){
        for (int i=0;i<alarmas.size();i+=2){
            String hora1=hora.getText()+":"+minutos.getText()+":"+segundos.getText();
            String hora2=alarmas.get(i)+":"+"01";
            if (hora1.contains(hora2)){
                switch (new Date().getDay()) {
                    case 1 -> {
                        if (alarmas.get(i + 1).contains("Lun")) {
                            sonarAlarmar();
                        }
                    }
                    case 2 -> {
                        if (alarmas.get(i + 1).contains("Mar")) {
                            sonarAlarmar();
                        }
                    }
                    case 3 -> {
                        if (alarmas.get(i + 1).contains("Mie")) {
                            sonarAlarmar();
                        }
                    }
                    case 4 -> {
                        if (alarmas.get(i + 1).contains("Jue")) {
                            sonarAlarmar();
                        }
                    }
                    case 5 -> {
                        if (alarmas.get(i + 1).contains("Vie")) {
                            sonarAlarmar();
                        }
                    }
                    case 6 -> {
                        if (alarmas.get(i + 1).contains("Sab")) {
                            sonarAlarmar();
                        }
                    }
                    case 0 -> {
                        if (alarmas.get(i + 1).contains("Dom")) {
                            sonarAlarmar();
                        }
                    }
                }
            }
        }
    }
    private void sonarAlarmar(){
        Alerta alerta = new Alerta("Alarma programada son las " + hora.getText() + ":" + minutos.getText());
    }
    private void eliminarAlarma(){

            int fsel;
            try{
                fsel=table1.getSelectedRow();
                if (fsel==-1){
                    JOptionPane.showMessageDialog(null,"Seleccione la alarma.","Advertencia",JOptionPane.WARNING_MESSAGE);
                }else {
                    createtable();
                    alarmas.remove(fsel);
                    alarmas.remove(fsel);
                    System.out.println(alarmas);
                    cargarAlarmas();
                }
            }catch (Exception e ){
                e.printStackTrace();
            }

    }
    private void crearAlarmas(){
        Alarmas alarma2 = new Alarmas(alarmas);
        this.dispose();
    }
    private void cargarAlarmas(){
        if (alarmas.size()==0){
            table_alarmas.setVisible(false);
            eliminarAlarma.setVisible(false);
        }else {
            table_alarmas.setVisible(true);
            eliminarAlarma.setVisible(true);
            for (int i=0;i<alarmas.size();i+=2){
                Object [] fila = new Object[2];
                fila[0]=alarmas.get(i);
                fila[1]=alarmas.get(i+1);
                tableModel.addRow(fila);
            }
        }
    }

    public  void  createtable() {
        tableModel = new DefaultTableModel(null, columnas()){
            @Override public boolean isCellEditable(int row, int column) {  return false; }
        };
        table1.setModel(tableModel);
        table1.setBackground(Color.BLACK);
        table1.setGridColor(Color.WHITE);
        table1.setRowHeight(30);
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        table1.getColumnModel().getColumn(0).setCellRenderer(tcr);
        table1.getColumnModel().getColumn(1).setCellRenderer(tcr);

    }
    public static Vector<String> columnas(){
        Vector<String> columnNames = new Vector<>();
        columnNames.add("HORA");
        columnNames.add("REPETICIÓN");
        return columnNames;
    }
    private boolean comprobar_temporizador(){
        boolean comprobar= true;
        try{

            if (Double.parseDouble(hora_temp.getText())==0 && Double.parseDouble(minutos_temp.getText())==0 && Double.parseDouble(segundos_temp.getText())==0){
                comprobar=false;
                JOptionPane.showMessageDialog(null,"Los campos a llenar no pueden estar en 0","Error encontrado",JOptionPane.ERROR_MESSAGE);
            }

        }catch (Exception e ){
            e.printStackTrace();
            comprobar=false;
            JOptionPane.showMessageDialog(null,"Posibles errores:\n-Ingreso de letras\n-Números Negativos","Error encontrado",JOptionPane.ERROR_MESSAGE);
            hora_temp.setText("00");
            minutos_temp.setText("00");
            segundos_temp.setText("00");
        }
        return  comprobar;
    }

    private void empezar_temporizdor(){
        if (comprobar_temporizador()){
            if (empezar_temporizdor.getText().equals("Cancelar")){
                empezar_temporizdor.setText("Empezar");
                panel_confg_temp.setVisible(true);
                panel_contador_temp.setVisible(false);
                hora_temp.setText("00");
                minutos_temp.setText("00");
                segundos_temp.setText("00");
            }else {
                empezar_temporizdor.setText("Cancelar");
                panel_confg_temp.setVisible(false);
                panel_contador_temp.setVisible(true);
                horas_temporizador=Integer.parseInt(hora_temp.getText());
                minutos_temporizador=Integer.parseInt(minutos_temp.getText());
                segundos_temporizador=Integer.parseInt(segundos_temp.getText());
                hora_run_tem.setText(horas_temporizador<10 ? "0"+horas_temporizador : ""+horas_temporizador);
                minutos_run_tem.setText(minutos_temporizador<10 ? "0"+minutos_temporizador : ""+minutos_temporizador );
                segundos_run_tem.setText(segundos_temporizador<10 ? "0"+segundos_temporizador : ""+segundos_temporizador);
                temporizador.start();
            }
        }
    }

    private void  conteoTemporizador(){
        if (segundos_temporizador!=0){
            segundos_temporizador--;
            segundos_run_tem.setText(segundos_temporizador<10 ? "0"+segundos_temporizador : ""+segundos_temporizador);
        }else {
            if (minutos_temporizador>0){
                minutos_temporizador--;
                segundos_temporizador=60;
                minutos_run_tem.setText(minutos_temporizador<10 ? "0"+minutos_temporizador : ""+minutos_temporizador);
            }else {
                if (horas_temporizador>0){
                    horas_temporizador--;
                    minutos_temporizador=60;
                    hora_run_tem.setText(horas_temporizador<10 ? "0"+horas_temporizador : ""+horas_temporizador);
                }
            }
        }
        if (segundos_temporizador==0 && minutos_temporizador==0 && horas_temporizador==0){
            temporizador.stop();
            panel_confg_temp.setVisible(true);
            panel_contador_temp.setVisible(false);
            Alerta alerta = new Alerta("El tiempo programado a terminado");
        }
    }
    private void setHora_tempAumentar(int caso){
        try{
            switch (caso) {
                case 1 -> hora_temp.setText((Double.parseDouble(hora_temp.getText()) + 1) < 10 ? "0" + ((int) (Double.parseDouble(hora_temp.getText())) + 1) : "" + ((int) (Double.parseDouble(hora_temp.getText())) + 1));
                case 2 -> {
                    if (Double.parseDouble(minutos_temp.getText()) > 58) {
                        minutos_temp.setText("00");
                    } else {
                        minutos_temp.setText((Double.parseDouble(minutos_temp.getText()) + 1) < 10 ? "0" + ((int) (Double.parseDouble(minutos_temp.getText())) + 1) : "" + ((int) (Double.parseDouble(minutos_temp.getText())) + 1));
                    }
                }
                case 3 -> {
                    if (Double.parseDouble(segundos_temp.getText()) > 58) {
                        segundos_temp.setText("00");
                    } else {
                        segundos_temp.setText((Double.parseDouble(segundos_temp.getText()) + 1) < 10 ? "0" + ((int) (Double.parseDouble(segundos_temp.getText())) + 1) : "" + ((int) (Double.parseDouble(segundos_temp.getText())) + 1));
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Posibles errores:\n-Ingreso de letras\n-Números Negativos","Error encontrado",JOptionPane.ERROR_MESSAGE);
            hora_temp.setText("00");
            minutos_temp.setText("00");
            segundos_temp.setText("00");
        }
    }
    private void setHora_tempDisminuir(int caso){
        try{
            switch (caso) {
                case 1 -> {
                    if (!(Double.parseDouble(hora_temp.getText()) < 1)) {
                        hora_temp.setText((Double.parseDouble(hora_temp.getText()) - 1) < 10 ? "0" + ((int) (Double.parseDouble(hora_temp.getText())) - 1) : "" + ((int) (Double.parseDouble(hora_temp.getText())) - 1));
                    }
                }
                case 2 -> {
                    if (!(Double.parseDouble(minutos_temp.getText()) < 1)) {
                        minutos_temp.setText((Double.parseDouble(minutos_temp.getText()) - 1) < 10 ? "0" + ((int) (Double.parseDouble(minutos_temp.getText())) - 1) : "" + ((int) (Double.parseDouble(minutos_temp.getText())) - 1));
                    } else {
                        minutos_temp.setText("59");
                    }
                }
                case 3 -> {
                    if (!(Double.parseDouble(segundos_temp.getText()) < 1)) {
                        segundos_temp.setText((Double.parseDouble(segundos_temp.getText()) - 1) < 10 ? "0" + ((int) (Double.parseDouble(segundos_temp.getText())) - 1) : "" + ((int) (Double.parseDouble(segundos_temp.getText())) - 1));
                    } else {
                        segundos_temp.setText("59");
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Posibles errores:\n-Ingreso de letras\n-Números Negativos","Error encontrado",JOptionPane.ERROR_MESSAGE);
            hora_temp.setText("00");
            minutos_temp.setText("00");
            segundos_temp.setText("00");
        }
    }
    private void empezarCronometro(){
        cronometro.start();
        iniciarButton.setText("Iniciar");
        min_cro_form.setForeground(Color.white);
        seg_cron_form.setForeground(Color.white);
        hora_crono_form.setForeground(Color.white);
    }
    private void pausarCronometro(){
        cronometro.stop();
        iniciarButton.setText("Continuar");
    }
    private void cancelar(){
        cronometro.stop();
        hora_crono_form.setText("00");
        min_cro_form.setText("00");
        seg_cron_form.setText("00");
        segundos_cronometro=0;
        minutos_cronometro=0;
        horas_cronometro=0;
        ocultarBotones();
        min_cro_form.setForeground(new Color(187,187,187));
        seg_cron_form.setForeground(new Color(187,187,187));
        hora_crono_form.setForeground(new Color(187,187,187));
    }

    private void conteoCronometro(){
        if (segundos_cronometro!=60){
            segundos_cronometro+=1;
            seg_cron_form.setText( segundos_cronometro<10 ? "0"+segundos_cronometro : segundos_cronometro+""    );
        }else {
            segundos_cronometro=0;
            minutos_cronometro+=1;
            min_cro_form.setText(minutos_cronometro<10 ? "0"+minutos_cronometro : minutos_cronometro+"");
            if (minutos_cronometro==60){
                minutos_cronometro=0;
                horas_cronometro+=1;
                hora_crono_form.setText(horas_cronometro<10 ? "0"+horas_cronometro : ""+horas_cronometro);
            }
        }
    }
    private  void ocultarBotones(){
        pausarButton.setVisible(false);
        detenerButton.setVisible(false);
    }
    private void activarBotones(){
        pausarButton.setVisible(true);
        detenerButton.setVisible(true);
    }
    public void setHora(){
        Date tiempo = new Date();
        hora.setText(tiempo.getHours()<10 ? "0"+tiempo.getHours() : tiempo.getHours()+"");
        minutos.setText(tiempo.getMinutes()<10 ? "0"+tiempo.getMinutes() : tiempo.getMinutes()+"");
        segundos.setText(tiempo.getSeconds()<10 ? "0"+tiempo.getSeconds() : tiempo.getSeconds()+"");
        dia.setText(dia(tiempo.getDay()));
        numeroDia.setText(tiempo.getDate()<10 ? "0"+tiempo.getDate() : tiempo.getDate()+"");
        mes.setText(mes(tiempo.getMonth()+1));
        anio.setText((tiempo.getYear()+1900)+"");
        setParpadeo();
        sonarAlarma();
    }
    public void setParpadeo(){
        if (parpadeo){
            puntos1.setForeground(Color.BLACK);
            puntos2.setForeground(Color.BLACK);
            parpadeo=false;
        }else {
            puntos1.setForeground(Color.RED);
            puntos2.setForeground(Color.RED);
            parpadeo=true;
        }
    }
    public String dia(int dia){
        return switch (dia) {
            case 1 -> "Lunes";
            case 2 -> "Martes";
            case 3 -> "Miercoles";
            case 4 -> "Jueves";
            case 5 -> "Viernes";
            case 6 -> "Sábado";
            case 0 -> "Domingo";
            default -> "none";
        };
    }
    public String mes(int dia){
        return switch (dia) {
            case 1 -> "Enero";
            case 2 -> "Febrero";
            case 3 -> "Marzo";
            case 4 -> "Abril";
            case 5 -> "Mayo";
            case 6 -> "Junio";
            case 7 -> "Julio";
            case 8 -> "Agosto";
            case 9 -> "Septiembre";
            case 10 -> "Octubre";
            case 11 -> "Noviembre";
            case 12 -> "Diciembre";
            default -> "none";
        };
    }

}
