package validation.cliente;

import model.cliente.ClienteModel;

public class ClienteValidation {

    public static void validar(ClienteModel cliente) {
        // EMAIL ---------------------------------
        if (!isValidEmail(cliente.getEmail())) {
            throw new ClienteException("Email inválido para o cliente: " + cliente.getEmail());
        }
        // DOCUMENTOS ---------------------------
        switch (cliente.getTipo()){
            case NACIONAL:
                if (!isValidCPF(cliente.getDocumento())) throw new ClienteException("CPF invalido!");
                break;
            case ESTRANGEIRO:
                if (!isValidPassport(cliente.getDocumento())) throw new ClienteException("Passaporte invalido!");
                break;
            default:
                throw new ClienteException("Tipo de cliente desconhecido!");
        }
        // TELEFONE ----------------------------
        if (!isValidPhoneNumber(cliente.getTelefone())) {
            throw new ClienteException("Telefone inválido! O formato deve seguir o padrão internacional. Exemplo: +55 11 123456789");
        }
        // NOME ---------------------------------
        if (cliente.getNome() == null || cliente.getNome().isBlank()) throw new ClienteException("Nome nulo ou vazio");
    }

    // SCRIPTS IS VALID ...

    private static boolean isValidEmail(String email) {
        return email != null && email.matches("^[\\w.%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
    }

    private static boolean isValidCPF(String cpf) {
        return cpf != null && cpf.matches("^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$");
    }

    private static boolean isValidPassport(String passaporte) {
        return passaporte != null && passaporte.matches("^[A-Z]{2}[0-9]{6}$");
    }

    private static boolean isValidPhoneNumber(String phone) {
        return phone != null && phone.matches("^\\+\\d{1,3}\\s\\d{1,14}(\\s\\d{1,13})?$");
    }
}
