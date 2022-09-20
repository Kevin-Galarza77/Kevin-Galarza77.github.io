package Cajero;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

public class GenerarFactura extends JFrame{
    private JPanel mainFacturacion;
    private JTextField cedcliTXT;
    private JComboBox comboBox1;
    private JTextField cantidadTXT;
    private JButton agregarButton;
    private JTable table1;
    private JButton eliminarBtn;
    private JButton cancelarBTN;
    private JLabel ivaTXT;
    private JLabel totalTxt;
    private JTextField nombreClieTXT;
    private JButton generarBTN;
    private JTextField empleadoTXT;

    private DefaultTableModel tableModel;
    private static ArrayList<String> IdProductos = new ArrayList<>();
    private static ArrayList<String> CedUsuarios = new ArrayList<>();

    private static ArrayList<Integer> stocks = new ArrayList<>();

    private static String numeroFactura;

    private  String cedula;
    private String rol;


    //METODO CONTRUCTOR
    public GenerarFactura(String cedula,String rol){
        this.rol=rol;
        empleadoTXT.setText(cedula);
        empleadoTXT.setEditable(false);
        this.cedula = cedula;
        createtable();
        cargarProductos();




        setContentPane(mainFacturacion);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200,800);
        setTitle("Generar Factura");
        setLocationRelativeTo(null);
        setVisible(true);

        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                newFila();

                sumaTotal();

            }
        });
        cancelarBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaMenuCajero();
            }
        });
        eliminarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removerFila();
                sumaTotal();
            }
        });
        generarBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                crearFactura();
                actualizarStocks();


            }
        });
    }


    //FUNCION PARA CARGAR LOS PRODUCTOS EN EL COMBO BOX AL IGUAL QUE LOS STOKS Y ID EN LOS ARRAYS
    private void cargarProductos(){

        Connection con=null;
        Statement st=null;
        ResultSet rs=null;

        try{

            con= DriverManager.getConnection("jdbc:mysql://mysql-kevin2008.alwaysdata.net/kevin2008_farmacia?serverTimezone=UTC",
                    "kevin2008","LDU2010ldu");
            st=con.createStatement();
            String s="select NOMBRE_PRODUCTO,ID_PRODUCTO,STOCK from PRODUCTOS";
            rs=st.executeQuery(s);
            comboBox1.addItem("Seleccione el producto...");
            IdProductos.add("Seleccione");
            stocks.add(11111);


            while(rs.next()){

                comboBox1.addItem(rs.getString(1));
                IdProductos.add(rs.getString(2));
                stocks.add(Integer.parseInt(rs.getString(3)));

            }
            //LIBRERIA QUE ME PERMITE ESCRIBIR Y Q SE AUTOCOMPLETE EL COMBO BOX
            AutoCompleteDecorator.decorate(comboBox1);

        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error");
        }finally {
            try{
                st.close();
                rs.close();
                con.close();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,"Error cierre");
            }
        }
    }




    //FUNCION PARA CREAR LOS DETALLES DE LAS FACTURAS
    private void guardarproductos(){


        try {

            Connection conn= DriverManager.getConnection("jdbc:mysql://mysql-kevin2008.alwaysdata.net/kevin2008_farmacia?serverTimezone=UTC",
                    "kevin2008","LDU2010ldu");
            Statement stmt = conn.createStatement();


            for(int i=0;i<tableModel.getRowCount();i++){

                String sql="INSERT INTO DETALLES (NUMERO ,ID_PRODUCTO ,CANTIDAD,PRECIO,TOTALDETALLE) VALUES (?,?,?,?,?)";

                PreparedStatement pst = conn.prepareStatement(sql);

                pst.setString(1, numeroFactura);
                pst.setString(2, tableModel.getValueAt(i,0).toString());
                pst.setString(3, tableModel.getValueAt(i,2).toString());
                pst.setString(4, tableModel.getValueAt(i,3).toString());
                pst.setString(5, tableModel.getValueAt(i,4).toString());

                pst.executeUpdate();

            }

            System.out.println( " Detalles Insertados ");
            stmt.close();
            conn.close();

            Factura factura = new Factura(numeroFactura,cedula,rol);

            JOptionPane.showMessageDialog(null,"Factura creada con exito","Exito",JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println(ex);
        }



        double precio=0,total=0,iva,pagar;

        for (int i=0;i<tableModel.getRowCount();i++){
            precio=Double.parseDouble(tableModel.getValueAt(i,4).toString());
            total+=precio;
        }



        iva=total*0.12;
        pagar=iva+total;

        ivaTXT.setText(""+redondearDecimales(iva,2));
        totalTxt.setText(""+redondearDecimales(pagar,2));


    }
    //FUNCION PARA ACTUALIZAR LOS STOCKS DE LOS PRODUCTOS LUEGO DE CREAR LA FACTURA
    private void actualizarStocks(){

        try {

            Connection conn= DriverManager.getConnection("jdbc:mysql://mysql-kevin2008.alwaysdata.net/kevin2008_farmacia?serverTimezone=UTC",
                    "kevin2008","LDU2010ldu");
            Statement stmt = conn.createStatement();

            int i=0;
            for(String id: IdProductos){

                String sql="UPDATE PRODUCTOS SET STOCK = ? WHERE ID_PRODUCTO = ? ";

                PreparedStatement pst = conn.prepareStatement(sql);

                pst.setString(1, String.valueOf(stocks.get(i)));
                pst.setString(2, id);

                pst.executeUpdate();
                i++;

            }

            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println(ex);
        }
    }
    //FUNCION PARA OBTENER EL ID DE LA FACTURA CREADA, CON EL OBJETIVO DE RELAZIONAR LOS PRODUCTOS COMPRADOS EN LA MISMA
    private void obtenerFactura(){

        Connection con=null;
        Statement st=null;
        ResultSet rs=null;

        try{

            con= DriverManager.getConnection("jdbc:mysql://mysql-kevin2008.alwaysdata.net/kevin2008_farmacia?serverTimezone=UTC",
                    "kevin2008","LDU2010ldu");

            st=con.createStatement();

            String s="SELECT NUMERO FROM FACTURAS ORDER BY NUMERO DESC ";

            rs=st.executeQuery(s);
            rs.next();

            numeroFactura = rs.getString(1);


            guardarproductos();


        }
        catch (Exception e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null,"Errorrrrr");
        }finally {
            try{
                st.close();
                rs.close();
                con.close();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,"Error cierre");
            }
        }
    }
    //FUNCION PARA CREAR LA CABEZERA DE LA FACTURA, DESPUES DE CONTROLAR ALGUNAS RESTRICCIONES
    private void crearFactura(){

        String cedulaCliente,nombreCliente,cedulaEmpleado;
        cedulaCliente=cedcliTXT.getText();
        nombreCliente=nombreClieTXT.getText();
        cedulaEmpleado= empleadoTXT.getText();




        if (cedulaCliente.equals("") || nombreCliente.equals("") || cedulaEmpleado.equals("Seleccione el empleado...")   ) {

            JOptionPane.showMessageDialog(null,"Por favor llena todos los campos.","LLenar todos los campos",JOptionPane.ERROR_MESSAGE);

        }
        else {
            if ( !comprobar(cedulaCliente) ){
                JOptionPane.showMessageDialog(null,"Numero de Cedula incorrecto.","Advertencia con el IC",JOptionPane.WARNING_MESSAGE);
            }else {
                if (!comprobar(cantidadTXT.getText())){
                    JOptionPane.showMessageDialog(null,"Escribe solo números en cantidad.","Advertencia en Cantidad",JOptionPane.WARNING_MESSAGE);
                }else {
                    if (Integer.parseInt(cantidadTXT.getText())<1){
                        JOptionPane.showMessageDialog(null,"Escribe una cantidad correcta.","Advertencia en Cantidad",JOptionPane.WARNING_MESSAGE);
                    }else {
                        if (tableModel.getRowCount()<1){
                            JOptionPane.showMessageDialog(null,"No existen productos agregados","Productos",JOptionPane.ERROR_MESSAGE);
                        }else {

                            try {
                                Connection conn= DriverManager.getConnection("jdbc:mysql://mysql-kevin2008.alwaysdata.net/kevin2008_farmacia?serverTimezone=UTC",
                                        "kevin2008","LDU2010ldu");
                                Statement stmt = conn.createStatement();

                                String sql="INSERT INTO FACTURAS (CEDULA_USUARIO ,CEDULACLIENTE,NOMBRECLIENTE,TOTALFACTURA,IVA) VALUES (?,?,?,?,?)";

                                PreparedStatement pst = conn.prepareStatement(sql);

                                pst.setString(1, cedulaEmpleado);
                                pst.setString(2, cedulaCliente);
                                pst.setString(3, nombreCliente);
                                pst.setString(4, totalTxt.getText());
                                pst.setString(5, ivaTXT.getText());

                                pst.executeUpdate();
                                stmt.close();
                                conn.close();

                                obtenerFactura();

                                this.dispose();



                            } catch (SQLException ex) {
                                ex.printStackTrace();
                                System.out.println(ex);
                            }
                        }
                    }
                }
            }
        }
    }
    //FUNCION PARA IR CALCULANDO EL VALOR DE LA FACTURA
    private void sumaTotal(){
        double precio=0,total=0,iva,pagar;

        for (int i=0;i<tableModel.getRowCount();i++){
            precio=Double.parseDouble(tableModel.getValueAt(i,4).toString());
            total+=precio;
        }

        iva=total*0.12;
        pagar=iva+total;
        ivaTXT.setText(""+redondearDecimales(iva,2));
        totalTxt.setText(""+redondearDecimales(pagar,2));
    }
    //FUNCION PARA REDONDEAR SOLAMENTE A 2 DECIMALES
    private   double redondearDecimales(double valorInicial, int numeroDecimales) {
        double parteEntera, resultado;
        resultado = valorInicial;
        parteEntera = Math.floor(resultado);
        resultado=(resultado-parteEntera)*Math.pow(10, numeroDecimales);
        resultado=Math.round(resultado);
        resultado=(resultado/Math.pow(10, numeroDecimales))+parteEntera;
        return resultado;
    }
    //FUNCION PARA ELIMINAR UNA FILA EN CASO DE YA NO QUERE UN PRODUCTO
    private void removerFila( ){

        int fsel;

        try{
            fsel=table1.getSelectedRow();
            if (fsel==-1){
                JOptionPane.showMessageDialog(null,"Seleccione el producto!","Advertencia",JOptionPane.WARNING_MESSAGE);
            }else {

                String id = (String) tableModel.getValueAt(fsel,0);
                int cant = Integer.parseInt((String) tableModel.getValueAt(fsel,2));
                System.out.printf("id>>>>"+id+">>>>"+cant);
                stocks.set(indice(id),stocks.get(indice(id))+cant);


               tableModel.removeRow(fsel);


            }

        }catch (Exception e ){
            System.out.println(e);
        }
    }

    //FUNCION PARA BUSCAR LA POSICION DEL STOCK DEL PRODUCTO Y ASI REACERLO
    private  int indice(String id){

        int cont=0;

        for(String a: IdProductos){
            if (a.equals(id)){
                return cont;
            }else {
                cont++;
            }
        }
        return -1;
    }
    //FUNCION PARA REGRESAR AL MENU
    private void ventanaMenuCajero(){
        MenuCajero menuCajero = new MenuCajero(cedula,rol);
        this.dispose();
    }
    ////FUNCION PARA INGRESAR UN PRODUCTRO A LOS DETALLES DE LA FACTURA
    private   void newFila(){

        int op = comboBox1.getSelectedIndex();

        String cantidad = cantidadTXT.getText();

        boolean comprobacion=comprobar(cantidad);

        if (op==0){
            JOptionPane.showMessageDialog(null,"Elige un producto.","Advertencia",JOptionPane.WARNING_MESSAGE);
        }else {

            int cantidad2=Integer.parseInt(cantidad);

            if (!comprobacion ){
                JOptionPane.showMessageDialog(null,"Cantidad incorrecta.","Error",JOptionPane.ERROR_MESSAGE);
            }else {
                if(cantidad2<1 ){
                    JOptionPane.showMessageDialog(null,"Cantidad incorrecta.","Error",JOptionPane.ERROR_MESSAGE);
                }else {
                    try{

                        Connection conn= DriverManager.getConnection("jdbc:mysql://mysql-kevin2008.alwaysdata.net/kevin2008_farmacia?serverTimezone=UTC",
                                "kevin2008","LDU2010ldu");
                        Statement stmt= conn.createStatement();
                        String sql="SELECT ID_PRODUCTO,NOMBRE_PRODUCTO,PRECIO_PRODUCTO,STOCK FROM PRODUCTOS where ID_PRODUCTO=?";

                        PreparedStatement pst=conn.prepareStatement(sql);

                        pst.setString(1,IdProductos.get(op));

                        ResultSet rs=pst.executeQuery();
                        rs.next();
                        int stock;

                        stock=Integer.parseInt(rs.getString(4));



                        if( stocks.get(op)>=Integer.parseInt(cantidadTXT.getText()) ){

                            Object [] nuevaFila = new Object[5];


                            nuevaFila[0]=rs.getString(1);
                            nuevaFila[1]=rs.getString(2);
                            nuevaFila[2]=cantidadTXT.getText();
                            nuevaFila[3]=rs.getString(3);

                            double totaldetalle = Double.parseDouble((String)nuevaFila[2])*Double.parseDouble((String)nuevaFila[3]);

                            nuevaFila[4]= ""+totaldetalle;

                            tableModel.addRow(nuevaFila);

                            stmt.close();
                            conn.close();

                            stocks.set(op,stocks.get(op)-Integer.parseInt(cantidadTXT.getText()));





                        }else{

                            JOptionPane.showMessageDialog(null,"Stock no dispobible.\n" +
                                    "Stock dispobilbe: "+stocks.get(comboBox1.getSelectedIndex()),"Error",JOptionPane.WARNING_MESSAGE);
                        }

                        cantidadTXT.setText("1");
                        comboBox1.setSelectedIndex(0);


                    } catch(SQLException ex){
                        ex.printStackTrace();
                        System.out.println("SQL incorrecto");

                    }
                }

            }
        }
    }
    //FUNCION PARA COMPROBAR SI EL DATO DE ENTRADA ES NUMERO
    private Boolean comprobar(String numero){
        try{

            Integer.parseInt(numero);

            return true;

        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }
    //FUNCION PARA CREAR EL MODELO DE LA TABLA
    private   void  createtable(){
        tableModel= new DefaultTableModel(null,columnas());
        table1.setModel(tableModel);
        table1.setBackground(Color.LIGHT_GRAY);
        table1.setGridColor(Color.white);
        table1.setRowHeight(30);
    }
    //FUNCION PARA CREAR LAS COLUMNAS DE LA TABLA
    private static Vector<String> columnas(){
        Vector<String> columnNames = new Vector<String>();
        columnNames.add("ID");
        columnNames.add("PRODUCTO");
        columnNames.add("CANTIDAD");
        columnNames.add("PRECIO UNITARIO");
        columnNames.add("TOTAL PARCIAL");
        return columnNames;
    }

}
