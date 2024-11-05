package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Imovel;

public class ImovelDAO {
    private Connection bd;

    public ImovelDAO() {
        this.bd = BancoDeDados.getBd();
    }

    public void create(Imovel imovel) throws SQLException {
        String query = "INSERT INTO imovel VALUES (null, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement st = this.bd.prepareStatement(query);
        st.setString(1, imovel.getEndereco());
        st.setString(2, imovel.getTipo());
        st.setString(3, imovel.getDescricao());
        st.setDouble(4, imovel.getArea());
        st.setDouble(5, imovel.getValor_venda());
        st.setDouble(6, imovel.getValor_aluguel());
        st.setInt(7, imovel.getAno_construcao());
        st.executeUpdate();

        try (ResultSet generatedKeys = st.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                int idGerado = generatedKeys.getInt(1); // Obtém o ID gerado//
                imovel.setId_imovel(idGerado); //
            } else {
                throw new SQLException("Falha ao obter o ID gerado.");
            }
        }
    }

    //UPDATE
    public void update (Imovel imovel) throws SQLException {
        String query = """
        UPDATE imovel
        SET  endereco = ?, tipo = ?, descricao = ?, area = ?, valor_venda = ?, valor_aluguel = ?, ano construcao = ?
        WHERE  id_imovel = ?
        """;
        PreparedStatement st = this.bd.prepareStatement(query);
        st.setString(1, imovel.getEndereco());
        st.setString(2, imovel.getTipo());
        st.setString(3, imovel.getDescricao());
        st.setDouble(4, imovel.getArea());
        st.setDouble(5, imovel.getValor_venda());
        st.setDouble(6, imovel.getValor_aluguel());
        st.setInt(7, imovel.getAno_construcao());
        st.executeUpdate();
    }

    //READ
    public ArrayList<Imovel>findByNomeLike(String t ) throws SQLException {
        ArrayList<Imovel> lista = new ArrayList<>();
        String query = """
        SELECT id_ imovel, endereco, tipo, descricao, area, valor_venda, valor_aluguel, ano construcao
        WHERE tipo LIKE ?
        """;
        PreparedStatement st = this.bd.prepareStatement(query);
        st.setString(1, "%" + t + "%");
        ResultSet res = st.executeQuery();
        while(res.next()) {
            int id_imovel = res.getInt("id_imovel");
            String endereco= res.getString("endereco");
            String tipo = res.getString("tipo");
            String descricao= res.getString("descricao");
            double area = res.getDouble("area");
            double valor_venda = res.getDouble("valor_venda");
            double valor_aluguel = res.getDouble("valor_aluguel");
            int ano_construcao = res.getInt("ano_construcao");
            Imovel imovel = new Imovel(id_imovel, endereco, tipo, descricao, area, valor_venda, valor_aluguel, ano_construcao);
            lista.add(imovel);
        }
        return lista;
    }

     public void delete(Imovel imovel) throws SQLException {
        String query  = """
        DELETE FROM imovel
        WHERE  id_imovel = ?
        """;
        PreparedStatement st = this.bd.prepareStatement(query);
        st.setInt(1, imovel.getId_imovel());
        st.executeUpdate();
    }

    public ArrayList<Imovel> getAll() throws SQLException {
		ArrayList<Imovel> lista = new ArrayList<>();
		String query = "SELECT endereco, tipo, descricao, area, valor_venda, valor_aluguel, ano_construcao FROM imovel";
		PreparedStatement st = this.bd.prepareStatement(query);
		ResultSet res = st.executeQuery();
		while (res.next()) {
            int id_imovel = res.getInt("id_imovel");
			String endereco = res.getString("endereco");
			String tipo = res.getString("tipo");
			String descricao = res.getString("descricao");
            double area = res.getDouble("area");
            double valor_venda = res.getDouble("valor_venda");
            double valor_aluguel = res.getDouble("valor_aluguel");
            int ano_construcao = res.getInt("ano_construcao"); // INT !!!
			Imovel imovel = new Imovel(id_imovel, endereco, tipo, descricao, area, valor_venda, valor_aluguel, ano_construcao);
			lista.add(imovel);
		}
		return lista;
	}

}