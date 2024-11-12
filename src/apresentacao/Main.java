package apresentacao;
import model.Usuario;
import model.Cliente;
import model.Contrato;
import model.Corretor;
import model.Imovel;
import model.Locacao;
import persistencia.BancoDeDados;
import persistencia.ClienteDAO;
import persistencia.CorretorDAO;
import persistencia.ContratoDAO;
import persistencia.ImovelDAO; ///
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
        System.out.println("1. Cadastrar imóvel"); //pronta
        System.out.println("2. Cadastrar cliente"); // pronta
        System.out.println("3. Cadastrar corretor"); // pronta
        System.out.println("4. Contrato de anúncio");
        System.out.println("5. Listar imóveis");
        System.out.println("6. Listar clientes");
        System.out.println("7. Listar corretores");
        System.out.println("8. Sair");
        res = tec.nextInt();
        tec.nextLine();

        ClienteDAO c = new ClienteDAO();
        CorretorDAO cor = new CorretorDAO();
        ContratoDAO cont = new ContratoDAO();
        ImovelDAO i = new ImovelDAO();
        LocacaoDAO loc = new LocacaoDAO();

        // Cadastro dos corretores fixos
        Corretor corretor1 = new Corretor("Bianca Tremea", "tremeabianca@gmailcom", "(51) 99584-8432", "Creci RS 123456-F");
        cor.create(corretor1);
        Corretor corretor2 = new Corretor("Luiza Demoliner", "emailamiga@exemplo.com", "(51) 98991-9186", "Creci RS 654321-F");
        cor.create(corretor2);

        // opcao 1 de cadastrar imovel
        if (res == 1) {
            Cliente cliente = null;
            System.out.println("O cliente já possui cadastro? Digite 'sim' ou 'não'");
            String r = tec.nextLine();
        
            if (r.equals("sim")) {
                System.out.println("Informe o CPF do cliente:");
                String cpf = tec.nextLine();
                cliente = c.findByCpfCliente(cpf);

                if (cliente != null) {
                    System.out.println("Cliente encontrado: " + cliente.getNome());
                    
                } else {
                    System.out.println("Cliente não encontrado. Deseja cadastrá-lo? Digite 'sim' ou 'não')");
                    r = tec.nextLine(); 

                    if (r.equals("sim")) {
                        System.out.println("Digite o nome do cliente:");
                        String nome_cliente = tec.nextLine();
                        System.out.println("Digite o email do cliente:");
                        String email_cliente = tec.nextLine();
                        System.out.println("Digite o telefone do cliente:");
                        String tel_cliente = tec.nextLine();
                        System.out.println("Digite a data de nascimento do cliente:");
                        String data_nasc = tec.nextLine();
                        System.out.println("Digite o CPF do cliente:");
                        cpf = tec.nextLine();
                        System.out.println("Digite o endereço do cliente:");
                        String endereco = tec.nextLine();
        
                        cliente = new Cliente(nome_cliente, email_cliente, tel_cliente, endereco, data_nasc, cpf);
                        c.create(cliente);
                        System.out.println("Cliente cadastrado com sucesso.");
                    }
                }
                    
            } else if (r.equals("não")) {
                System.out.println("Digite o nome do cliente:");
                String nome_cliente = tec.nextLine();
                System.out.println("Digite o email do cliente:");
                String email_cliente = tec.nextLine();
                System.out.println("Digite o telefone do cliente:");
                String tel_cliente = tec.nextLine();
                System.out.println("Digite a data de nascimento do cliente:");
                String data_nasc = tec.nextLine();
                System.out.println("Digite o CPF do cliente:");
                String cpf = tec.nextLine();
                System.out.println("Digite o endereço do cliente:");
                String endereco = tec.nextLine();
        
                cliente = new Cliente(nome_cliente, email_cliente, tel_cliente, endereco, data_nasc, cpf);
                c.create(cliente);
                System.out.println("Cliente cadastrado com sucesso.");
            }

                System.out.println("Informe o creci do corretor responsável pelo imóvel:");
                String creci = tec.nextLine();
                Corretor corretor = cor.findByCreci(creci);
                if (corretor != null) {
                    System.out.println("Corretor encontrado: " + corretor.getNome());
                } else {
                    System.out.println("Corretor não encontrado com o creci fornecido.");
                }
                
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
        

            // fim da opção 1 de cadastrar imovel


        // opção 2 de cadastrar cliente
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


        // opção 3 de cadastrar corretor
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


        // opção 4 de contrato
        } else if (res == 4) {
            Cliente cliente = null;

            System.out.println("O cliente que deseja fazer o contrato, ja possui cadastro? Digite 'sim' ou 'não'");
            String r = tec.nextLine();
            if (r.equals("sim")) {
                System.out.println("Digite o CPF do cliente cadastrado:");
                String cpf = tec.nextLine();
                cliente = c.findByCpfCliente(cpf);

                if (cliente != null) {
                    System.out.println("Cliente encontrado: " + cliente.getNome());
                    
                } else {
                    System.out.println("Cliente não encontrado. Caso deseje cadastrá-lo, encerre a seção e dadastre o Cliente. ");
                }
            }

                System.out.println("O imovel que fará parte do contrato ja esta cadastrado? Digite 'sim' ou 'não'" );
                Imovel imovel = null;

                String resposta = tec.nextLine();
                if (resposta.equals("sim")) {
                
                    System.out.println("Digite o ID do imóvel cadastrado:");
                    int id = tec.nextInt();
                    i.findById(id);
                    if(imovel != null) {
                    System.out.println("Imóvel encontrado: "+imovel.getDescricao()); //nao sei o que é o aviso
            
                    }else {
                        System.out.println("Imóvel não encontrado. Deseja cadastrá-lo? Para cadastrar o imóvel, encerre esta seção e cadastre o imóvel");                    
                    }
                }
                    System.out.println("Insira a data de início do contrato:");
                    String dataInicio = tec.nextLine();
                    System.out.println("Digite o prazo final do contrato: ");
                    String dataFinal = tec.nextLine();
                    System.out.println("Informe a Comissão do Contrato:");
                    double comissao = tec.nextDouble();

                    Contrato contrato = new Contrato(cliente, corretor2, imovel, dataInicio, dataFinal, comissao);
                    cont.create(contrato);
                
            
            
        } else if(res==5) {
            System.out.println(i.getAll());
            System.out.println("\n Clique na opção que deseja realizar:");
            System.out.println("1.Editar cadastro");
            System.out.println("2.Deletar cadastro");
            int resposta = tec.nextInt();

            if (resposta==1) {
                System.out.println("Digite o ID do imóvel");
                int id = tec.nextInt();
                i.findById(id);
                if (id=!) {
                    System.out.println("imovel encontrado:"imovel.getDescricao());
                    
                } else {
                    
                }
                System.out.println(i.update(imovel));

                
            } else {
                
            }

        }

    } while (res!=8);
}
}
       

