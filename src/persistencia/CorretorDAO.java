package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Corretor;

public class CorretorDAO{
    private Connection bd;

    public CorretorDAO() {
        this.bd = BancoDeDados.getBd();
    }

    public void create (Corretor cor) throws SQLException {
        String query = "INSERT INTO corretor VALUES(null, ?, ?, ?, ?)";
        PreparedStatement st = this.bd.prepareStatement(query);
        st.setString(1, cor.getNome());
        st.setString(2, cor.getEmail());
        st.setString(3, cor.getTel());
        st.setString(4, cor.getCreci());
        st.executeUpdate();
    
        try (ResultSet generatedKeys = st.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                int idGerado = generatedKeys.getInt(1); // Obtém o ID gerado
                cor.setId_corretor(idGerado); //
            } else {
                throw new SQLException("Falha ao obter o ID gerado.");
            }
        }
    }

    public ArrayList<Corretor> getAll() throws SQLException {
        ArrayList<Corretor> lista = new ArrayList<Corretor>();
        String query = "SELECT nome, email, tel, creci FROM corretor";
        PreparedStatement st = this.bd.prepareStatement(query);
        ResultSet res = st.executeQuery();
        while (res.next()) {
            int id_corretor = res.getInt("id_corretor");
            String nome_corretor = res.getString("nome");
            String email_corretor = res.getString("email");
            String tel_corretor = res.getString("tel");
            String creci = res.getString("creci");
            Corretor cor = new Corretor(id_corretor, nome_corretor, email_corretor, tel_corretor, creci);
            lista.add(cor);
        }
        return lista;
    }
}
