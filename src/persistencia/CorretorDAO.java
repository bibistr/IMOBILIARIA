package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Corretor;

public class CorretorDAO{
    private conection bd;

    public corretorDAO() {
        this.bd = BancoDeDados.getBd();
    }

    public void create (Corretor c) throws SQLException {
        String query = "INSERT INTO corretor VALUES(null, ?, ?, ?, ?)";
        prepareStatement st = this.bd.prepareStatement(query);
        st.setString(1, c.getNome());
        st.setString(2, c.getEmail());
        st.setString(3, c.getTel());
        st.setString(4, c.getCreci());
        st.executeUpdate();
    }

    public ArrayList<Corretor> getAll() throws SQLException {
        ArrayList<Corretor> lista = new ArrayList<Corretor>();
        String query = "SELECT nome, email, tel, creci FROM corretor";
        PreparedStatement st = this.bd.prepareStatement(query);
        ResultSet res = st.executeQuery();
        while (res.next()) {
            String nome = res.getString("nome");
            String email = res.getString("email");
            String tel = res.getString("tel");
            String creci = res.getString("creci");
            Corretor c = new Corretor(nome, email, tel, creci);
            lista.add(c);
        }
        return lista;
    }
}
