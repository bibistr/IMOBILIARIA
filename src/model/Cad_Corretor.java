package model;
import java.util.ArrayList;

public class Cad_Corretor {

    private ArrayList<Corretor> corretores;

    Cad_Corretor(){
        this.corretores = new ArrayList<Corretor>();
    }


    public void cadastrarCorretor(String nome_corretor, String email_corretor, String tel_corretor, String creci){

    Corretor cor = new Corretor( nome_corretor, email_corretor, tel_corretor, creci);

    this.corretores.add(cor);


    }

    @Override
    public String toString() {
        String s = "";

        for(int i = 1; i < this.corretores.size(); i++){
            s+= this.corretores.get(i)+"\n";
        }

        return s;
    }

}
