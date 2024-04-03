
package com.miguelefernando.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *commom user = 0 e admin = 1<br><br>para puxar os dados do excel, deverá
 * ser feito um construtor com id<br>
 * no próprio MySQL podemos utilizar de:<br>
 * <br>
 * -- Desativa temporariamente a AUTO_INCREMENT para a coluna id<br>
 * SET @@auto_increment_increment=0;<br>
 * -- Insere o registro com o ID específico 100<br>
 * INSERT INTO tabela_exemplo (id, coluna1, coluna2) VALUES (100, valor1,
 * valor2);<br>
 * -- Reativa a AUTO_INCREMENT para a coluna id<br>
 * SET @@auto_increment_increment=1;<br>
 * @author fernando e miguel
 * @since 0.0.1 04/24
 * @version 0.0.1
 */
public class PessoaDAO {

    private int id;
    private String nome;
    private String cidade;
    private String uf;
    private String cpf;
    private BancoDAO banco;
    private int admin;

    public PessoaDAO() {
        this.banco = new BancoDAO();
    }

    public PessoaDAO(int id_cliente, String nome, String cidade, String uf, String cpf) {
        this.id = id_cliente;
        this.nome = nome;
        this.cidade = cidade;
        this.uf = uf;
        this.cpf = cpf;
        this.admin = 0;
        this.banco = new BancoDAO();
    }

    public PessoaDAO(String nome, String cidade, String uf, String cpf) {
        //id no auto increment
        this.nome = nome;
        this.cidade = cidade;
        this.uf = uf;
        this.cpf = cpf;
        this.banco = new BancoDAO();
        this.admin = 0;
    }
/**
 * Método para salvar um cliente com ID.
 * // TODO: Implementar o método salvarClienteComId()<br>
 * @deprecated Este método será implementado no futuro.
 * @throws SQLException Se ocorrer um erro durante a execução do SQL.
 * 
 * // TODO: Implementar o método salvarClienteComId()
 */
    public boolean salvarClienteComId() throws SQLException {
        Connection conexao = this.banco.getConexao();
        boolean resultado = false;

        String sql = "SET @@auto_increment_increment=0; "
                + "INSERT INTO pessoa(id, nome, cidade, uf, cpf, admin) VALUES (?, ?, ?, ?, ?, 0);"
                + "SET @@auto_increment_increment=1;";
        PreparedStatement consulta;

        try {

            consulta = conexao.prepareStatement(sql);
            consulta.setInt(1, this.id);
            consulta.setString(2, this.nome);
            consulta.setString(3, this.cidade);
            consulta.setString(4, this.uf);
            consulta.setString(5, this.cpf);
            consulta.execute();
            resultado = true;

        } catch (SQLException ex) {
            resultado = false;
            System.out.println("Erro ao inserir dados de Pessoa: " + ex.getMessage());
        }
        return resultado;
    }
    /**
     * Salva uma pessoa no bdd como admin = 0
     * @param void
     * @return boolean confirmação do insert
     * @throws SQLException 
     */
    public boolean salvarClienteSemId() throws SQLException {
        Connection conexao = this.banco.getConexao();
        boolean resultado = false;

        String sql
                = "INSERT INTO pessoa(nome, cidade, uf, cpf, admin) VALUES (?, ?, ?, ?, 0);";
        PreparedStatement consulta;

        try {

            consulta = conexao.prepareStatement(sql);
            consulta.setString(1, this.nome);
            consulta.setString(2, this.cidade);
            consulta.setString(3, this.uf);
            consulta.setString(4, this.cpf);
            consulta.execute();
            resultado = true;

        } catch (SQLException ex) {
            resultado = false;
            System.out.println("Erro ao inserir dados de Pessoa: " + ex.getMessage());
        }
        return resultado;
    }

}