package br.com.lojaoriodopeixe.visao;

import br.com.lojaoriodopeixe.controle.Calculadora;
import br.com.lojaoriodopeixe.controle.CalculadoraImpl;
import br.com.lojaoriodopeixe.utils.ParcTableModelAVista;
import br.com.lojaoriodopeixe.utils.Utils;
import java.awt.Color;
import java.awt.Component;
import java.awt.Toolkit;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author vagner
 */
public class CalculadoraAVistaViewer extends javax.swing.JFrame {

    ParcTableModelAVista f = new ParcTableModelAVista();
    Locale locBrazil = new Locale("pt", "BR");
    NumberFormat vProduto = NumberFormat.getInstance(locBrazil);
    NumberFormat pParcelas = NumberFormat.getInstance(locBrazil);
    NumberFormat tJuros = NumberFormat.getInstance(locBrazil);
    NumberFormat nfIputValue = NumberFormat.getInstance(locBrazil);
    NumberFormat nfOldIputValue = NumberFormat.getInstance(locBrazil);
    Number nValue = null;
    Number nInterest = null;
    Number nInputValue = null;
    Number nOldInputValue = null;
    Calculadora c = new CalculadoraImpl();

    Double inputValue = 0d;
    Integer parcelas = 0;
    Double interest = 0d;
    Double value = 0d;
    
    public static CalculadoraPrestacoesViewer cpv = null;
    public static CalculadoraAVistaViewer cav = null;
    public static CalculadoraSimulacaoViewer csv = null;    

    /**
     * Creates new form Main
     */
    public CalculadoraAVistaViewer() {
        initComponents();
        util.centerWindow(this);
    }
    Utils util = new Utils();

    public int exitSystem() {
        if (javax.swing.JOptionPane.showConfirmDialog(this, "Tem certeza que deseja sair?", "Calculadora de Prestações", javax.swing.JOptionPane.YES_NO_OPTION) == 0) {
            this.dispose();
            System.exit(0);
        }
        return 1;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        ValorBemjNumberFormatField = new br.com.lojaoriodopeixe.utils.JNumberFormatField();
        TotalParcelasjTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        JurosjTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable() {
            public Component prepareRenderer(TableCellRenderer renderer,
                int rowIndex, int vColIndex) {

                Component c = super.prepareRenderer(renderer, rowIndex, vColIndex);
                if (parcelas > 9) {
                    // altera a cor de background da linha para vermelho e foreground para branco
                    // quando o valor da coluna 3 for igual a fechado
                    if (jTable3.getValueAt(rowIndex, 0).toString().equals(parcelas + "ª Parcela(s)")) {
                        c.setBackground(new Color(192, 0, 0));
                        c.setForeground(Color.white);
                    } else {
                        // mantem a cor padrão de foreground
                        c.setForeground(getForeground());

                        // determina a cor de background da linha selecionada
                        if (isCellSelected(rowIndex, vColIndex)) {
                            c.setBackground(new Color(184, 207, 229));
                        } else {
                            // linhas não selecionadas, manter cor de background padrão
                            c.setBackground(getBackground());
                        }

                    }
                } else {// altera a cor de background da linha para vermelho e foreground para branco
                    // quando o valor da coluna 3 for igual a fechado
                    if (jTable3.getValueAt(rowIndex, 0).toString().equals("0" + parcelas + "ª Parcela(s)"

                    )) {
                        c.setBackground(new Color(192, 0, 0));
                        c.setForeground(Color.white);
                    }else {
                        // mantem a cor padrão de foreground
                        c.setForeground(getForeground());

                        // determina a cor de background da linha selecionada
                        if (isCellSelected(rowIndex, vColIndex)) {
                            c.setBackground(new Color(184, 207, 229));
                        } else {
                            // linhas não selecionadas, manter cor de background padrão
                            c.setBackground(getBackground());
                        }}}
                        return c;}}
                ;
                barraMenu = new javax.swing.JMenuBar();
                barraMenuArquivo = new javax.swing.JMenu();
                barraMenuCalcPrest = new javax.swing.JMenuItem();
                barraMenuCalcVista = new javax.swing.JMenuItem();
                barraMenuSimul = new javax.swing.JMenuItem();
                barraMenuSeparador = new javax.swing.JPopupMenu.Separator();
                barraMenuSair = new javax.swing.JMenuItem();
                barraMenuAjuda = new javax.swing.JMenu();
                barraMenuItemSobre = new javax.swing.JMenuItem();

                jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
                jScrollPane1.setViewportView(jTable2);

                setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
                setTitle("Cálculo para Valor à Vista");
                setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/mono.png")));
                setResizable(false);

                jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
                jLabel1.setText("Valor do Produto R$");

                ValorBemjNumberFormatField.setText("0,01");
                ValorBemjNumberFormatField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
                ValorBemjNumberFormatField.setValue(new BigDecimal(0));
                ValorBemjNumberFormatField.addFocusListener(new java.awt.event.FocusAdapter() {
                    public void focusGained(java.awt.event.FocusEvent evt) {
                        ValorBemjNumberFormatFieldFocusGained(evt);
                    }
                });
                ValorBemjNumberFormatField.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        ValorBemjNumberFormatFieldActionPerformed(evt);
                    }
                });
                ValorBemjNumberFormatField.addKeyListener(new java.awt.event.KeyAdapter() {
                    public void keyPressed(java.awt.event.KeyEvent evt) {
                        ValorBemjNumberFormatFieldKeyPressed(evt);
                    }
                    public void keyReleased(java.awt.event.KeyEvent evt) {
                        ValorBemjNumberFormatFieldKeyReleased(evt);
                    }
                    public void keyTyped(java.awt.event.KeyEvent evt) {
                        ValorBemjNumberFormatFieldKeyTyped(evt);
                    }
                });

                TotalParcelasjTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
                TotalParcelasjTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
                TotalParcelasjTextField.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        TotalParcelasjTextFieldActionPerformed(evt);
                    }
                });
                TotalParcelasjTextField.addKeyListener(new java.awt.event.KeyAdapter() {
                    public void keyTyped(java.awt.event.KeyEvent evt) {
                        TotalParcelasjTextFieldKeyTyped(evt);
                    }
                });

                jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
                jLabel2.setText("Parcelas");

                JurosjTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
                JurosjTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
                JurosjTextField.setPreferredSize(new java.awt.Dimension(6, 26));
                JurosjTextField.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        JurosjTextFieldActionPerformed(evt);
                    }
                });
                JurosjTextField.addKeyListener(new java.awt.event.KeyAdapter() {
                    public void keyReleased(java.awt.event.KeyEvent evt) {
                        JurosjTextFieldKeyReleased(evt);
                    }
                });

                jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
                jLabel3.setText("Taxa de Juros %");

                jButton1.setBackground(new java.awt.Color(51, 102, 255));
                jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
                jButton1.setForeground(new java.awt.Color(255, 255, 255));
                jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/calculator.png"))); // NOI18N
                jButton1.setText("Calcular");
                jButton1.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jButton1ActionPerformed(evt);
                    }
                });
                jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
                    public void keyPressed(java.awt.event.KeyEvent evt) {
                        jButton1KeyPressed(evt);
                    }
                });

                jTable3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                jTable3.setModel(f);
                jTable3.setRowHeight(23);
                jScrollPane3.setViewportView(jTable3);

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(ValorBemjNumberFormatField, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TotalParcelasjTextField)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 64, Short.MAX_VALUE)
                                        .addComponent(jLabel2)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(JurosjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGap(10, 10, 10)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                );
                jPanel1Layout.setVerticalGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(ValorBemjNumberFormatField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(JurosjTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                                    .addComponent(TotalParcelasjTextField)))
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 13, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                );

                barraMenu.setMaximumSize(new java.awt.Dimension(90, 200));

                barraMenuArquivo.setText("Funções");

                barraMenuCalcPrest.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.event.InputEvent.CTRL_MASK));
                barraMenuCalcPrest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/calc.png"))); // NOI18N
                barraMenuCalcPrest.setText("Cálculo de Prestações");
                barraMenuCalcPrest.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        barraMenuCalcPrestActionPerformed(evt);
                    }
                });
                barraMenuArquivo.add(barraMenuCalcPrest);

                barraMenuCalcVista.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, java.awt.event.InputEvent.CTRL_MASK));
                barraMenuCalcVista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/calc2.png"))); // NOI18N
                barraMenuCalcVista.setText("Cálculo para Valor à Vista");
                barraMenuCalcVista.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        barraMenuCalcVistaActionPerformed(evt);
                    }
                });
                barraMenuArquivo.add(barraMenuCalcVista);

                barraMenuSimul.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_3, java.awt.event.InputEvent.CTRL_MASK));
                barraMenuSimul.setIcon(new javax.swing.ImageIcon(getClass().getResource("/calc3.png"))); // NOI18N
                barraMenuSimul.setText("Sugestão de Entrada");
                barraMenuSimul.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        barraMenuSimulActionPerformed(evt);
                    }
                });
                barraMenuArquivo.add(barraMenuSimul);
                barraMenuArquivo.add(barraMenuSeparador);

                barraMenuSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
                barraMenuSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/exit.png"))); // NOI18N
                barraMenuSair.setText("Sair");
                barraMenuSair.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        barraMenuSairActionPerformed(evt);
                    }
                });
                barraMenuArquivo.add(barraMenuSair);

                barraMenu.add(barraMenuArquivo);

                barraMenuAjuda.setText("Ajuda");

                barraMenuItemSobre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/about-us.png"))); // NOI18N
                barraMenuItemSobre.setText("Sobre");
                barraMenuItemSobre.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        barraMenuItemSobreActionPerformed(evt);
                    }
                });
                barraMenuAjuda.add(barraMenuItemSobre);

                barraMenu.add(barraMenuAjuda);

                setJMenuBar(barraMenu);

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                );
                layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                );

                pack();
            }// </editor-fold>//GEN-END:initComponents

    private void ValorBemjNumberFormatFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ValorBemjNumberFormatFieldActionPerformed
        this.TotalParcelasjTextField.requestFocusInWindow();
    }//GEN-LAST:event_ValorBemjNumberFormatFieldActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            Double valorProduto = vProduto.parse(ValorBemjNumberFormatField.getText()).doubleValue();
            parcelas = pParcelas.parse(TotalParcelasjTextField.getText()).intValue();
            Double taxaJuros = tJuros.parse(JurosjTextField.getText()).doubleValue();
            Calculadora cc = new CalculadoraImpl();
            f.limpar();
            f.addListaDeParcelas(cc.calculoFinanceiro(valorProduto, taxaJuros, parcelas));
        } catch (ParseException | NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Um ou mais valores não informados ou incompatíveis!", "Atenção!", 2);
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ValorBemjNumberFormatFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ValorBemjNumberFormatFieldKeyPressed

    }//GEN-LAST:event_ValorBemjNumberFormatFieldKeyPressed

    private void ValorBemjNumberFormatFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ValorBemjNumberFormatFieldKeyTyped

    }//GEN-LAST:event_ValorBemjNumberFormatFieldKeyTyped

    private void ValorBemjNumberFormatFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ValorBemjNumberFormatFieldKeyReleased

        try {
            nInputValue = nfIputValue.parse(ValorBemjNumberFormatField.getText());
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Valor informado não é compativel!", "Atenção!", 2);
            System.out.println(ex.getMessage());
        }
        Double bem = nInputValue.doubleValue();
        Double financiamento = nValue.doubleValue();
        Double realValue = null;
        if (!Objects.equals(bem, financiamento)) {
            realValue = bem + 0;
        } else {
            realValue = financiamento + 0;
        }
        DecimalFormat decFormat = new DecimalFormat("¤ #,###,##0.00");

        
    }//GEN-LAST:event_ValorBemjNumberFormatFieldKeyReleased

    private void TotalParcelasjTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TotalParcelasjTextFieldKeyTyped
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_TotalParcelasjTextFieldKeyTyped

    private void TotalParcelasjTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TotalParcelasjTextFieldActionPerformed
        this.JurosjTextField.requestFocusInWindow();
    }//GEN-LAST:event_TotalParcelasjTextFieldActionPerformed

    private void JurosjTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JurosjTextFieldActionPerformed
        this.jButton1.requestFocusInWindow();
    }//GEN-LAST:event_JurosjTextFieldActionPerformed

    private void JurosjTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JurosjTextFieldKeyReleased
        try {
            if (JurosjTextField.getText() != null) {
                nInterest = pParcelas.parse(JurosjTextField.getText());
            }
        } catch (ParseException ex) {
            Logger.getLogger(CalculadoraAVistaViewer.class.getName()).log(Level.SEVERE, null, ex);
        }
        Double interest = nInterest.doubleValue();


    }//GEN-LAST:event_JurosjTextFieldKeyReleased

    private void ValorBemjNumberFormatFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ValorBemjNumberFormatFieldFocusGained
        ValorBemjNumberFormatField.selectAll();
    }//GEN-LAST:event_ValorBemjNumberFormatFieldFocusGained

    private void barraMenuCalcPrestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barraMenuCalcPrestActionPerformed
        if (cpv == null) {
        cpv = new CalculadoraPrestacoesViewer();
        cpv.setVisible(true);
        } else {
        cpv.setVisible(true);
        }
    }//GEN-LAST:event_barraMenuCalcPrestActionPerformed

    private void barraMenuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barraMenuSairActionPerformed
        exitSystem();
    }//GEN-LAST:event_barraMenuSairActionPerformed

    private void barraMenuItemSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barraMenuItemSobreActionPerformed
        JOptionPane.showConfirmDialog( null," Desenvolvido em conjunto por: \n Vagner Barbosa e Solon Diego", "Sobre",JOptionPane.CLOSED_OPTION);
    }//GEN-LAST:event_barraMenuItemSobreActionPerformed

    private void barraMenuCalcVistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barraMenuCalcVistaActionPerformed
        if (cav == null) {
        cav = new CalculadoraAVistaViewer();
        cav.setVisible(true);        
        } else {
        cav.setVisible(true);            
        }
    }//GEN-LAST:event_barraMenuCalcVistaActionPerformed

    private void barraMenuSimulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barraMenuSimulActionPerformed
        if (csv == null) {
        CalculadoraSimulacaoViewer csv = new CalculadoraSimulacaoViewer();
        csv.setVisible(true);
        } else {
        csv.setVisible(true);
        }
    }//GEN-LAST:event_barraMenuSimulActionPerformed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        try {
            Double valorProduto = vProduto.parse(ValorBemjNumberFormatField.getText()).doubleValue();
            parcelas = pParcelas.parse(TotalParcelasjTextField.getText()).intValue();
            Double taxaJuros = tJuros.parse(JurosjTextField.getText()).doubleValue();
            Calculadora cc = new CalculadoraImpl();
            f.limpar();
            f.addListaDeParcelas(cc.calculoFinanceiro(valorProduto, taxaJuros, parcelas));
        } catch (ParseException | NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Um ou mais valores não informados ou incompatíveis!", "Atenção!", 2);
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_jButton1KeyPressed

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
                    javax.swing.UIManager.put("control", new Color(248, 248, 255));
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CalculadoraAVistaViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CalculadoraAVistaViewer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JurosjTextField;
    private javax.swing.JTextField TotalParcelasjTextField;
    private br.com.lojaoriodopeixe.utils.JNumberFormatField ValorBemjNumberFormatField;
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JMenu barraMenuAjuda;
    private javax.swing.JMenu barraMenuArquivo;
    private javax.swing.JMenuItem barraMenuCalcPrest;
    private javax.swing.JMenuItem barraMenuCalcVista;
    private javax.swing.JMenuItem barraMenuItemSobre;
    private javax.swing.JMenuItem barraMenuSair;
    private javax.swing.JPopupMenu.Separator barraMenuSeparador;
    private javax.swing.JMenuItem barraMenuSimul;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    // End of variables declaration//GEN-END:variables
}
