package com.miguelefernando.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * entidade que representa a table produto
 *
 * @author fernando
 * @since 03/24
 * @version 1.0
 */
public class ProdutoDAO {

    private int id;
    private double preco;
    private String nome;
    private char sexo;
    private String categoria;
    private String marca;
    private BancoDAO banco;

    /**
     * construtor com id para unmashalling
     * @param id
     * @param preco
     * @param nome
     * @param sexo
     * @param categoria
     * @param marca
     * @author fernando
     * @since 03/24
     * @version 1.0
     */
    public ProdutoDAO(int id, double preco, String nome, char sexo, String categoria, String marca) {
        this.id = id;
        this.preco = preco;
        this.nome = nome;
        this.sexo = sexo;
        this.categoria = categoria;
        this.marca = marca;
        this.banco = new BancoDAO();
    }

    /**
     * construtor com id para unmashalling sem sexo, que é<br>
     * column opicional.
     * @param id
     * @param preco
     * @param nome
     * @param categoria
     * @param marca
     * construtor com id para unmashalling
     */
    public ProdutoDAO(int id, double preco, String nome, String categoria, String marca) {
        this.id = id;
        this.preco = preco;
        this.nome = nome;
        this.categoria = categoria;
        this.marca = marca;
        this.banco = new BancoDAO();
    }

    /**
     * construtor com sexo da roupa sem id<br>
     * para mashlling
     *
     * @param preco
     * @param nome
     * @param sexo
     * @param categoria
     * @param marca
     * @author fernando
     * @since 03/24
     * @version 1.0
     */
    public ProdutoDAO(double preco, String nome, char sexo, String categoria, String marca) {
        this.preco = preco;
        this.nome = nome;
        this.sexo = sexo;
        this.categoria = categoria;
        this.marca = marca;
        this.banco = new BancoDAO();
    }

    /**
     * construtor sem sexo da roupa sem id<br>
     * para mashlling
     *
     * @param preco
     * @param nome
     * @param categoria
     * @param marca
     * @author fernando
     * @since 03/24
     * @version 1.0
     */
    public ProdutoDAO(double preco, String nome, String categoria, String marca) {
        this.preco = preco;
        this.nome = nome;
        this.categoria = categoria;
        this.marca = marca;
        this.banco = new BancoDAO();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public BancoDAO getBanco() {
        return banco;
    }

    public void setBanco(BancoDAO banco) {
        this.banco = banco;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    
    
    

    /**
     * nome já autoexplicativo
     * @return boolean confirmando a inserção
     * @throws SQLException 
     * @author fernando
     * @since 03/24
     * @version 1.0
     */
    private boolean salvarProdutoComIDComSexo() throws SQLException {
        Connection conexao = this.banco.getConexao();
        boolean resultado;

        String sql = "SET @@auto_increment_increment=0; "
                + "INSERT INTO produto(id, preco, nome, sexo, categoria, marca) VALUES (?, ?, ?, ?, ?, ?);"
                + "SET @@auto_increment_increment=1;";
        PreparedStatement consulta;

        try {

            consulta = conexao.prepareStatement(sql);
            consulta.setInt(1, this.id);
            consulta.setDouble(2, this.preco);
            consulta.setString(3, this.nome);
            consulta.setString(4, String.valueOf(this.sexo));
            consulta.setString(5, this.categoria);
            consulta.setString(6, this.marca);
            consulta.execute();
            resultado = true;

        } catch (SQLException ex) {
            resultado = false;
            System.out.println("Erro ao inserir dados de Pessoa: " + ex.getMessage());
        }
        return resultado;
    }

     /**
     * nome já autoexplicativo
     * @return boolean confirmando a inserção
     * @throws SQLException 
     * @author fernando
     * @since 03/24
     * @version 1.0
     * @deprecated: não está operacional ainda
     */
    private boolean salvarProdutoComIDSemSexo() throws SQLException {
        Connection conexao = this.banco.getConexao();
        boolean resultado;

        String sql = "SET @@auto_increment_increment=0; "
                + "INSERT INTO produto(id, preco, nome, categoria, marca) VALUES (?, ?, ?, ?, ?);"
                + "SET @@auto_increment_increment=1;";
        PreparedStatement consulta;

        try {

            consulta = conexao.prepareStatement(sql);
            consulta.setInt(1, this.id);
            consulta.setDouble(2, this.preco);
            consulta.setString(3, this.nome);
            consulta.setString(4, this.categoria);
            consulta.setString(5, this.marca);
            consulta.execute();
            resultado = true;

        } catch (SQLException ex) {
            resultado = false;
            System.out.println("Erro ao inserir dados de Pessoa: " + ex.getMessage());
        }
        return resultado;
    }
    /**
     * nome já autoexplicativo
     * @return boolean confirmando a inserção
     * @throws SQLException 
     * @author fernando
     * @since 03/24
     * @version 1.0
     */
    private boolean salvarProdutoSemIDComSexo() throws SQLException {
        Connection conexao = this.banco.getConexao();
        boolean resultado;

        String sql = "INSERT INTO produto(preco, nome, sexo, categoria, marca) VALUES (?, ?, ?, ?, ?);";
        PreparedStatement consulta;

        try {

            consulta = conexao.prepareStatement(sql);
            consulta.setDouble(1, this.preco);
            consulta.setString(2, this.nome);
            consulta.setString(3, String.valueOf(this.sexo));
            consulta.setString(4, this.categoria);
            consulta.setString(5, this.marca);
            consulta.execute();
            resultado = true;

        } catch (SQLException ex) {
            resultado = false;
            System.out.println("Erro ao inserir dados de Pessoa: " + ex.getMessage());
        }
        return resultado;
    }
    /**
     * nome já autoexplicativo
     * @return boolean confirmando a inserção
     * @throws SQLException 
     * @author fernando
     * @since 03/24
     * @version 1.0
     */
    private boolean salvarProdutSemIDSemSexo() throws SQLException {
        Connection conexao = this.banco.getConexao();
        boolean resultado;

        String sql = "INSERT INTO produto(preco, nome, categoria) VALUES (?, ?, ?, ?);";
        PreparedStatement consulta;

        try {

            consulta = conexao.prepareStatement(sql);
            consulta.setDouble(1, this.preco);
            consulta.setString(2, this.nome);
            consulta.setString(3, this.categoria);
            consulta.setString(4, this.marca);

            consulta.execute();
            resultado = true;

        } catch (SQLException ex) {
            resultado = false;
            System.out.println("Erro ao inserir dados de Pessoa: " + ex.getMessage());
        }
        return resultado;
    }
    /**
     * um switch que seleciona qual método ele usa para fazer o mashaling,
     * não insira uma entidade com id.
     * @return boolean confirmando a inserção
     * @throws SQLException 
     * @author fernando
     * @since 03/24
     * @version 1.0
     */
    public boolean salvarProduto() throws SQLException {
        if (this.id == 0 && this.sexo == '\0') {
            salvarProdutSemIDSemSexo();
            return true;
        }
        if (this.id != 0 && this.sexo == '\0') {
            salvarProdutoComIDSemSexo();
            return true;
        }
        if (this.id == 0 && this.sexo != '\0') {
            salvarProdutoSemIDComSexo();
            return true;
        }
        if (this.id != 0 && this.sexo != '\0') {
            salvarProdutoComIDComSexo();
            return true;
        }
        return true;
    }

}
