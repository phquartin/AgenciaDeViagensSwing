package dao.cliente;

import dao.Conexao;
import model.cliente.ClienteModel;
import model.cliente.TipoCliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteDao {

    public static void cadastrarCliente(ClienteModel cliente) {
        String SQL = "INSERT INTO clientes (nome, documento, telefone, email, tipo_cliente) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(SQL)
        ){

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getDocumento());
            stmt.setString(3, cliente.getTelefone());
            stmt.setString(4, cliente.getEmail());
            stmt.setString(5, cliente.getTipo().toString());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar cliente: " + e);
        }
    }

    public static List<ClienteModel> listarClientes() {
        List<ClienteModel> clientes = new ArrayList<>();
        String SQL = "SELECT * FROM clientes";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(SQL);
             var rs = stmt.executeQuery()) {
    
            while (rs.next()) {
                clientes.add(new ClienteModel(
                        rs.getLong("id_cliente"),
                        rs.getString("nome"),
                        rs.getString("documento"),
                        rs.getString("email"),
                        rs.getString("telefone"),
                        TipoCliente.valueOf(rs.getString("tipo_cliente"))
                ));
            }
            
            return clientes;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar clientes: " + e);
        }
    }

    public static Optional<ClienteModel> buscarClientePorId(long id) {
        String SQL = "SELECT * FROM clientes WHERE id_cliente = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(SQL)) {

            stmt.setLong(1, id);
            try (var rs = stmt.executeQuery()) {
                if (rs.next()) {
                    ClienteModel cliente = new ClienteModel(
                            rs.getLong("id_cliente"),
                            rs.getString("nome"),
                            rs.getString("documento"),
                            rs.getString("email"),
                            rs.getString("telefone"),
                            TipoCliente.valueOf(rs.getString("tipo_cliente"))
                    );
                    return Optional.of(cliente);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar cliente por ID: " + e);
        }
        return Optional.empty();
    }

    public static Optional<ClienteModel> buscarClientePorDocumento(String documento) {
        String SQL = "SELECT * FROM clientes WHERE documento = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(SQL)) {

            stmt.setString(1, documento);
            try (var rs = stmt.executeQuery()) {
                if (rs.next()) {
                    ClienteModel cliente = new ClienteModel(
                            rs.getLong("id_cliente"),
                            rs.getString("nome"),
                            rs.getString("documento"),
                            rs.getString("email"),
                            rs.getString("telefone"),
                            TipoCliente.valueOf(rs.getString("tipo_cliente"))
                    );
                    return Optional.of(cliente);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar cliente por documento: " + e);
        }
        return Optional.empty();
    }

    public static void excluirCliente(long id) {
        String SQL = "DELETE FROM clientes WHERE id_cliente = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(SQL)) {

            stmt.setLong(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir cliente: " + e);
        }
    }


}
