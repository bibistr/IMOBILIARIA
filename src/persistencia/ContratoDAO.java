package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Contrato;

public class ContratoDAO {
    private Connection bd;

    public ContratoDAO() {
        this.bd = BancoDeDados.getBd();
    }

    public void create(Contrato contrato) throws SQLException {
        String query = "INSERT INTO contrato (id_cliente, id_corretor, id_imovel, data_inicio, data_fim) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement st = this.bd.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
        st.setInt(1, contrato.getId_cliente());
        st.setInt(2, contrato.getId_corretor());
        st.setInt(3, contrato.getId_imovel());
        st.setString(4, contrato.getData_inicio());
        st.setString(5, contrato.getData_fim());
        st.executeUpdate();

        try (ResultSet generatedKeys = st.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                int idGerado = generatedKeys.getInt(1); // Obtém o ID gerado
                contrato.setId(idGerado); // 
            } else {
                throw new SQLException("Falha ao obter o ID gerado.");
            }
        }
    }

    public ArrayList<Contrato> getAll() throws SQLException {
        ArrayList<Contrato> listaContratos = new ArrayList<>();
        String query = "SELECT id, id_cliente, id_corretor, id_imovel, data_inicio, data_fim FROM contrato";
        PreparedStatement st = this.bd.prepareStatement(query);
        ResultSet res = st.executeQuery();
        while (res.next()) {
            int id = res.getInt("id");
            int id_cliente = res.getInt("id_cliente");
            int id_corretor = res.getInt("id_corretor");
            int id_imovel = res.getInt("id_imovel");
            String data_inicio = res.getString("data_inicio");
            String data_fim = res.getString("data_fim");
            Contrato contrato = new Contrato(id, id_cliente, id_corretor, id_imovel, data_inicio, data_fim);
            listaContratos.add(contrato);
        }
        return listaContratos;
    }

}
