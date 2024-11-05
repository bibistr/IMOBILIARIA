package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Locacao;

public class LocacaoDAO {
    private Connection bd;

    public LocacaoDAO() {
        this.bd = BancoDeDados.getBd();
    }

    public void create(Locacao l) throws SQLException {
        String query = "INSERT INTO locacao (id_cliente, id_imovel, data_inicio, data_fim) VALUES (?, ?, ?, ?)";
        PreparedStatement st = this.bd.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
        st.setInt(1, l.getIdCliente());
        st.setInt(2, l.getIdImovel());
        st.setString(3, l.getDataInicio());
        st.setString(4, l.getDataFim());
        st.executeUpdate();

        try (ResultSet generatedKeys = st.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                int idGerado = generatedKeys.getInt(1); // Obtém o ID gerado
                l.setIdLocacao(idGerado);
            } else {
                throw new SQLException("Falha ao obter o ID gerado.");
            }
        }
    }

    //UPDATE
    public void update (Locacao l) throws SQLException {
        String query = """
        UPDATE locacao
        SET data_inicio, data_fim = ?
        WHERE id_locacao = ?;
        """;

        PreparedStatement st = this.bd.prepareStatement(query);
        st.setString(1, l.getDataInicio());
        st.setString(2, l.getDataFim());
        st.executeUpdate();
    }

    //READ
    public ArrayList<Locacao>findByNomeLike(String d) throws SQLException {
        ArrayList<Locacao> lista = new ArrayList<>();
        String query = """
        SELECT * FROM locacao
        WHERE data_inicio LIKE ?
        """;

        PreparedStatement st = this.bd.prepareStatement(query);
        st.setString(1, "%" + d + "%");
        ResultSet res = st.executeQuery();
        while(res.next()) {
            int id_locacao = res.getInt("id_locacao");
            int id_cliente = res.getInt("id_cliente");
            int id_imovel = res.getInt("id_imovel");
            String data_inicio = res.getString("data_inicio");
            String data_fim = res.getString("data_fim");
            Locacao l = new Locacao(id_locacao, id_cliente, id_imovel, data_inicio, data_fim);
            lista.add(l);
        }
        return lista;
    }

     public void delete(Locacao l) throws SQLException {
        String query  = """
        DELETE FROM locacao
        WHERE  id_locacao = ?
        """;
        PreparedStatement st = this.bd.prepareStatement(query);
        st.setInt(1, l.getIdLocacao());
        st.executeUpdate();
    }

    public ArrayList<Locacao> getAll() throws SQLException {
        ArrayList<Locacao> listaContratos = new ArrayList<>();
        String query = "SELECT id_cliente, id_imovel, data_inicio, data_fim, FROM l";
        PreparedStatement st = this.bd.prepareStatement(query);
        ResultSet res = st.executeQuery();
        while (res.next()) {
            int id_locacao = res.getInt("id_locacao");
            int id_cliente = res.getInt("id_cliente");
            int id_imovel = res.getInt("id_imovel");
            String data_inicio = res.getString("data_inicio");
            String data_fim = res.getString("data_fim");
            Locacao l = new Locacao(id_locacao, id_cliente, id_imovel, data_inicio, data_fim);
            listaContratos.add(l);
        }
        return listaContratos;
    }

}
