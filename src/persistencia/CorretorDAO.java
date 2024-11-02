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

    //UPDATE
    public void update (Corretor cor) throws SQLException {
        String query = """
        UPDATE corretor
        SET nome = ?, email = ?, tel = ?
        WHERE creci = ?;
        """;

        PreparedStatement st = this.bd.prepareStatement(query);
        st.setString(cor.getNome());
        st.setString(cor.getEmail());
        st.setString(cor.getTel());
        st.setString(cor.getCreci());
        st.executeUpdate();
    }

    //READ
    public ArrayList<Corretor>findByNomeLike(String n) throws SQLException {
        ArrayList<Corretor> lista = new ArrayList<Corretor>();
        String query = """
        SELECT email, tel, creci 
        WHERE nome LIKE ?
        """;

        PreparedStatement st = this.bd.prepareStatement(query);
        st.setString(1, "%" + n + "%");
        ResultSet res = st.executeQuery();
        while(res.next()) {
            int id_corretor = res.getInt("id_corretor");
            String nome = res.getString("nome");
            String email = res.getString("email");
            String tel = res.getString("tel");
            String creci = res.getString("creci");
            Corretor cor = new Corretor(id_corretor, nome, email, tel, creci);
            lista.add(cor);
        }
        return lista;
    }

    //DELTE
    public void delete(Corretor cor) throws SQLException {
        String query  = """
        DELETE FROM corretor
        WHERE  creci = ?
        """;
        PreparedStatement st = this.bd.prepareStatement(query);
        st.setString(cor.getCreci());
        st.executeUpdate();
    }
    

    public ArrayList<Corretor> getAll() throws SQLException {
        ArrayList<Corretor> lista_geral = new ArrayList<Corretor>();
        String query = "SELECT nome, email, tel, creci FROM corretor";
        PreparedStatement st = this.bd.prepareStatement(query);
        ResultSet res = st.executeQuery();
        while (res.next()) {
            int id_corretor = res.getInt("id_corretor");
            String nome = res.getString("nome");
            String email = res.getString("email");
            String tel = res.getString("tel");
            String creci = res.getString("creci");
            Corretor cor = new Corretor(id_corretor, nome_corretor, email_corretor, tel_corretor, creci);
            lista.add(cor);
        }
        return lista_geral;
    }
}
