package dao.cliente;

import model.cliente.ClienteModel;

import java.util.List;
import java.util.Optional;

public class ClienteDao {

    public static void cadastrarCliente(ClienteModel cliente) {
        String SQL = "INSERT INTO cliente (nome, documento, telefone, email, tipo_cliente) VALUES (?, ?, ?, ?, ?)";
    }

    public static List<ClienteModel> listarClientes() {
        String SQL = "SELECT * FROM cliente";
        return null;
    }

    public static Optional<ClienteModel> buscarClientePorId(long id){
        String SQL = "SELECT * FROM cliente WHERE id = ?";
        return Optional.empty();
    }

    public static Optional<ClienteModel> buscarClientePorDocumento(String documento){
        String SQL = "SELECT * FROM cliente WHERE documento = ?";
        return Optional.empty();
    }

    public static void excluirCliente(long id) {
        String SQL = "DELETE FROM cliente WHERE id = ?";
    }


}
