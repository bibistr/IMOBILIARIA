package model;

public class Cliente extends Usuario {

    private String data_nasc;
    private String cpf;
    private String endereco;
    private int id_cliente;

    public Cliente(int id_cliente, String nome_cliente, String email_cliente, String tel_cliente, String data_nasc,
            String cpf, String endereco) {
        super(nome_cliente, email_cliente, tel_cliente);
        this.data_nasc = data_nasc;
        this.cpf = cpf;
        this.endereco = endereco;
        this.id_cliente = id_cliente;
    }

    public String getData_nasc() {
        return this.data_nasc;
    }

    public void setData_nasc(String data_nasc) {
        this.data_nasc = data_nasc;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getId_cliente() {
        return this.id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    @Override
    public String toString() {
        return "" + "id do cliente: " + getId_cliente() + ", " + getNome() + ", " + getData_nasc() + ", " + getCpf() + ", " + getEndereco()
                + ", " + getEmail() + ", " + getTel();
    }

} // SEM ALTERAÇÕES
