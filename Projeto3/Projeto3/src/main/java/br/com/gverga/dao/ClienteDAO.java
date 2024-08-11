package br.com.gverga.dao;

import br.com.gverga.dao.jdbc.ConnectionFactory;
import br.com.gverga.domain.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements IClienteDAO{
    @Override
    public Integer cadastrar(Cliente cliente) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;

        try {
            connection = ConnectionFactory.getConnection();
            String sql = "INSERT INTO TB_CLIENTE (ID, CODIGO, NOME) VALUES(nextval('SQ_CLIENTE'),?,?)";
            stm = connection.prepareStatement(sql);
            stm.setString(1, cliente.getCodigo());
            stm.setString(2, cliente.getNome());
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

    @Override
    public Cliente consultar(String codigo) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Cliente cliente = null;

        try {
            connection = ConnectionFactory.getConnection();
            String sql = "SELECT * FROM TB_CLIENTE WHERE codigo = ?";
            stm = connection.prepareStatement(sql);
            stm.setString(1, codigo);
            rs = stm.executeQuery();

           if (rs.next()) {
               cliente = new Cliente();
               cliente.setId(rs.getLong("ID"));
               cliente.setCodigo(rs.getString("CODIGO"));
               cliente.setNome(rs.getString("NOME"));
           }

           return cliente;
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

    @Override
    public Integer excluir(Cliente cliente) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;

        try {
            connection = ConnectionFactory.getConnection();
            String sql = "DELETE FROM TB_CLIENTE WHERE CODIGO = ?";
            stm = connection.prepareStatement(sql);
            stm.setString(1, cliente.getCodigo());
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

    @Override
    public List<Cliente> buscarTodos() throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<Cliente> clientes = new ArrayList<>();

        try {
            connection = ConnectionFactory.getConnection();
            String sql = "SELECT * FROM TB_CLIENTE";
            stm = connection.prepareStatement(sql);
            rs = stm.executeQuery();

            if (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getLong("ID"));
                cliente.setCodigo(rs.getString("CODIGO"));
                cliente.setNome(rs.getString("NOME"));
                clientes.add(cliente);
            }

            return clientes;
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

    @Override
    public Integer atualizar(Cliente clienteNovo) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;

        try {
            connection = ConnectionFactory.getConnection();
            String sql = "UPDATE TB_CLIENTE SET NOME = ? WHERE CODIGO = ?";
            stm = connection.prepareStatement(sql);
            stm.setString(1, clienteNovo.getNome());
            stm.setString(2, clienteNovo.getCodigo());
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
