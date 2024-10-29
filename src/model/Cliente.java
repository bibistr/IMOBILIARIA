package model;

public class Cliente extends Usuario{

 private String data_nasc;
 private String cpf;
 private String endereco;

    public Cliente(String nome_cliente, String email_cliente, String tel_cliente, String data_nasc, String cpf, String endereco){
        super(nome_cliente, email_cliente, tel_cliente);
        this.data_nasc = data_nasc;
        this.cpf = cpf;
        this.endereco = endereco;
    }
    

    public String getData_nasc() {
        return data_nasc;
    }
    public void setData_nasc(String data_nasc) {
        this.data_nasc = data_nasc;
    }


    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "" + getNome() + ", " + getData_nasc() + ", " + getCpf() + ", " + getEndereco() + ", " + getEmail() + ", " + getTel();
    }

    
} //SEM ALTERAÇÕES
