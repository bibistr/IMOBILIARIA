package model;
import java.util.ArrayList;

public class Cad_Corretor {

    private ArrayList<Corretor> corretores;

    Cad_Corretor(){
        this.corretores = new ArrayList<Corretor>();
    }


    public void cadastrarCorretor(Corretor cor){
        this.corretores.add(cor);
    }

    @Override
    public String toString() {
        StringBuilder resultado = new StringBuilder();
        for (Corretor cor : corretores) {
          resultado.append(cor).append("\n");
        }
        return resultado.toString();
    }

    //CLASSE CADASTRO DE CORRETORES. FOI CRIADA PARA FACILITAR, JA QUE COM ELA É NECESSÁRIA A CRIAÇÃO DE APENAS 1 ARRAYLIST :)
}
