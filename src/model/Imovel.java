package model;

public class Imovel {

    private String endereco, tipo, descricao;
    private double area, valor_venda, valor_aluguel;
    private int ano_construcao;

    public Imovel (String endereco, String tipo, String descricao, double area, double valor_venda, double valor_aluguel, int ano_construcao) {
        this.endereco = endereco;
        this.tipo = tipo;
        this.descricao = descricao;
        this.area = area;
        this.valor_venda = valor_venda;
        this.valor_aluguel = valor_aluguel;
        this.ano_construcao = ano_construcao;
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


    public double getValor_venda() {
        return this.valor_venda;
    }
    public void setValor_venda(double valor_venda) {
        this.valor_venda = valor_venda;
    }


    public double getValor_aluguel() {
        return this.valor_aluguel;
    }
    public void setValor_aluguel(double valor_aluguel) {
        this.valor_aluguel = valor_aluguel;
    }


    public int getAno_construcao() {
        return this.ano_construcao;
    }
    public void setAno_construcao(int ano_construcao) {
        this.ano_construcao = ano_construcao;
    }

    @Override
    public String toString() {
return "" + "Endereço: " + getEndereco() + ", " + "Imóvel: " + getTipo() + ", Descrição: " + getDescricao() + ", Ano de construção: " + getAno_construcao() + ", Área: " + getArea() + ", valor do imóvel à venda: " + getValor_venda() + ", valor locação: " + getValor_aluguel();
    }

}
