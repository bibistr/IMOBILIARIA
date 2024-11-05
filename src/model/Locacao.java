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

    public int getIdLocacao() {
        return this.id_locacao;
    }
    public void setIdLocacao(int id_locacao) {
        this.id_locacao = id_locacao;
    }

    
    public int getIdCliente() {
        return this.id_cliente;
    }
    public void setIdCliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }


    public int getIdImovel() {
        return this.id_imovel;
    }
    public void setIdImovel(int id_imovel) {
        this.id_imovel = id_imovel;
    }


    public String getDataInicio() {
        return this.data_inicio;
    }
    public void setDataInicio(String data_inicio) {
        this.data_inicio = data_inicio;
    }


    public String getDataFim() {
        return this.data_fim;
    }
    public void setDataFim(String data_fim) {
        this.data_fim = data_fim;
    }

    @Override
    public String toString() {
        return "" + "id da locação: " + getIdLocacao() + ", id do cliente: " + getIdCliente() + ", id do imóvel: "
        + getIdImovel() + ", data de início da locação: " + getDataInicio() + ", data do fim da locação: "
        + getDataFim();
    }
    
}//
