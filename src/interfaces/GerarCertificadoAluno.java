
package interfaces;

import static db.DAO.conexao;
import static db.DAO.instrucao;
import static db.DAO.resultado;
import modelos.FixedLengthDocument;
import sql.CertificadoDAO;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author mayck
 */
public class GerarCertificadoAluno extends javax.swing.JDialog {

    int row = Main.jTableMain.getSelectedRow();
    String linhaProjeto = Main.jTableMain.getValueAt(row, 0).toString();
    
    public GerarCertificadoAluno(java.awt.Frame parent, boolean modal) throws ParseException {
        super(parent, modal);
        initComponents();
        
        if(jbAutomatico.isSelected())
        {
            txtPeriodo.setEnabled(false);
        }else{
            txtPeriodo.setEnabled(true);
        }
        
        if(jbAutomatico1.isSelected())
        {
            txtRegistro.setEnabled(false);
        }else{
            txtRegistro.setEnabled(true);
        }
        //String periodo = geraPeriodo();
        txtPeriodo.setText(geraPeriodo());        
    
        populaNRegistro();
    }
    
    public void populaNRegistro()
    {
      try
        {
            instrucao = conexao.prepareStatement("SELECT max(nregistro) + 1  as nregistro from registro");
            resultado = instrucao.executeQuery();
            resultado.first();
            int nregistropopula = resultado.getInt("nregistro");
            txtRegistro.setText(String.format("%06d", nregistropopula));
            resultado.close();
            instrucao.close();
        }
        catch( SQLException e )
        {
            if(e instanceof com.mysql.jdbc.exceptions.jdbc4.CommunicationsException)
            {              
                JOptionPane.showMessageDialog(null, "Sua sessão expirou, faça o login novamente!");
                System.exit(0);
            }else
            {
                JOptionPane.showMessageDialog(null, e);                
            }
        }
    }
    
    public String geraPeriodo() throws ParseException
    {
        
        
        String vigencia = Main.jTableMain.getValueAt(row, 5).toString();
        String pro = vigencia;
        int um;
        int dois;
        um = pro.indexOf("2");
        dois = pro.lastIndexOf("-");
        String inicio = (pro.substring(um, dois));
        
        int tres;
        tres = pro.indexOf("-2");
        String fim = (pro.substring(tres + 1));
        
        String id_aluno = Main.jTableMain.getValueAt(row, 17).toString();
        String id_aluno1 = Main.jTableMain.getValueAt(row, 18).toString();
        String aluno1Substituto = Main.jTableMain.getValueAt(row, 15).toString();
        String aluno2Substituto = Main.jTableMain.getValueAt(row, 16).toString();
        
        Date data_aluno;
        String periodo;
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        
        
        if (id_aluno.equals(id_aluno1))
        {
            data_aluno = formato.parse(Main.jTableMain.getValueAt(row, 21).toString());  
            
            if(aluno1Substituto.equals("1"))
            {
                periodo = formato.format(data_aluno) + " a " + "31/07/" + fim; 
            }else
            {
                 periodo = "01/08/" + inicio + " a " + "31/07/" + fim; 
            }
            return periodo;
            
        }else
        {
            data_aluno = formato.parse(Main.jTableMain.getValueAt(row, 22).toString());
            
            if(aluno2Substituto.equals("1"))
            {
                periodo = formato.format(data_aluno) + " a " + "31/07/" + fim; 
            }else
            {
                 periodo = "01/08/" + inicio + " a " + "31/07/" + fim; 
            }
            return periodo;
        }
        
    }
    
      public void gerarCertificado() throws ParseException
      {   
        try 
        {
            CertificadoDAO certificado = new CertificadoDAO();
            certificado.geraCertificadoAluno(linhaProjeto, txtPeriodo.getText(),Integer.parseInt(txtRegistro.getText()));
            Main.limparProjeto();
        } catch (ParseException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
       
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
        bgroupRegistro = new javax.swing.ButtonGroup();
        titulo = new javax.swing.JLabel();
        nomeAluno1 = new javax.swing.JLabel();
        txtAluno = new javax.swing.JTextField();
        nomeOrientador = new javax.swing.JLabel();
        txtOrientador = new javax.swing.JTextField();
        jLabelperiodo = new javax.swing.JLabel();
        txtPeriodo = new javax.swing.JTextField();
        jbAutomatico = new javax.swing.JRadioButton();
        jbManual = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        txtRegistro = new javax.swing.JTextField();
        jbManual1 = new javax.swing.JRadioButton();
        jbAutomatico1 = new javax.swing.JRadioButton();
        nRegistro = new javax.swing.JLabel();
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
        titulo.setText("Gerar certificado");
        titulo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        titulo.setOpaque(true);
        getContentPane().add(titulo);
        titulo.setBounds(-10, -10, 440, 70);

        nomeAluno1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        nomeAluno1.setText("Aluno");
        getContentPane().add(nomeAluno1);
        nomeAluno1.setBounds(40, 150, 110, 20);

        txtAluno.setEnabled(false);
        getContentPane().add(txtAluno);
        txtAluno.setBounds(40, 170, 350, 30);

        nomeOrientador.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        nomeOrientador.setText("Orientador");
        getContentPane().add(nomeOrientador);
        nomeOrientador.setBounds(40, 210, 110, 20);

        txtOrientador.setEnabled(false);
        getContentPane().add(txtOrientador);
        txtOrientador.setBounds(40, 230, 350, 30);

        jLabelperiodo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelperiodo.setText("Período");
        getContentPane().add(jLabelperiodo);
        jLabelperiodo.setBounds(40, 270, 80, 20);

        txtPeriodo.setDocument(new FixedLengthDocument(25));
        txtPeriodo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPeriodoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPeriodoKeyTyped(evt);
            }
        });
        getContentPane().add(txtPeriodo);
        txtPeriodo.setBounds(40, 310, 210, 30);

        bgroupPeriodo.add(jbAutomatico);
        jbAutomatico.setSelected(true);
        jbAutomatico.setText("Automático");
        jbAutomatico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAutomaticoActionPerformed(evt);
            }
        });
        getContentPane().add(jbAutomatico);
        jbAutomatico.setBounds(40, 290, 90, 23);

        bgroupPeriodo.add(jbManual);
        jbManual.setText("Manual");
        jbManual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbManualActionPerformed(evt);
            }
        });
        getContentPane().add(jbManual);
        jbManual.setBounds(130, 290, 90, 20);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/certificado2.png"))); // NOI18N
        jButton1.setText("Gerar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(300, 370, 100, 30);

        txtRegistro.setDocument(new FixedLengthDocument(6));
        txtRegistro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtRegistroFocusGained(evt);
            }
        });
        txtRegistro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRegistroKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRegistroKeyTyped(evt);
            }
        });
        getContentPane().add(txtRegistro);
        txtRegistro.setBounds(40, 110, 90, 30);

        bgroupRegistro.add(jbManual1);
        jbManual1.setText("Manual");
        jbManual1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbManual1ActionPerformed(evt);
            }
        });
        getContentPane().add(jbManual1);
        jbManual1.setBounds(130, 90, 90, 20);

        bgroupRegistro.add(jbAutomatico1);
        jbAutomatico1.setSelected(true);
        jbAutomatico1.setText("Automático");
        jbAutomatico1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAutomatico1ActionPerformed(evt);
            }
        });
        getContentPane().add(jbAutomatico1);
        jbAutomatico1.setBounds(40, 90, 90, 23);

        nRegistro.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        nRegistro.setText("Nº Registro");
        getContentPane().add(nRegistro);
        nRegistro.setBounds(40, 70, 110, 20);

        bg.setBackground(new java.awt.Color(236, 236, 236));
        bg.setOpaque(true);
        getContentPane().add(bg);
        bg.setBounds(-10, 60, 440, 360);

        setSize(new java.awt.Dimension(426, 445));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        txtAluno.setText(Main.jTableMain.getValueAt(row, 1).toString());
        txtOrientador.setText(Main.jTableMain.getValueAt(row, 4).toString());
    }//GEN-LAST:event_formWindowOpened

    private void txtPeriodoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPeriodoKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            try {
                gerarCertificado();
            } catch (ParseException ex) {
                Logger.getLogger(GerarCertificadoAluno.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_txtPeriodoKeyPressed

    private void txtPeriodoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPeriodoKeyTyped
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            try {
                gerarCertificado();
            } catch (ParseException ex) {
                Logger.getLogger(GerarCertificadoAluno.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_txtPeriodoKeyTyped

    private void jbAutomaticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAutomaticoActionPerformed
        txtPeriodo.setEnabled(false);
    }//GEN-LAST:event_jbAutomaticoActionPerformed

    private void jbManualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbManualActionPerformed
        txtPeriodo.setEnabled(true);
    }//GEN-LAST:event_jbManualActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try 
        {
            gerarCertificado();
            dispose();
        } catch (ParseException ex) {
            Logger.getLogger(GerarCertificadoAluno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtRegistroFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRegistroFocusGained
       
    }//GEN-LAST:event_txtRegistroFocusGained

    private void txtRegistroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRegistroKeyPressed
      
    }//GEN-LAST:event_txtRegistroKeyPressed

    private void txtRegistroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRegistroKeyTyped
       
    }//GEN-LAST:event_txtRegistroKeyTyped

    private void jbManual1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbManual1ActionPerformed
        txtRegistro.setEnabled(true);
    }//GEN-LAST:event_jbManual1ActionPerformed

    private void jbAutomatico1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAutomatico1ActionPerformed
        txtRegistro.setEnabled(false);
    }//GEN-LAST:event_jbAutomatico1ActionPerformed

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
            java.util.logging.Logger.getLogger(GerarCertificadoAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GerarCertificadoAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GerarCertificadoAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GerarCertificadoAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                GerarCertificadoAluno dialog = null;
                try {
                    dialog = new GerarCertificadoAluno(new javax.swing.JFrame(), true);
                } catch (ParseException ex) {
                    Logger.getLogger(GerarCertificadoAluno.class.getName()).log(Level.SEVERE, null, ex);
                }
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
    private javax.swing.ButtonGroup bgroupRegistro;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabelperiodo;
    private javax.swing.JRadioButton jbAutomatico;
    private javax.swing.JRadioButton jbAutomatico1;
    private javax.swing.JRadioButton jbManual;
    private javax.swing.JRadioButton jbManual1;
    private javax.swing.JLabel nRegistro;
    private javax.swing.JLabel nomeAluno1;
    private javax.swing.JLabel nomeOrientador;
    private javax.swing.JLabel titulo;
    private javax.swing.JTextField txtAluno;
    private javax.swing.JTextField txtOrientador;
    private javax.swing.JTextField txtPeriodo;
    private javax.swing.JTextField txtRegistro;
    // End of variables declaration//GEN-END:variables
}
