package service.cliente;

import dao.cliente.ClienteDao;
import model.cliente.ClienteModel;

import java.util.List;

public class ClienteService {

    public void cadastrarCliente(ClienteModel cliente) {
        ClienteDao.cadastrarCliente(cliente);
    }

    public List<ClienteModel> listarClientes() {
        return ClienteDao.listarClientes();
    }

    public ClienteModel buscarClientePorId(long id) {
        return ClienteDao.buscarClientePorId(id).orElseThrow(RuntimeException::new);
    }

    public ClienteModel buscarClientePorDocumento(String documento) {
        return ClienteDao.buscarClientePorDocumento(documento).orElseThrow(RuntimeException::new);
    }

    public void excluirCliente(long id) {
        buscarClientePorId(id);
        ClienteDao.excluirCliente(id);
    }
}
