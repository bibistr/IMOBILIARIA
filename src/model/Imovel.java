package model;

public class Imovel {

    private int id_imovel;
    private String endereco, tipo, descricao;
    private double area, valor_venda, valor_aluguel;
    private int ano_construcao;

    public Imovel (int id_imovel, String endereco, String tipo, String descricao, double area, double valor_venda, double valor_aluguel, int ano_construcao) {
        this.id_imovel = id_imovel;
        this.endereco = endereco;
        this.tipo = tipo;
        this.descricao = descricao;
        this.area = area;
        this.valor_venda = valor_venda;
        this.valor_aluguel = valor_aluguel;
        this.ano_construcao = ano_construcao;
    }

    public int getId_imovel() {
        return this.id_imovel;
    }
    public void setId_imovel(int id_imovel) {
        this.id_imovel = id_imovel;
    }


    public String getEndereco() {
        return this.endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }


    public String getTipo() {
        return this.tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    public String getDescricao() {
        return this.descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    
    public double getArea() {
        return this.area;
    }
    public void setArea(double area) {
        this.area = area;
    }


    public double getValorVenda() {
        return this.valor_venda;
    }
    public void setValorVenda(double valor_venda) {
        this.valor_venda = valor_venda;
    }


    public double getValorAluguel() {
        return this.valor_aluguel;
    }
    public void setValorAluguel(double valor_aluguel) {
        this.valor_aluguel = valor_aluguel;
    }


    public int getAnoConstrucao() {
        return this.ano_construcao;
    }
    public void setAnoConstrucao(int ano_construcao) {
        this.ano_construcao = ano_construcao;
    }


    @Override
    public String toString() {
return "" + getId_imovel() + ", " + "Endereço: " + getEndereco() + ", " + "Imóvel: " + getTipo() + ", Descrição: " + getDescricao() + ", Ano de construção: " + getAnoConstrucao() + ", Área: " + getArea() + ", valor do imóvel à venda: " + getValorVenda() + ", valor locação: " + getValorAluguel();
    }

}//
