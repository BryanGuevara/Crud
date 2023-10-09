package ventanas;

import clases.Conexiones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class Ventana extends javax.swing.JFrame {

    DefaultTableModel model = new DefaultTableModel();

    public Ventana() {
        initComponents();

        this.setLocationRelativeTo(null);
        setTitle("Alumnos");

        Student = new JTable(model);
        jScrollPane1.setViewportView(Student);

        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Birthday");
        model.addColumn("Address");
        Reinicio();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TxtNombre = new javax.swing.JTextField();
        TxtBirthday = new javax.swing.JTextField();
        Txtid = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Student = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        TxtAddress = new javax.swing.JTextField();
        TxtBuscar = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("ID");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jLabel3.setText("Birthday");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        jLabel4.setText("Nombre");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));
        getContentPane().add(TxtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 270, -1));
        getContentPane().add(TxtBirthday, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 270, -1));
        getContentPane().add(Txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 270, -1));

        Student.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(Student);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 210, 560, 210));

        jButton1.setText("Añadir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 40, 200, 100));

        jButton2.setText("Editar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 140, 80, 30));

        jButton4.setText("Buscar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 140, 80, 30));

        jLabel5.setText("Address");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));
        getContentPane().add(TxtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 270, -1));

        TxtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtBuscarKeyReleased(evt);
            }
        });
        getContentPane().add(TxtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 176, 540, -1));

        jButton5.setText("Eliminar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 140, 80, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TxtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtBuscarKeyReleased
        String buscar = TxtBuscar.getText();

        if (!buscar.equals("")) {

            for (int i = 0; i < Student.getRowCount(); i++) {
                model.removeRow(i);
                i--;
            }
            try {

                Connection cn1 = Conexiones.conexion();
                PreparedStatement pst1 = cn1.prepareStatement(
                        "select ID, Nombre, Cumpleaños, address from students where "
                        + "Nombre LIKE'" + TxtBuscar.getText() + "%'");

                ResultSet rs1 = pst1.executeQuery();

                while (rs1.next()) {
                    Object[] fila = new Object[4];

                    for (int i = 0; i < 4; i++) {
                        fila[i] = rs1.getObject(i + 1);
                    }
                    model.addRow(fila);
                }

            } catch (Exception e) {
                System.err.println(e);
            }
        } else {

            for (int i = 0; i < Student.getRowCount(); i++) {
                model.removeRow(i);
                i--;
            }
            Reinicio();
        }

    }//GEN-LAST:event_TxtBuscarKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String nombre = TxtNombre.getText(), fecha = TxtBirthday.getText(), address = TxtAddress.getText();
        boolean solo = true;
        if (!nombre.equals("") && !fecha.equals("")) {
            solo = false;
        }

        if (solo = true) {
            try {

                Connection cnz = Conexiones.conexion();
                PreparedStatement pstz = cnz.prepareStatement(
                        "insert into students values(?,?,?,?)");

                pstz.setString(1, "0");
                pstz.setString(2, nombre);
                pstz.setString(3, fecha);
                pstz.setString(4, address);

                pstz.executeUpdate();
                cnz.close();
            } catch (Exception e) {
                System.out.println(e);
            }
            JOptionPane.showMessageDialog(null, "Objeto añadido exitosamente");

            for (int i = 0; i < Student.getRowCount(); i++) {
                model.removeRow(i);
                i--;
            }
            Reinicio();
        } else {

        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String id = Txtid.getText();
        boolean solo = true;

        if (!id.equals("")) {
            solo = false;
        }
        if(solo=true){
        try {

            Connection cn1 = Conexiones.conexion();
            PreparedStatement pst1 = cn1.prepareStatement(
                    "select ID, Nombre, Cumpleaños, address from students where "
                    + "id ='" + Txtid.getText() + "'");

            ResultSet rs1 = pst1.executeQuery();
            if (rs1.next()) {

                TxtNombre.setText(rs1.getString("Nombre"));
                TxtBirthday.setText(rs1.getString("Cumpleaños"));
                TxtAddress.setText(rs1.getString("Address"));
            }

            for (int i = 0; i < Student.getRowCount(); i++) {
                model.removeRow(i);
                i--;
            }
            Reinicio();
        } catch (Exception e) {
            System.err.println(e);
        }}

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String nombre = TxtNombre.getText(), birthday = TxtBirthday.getText(), add = TxtAddress.getText();
        boolean solo = true;

        if (!nombre.equals("") && !birthday.equals("")) {
            solo = false;
        }
        if (solo = true) {
            try {

                Connection cnz = Conexiones.conexion();
                PreparedStatement pstz = cnz.prepareStatement(
                        "update students set Nombre=?, Cumpleaños=?, address=? where ID = '" + Txtid.getText() + "'");

                pstz.setString(1, nombre);
                pstz.setString(2, birthday);
                pstz.setString(3, add);

                pstz.executeUpdate();
                cnz.close();
            } catch (Exception e) {
                System.out.println(e);
            }
            JOptionPane.showMessageDialog(null, "Actualizacion exitosa");
            for (int i = 0; i < Student.getRowCount(); i++) {
                model.removeRow(i);
                i--;
            }
            Reinicio();
        } else {
            JOptionPane.showMessageDialog(null, "Porfavor llene los campos obligatorios");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String nombre = TxtNombre.getText(), birthday = TxtBirthday.getText(), add = TxtAddress.getText();
        boolean solo = true;

        if (!nombre.equals("") && !birthday.equals("")) {
            solo = false;
        }
        try {

            Connection cnz = Conexiones.conexion();
            PreparedStatement pstz = cnz.prepareStatement(
                    "delete from students where ID = '" + Txtid.getText() + "'");

            TxtAddress.setText("");
            TxtBirthday.setText("");
            TxtNombre.setText("");
            Txtid.setText("");

            for (int i = 0; i < Student.getRowCount(); i++) {
                model.removeRow(i);
                i--;
            }
            Reinicio();

            pstz.executeUpdate();
            cnz.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Ventana().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Student;
    private javax.swing.JTextField TxtAddress;
    private javax.swing.JTextField TxtBirthday;
    private javax.swing.JTextField TxtBuscar;
    private javax.swing.JTextField TxtNombre;
    private javax.swing.JTextField Txtid;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
private void Reinicio() {

        try {

            Connection cn1 = Conexiones.conexion();
            PreparedStatement pst1 = cn1.prepareStatement(
                    "select ID, Nombre, Cumpleaños, address from students");

            ResultSet rs1 = pst1.executeQuery();

            while (rs1.next()) {
                Object[] fila = new Object[5];

                for (int i = 0; i < 4; i++) {
                    fila[i] = rs1.getObject(i + 1);

                }
                model.addRow(fila);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
