package interfaces;

import static db.DAO.conexao;
import static db.DAO.instrucao;
import static db.DAO.resultado;
import modelos.Projeto;
import sql.AlunoDAO;
import sql.ProjetoDAO;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author mayck
 */
public class NovoAluno extends javax.swing.JDialog {

    
    static ArrayList<Integer> idAlunos = new ArrayList<Integer>();
    int idAluno = 0;
    public NovoAluno(java.awt.Frame parent, boolean modal) 
    {
        super(parent, modal);
        initComponents();
        populaComboBoxAluno();
    }
    
    public static void populaComboBoxAluno()
    {
        idAlunos.clear();
        try 
        {
            instrucao = conexao.prepareStatement("SELECT id_aluno, nome_aluno,curso_aluno FROM aluno WHERE NOT EXISTS (select * from projeto where vigencia_projeto = '" + AlterarProjeto.TxtVigencia.getText() + "' and (id_aluno = aluno1_id or id_aluno = aluno2_id)) and aluno_excluido = 0 order by nome_aluno");
            resultado = instrucao.executeQuery();
            
            while (resultado.next())
            {
                idAlunos.add(Integer.parseInt(resultado.getString("id_aluno"))); 
                jComboNovoAluno.addItem(resultado.getString("nome_aluno")   + " - " + resultado.getString("curso_aluno"));                
            }
            
        } catch (SQLException e) 
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
    
    public void atualizaAluno()
    {        
        ProjetoDAO pro = new ProjetoDAO();
        AlunoDAO a = new AlunoDAO();
        Projeto p = new Projeto();
        try 
        {
                
                
                idAluno = idAlunos.get(jComboNovoAluno.getSelectedIndex());
                
                p.setAluno2(idAluno);
                p.setModalidadeAluno2(String.valueOf(JComboBoxModalidadeAluno2.getSelectedItem()));
                pro.atualizarProjetoSegundoAluno(p, Main.linhaProjeto);
                Main.JRbALuno.setSelected(true);
                a.getAluno("");
                
                
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        dispose();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nomeAluno = new javax.swing.JLabel();
        jComboNovoAluno = new javax.swing.JComboBox<>();
        jbCriar = new javax.swing.JButton();
        modalidadeAlluno = new javax.swing.JLabel();
        JComboBoxModalidadeAluno2 = new javax.swing.JComboBox<>();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Adicionar segundo aluno");
        setIconImage(new ImageIcon(getClass().getResource("/imagens/icon.png")).getImage());
        setResizable(false);
        getContentPane().setLayout(null);

        nomeAluno.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        nomeAluno.setText("Novo aluno");
        getContentPane().add(nomeAluno);
        nomeAluno.setBounds(20, 20, 110, 20);

        jComboNovoAluno.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboNovoAlunoItemStateChanged(evt);
            }
        });
        getContentPane().add(jComboNovoAluno);
        jComboNovoAluno.setBounds(20, 40, 380, 30);

        jbCriar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jbCriar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/adicionar.png"))); // NOI18N
        jbCriar.setText("Adicionar");
        jbCriar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCriarActionPerformed(evt);
            }
        });
        jbCriar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jbCriarKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jbCriarKeyTyped(evt);
            }
        });
        getContentPane().add(jbCriar);
        jbCriar.setBounds(420, 80, 120, 30);

        modalidadeAlluno.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        modalidadeAlluno.setText("Modalidade");
        getContentPane().add(modalidadeAlluno);
        modalidadeAlluno.setBounds(400, 20, 140, 20);

        JComboBoxModalidadeAluno2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PIBIC/IF Goiano", "PIBIC/CNPq", "PIVIC/IF Goiano", "PIBITI/IF Goiano", "PIBITI/CNPq", "PIVITI/IF Goiano", "PIBIC Jr/IF Goiano", "PIBIC Jr/CNPq", "PIVIC Jr/IF Goiano" }));
        JComboBoxModalidadeAluno2.setSelectedItem("PIVIC/IF Goiano");
        JComboBoxModalidadeAluno2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JComboBoxModalidadeAluno2ActionPerformed(evt);
            }
        });
        getContentPane().add(JComboBoxModalidadeAluno2);
        JComboBoxModalidadeAluno2.setBounds(400, 40, 140, 30);

        bg.setBackground(new java.awt.Color(236, 236, 236));
        bg.setOpaque(true);
        getContentPane().add(bg);
        bg.setBounds(0, 0, 560, 140);

        setSize(new java.awt.Dimension(567, 165));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbCriarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCriarActionPerformed
        atualizaAluno();
    }//GEN-LAST:event_jbCriarActionPerformed

    private void jbCriarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbCriarKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            atualizaAluno();
        }
    }//GEN-LAST:event_jbCriarKeyPressed

    private void jbCriarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbCriarKeyTyped
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            atualizaAluno();
        }
    }//GEN-LAST:event_jbCriarKeyTyped

    private void JComboBoxModalidadeAluno2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JComboBoxModalidadeAluno2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JComboBoxModalidadeAluno2ActionPerformed

    private void jComboNovoAlunoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboNovoAlunoItemStateChanged
        idAluno = idAlunos.get(jComboNovoAluno.getSelectedIndex());
    }//GEN-LAST:event_jComboNovoAlunoItemStateChanged

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
            java.util.logging.Logger.getLogger(NovoAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NovoAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NovoAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NovoAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NovoAluno dialog = new NovoAluno(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<String> JComboBoxModalidadeAluno2;
    private javax.swing.JLabel bg;
    public static javax.swing.JComboBox<String> jComboNovoAluno;
    private javax.swing.JButton jbCriar;
    private javax.swing.JLabel modalidadeAlluno;
    private javax.swing.JLabel nomeAluno;
    // End of variables declaration//GEN-END:variables
}