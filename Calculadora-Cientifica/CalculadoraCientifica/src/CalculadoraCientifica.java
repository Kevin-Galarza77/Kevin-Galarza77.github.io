import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculadoraCientifica extends  JFrame{
    private float num1;
    private float num2;
    private String operador;
    private float resultado;
    private JButton cero;
    private JButton punto;
    private JButton uno;
    private JButton dos;
    private JButton cuatro;
    private JButton cinco;
    private JButton seis;
    private JButton siete;
    private JButton ocho;
    private JButton nueve;
    private JButton del;
    private JButton ac;
    private JButton ans;
    private JButton por;
    private JButton dividido;
    private JButton mas;
    private JButton menos;
    private JButton igual;
    private JButton masOmeno;
    private JButton e;
    private JButton coseno;
    private JButton tangente;
    private JButton secante;
    private JButton cosecante;
    private JButton cotangente;
    private JButton senoinverso;
    private JButton cosenoinverso;
    private JButton tangenteinverso;
    private JButton raiz;
    private JButton potencia;
    private JButton factorial;
    private JButton absoluto;
    private JButton logaritmo;
    private JButton pi;
    private JLabel pantalla;
    private JButton tres;
    private JPanel panel2;
    private JPanel mainCalculadora;
    private JButton seno;
    private JLabel pantalla2;
    private JButton porcentaje;
    private JButton raizx;
    private JButton inversa;
    private JButton exp;
    private JButton ln;
    private JButton redondear;


    public CalculadoraCientifica() {

        cero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pantalla.setText(pantalla.getText()+"0");
                pantalla2.setText("");
            }
        });
        uno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pantalla.setText(pantalla.getText()+"1");
                pantalla2.setText("");
            }
        });
        dos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pantalla.setText(pantalla.getText()+"2");
                pantalla2.setText("");
            }
        });
        cuatro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pantalla.setText(pantalla.getText()+"4");
                pantalla2.setText("");
            }
        });
        tres.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pantalla.setText(pantalla.getText()+"3");
                pantalla2.setText("");
            }
        });
        cinco.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pantalla.setText(pantalla.getText()+"5");
                pantalla2.setText("");
            }
        });
        seis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pantalla.setText(pantalla.getText()+"6");
                pantalla2.setText("");
            }
        });
        siete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pantalla.setText(pantalla.getText()+"7");
                pantalla2.setText("");
            }
        });
        ocho.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pantalla.setText(pantalla.getText()+"8");
                pantalla2.setText("");
            }
        });
        nueve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pantalla.setText(pantalla.getText()+"9");
                pantalla2.setText("");
            }
        });
        punto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!(pantalla.getText().contains("."))){
                    pantalla.setText(pantalla.getText()+".");
                    pantalla2.setText("");
                }
            }
        });
        ans.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pantalla.setText(sinCero(resultado));
                num1=0;
                num2=0;
            }
        });
        del.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String retorno=pantalla.getText();
                retorno=retorno.substring(0,retorno.length()-1);
                pantalla.setText(retorno);
            }
        });
        ac.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pantalla.setText("");
                pantalla2.setText("");
            }
        });
        por.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1=Float.parseFloat(pantalla.getText());
                operador="*";
                pantalla2.setText("x");
                pantalla.setText("");
            }
        });
        dividido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1=Float.parseFloat(pantalla.getText());
                operador="/";
                pantalla2.setText("÷");
                pantalla.setText("");
            }
        });
        mas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1=Float.parseFloat(pantalla.getText());
                operador="+";
                pantalla2.setText("+");
                pantalla.setText("");
            }
        });
        menos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (pantalla.getText().equals("")){
                    pantalla.setText("-");
                }else{
                    num1=Float.parseFloat(pantalla.getText());
                    operador="-";
                    pantalla.setText("");
                }
            }
        });
        masOmeno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1=Float.parseFloat(pantalla.getText());
                num1=num1*(-1);
                pantalla.setText(sinCero(num1));
            }
        });
        pi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pantalla2.setText("π");
                pantalla.setText(Math.PI + " ");
            }
        });
        e.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pantalla2.setText("e");
                pantalla.setText(Math.E + " ");
            }
        });
        logaritmo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operador="log";
                pantalla2.setText("log");
                pantalla.setText("");
            }
        });
        exp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pantalla2.setText("e^");
                operador="e";
            }
        });
        porcentaje.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1 = Float.parseFloat(pantalla.getText());
                pantalla2.setText(pantalla2.getText()+pantalla.getText());
                pantalla.setText((num1)/100 + " ");

            }
        });
        inversa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pantalla2.setText("1/x");
                operador="1/x";
                pantalla.setText("");
            }
        });
        raizx.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1=Float.parseFloat(pantalla.getText());
                pantalla2.setText( sinCero(num1)+"√");
                pantalla.setText(" ");
                operador="3√";
            }
        });
        igual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //num2=Float.parseFloat(pantalla.getText());
                switch (operador){
                    case "*":
                    {
                        num2=Float.parseFloat(pantalla.getText());
                        pantalla2.setText(""+sinCero(num1)+operador+sinCero(num2)+"=");
                        resultado=num1*num2;
                        pantalla.setText(sinCero(resultado));
                        break;
                    }
                    case "/":
                    {
                        num2=Float.parseFloat(pantalla.getText());
                        pantalla2.setText(""+sinCero(num1)+operador+sinCero(num2)+"=");
                        resultado=num1/num2;
                        pantalla.setText(sinCero(resultado));
                        break;
                    }
                    case "+":
                    {
                        num2=Float.parseFloat(pantalla.getText());
                        pantalla2.setText(""+sinCero(num1)+operador+sinCero(num2)+"=");
                        resultado=num1+num2;
                        pantalla.setText(sinCero(resultado));
                        break;
                    }
                    case "-":
                    {
                        num2=Float.parseFloat(pantalla.getText());
                        pantalla2.setText(""+sinCero(num1)+operador+sinCero(num2)+"=");
                        resultado=num1-num2;
                        pantalla.setText(sinCero(resultado));
                        break;
                    }
                    case "sin":
                    {
                        num2=Float.parseFloat(pantalla.getText());
                        pantalla2.setText(""+operador+"("+sinCero(num2)+")=");
                        resultado = (float) Math.sin((num2 * Math.PI) / 180);
                        resultado = new BigDecimal(resultado).setScale(15, RoundingMode.HALF_EVEN).floatValue();
                        pantalla.setText(sinCero(resultado));
                        break;
                    }
                    case "cos":
                    {
                        num2=Float.parseFloat(pantalla.getText());
                        pantalla2.setText(""+operador+"("+sinCero(num2)+")=");
                        resultado = (float) Math.cos((num2 * Math.PI) / 180);
                        resultado = new BigDecimal(resultado).setScale(15, RoundingMode.HALF_EVEN).floatValue();
                        pantalla.setText(sinCero(resultado));
                        break;
                    }
                    case "tan":
                    {
                        num2=Float.parseFloat(pantalla.getText());
                        pantalla2.setText(""+operador+"("+sinCero(num2)+")=");
                        if(num2 == 90 || num2 == 270){
                            pantalla.setText("und");
                        } else {
                            resultado = (float) Math.tan((num2 * Math.PI) / 180);
                            resultado = new BigDecimal(resultado).setScale(15, RoundingMode.HALF_EVEN).floatValue();
                            pantalla.setText(sinCero(resultado));
                        }
                        break;
                    }
                    case "sec":
                    {
                        num2=Float.parseFloat(pantalla.getText());
                        pantalla2.setText(""+operador+"("+sinCero(num2)+")=");
                        if(num2 == 90){
                            pantalla.setText("und");
                        } else {
                            resultado =  ((float)( 1/(Math.cos((num2 * Math.PI) / 180))));
                            resultado = new BigDecimal(resultado).setScale(15, RoundingMode.HALF_EVEN).floatValue();
                            pantalla.setText(sinCero(resultado));
                        }
                        break;
                    }
                    case "csc":
                    {
                        num2=Float.parseFloat(pantalla.getText());
                        pantalla2.setText(""+operador+"("+sinCero(num2)+")=");
                        if(num2 == 0 || num2 == 180){
                            pantalla.setText("und");
                        } else {
                            resultado =  ((float)( 1/(Math.sin((num2 * Math.PI) / 180))));
                            resultado = new BigDecimal(resultado).setScale(15, RoundingMode.HALF_EVEN).floatValue();
                            pantalla.setText(sinCero(resultado));
                        }
                        break;
                    }
                    case "cot":
                    {
                        num2=Float.parseFloat(pantalla.getText());
                        pantalla2.setText(""+operador+"("+sinCero(num2)+")=");
                        if(num2 == 0 || num2 == 180){
                            pantalla.setText("und");
                        } else {
                            resultado =  ((float)( 1/(Math.tan((num2 * Math.PI) / 180))));
                            resultado = new BigDecimal(resultado).setScale(15, RoundingMode.HALF_EVEN).floatValue();
                            pantalla.setText(sinCero(resultado));
                        }
                        break;
                    }
                    case "n!":
                    {
                        num2=Float.parseFloat(pantalla.getText());
                        if(num2 < 0){
                            pantalla.setText("error");
                        } else {
                            pantalla2.setText(sinCero(num2)+"!=");
                            resultado=1;
                            for (int i = 1; i <=num2; i++) {
                                resultado *= i;
                            }
                            pantalla.setText(sinCero(resultado));
                        }
                        break;
                    }
                    case "^":
                    {
                        num2=Float.parseFloat(pantalla.getText());
                        pantalla2.setText(""+sinCero(num1)+operador+sinCero(num2)+"=");
                        resultado = (float) Math.pow(num1, num2);
                        pantalla.setText(sinCero(resultado));
                        break;
                    }
                    case "√":
                    {

                        if(num2 < 0){
                            pantalla.setText("Error");
                        }else {
                            num2=Float.parseFloat(pantalla.getText().isEmpty()? String.valueOf(num1) :pantalla.getText());
                            pantalla2.setText(""+operador+sinCero(num2)+" =");
                            resultado= num1 * (float) Math.sqrt(num2);
                            pantalla.setText(sinCero(resultado));
                        }
                        break;
                    }
                    case "|x|":
                    {
                        num2=Float.parseFloat(pantalla.getText().isEmpty()? String.valueOf(num1) :pantalla.getText());
                        resultado= Math.abs(num2);
                        pantalla2.setText("|"+sinCero(num2)+"|=");
                        pantalla.setText(sinCero(resultado));
                        break;
                    }
                    case "log":
                    {
                        num2 = Float.parseFloat(pantalla.getText());
                        pantalla2.setText("log(" + sinCero(num2) + ")=");
                        resultado=(float) Math.log10(num2);
                        pantalla.setText(sinCero(resultado)+ " ");
                        break;
                    }
                    case "asin":
                    {
                        num2 = Float.parseFloat(pantalla.getText());
                        pantalla2.setText("sen-1("+num2+")=");
                        float num3= (float) Math.asin(num2);
                        resultado=(float) Math.toDegrees(num3);
                        pantalla.setText(sinCero(resultado));
                        break;
                    }

                    case "acos":
                    {
                        num2 = Float.parseFloat(pantalla.getText());
                        pantalla2.setText("cos-1("+num2+")=");
                        float num3= (float) Math.acos(num2);
                        resultado=(float) Math.toDegrees(num3);
                        pantalla.setText(sinCero(resultado));
                        break;
                    }
                    case "atan":
                    {
                        num2 = Float.parseFloat(pantalla.getText());
                        pantalla2.setText("tan-1("+num2+")=");
                        float num3= (float) Math.atan(num2);
                        resultado=(float) Math.toDegrees(num3);
                        pantalla.setText(sinCero(resultado));
                        break;
                    }
                    case "ln":
                    {
                        num2 = Float.parseFloat(pantalla.getText());
                        pantalla2.setText("ln(" + sinCero(num2) + ")=");
                        resultado=(float) Math.log(num2);
                        pantalla.setText(sinCero(resultado)+ " ");
                        break;
                    }
                    case "e":
                    {
                        num2 = Float.parseFloat(pantalla.getText());
                        pantalla2.setText("e^"+sinCero(num2)+"=");
                        resultado= (float)Math.pow(Math.E,num2);
                        pantalla.setText(sinCero(resultado));
                        break;
                    }
                    case "3√":
                    {
                        num2=Float.parseFloat(pantalla.getText());
                        pantalla2.setText(sinCero(num1)+"√"+sinCero(num2));
                        resultado = (float) Math.pow(num2,1/num1);
                        pantalla.setText(sinCero(resultado));
                        break;
                    }
                    case "1/x":
                    {
                        num2=Float.parseFloat(pantalla.getText());
                        pantalla2.setText("1/"+sinCero(num2)+"=");
                        resultado=  1/num2;
                        pantalla.setText(sinCero(resultado));
                        break;
                    }
                }
            }
        });
        seno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1=Float.parseFloat(pantalla.getText().isEmpty()? String.valueOf(1) :pantalla.getText());
                operador= "sin";
                pantalla2.setText("sin");
                pantalla.setText("");
            }
        });
        coseno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1=Float.parseFloat(pantalla.getText().isEmpty()? String.valueOf(1) :pantalla.getText());
                operador= "cos";
                pantalla2.setText("cos");
                pantalla.setText("");
            }
        });
        tangente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1=Float.parseFloat(pantalla.getText().isEmpty()? String.valueOf(1) :pantalla.getText());
                operador= "tan";
                pantalla2.setText("tan");
                pantalla.setText("");
            }
        });
        secante.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1=Float.parseFloat(pantalla.getText().isEmpty()? String.valueOf(1) :pantalla.getText());
                operador= "sec";
                pantalla2.setText("sec");
                pantalla.setText("");
            }
        });
        cosecante.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1=Float.parseFloat(pantalla.getText().isEmpty()? String.valueOf(1) :pantalla.getText());
                operador= "csc";
                pantalla2.setText("csc");
                pantalla.setText("");
            }
        });
        cotangente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1=Float.parseFloat(pantalla.getText().isEmpty()? String.valueOf(1) :pantalla.getText());
                operador= "cot";
                pantalla2.setText("cot");
                pantalla.setText("");
            }
        });
        senoinverso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1=Float.parseFloat(pantalla.getText().isEmpty()? String.valueOf(1) :pantalla.getText());
                operador= "asin";
                pantalla2.setText("sen-1");
                pantalla.setText("");
            }
        });
        cosenoinverso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1=Float.parseFloat(pantalla.getText().isEmpty()? String.valueOf(1) :pantalla.getText());
                operador= "acos";
                pantalla2.setText("cos-1");
                pantalla.setText("");
            }
        });
        tangenteinverso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1=Float.parseFloat(pantalla.getText().isEmpty()? String.valueOf(1) :pantalla.getText());
                operador= "atan";
                pantalla2.setText("tan-1");
                pantalla.setText("");
            }
        });
        factorial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operador="n!";
                pantalla2.setText("!");
                pantalla.setText("");

            }
        });
        raiz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1=Float.parseFloat(pantalla.getText().isEmpty()? String.valueOf(1) :pantalla.getText());
                operador="√";
                pantalla2.setText("√");
                pantalla.setText("");

            }
        });
        potencia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1=Float.parseFloat(pantalla.getText());
                operador="^";
                pantalla2.setText("^");
                pantalla.setText("");

            }
        });
        absoluto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operador="|x|";
                pantalla2.setText("|x|");
                pantalla.setText("");

            }
        });

        ln.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operador="ln";
                pantalla2.setText("ln");
                pantalla.setText("");
            }
        });
        redondear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num2=Float.parseFloat(pantalla.getText());
                num2=Math.round(num2);
                pantalla.setText(sinCero(num2));
            }
        });
    }
    public static String sinCero(float numero){
        String sincero;
        sincero=Float.toString(numero);
        if (numero%1==0){
            sincero=sincero.substring(0,sincero.length()-2);
        }
        return sincero;
    }
    public static void main(String[] args) {
        CalculadoraCientifica calculadoraCientifica=new CalculadoraCientifica();
        JFrame frema = new JFrame();
        frema.setContentPane(calculadoraCientifica.mainCalculadora);
        frema.setTitle("Calculadora");
        frema.setSize(500,750);
        frema.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frema.setVisible(true);
        frema.setLocationRelativeTo(null);
    }
}
