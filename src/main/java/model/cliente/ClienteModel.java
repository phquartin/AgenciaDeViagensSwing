package model.cliente;

public class ClienteModel {

    private long id;
    private String nome;
    private String documento;
    private String email;
    private String telefone;
    private TipoCliente tipo;

    public ClienteModel(long id, String nome, String documento, String email, String telefone, TipoCliente tipo) {
        this.id = id;
        this.nome = nome;
        this.documento = documento;
        this.email = email;
        this.telefone = telefone;
        this.tipo = tipo;
    }

    public ClienteModel(String nome, String documento, String email, String telefone, TipoCliente tipo) {
        this.nome = nome;
        this.documento = documento;
        this.email = email;
        this.telefone = telefone;
        this.tipo = tipo;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public TipoCliente getTipo() {
        return tipo;
    }
}
