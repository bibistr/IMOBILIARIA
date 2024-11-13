package apresentacao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import model.Cliente;
import model.Contrato;
import model.Corretor;
import model.Imovel;
import model.Locacao;
import persistencia.ClienteDAO;
import persistencia.ContratoDAO;
import persistencia.CorretorDAO;
import persistencia.ImovelDAO;
import persistencia.LocacaoDAO;


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
        System.out.println("8. Fechar locação");
        System.out.println("9 - Sair");
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
        
            if (r.equalsIgnoreCase("sim")) {
                System.out.println("Informe o CPF do cliente:");
                String cpf = tec.nextLine();
                cliente = c.findByCpfCliente(cpf);

                if (cliente != null) {
                    System.out.println("Cliente encontrado: " + cliente.getNome());
                    
                } else {
                    System.out.println("Cliente não encontrado. Deseja cadastrá-lo? Digite 'sim' ou 'não')");
                    r = tec.nextLine(); 

                    if (r.equalsIgnoreCase("sim")) {
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
                    
            } else if (r.equalsIgnoreCase("não")) {
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

                System.out.println("Informe o CRECI do corretor responsável pelo imóvel:");
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
            String endereco = tec.nextLine();
            Cliente cliente = new Cliente(nome, email, tel, endereco, data_nasc, cpf);
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
            if (r.equalsIgnoreCase("sim")) {
                System.out.println("Digite o CPF do cliente cadastrado:");
                String cpf = tec.nextLine();
                cliente = c.findByCpfCliente(cpf);

                if (cliente != null) {
                    System.out.println("Cliente encontrado: " + cliente.getNome());
                    
                } else {
                    System.out.println("Cliente não encontrado. Caso deseje cadastrá-lo, encerre a seção e cadastre o Cliente. ");
                }
            }
                System.out.println("O imovel que fará parte do contrato ja esta cadastrado? Digite 'sim' ou 'não'" );
                Imovel imovel = null;
                r = tec.nextLine();
                if (r.equalsIgnoreCase("sim")) {
                    System.out.println("Digite o ID do imóvel cadastrado:");
                    int id_imovel = tec.nextInt();
                    imovel = i.findById(id_imovel);
                    if(imovel != null) {
                    System.out.println("Imóvel encontrado: "+ imovel.getDescricao()); 

                    }else {
                        System.out.println("Imóvel não encontrado. Deseja cadastrá-lo? Para cadastrar o imóvel, encerre esta seção e cadastre o imóvel");                    
                    }
                }
                    System.out.println("Insira a data de início do contrato:");
                    String dataInicio = tec.nextLine();
                    System.out.println("Digite o prazo final do contrato: ");
                    String dataFinal = tec.nextLine();
                    System.out.println("Informe a Comissão do Contrato em casas decimais:");
                    double comissao = tec.nextDouble();

                    Contrato contrato = new Contrato(cliente, corretor2, imovel, dataInicio, dataFinal, comissao);
                    cont.create(contrato);
                    System.out.println("Contrato criado com sucesso.");



                } else if (res == 5) {
                    System.out.println("Lista de imóveis:");
                    ArrayList<Imovel> lista = i.getAll();
                    
                    if (lista.isEmpty()) {
                        System.out.println("Nenhum imóvel cadastrado.");
                    } else {
                        for (Imovel imovel : lista) {
                            System.out.println(imovel);
                        }
                    }
                    
                    System.out.println("Deseja fazer alguma alteração? Digite 'sim' ou 'não'");
                    String r = tec.nextLine();
                    
                    if (r.equalsIgnoreCase("sim")) {
                        System.out.println("\nEscolha a opção que deseja realizar:");
                        System.out.println("1. Editar cadastro");
                        System.out.println("2. Deletar cadastro");
                        res = tec.nextInt();
                        tec.nextLine(); 
                        System.out.println("Digite o ID do imóvel");
                        int id_imovel = tec.nextInt();
                        tec.nextLine(); 
                        Imovel imovel = i.findById(id_imovel);
                        if (imovel == null) {
                            System.out.println("Imóvel não encontrado.");

                        } else if (res == 1) {  // Editar cadastro
                            System.out.println("Imóvel encontrado: " + imovel.getDescricao());
                            System.out.println("Digite os novos dados para atualizar o imóvel:");
                            System.out.println("Digite o novo endereço do imóvel:");
                            String endereco = tec.nextLine();
                            System.out.println("Digite o novo tipo de imóvel:");
                            String tipo = tec.nextLine();
                            System.out.println("Digite uma nova descrição do imóvel:");
                            String descricao = tec.nextLine();
                            System.out.println("Digite a nova área do imóvel:");
                            double area = tec.nextDouble();
                            System.out.println("Digite o novo valor de venda do imóvel:");
                            double valorVenda = tec.nextDouble();
                            System.out.println("Digite o novo valor de aluguel do imóvel:");
                            double valorAluguel = tec.nextDouble();
                            System.out.println("Digite o novo ano de construção do imóvel:");
                            int anoConstrucao = tec.nextInt();
                            tec.nextLine(); // Consumir nova linha
                
                            // Atualizar as informações do imóvel
                            imovel.setEndereco(endereco);
                            imovel.setTipo(tipo);
                            imovel.setDescricao(descricao);
                            imovel.setArea(area);
                            imovel.setValorVenda(valorVenda);
                            imovel.setValorAluguel(valorAluguel);
                            imovel.setAnoConstrucao(anoConstrucao);
                
                            i.update(imovel);
                            System.out.println("Imóvel atualizado com sucesso!");
                
                        } else if (res == 2) { // Deletar cadastro
                            i.delete(imovel);
                            System.out.println("Imóvel deletado com sucesso!");
                        }
                    }
               

            // opção 6
            } else if(res == 6) {
                System.out.println("Lista de clientes:");
                    ArrayList<Cliente> lista = c.getAll();              
                    if (lista.isEmpty()) {
                        System.out.println("Nenhum cliente cadastrado.");
                    } else {
                        for (Cliente cliente : lista) {
                            System.out.println(cliente);
                        }
                    }             
                    System.out.println("Deseja fazer alguma alteração? Digite 'sim' ou 'não'");
                    String r = tec.nextLine();     
                    if (r.equalsIgnoreCase("sim")) {
                        System.out.println("\nEscolha a opção que deseja realizar:");
                        System.out.println("1. Editar cadastro");
                        System.out.println("2. Deletar cadastro");
                        res = tec.nextInt();
                        tec.nextLine(); 
                        System.out.println("Digite o ID do cliente");
                        int id_cliente = tec.nextInt();
                        tec.nextLine(); 
                        Cliente cliente = c.findById(id_cliente);
                        if (cliente == null) {
                            System.out.println("Cliente não encontrado.");

                        } else if (res == 1) {  // Editar cadastro
                            System.out.println("Cliente encontrado: " + cliente.getNome());
                            System.out.println("Digite os novos dados para atualizar o cliente:");
                            System.out.println("Digite o nome:");
                            String nome_cliente = tec.nextLine();
                            System.out.println("Digite o email:");
                            String email_cliente = tec.nextLine();
                            System.out.println("Digite o telefone:");
                            String tel = tec.nextLine();
                            System.out.println("Digite a data de nascimento:");
                            String data_nasc = tec.nextLine();
                            System.out.println("Digite o cpf:");
                            String cpf = tec.nextLine();
                            System.out.println("Digite o endereço:");
                            String endereco = tec.nextLine();
                
                            // Atualizar as informações do imóvel
                            cliente.setNome(nome_cliente);
                            cliente.setEmail(email_cliente);
                            cliente.setTel(tel);
                            cliente.setDataNasc(data_nasc);
                            cliente.setCpf(cpf);
                            cliente.setEndereco(endereco);
        
                            c.update(cliente);
                            System.out.println("Cliente atualizado com sucesso!");
                
                        } else if (res == 2) { // Deletar cadastro
                            c.delete(cliente);
                            System.out.println("cliente deletado com sucesso!");
                        }
                    }

            // opção 7
            } else if(res == 7) {
                System.out.println("Lista de corretores:");
                ArrayList<Corretor> lista = cor.getAll();              
                    for (Corretor corretor: lista) {
                        System.out.println(corretor);
                    }


            // opção 8
            } else if(res == 8) {
                System.out.println("O cliente que deseja fazer a locação ja possui cadastro? Digite 'sim' ou 'não: ");
                Cliente cliente = null;
                Imovel imovel = null;
                String r = tec.nextLine();

                if (r.equalsIgnoreCase("sim")) {
                    System.out.println("Digite o CPF do cliente cadastrado:");
                    String cpf = tec.nextLine();
                    cliente = c.findByCpfCliente(cpf);  // Atribuindo o cliente encontrado à variável cliente
                    
                    if (cliente != null) {
                        System.out.println("Cliente encontrado! " + cliente.getNome());
                        System.out.println("Digite o ID do imóvel que será locado:");
                        int id_imovel = tec.nextInt();
                        tec.nextLine(); 
                        imovel = i.findById(id_imovel); 

                        if (imovel != null) {
                            System.out.println("Imóvel encontrado! " + imovel.getDescricao());
                            System.out.println("Digite a data de início de início da locação:");
                            String dataInicio = tec.nextLine();
                            System.out.println("Digite a data de fim de início da locação:");
                            String dataFim = tec.nextLine();
                            Locacao locacao = new Locacao(cliente, imovel, dataInicio, dataFim);
                            loc.create(locacao);
                        } else {
                            System.out.println("Para realizar a locação, é necessário o cliente estar cadastrado: ");
                            
                        }
                    }
                }
            }
    
    
    
        } while (res!=9);

    }
}
                
       

