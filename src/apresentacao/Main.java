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
import java.sql.SQLException;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner tec = new Scanner(System.in);
        int res = 0;

        do {

        System.out.println("Bem vindo(a) à Conecta Imobiliária");
        System.out.println("Selecione a opção que deseja realizar: ");
        System.out.println("1. Cadastrar imóvel");
        System.out.println("2. Cadastrar cliente");
        System.out.println("3. Cadastrar corretor");
        System.out.println("4. Contrato de anúncio");
        System.out.println("5. Listar imóveis");
        System.out.println("6. Listar clientes");
        System.out.println("7. Listar corretores");
        System.out.println("8. Sair");
        res = tec.nextInt();

        ClienteDAO c = new ClienteDAO();
        CorretorDAO cor = new CorretorDAO();
        ContratoDAO cont = new ContratoDAO();
        ImovelDAO i = new ImovelDAO();
        LocacaoDAO loc = new LocacaoDAO();


        if (res==1) {

            System.out.println("Digite o nome do cliente:");
            String nome = tec.nextLine();
            System.out.println("Digite o email do cliente:");
            String email = tec.nextLine();
            System.out.println("Digite o telefone do cliente:");
            String tel = tec.nextLine();
            System.out.println("Digite a data de nascimento do cliente:");
            String data_nasc = tec.nextLine();
            System.out.println("Digite o CPF do cliente:");
            String cpf = tec.nextLine();
            System.out.println("Digite o endereço do cliente:");
            String enderecoCliente = tec.nextLine();

            Cliente cliente  = new Cliente(nome, email, enderecoCliente, data_nasc, cpf, enderecoCliente);
            c.create(cliente);
             
            Corretor corretor = new Corretor("Luiza", "luiza123@gmail.com", "51 996363306", "Creci RS 1002016");
            cor.create(corretor);


             System.out.println("Digite o endereço do imóvel:");
             String endereco = tec.nextLine();
             System.out.println("Digite o tipo de imóvel:");
             String tipo = tec.nextLine();
             System.out.println("Digite uma descrição do imóvel:");
             String descricao = tec.nextLine();
             System.out.println("Digite a área do imóvel:");
             double area = tec.nextDouble();
             System.out.println("Digite o valor de venda do imóvel:");
             double valor_venda = tec.nextDouble();
             System.out.println("Digite o valor de aluguel do imóvel:");
             double valor_aluguel = tec.nextDouble();
             System.out.println("Digite o ano de construção do imóvel:");
             int ano_construcao = tec.nextInt();
             tec.nextLine(); 

            Imovel imovel = new Imovel(cliente, corretor, endereco, tipo, descricao, area, valor_venda, valor_aluguel, ano_construcao);
            i.create(imovel);

        } else if (res==2) {

            System.out.println("Digite o nome do cliente:");
            String nome = tec.nextLine();
            System.out.println("Digite o email do cliente:");
            String email = tec.nextLine();
            System.out.println("Digite o telefone do cliente:");
            String tel = tec.nextLine();
            System.out.println("Digite a data de nascimento do cliente:");
            String data_nasc = tec.nextLine();
            System.out.println("Digite o CPF do cliente:");
            String cpf = tec.nextLine();
            System.out.println("Digite o endereço do cliente:");
            String enderecoCliente = tec.nextLine();
            Cliente cliente = new Cliente(nome, email, enderecoCliente, data_nasc, cpf, enderecoCliente);
            c.create(cliente);

        } else if (res==3) {

            System.out.println("Digite o nome do corretor:");
            String nome = tec.nextLine();
            System.out.println("Digite o email do corretor:");
            String email = tec.nextLine();
            System.out.println("Digite o telefone do corretor:");
            String tel = tec.nextLine();
            System.out.println("Digite o número CRECI do corretor:");
            String creci = tec.nextLine();

            Corretor corretor = new Corretor(nome, email, tel, creci);
            cor.create(corretor);        


        } else if (res == 4) {
 
            
            
        }

    } while (res!=8);
       
    }
}
