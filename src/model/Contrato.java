package model;

public class Contrato {

    private int id;
    private int id_cliente;
    private int id_corretor;
    private int id_imovel;
    private String data_inicio, data_fim;

    public Contrato(int id, int id_cliente, int id_corretor, int id_imovel, String data_inicio, String data_fim) {
        this.id = id;
        this.id_cliente = id_cliente;
        this.id_corretor = id_corretor;
        this.id_imovel = id_imovel;
        this.data_inicio = data_inicio;
        this.data_fim = data_fim;
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    public int getId_cliente() {
        return id_cliente;
    }

    public int getId_corretor() {
        return id_corretor;
    }

    public int getId_imovel() {
        return id_imovel;
    }

    public String getData_inicio() {
        return data_inicio;
    }
    public void setData_inicio(String data_inicio) {
        this.data_inicio = data_inicio;
    }

    public String getData_fim() {
        return data_fim;
    }
    public void setData_fim(String data_fim) {
        this.data_fim = data_fim;
    }
    
    @Override
    public String toString() {
        return "" + "id do cliente: " + getId_cliente() + ", id do corretor" + getId_corretor() + ", id do imóvel: " + getId_imovel() + ", data de início do contrato: " + getData_inicio() + ", data do fim do contrato: " + getData_fim();
    }
}
