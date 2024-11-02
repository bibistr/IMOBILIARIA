package model;

public class Locacao {

    private int id_locacao;
    private int id_cliente;
    private int id_imovel;
    private String data_inicio;
    private String data_fim;

    public Locacao(int id_locacao, int id_cliente, int id_imovel, String data_inicio, String data_fim) {
        this.id_locacao = id_locacao;
        this.id_cliente = id_cliente;
        this.id_imovel = id_imovel;
        this.data_inicio = data_inicio;
        this.data_fim = data_fim;
    }

    public int getId_locacao() {
        return this.id_locacao;
    }
    public void setId_locacao(int id_locacao) {
        this.id_locacao = id_locacao;
    }

    public int getId_cliente() {
        return this.id_cliente;
    }
    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_imovel() {
        return this.id_imovel;
    }
    public void setId_imovel(int id_imovel) {
        this.id_imovel = id_imovel;
    }

    public String getData_inicio() {
        return this.data_inicio;
    }
    public void setData_inicio(String data_inicio) {
        this.data_inicio = data_inicio;
    }

    public String getData_fim() {
        return this.data_fim;
    }
    public void setData_fim(String data_fim) {
        this.data_fim = data_fim;
    }

    @Override
    public String toString() {
        return "" + "id da locação: " + getId_locacao() + ", id do cliente: " + getId_cliente() + ", id do imóvel: "
        + getId_imovel() + ", data de início da locação: " + getData_inicio() + ", data do fim da locação: "
        + getData_fim();
    }
    
}/
