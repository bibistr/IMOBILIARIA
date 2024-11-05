package apresentacao;

import model.Usuario;
import model.Cliente;
import model.Corretor;
import model.Imovel;
import model.Locacao;

import persistencia.BancoDeDados;
import persistencia.ClienteDAO;
import persistencia.CorretorDAO;
import persistencia.ContratoDAO;
import persistencia.ImovelDAO;
import persistencia.LocacaoDAO;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);


        int res = 0;

        System.out.println("Bem vindo(a) à Conecta Imobiliária");

        System.out.println("Selecione a opção que deseja realizar: \n 1.Cadastrar imóvel \n 2.Cadastrar cliente \n 3. Cadastrar corretor \n 4.Contrato de anúncio \n 5.Listar imóveis \n 6.Listar clientes \n 7.Listar corretores \n 8. ");
        res = tec.nextInt();

        if (res==1) {

        String endereco = tec.nextLine();
        String tipo = tec.nextLine();
        String descricao = tec.nextLine();
        Double area = tec.nextDouble();
        Double valor_venda = tec.nextDouble();
        Double valor_aluguel = tec.nextDouble();
        int ano_construcao = tec.nextInt();
        Imovel imovel = new Imovel(endereco, tipo,descricao, area, valor_venda, valor_aluguel, ano_construcao);
        ImovelDAO i = new ImovelDAO();
        i.create(imovel);


        } else {
            
        }


       
    }

}
