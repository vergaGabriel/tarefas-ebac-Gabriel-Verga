package br.com.gverga.dao;

import br.com.gverga.dao.jdbc.ConnectionFactory;
import br.com.gverga.domain.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO implements IProdutoDAO{
    @Override
    public Integer cadastrar(Produto produto) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;

        try {
            connection = ConnectionFactory.getConnection();
            String sql = "INSERT INTO TB_PRODUTO (ID, CODIGO, NOME, VALOR) VALUES(nextval('SQ_PRODUTO'),?,?,?)";
            stm = connection.prepareStatement(sql);
            stm.setString(1, produto.getCodigo());
            stm.setString(2, produto.getNome());
            stm.setDouble(3, produto.getValor());
            return stm.executeUpdate();
        } catch(Exception e) {
            throw e;
        } finally {
            if (stm != null && !stm.isClosed()) {
                stm.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    @Override
    public Produto consultar(String codigo) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Produto produto = null;

        try {
            connection = ConnectionFactory.getConnection();
            String sql = "SELECT * FROM TB_PRODUTO WHERE CODIGO = ?";
            stm = connection.prepareStatement(sql);
            stm.setString(1, codigo);
            rs = stm.executeQuery();
            if (rs.next()) {
                produto = new Produto();
                produto.setNome(rs.getString("NOME"));
                produto.setCodigo(rs.getString("CODIGO"));
                produto.setValor(rs.getDouble("VALOR"));
                produto.setId(rs.getLong("ID"));
            }

            return produto;
        } catch(Exception e) {
            throw e;
        } finally {
            if (stm != null && !stm.isClosed()) {
                stm.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    @Override
    public Integer excluir(Produto produto) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;

        try {
            connection = ConnectionFactory.getConnection();
            String sql = "DELETE FROM TB_PRODUTO WHERE CODIGO = ?";
            stm = connection.prepareStatement(sql);
            stm.setString(1, produto.getCodigo());
            return stm.executeUpdate();
        } catch(Exception e) {
            throw e;
        } finally {
            if (stm != null && !stm.isClosed()) {
                stm.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    @Override
    public List<Produto> buscarTodos() throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Produto produto = null;
        List<Produto> produtos = new ArrayList<>();

        try {
            connection = ConnectionFactory.getConnection();
            String sql = "SELECT * FROM TB_PRODUTO";
            stm = connection.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                produto = new Produto();
                produto.setNome(rs.getString("NOME"));
                produto.setCodigo(rs.getString("CODIGO"));
                produto.setValor(rs.getDouble("VALOR"));
                produto.setId(rs.getLong("ID"));
                produtos.add(produto);
            }

            return produtos;
        } catch(Exception e) {
            throw e;
        } finally {
            if (stm != null && !stm.isClosed()) {
                stm.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    @Override
    public Integer atualizar(Produto produtoNovo) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;

        try {
            connection = ConnectionFactory.getConnection();
            String sql = "UPDATE TB_PRODUTO SET NOME = ?, VALOR = ? WHERE CODIGO = ?";
            stm = connection.prepareStatement(sql);
            stm.setString(1, produtoNovo.getNome());
            stm.setDouble(2, produtoNovo.getValor());
            stm.setString(3, produtoNovo.getCodigo());
            return stm.executeUpdate();
        } catch(Exception e) {
            throw e;
        } finally {
            if(stm != null && !stm.isClosed()) {
                stm.close();
            }
            if(connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }
}
