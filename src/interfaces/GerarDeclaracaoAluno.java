
package interfaces;

import sql.DeclaracaoDAO;
import javax.swing.ImageIcon;

/**
 *
 * @author mayck
 */
public class GerarDeclaracaoAluno extends javax.swing.JDialog {

    int row = Main.jTableMain.getSelectedRow();
    String linhaProjeto = Main.jTableMain.getValueAt(row, 0).toString();
    
    public GerarDeclaracaoAluno(java.awt.Frame parent, boolean modal){
        super(parent, modal);
        initComponents();
        if(jbAutomatico.isSelected())
        {
            mesInicio.setEnabled(false);
            mesFim.setEnabled(false);
        }else{
            mesInicio.setEnabled(true);
            mesFim.setEnabled(true);
        }
    }
      public void emitirDeclaracao()
      {   
            DeclaracaoDAO declaracao = new DeclaracaoDAO();
            //declaracao.geraDeclaracaoAluno(linhaProjeto, mesInicio.getMonth(),mesFim.getMonth());
            Main.limparProjeto();
       
      }
      public void emitirDeclaracaoComBolsa()
      {   
            DeclaracaoDAO declaracao = new DeclaracaoDAO();
            //declaracao.geraDeclaracaoAlunoValor(linhaProjeto, mesInicio.getMonth(),mesFim.getMonth(),txtBolsa.getText());
            Main.limparProjeto();
       
      }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgroupPeriodo = new javax.swing.ButtonGroup();
        titulo = new javax.swing.JLabel();
        nomeAluno1 = new javax.swing.JLabel();
        txtAluno = new javax.swing.JTextField();
        nomeOrientador = new javax.swing.JLabel();
        txtOrientador = new javax.swing.JTextField();
        jLabelperiodo = new javax.swing.JLabel();
        jbAutomatico = new javax.swing.JRadioButton();
        jbManual = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        mesFim = new com.toedter.calendar.JMonthChooser();
        mesInicio = new com.toedter.calendar.JMonthChooser();
        inicioLabel = new javax.swing.JLabel();
        inicioLabel1 = new javax.swing.JLabel();
        labelBolsa = new javax.swing.JLabel();
        txtBolsa = new javax.swing.JFormattedTextField();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerar certificado");
        setIconImage(new ImageIcon(getClass().getResource("/imagens/icon.png")).getImage());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        titulo.setBackground(new java.awt.Color(204, 204, 204));
        titulo.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("Gerar declaração");
        titulo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        titulo.setOpaque(true);
        getContentPane().add(titulo);
        titulo.setBounds(-10, -10, 430, 70);

        nomeAluno1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        nomeAluno1.setText("Aluno");
        getContentPane().add(nomeAluno1);
        nomeAluno1.setBounds(30, 80, 110, 20);

        txtAluno.setEnabled(false);
        getContentPane().add(txtAluno);
        txtAluno.setBounds(30, 100, 350, 30);

        nomeOrientador.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        nomeOrientador.setText("Orientador");
        getContentPane().add(nomeOrientador);
        nomeOrientador.setBounds(30, 140, 110, 20);

        txtOrientador.setEnabled(false);
        getContentPane().add(txtOrientador);
        txtOrientador.setBounds(30, 160, 350, 30);

        jLabelperiodo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelperiodo.setText("Período");
        getContentPane().add(jLabelperiodo);
        jLabelperiodo.setBounds(30, 200, 80, 20);

        bgroupPeriodo.add(jbAutomatico);
        jbAutomatico.setSelected(true);
        jbAutomatico.setText("Automático");
        jbAutomatico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAutomaticoActionPerformed(evt);
            }
        });
        getContentPane().add(jbAutomatico);
        jbAutomatico.setBounds(30, 220, 90, 23);

        bgroupPeriodo.add(jbManual);
        jbManual.setText("Manual");
        jbManual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbManualActionPerformed(evt);
            }
        });
        getContentPane().add(jbManual);
        jbManual.setBounds(120, 220, 90, 20);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/declaracao.png"))); // NOI18N
        jButton1.setText("Gerar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(300, 300, 100, 30);

        mesFim.setOpaque(false);
        getContentPane().add(mesFim);
        mesFim.setBounds(150, 260, 110, 30);

        mesInicio.setMonth(7);
        mesInicio.setOpaque(false);
        getContentPane().add(mesInicio);
        mesInicio.setBounds(30, 260, 130, 30);

        inicioLabel.setText("Início");
        getContentPane().add(inicioLabel);
        inicioLabel.setBounds(30, 240, 90, 20);

        inicioLabel1.setText("Término");
        getContentPane().add(inicioLabel1);
        inicioLabel1.setBounds(150, 240, 100, 20);

        labelBolsa.setText("Valor da bolsa");
        getContentPane().add(labelBolsa);
        labelBolsa.setBounds(300, 240, 80, 20);

        try {
            txtBolsa.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###,##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(txtBolsa);
        txtBolsa.setBounds(300, 260, 70, 30);

        bg.setBackground(new java.awt.Color(236, 236, 236));
        bg.setOpaque(true);
        getContentPane().add(bg);
        bg.setBounds(-10, 60, 440, 290);

        setSize(new java.awt.Dimension(426, 378));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        txtAluno.setText(Main.jTableMain.getValueAt(row, 1).toString());
        txtOrientador.setText(Main.jTableMain.getValueAt(row, 4).toString());
    }//GEN-LAST:event_formWindowOpened

    private void jbAutomaticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAutomaticoActionPerformed
        mesInicio.setEnabled(false);
            mesFim.setEnabled(false);
    }//GEN-LAST:event_jbAutomaticoActionPerformed

    private void jbManualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbManualActionPerformed
       mesInicio.setEnabled(true);
            mesFim.setEnabled(true);
    }//GEN-LAST:event_jbManualActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            if(txtBolsa.getText().equals("   ,  "))
            {
                emitirDeclaracao();
            }else{
                emitirDeclaracaoComBolsa();
            }
            dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GerarDeclaracaoAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GerarDeclaracaoAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GerarDeclaracaoAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GerarDeclaracaoAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GerarDeclaracaoAluno dialog = null;                
                    dialog = new GerarDeclaracaoAluno(new javax.swing.JFrame(), true);
                    dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.ButtonGroup bgroupPeriodo;
    private javax.swing.JLabel inicioLabel;
    private javax.swing.JLabel inicioLabel1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabelperiodo;
    private javax.swing.JRadioButton jbAutomatico;
    private javax.swing.JRadioButton jbManual;
    private javax.swing.JLabel labelBolsa;
    private com.toedter.calendar.JMonthChooser mesFim;
    private com.toedter.calendar.JMonthChooser mesInicio;
    private javax.swing.JLabel nomeAluno1;
    private javax.swing.JLabel nomeOrientador;
    private javax.swing.JLabel titulo;
    private javax.swing.JTextField txtAluno;
    private javax.swing.JFormattedTextField txtBolsa;
    private javax.swing.JTextField txtOrientador;
    // End of variables declaration//GEN-END:variables
}
