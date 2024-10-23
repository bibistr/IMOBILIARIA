package model;
import java.util.ArrayList;

public class Cad_Cliente {

    private ArrayList<Cliente> clientes;


    Cad_Cliente(){
        
    this.clientes = new ArrayList<Cliente>();
} 
    public void cadastrarCliente(String nome_cliente, String email_cliente, String tel_cliente, String data_nasc, String cpf, String endereco){

        Cliente c = new Cliente(nome_cliente, email_cliente, tel_cliente, data_nasc, cpf, endereco);

        clientes.add(c);
    }


    @Override
    public String toString() {
        String s = "";
         for(int i = 1; i<this.clientes.size(); i++){
            s+= this.clientes.get(i)+"\n";
         }
         return s;
    }
    







}
