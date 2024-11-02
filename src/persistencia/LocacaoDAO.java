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
        String query = "INSERT INTO l (id_cliente, id_imovel, data_inicio, data_fim) VALUES (?, ?, ?, ?)";
        PreparedStatement st = this.bd.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
        st.setInt(1, l.getId_cliente());
        st.setInt(2, l.getId_imovel());
        st.setString(3, l.getData_inicio());
        st.setString(4, l.getData_fim());
        st.executeUpdate();

        try (ResultSet generatedKeys = st.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                int idGerado = generatedKeys.getInt(1); // Obtém o ID gerado
                l.setId_locacao(idGerado);
            } else {
                throw new SQLException("Falha ao obter o ID gerado.");
            }
        }
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

}//
