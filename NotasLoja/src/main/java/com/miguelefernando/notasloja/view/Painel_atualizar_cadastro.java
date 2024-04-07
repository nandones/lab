/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miguelefernando.notasloja.view;

import com.miguelefernando.DAO.PessoaDAO;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;


/**
 * Painel que realiza o update com as novas<br>
 * informações do cliente
 * 
 *
 * @author Miguel
 * @since 04/24
 * @version 1.0
 */
public class Painel_atualizar_cadastro extends javax.swing.JPanel {

     int id_pessoa;
    /**
     * Creates new form Painel_atualizar_cadastro
     * @param id int
     */
    public Painel_atualizar_cadastro(int id) {
        initComponents();
        /**
        * realiza a atualização do cadastro
        */
        id_pessoa = id;
        PessoaDAO pessoa = new PessoaDAO();
        pessoa = pessoa.getPessoa(id);
        String nome = pessoa.getNome();
        String cpf = pessoa.getCpf();
        String cidade = pessoa.getCidade();
        String uf = pessoa.getUf();
        setarTF(nome, cpf, cidade, uf);
        
        pessoa.update();
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tf_nome = new javax.swing.JTextField();
        tf_cpf = new javax.swing.JTextField();
        tf_cidade = new javax.swing.JTextField();
        cb_uf = new javax.swing.JComboBox<>();
        bt_recadastrar = new javax.swing.JButton();
        bt_voltar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 204, 204));
        setPreferredSize(new java.awt.Dimension(536, 470));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel1.setText("BALULAK");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Novo Nome:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Novo CPF:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Nova Cidade:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Novo UF:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));

        tf_nome.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(tf_nome, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 370, -1));

        tf_cpf.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tf_cpf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_cpfKeyTyped(evt);
            }
        });
        add(tf_cpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 390, -1));

        tf_cidade.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(tf_cidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 360, -1));

        cb_uf.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cb_uf.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PR", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MS", "MT", "MG", "PA", "PB", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        add(cb_uf, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, -1, -1));

        bt_recadastrar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bt_recadastrar.setText("Recadastrar");
        bt_recadastrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_recadastrarMouseClicked(evt);
            }
        });
        add(bt_recadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 400, 130, 40));

        bt_voltar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bt_voltar.setText("Voltar");
        bt_voltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_voltarMouseClicked(evt);
            }
        });
        add(bt_voltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 130, 40));
    }// </editor-fold>//GEN-END:initComponents
    /**
    * Atualiza as informações que o usuário decidir reescrever.
    * @author Miguel
    * @since 04/24
    * @version 1.0
    */
    private void bt_recadastrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_recadastrarMouseClicked
        String nome = tf_nome.getText();
        String cpf = tf_cpf.getText();
        String cidade = tf_cidade.getText();
        String uf = (String) cb_uf.getSelectedItem();
        nome = nome.toUpperCase();
        cidade = cidade.toUpperCase();
        if (uf == null) {
            JOptionPane.showMessageDialog(null, "selecione um uf!");
        } else if(verificarFormatoCPF(cpf)==false){
            JOptionPane.showMessageDialog(null, "digite um cpf válido!");
        }else if(nome != null && cpf!=null && cidade !=null){
            cpf = formatarCPF(cpf);
            PessoaDAO pessoa = new PessoaDAO();
            pessoa = pessoa.getPessoa(id_pessoa);
            pessoa.setCpf(cpf);
            pessoa.setNome(nome);
            pessoa.setCidade(cidade);
            pessoa.setUf(uf);
            pessoa.update();
            Janela.p3 = new Painel_clientes();
            JFrame maininterface = (JFrame) SwingUtilities.getWindowAncestor(this);
            maininterface.getContentPane().remove(this);
            maininterface.add(Janela.p3, BorderLayout.CENTER);
            maininterface.pack();
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");          
        }else{
           JOptionPane.showMessageDialog(null, "cliente não cadastrado!");
        }
    }//GEN-LAST:event_bt_recadastrarMouseClicked
        /**
        * chama o método formatacaoCPF.
        * @param evt java.awt.event.KeyEvent
        * @author Miguel
        * @since 04/24
        * @version 1.0
        */
    private void tf_cpfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_cpfKeyTyped
        formatacaoCPF(evt);
    }//GEN-LAST:event_tf_cpfKeyTyped
        /**
        * Volta para o painel clientes
        * @param evt java.awt.event.MouseEvent
        * @author Miguel
        * @since 04/24
        * @version 1.0
        */
    private void bt_voltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_voltarMouseClicked
        Janela.p3 = new Painel_clientes();
        JFrame maininterface = (JFrame) SwingUtilities.getWindowAncestor(this);
        maininterface.getContentPane().remove(this);
        maininterface.add(Janela.p3, BorderLayout.CENTER);
        maininterface.pack();
    }//GEN-LAST:event_bt_voltarMouseClicked

    /**
    * Realiza a verificação se o cpf inserido é válido.
    * @param cpf
    * @return boolean verificação do cpf
    * @author Miguel
    * @since 04/24
    * @version 1.0
    */ 
    public boolean verificarFormatoCPF(String cpf) {
        // Remove caracteres não numéricos do CPF
        cpf = cpf.replaceAll("[^0-9]", "");
        
        // Verifica se o CPF tem 11 dígitos
        if (cpf.length() != 11) {
            return false;
        }
        
        // Verifica se todos os dígitos são iguais, o que é inválido para CPF
        boolean todosDigitosIguais = true;
        for (int i = 1; i < cpf.length(); i++) {
            if (cpf.charAt(i) != cpf.charAt(0)) {
                todosDigitosIguais = false;
                break;
            }
        }
        if (todosDigitosIguais) {
            return false;
        }
        
        // Verifica se o CPF é válido
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += (cpf.charAt(i) - '0') * (10 - i);
        }
        int resto = soma % 11;
        int digitoVerificador1 = (resto < 2) ? 0 : (11 - resto);

        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += (cpf.charAt(i) - '0') * (11 - i);
        }
        resto = soma % 11;
        int digitoVerificador2 = (resto < 2) ? 0 : (11 - resto);

        // Verifica se os dígitos verificadores estão corretos
        if ((cpf.charAt(9) - '0' != digitoVerificador1) || (cpf.charAt(10) - '0' != digitoVerificador2)) {
            return false;
        }
        
        // Se chegou até aqui, o CPF é válido
        return true;
    }
    
    /**
     * seta as informações atuais do cliente.
    * @param nome
    * @param cpf
    * @param cidade
    * @param uf
    * @author Miguel
    * @since 04/24
    * @version 1.0
    */
    public void setarTF(String nome, String cpf, String cidade, String uf){
        tf_nome.setText(nome);
        tf_cidade.setText(cidade);
        tf_cpf.setText(cpf);
        cb_uf.setSelectedItem(uf);
   
    }
    
    /**
     * Realiza a formatação do cpf (###.###.###-##).
    * @param cpf
    * @return String cpfFormatado
    * @author Miguel
    * @since 04/24
    * @version 1.0
    */  
    public static String formatarCPF(String cpf) {
        if (cpf == null || cpf.length() != 11) {
            throw new IllegalArgumentException("CPF inválido");
        }

        // Formatar o CPF com pontos e hífen
        return cpf.substring(0, 3) + "." +
               cpf.substring(3, 6) + "." +
               cpf.substring(6, 9) + "-" +
               cpf.substring(9);
    }
    
    /**
    * Impede a digitação de digitos que não sejam números para evitar erros na verificação de cpf
    * @param evt
    * @author Miguel
    * @since 04/24
    * @version 1.0
    */
    public void formatacaoCPF(java.awt.event.KeyEvent evt){
        String caracteres="0987654321";
        if(!caracteres.contains(evt.getKeyChar()+"")){
            evt.consume();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_recadastrar;
    private javax.swing.JButton bt_voltar;
    private javax.swing.JComboBox<String> cb_uf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField tf_cidade;
    private javax.swing.JTextField tf_cpf;
    private javax.swing.JTextField tf_nome;
    // End of variables declaration//GEN-END:variables
}
