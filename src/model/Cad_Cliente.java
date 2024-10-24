package model;
import java.util.ArrayList;

public class Cad_Cliente {

    private ArrayList<Cliente> clientes;

    Cad_Cliente(){
      this.clientes = new ArrayList<Cliente>();
    }


    public void addClientes(Cliente c) {
      clientes.add(c);
    }

    @Override
    public String toString() {
      StringBuilder resultado = new StringBuilder();
      for (Cliente c : clientes) {
        resultado.append(c).append("\n");
      }
      return resultado.toString();
    }

    //CLASSE CADASTRO DE CLIENTES. FOI CRIADA PARA FACILITAR, JA QUE COM ELA É NECESSÁRIA A CRIAÇÃO DE APENAS 1 ARRAYLIST :)

  }
  
