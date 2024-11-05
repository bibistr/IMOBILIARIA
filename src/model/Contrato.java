package model;

public class Contrato {

    private Imovel imovel;
    private int id_contrato;
    private int id_cliente;
    private int id_corretor;
    private int id_imovel;
    private String data_inicio, data_fim;
    private double comissao;

    public Contrato(int id_contrato, int id_cliente, int id_corretor, Imovel imovel, String data_inicio, String data_fim, double comissao) {
        this.id_contrato = id_contrato;
        this.imovel = imovel;
        this.id_cliente = id_cliente;
        this.id_corretor = id_corretor;
        this.data_inicio = data_inicio;
        this.data_fim = data_fim;
        this.comissao = comissao;
    }

    public int getIdContrato() {
        return this.id_contrato;
    }
    public void setIdContrato(int id_contrato) {
        this.id_contrato = id_contrato;
    }


    public int getIdCliente() {
        return this.id_cliente;
    }
    public void setIdCliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }


    public int getIdCorretor() {
        return this.id_corretor;
    }
    public void setIdCorretor(int id_corretor) {
        this.id_corretor = id_corretor;
    }


    public int getIdImovel() {
        return id_imovel;
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


    public double getComissao() {
        return this.comissao;
    }
    public void setComissao(double comissao) { // MUDAR PARA DOUBLE
        this.comissao = comissao;
    }


    public void taxarCompra(double taxa) {
        taxa = this.comissao*this.imovel.getValorVenda();
    }


    @Override
    public String toString() {
        return "" + "id do contrato: " + getIdContrato() + "id do cliente: " + getIdCliente() + ", id do corretor" + getIdCorretor() + ", id do imóvel: " + getIdImovel() + ", data de início do contrato: " + getDataInicio() + ", data do fim do contrato: " + getDataFim() + "porcentagem a pagar: ";
    }
}///
