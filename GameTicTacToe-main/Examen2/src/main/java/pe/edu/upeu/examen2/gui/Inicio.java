/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pe.edu.upeu.examen2.gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import pe.edu.upeu.examen2.dao.ResultadoDAO;
import pe.edu.upeu.examen2.dao.ResultadoDaoI;
import pe.edu.upeu.examen2.modelo.ResultadoTO;
import pe.edu.upeu.examen2.util.MsgBox;
import pe.edu.upeu.examen2.util.UtilsX;

/**
 *
 * @author HP
 */
public class Inicio extends javax.swing.JFrame {

    private JLabel[][] casillas;
    //private ModelGame model;
    ResultadoDaoI rDao;
    public static ResultadoTO uTO = new ResultadoTO();
    DefaultTableModel modelo;
    MsgBox msg;
    TableRowSorter<TableModel> trsfiltro;
    BufferedImage image;
    UtilsX obj = new UtilsX();

    public Inicio() {
        initComponents();

        //Titulo
        this.setTitle("Examen unidad II ");
        //Icono
        try {
            image = ImageIO.read(obj.getFile("icono.jpg"));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        this.setIconImage(image);

        //Tamaño
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(new Dimension(screenSize.width, screenSize.height));

        casillas = new JLabel[3][3];
        asignarCasillas();
        ListarResultado();
    }

    public void ListarResultado() {
        rDao = new ResultadoDAO();
        List<ResultadoTO> listarResultado = rDao.listarResultado();
        jTable1.setAutoCreateRowSorter(true);
        modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setNumRows(0);
        Object[] ob = new Object[7];
        for (int i = 0; i < listarResultado.size(); i++) {
            ob[0] = listarResultado.get(i).getNombrePartida();
            ob[1] = listarResultado.get(i).getIdResultado();
            ob[2] = listarResultado.get(i).getNombreJugador1();
            ob[3] = listarResultado.get(i).getNombreJugador2();
            ob[4] = listarResultado.get(i).getGanador();
            ob[5] = listarResultado.get(i).getPunto();
            ob[6] = listarResultado.get(i).getEstado();
            modelo.addRow(ob);
        }
        jTable1.setModel(modelo);
    }

    private void paintForm() {
        if (jTable1.getSelectedRow() != -1) {
            modelo = (DefaultTableModel) jTable1.getModel();
            int rowx = jTable1.getSelectedRow();
            Object valor = jTable1.getValueAt(rowx, 1);
            rDao = new ResultadoDAO();
            ResultadoTO d = rDao.buscarResultado(Integer.parseInt(valor.toString()));
            txtIdResultado.setText(String.valueOf(d.getIdResultado()));
            txtJugador1.setText(d.getNombreJugador1());
            txtJugador2.setText(d.getNombreJugador2());
        } else {
            txtNombrePartida.setVisible(false);
        }
    }

    public void resetForm() {
        txtIdResultado.setText("sd");
        txtJugador1.setText("O");
        txtJugador2.setText("X");
        txtJugador1.requestFocus();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbtnExit = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        victoriasJ1 = new javax.swing.JLabel();
        victoriasJ2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        cuadra1 = new javax.swing.JLabel();
        cuadra2 = new javax.swing.JLabel();
        cuadra3 = new javax.swing.JLabel();
        cuadra4 = new javax.swing.JLabel();
        cuadra5 = new javax.swing.JLabel();
        cuadra6 = new javax.swing.JLabel();
        cuadra7 = new javax.swing.JLabel();
        cuadra8 = new javax.swing.JLabel();
        cuadra9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtJugador1 = new javax.swing.JTextField();
        txtJugador2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnIniciar = new javax.swing.JButton();
        btnAnular = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbtnExit.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jbtnExit.setText("Salir");
        jbtnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnExitActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 10, 100, 40));

        jPanel3.setBackground(new java.awt.Color(255, 204, 255));
        jPanel3.setForeground(new java.awt.Color(102, 0, 102));

        victoriasJ1.setBackground(new java.awt.Color(204, 255, 255));
        victoriasJ1.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        victoriasJ1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        victoriasJ1.setText("0");
        victoriasJ1.setOpaque(true);

        victoriasJ2.setBackground(new java.awt.Color(204, 255, 255));
        victoriasJ2.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        victoriasJ2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        victoriasJ2.setText("0");
        victoriasJ2.setOpaque(true);

        jLabel6.setBackground(new java.awt.Color(255, 255, 204));
        jLabel6.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Player 1:");
        jLabel6.setOpaque(true);

        jLabel7.setBackground(new java.awt.Color(255, 255, 204));
        jLabel7.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Player 2:");
        jLabel7.setOpaque(true);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(victoriasJ1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(victoriasJ2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(victoriasJ1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(victoriasJ2))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 200, 120));

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cuadra1.setBackground(new java.awt.Color(204, 204, 255));
        cuadra1.setFont(new java.awt.Font("Serif", 1, 48)); // NOI18N
        cuadra1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cuadra1.setOpaque(true);

        cuadra2.setBackground(new java.awt.Color(204, 204, 255));
        cuadra2.setFont(new java.awt.Font("Serif", 1, 48)); // NOI18N
        cuadra2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cuadra2.setOpaque(true);

        cuadra3.setBackground(new java.awt.Color(204, 204, 255));
        cuadra3.setFont(new java.awt.Font("Serif", 1, 48)); // NOI18N
        cuadra3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cuadra3.setOpaque(true);

        cuadra4.setBackground(new java.awt.Color(204, 204, 255));
        cuadra4.setFont(new java.awt.Font("Serif", 1, 48)); // NOI18N
        cuadra4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cuadra4.setOpaque(true);

        cuadra5.setBackground(new java.awt.Color(204, 204, 255));
        cuadra5.setFont(new java.awt.Font("Serif", 1, 48)); // NOI18N
        cuadra5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cuadra5.setOpaque(true);

        cuadra6.setBackground(new java.awt.Color(204, 204, 255));
        cuadra6.setFont(new java.awt.Font("Serif", 1, 48)); // NOI18N
        cuadra6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cuadra6.setOpaque(true);

        cuadra7.setBackground(new java.awt.Color(204, 204, 255));
        cuadra7.setFont(new java.awt.Font("Serif", 1, 48)); // NOI18N
        cuadra7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cuadra7.setOpaque(true);

        cuadra8.setBackground(new java.awt.Color(204, 204, 255));
        cuadra8.setFont(new java.awt.Font("Serif", 1, 48)); // NOI18N
        cuadra8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cuadra8.setOpaque(true);

        cuadra9.setBackground(new java.awt.Color(204, 204, 255));
        cuadra9.setFont(new java.awt.Font("Serif", 1, 48)); // NOI18N
        cuadra9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cuadra9.setOpaque(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(cuadra7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(cuadra4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cuadra1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cuadra2, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(cuadra5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cuadra8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cuadra3, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(cuadra6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cuadra9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 4, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(cuadra3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(cuadra1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cuadra2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cuadra4, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(cuadra5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cuadra6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cuadra7, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(cuadra8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cuadra9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 4, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 260, 260));

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setForeground(new java.awt.Color(102, 0, 102));

        jLabel1.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jLabel1.setText("Alumno: Alessandro Pastor Mamani Mamani");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 550, 50));

        jLabel3.setBackground(new java.awt.Color(255, 204, 255));
        jLabel3.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jLabel3.setText("Player 1:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, -1, -1));

        jLabel4.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jLabel4.setText("Player 2:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, -1, 30));
        getContentPane().add(txtJugador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 110, 180, 30));
        getContentPane().add(txtJugador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 150, 180, 30));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre Partido ", "Id resultado", "Nombre Jugador 1", "Nombre Jugador 2", "Nombre Ganador", "Puntuacion", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(1).setMinWidth(0);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(0);
            jTable1.getColumnModel().getColumn(1).setMaxWidth(0);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 250, 560, 240));

        btnIniciar.setText("INICIAR");
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });
        getContentPane().add(btnIniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 190, -1, 40));

        btnAnular.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnAnular.setText("ANULAR");
        btnAnular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnularActionPerformed(evt);
            }
        });
        getContentPane().add(btnAnular, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 190, -1, 40));

        jLabel5.setFont(new java.awt.Font("Segoe UI Emoji", 1, 24)); // NOI18N
        jLabel5.setText("Datos :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, 90, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pastel.jpg"))); // NOI18N
        jLabel9.setText("jLabel9");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 620));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("NOMBRE JUGADOR 1:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 134, -1, -1));
        getContentPane().add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 537, 120, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnularActionPerformed

    }//GEN-LAST:event_btnAnularActionPerformed

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed

        uTO.setNombrePartida("Partida "+ uTO.getIdResultado());
        uTO.setNombreJugador1(txtJugador1.getText());
        uTO.setNombreJugador2(txtJugador2.getText());
        uTO.setGanador("");
        uTO.setPunto(0);
        uTO.setEstado("Jugando");
        rDao = new ResultadoDAO();

        int dx = rDao.create(uTO);
        uTO.setIdResultado(dx);
        lblNombre.setText(uTO.getNombreJugador1()+" (X)");
        ListarResultado();
    }//GEN-LAST:event_btnIniciarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        paintForm();
    }//GEN-LAST:event_jTable1MouseClicked

    private void jbtnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnExitActionPerformed
        Component frame = new JFrame("Salir");
        if (JOptionPane.showConfirmDialog(frame, "Saliendo del juego ", "Tic Tac Toe",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_jbtnExitActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnular;
    private javax.swing.JButton btnIniciar;
    private javax.swing.JLabel cuadra1;
    private javax.swing.JLabel cuadra2;
    private javax.swing.JLabel cuadra3;
    private javax.swing.JLabel cuadra4;
    private javax.swing.JLabel cuadra5;
    private javax.swing.JLabel cuadra6;
    private javax.swing.JLabel cuadra7;
    private javax.swing.JLabel cuadra8;
    private javax.swing.JLabel cuadra9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbtnExit;
    public javax.swing.JLabel lblNombre;
    private javax.swing.JTextField txtJugador1;
    private javax.swing.JTextField txtJugador2;
    private javax.swing.JLabel victoriasJ1;
    private javax.swing.JLabel victoriasJ2;
    // End of variables declaration//GEN-END:variables
//**Casillas de donde se pone cuadrados
    private void asignarCasillas() {
        casillas[0][0] = cuadra1;
        casillas[0][1] = cuadra2;
        casillas[0][2] = cuadra3;
        casillas[1][0] = cuadra4;
        casillas[1][1] = cuadra5;
        casillas[1][2] = cuadra6;
        casillas[2][0] = cuadra7;
        casillas[2][1] = cuadra8;
        casillas[2][2] = cuadra9;
    }
//**GETER Y SETER
    public JLabel[][] getCasillas() {
        return casillas;
    }

    public JLabel getVictoriasJ1() {
        return victoriasJ1;
    }

    public JLabel getVictoriasJ2() {
        return victoriasJ2;
    }

    public JButton getBotonReset() {
        return btnIniciar;
    }

    public JButton getBotonAnular() {
        return btnAnular;
    }
}
