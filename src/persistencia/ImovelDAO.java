package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Imovel;

public class ImovelDAO {
    private connection bd;

    public ImovelDAO() {
        this.bd = BancoDeDados.getBd();
    }

    public void create(Imovel i) throws SQLException {
        String query = "INSERT INTO imovel VALUES (null, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement st = this.bd.prepareStatement(query);
        st.setString(1, i.getEndereco());
        st.setString(2, i.etTipo());
        st.setString(3, i.etDescricao());
        st.setString(4, i.etArea());
        st.setString(5, i.etValor_venda());
        st.setString(6, i.etValor_aluguel());
        st.setString(7, i.etAno_construcao());// NÃO É STRING. TEMOS QUE DESCOBRIR COMO FAZ COM INT
        st.executeUpdate();

    }

    public ArrayList<Imovel> getAll() throws SQLException {
		ArrayList<Imovel> lista = new ArrayList<Imovel>();
		String query = "SELECT endereco, tipo, descricao, area, valor_venda, valor_aluguel, ano_construcao FROM imovel";
		PreparedStatement st = this.bd.prepareStatement(query);
		ResultSet res = st.executeQuery();
		while (res.next()) {
			String endereco = res.getString("endereco");
			String tipo = res.getString("tipo");
			String descricao = res.getString("descricao");
            String area =  res.getString("area");
            String valor_venda = res.getString("valor_venda");
            String valor_aluguel = res.getString("valor_aluguel");
            String ano_construcao = res.getString("ano_construcao"); // INT !!!
			Imovel i = new Imovel(endereco, tipo, descricao, area, valor_venda, valor_aluguel, ano_construcao);
			lista.add(i);
		}
		return lista;
	}



}