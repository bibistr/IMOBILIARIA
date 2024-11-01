package model;

public class Contrato {

    private int id_contrato;
    private int id_cliente;
    private int id_corretor;
    private int id_imovel;
    private String data_inicio, data_fim;
    private String comissao;

    public Contrato(int id_contrato, int id_cliente, int id_corretor, int id_imovel, String data_inicio, String data_fim, String comissao) {
        this.id_contrato = id_contrato;
        this.id_cliente = id_cliente;
        this.id_corretor = id_corretor;
        this.id_imovel = id_imovel;
        this.data_inicio = data_inicio;
        this.data_fim = data_fim;
        this.comissao = comissao;
    }

    public int getId_contrato() {
        return this.id_contrato;
    }

    public void setId_contrato(int id_contrato) {
        this.id_contrato = id_contrato;
    }

    public int getId_cliente() {
        return this.id_cliente;
    }

    public int getId_corretor() {
        return this.id_corretor;
    }

    public int getId_imovel() {
        return this.id_imovel;
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

    public String getComissao() {
        return this.comissao;
    }
    public void setComissao(String comissao) {
        this.comissao = comissao;
    }

    @Override
    public String toString() {
        return "" + "id do contrato: " + getId_contrato() + "id do cliente: " + getId_cliente() + ", id do corretor" + getId_corretor() + ", id do imóvel: "
                + getId_imovel() + ", data de início do contrato: " + getData_inicio() + ", data do fim do contrato: "
                + getData_fim() + "porcentagem a pagar: " + getComissao();
    }
}
