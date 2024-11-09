package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Cliente;
import model.Corretor;
import model.Imovel;

public class ImovelDAO {
    private Connection bd;
    private ClienteDAO clienteDAO;  
    private CorretorDAO corretorDAO;

    public ImovelDAO() {
        this.bd = BancoDeDados.getBd();
        this.clienteDAO = new ClienteDAO(); 
        this.corretorDAO = new CorretorDAO();
    }

    public void create(Imovel imovel) throws SQLException {
        String query = "INSERT INTO imovel VALUES (null, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement st = this.bd.prepareStatement(query);
        st.setString(1, imovel.getEndereco());
        st.setString(2, imovel.getTipo());
        st.setString(3, imovel.getDescricao());
        st.setDouble(4, imovel.getArea());
        st.setDouble(5, imovel.getValorVenda());
        st.setDouble(6, imovel.getValorAluguel());
        st.setInt(7, imovel.getAnoConstrucao());
        st.executeUpdate();

        try (ResultSet generatedKeys = st.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                int idGerado = generatedKeys.getInt(1); // Obtém o ID gerado//
                imovel.setIdImovel(idGerado); //
            } else {
                throw new SQLException("Falha ao obter o ID gerado.");
            }
        }
    }

    //UPDATE
    public void update (Imovel imovel) throws SQLException {
        String query = """
        UPDATE imovel
        SET  endereco = ?, tipo = ?, descricao = ?, area = ?, valor_venda = ?, valor_aluguel = ?, ano_construcao = ?
        WHERE  id_imovel = ?
        """;
        PreparedStatement st = this.bd.prepareStatement(query);
        st.setString(1, imovel.getEndereco());
        st.setString(2, imovel.getTipo());
        st.setString(3, imovel.getDescricao());
        st.setDouble(4, imovel.getArea());
        st.setDouble(5, imovel.getValorVenda());
        st.setDouble(6, imovel.getValorAluguel());
        st.setInt(7, imovel.getAnoConstrucao());
        st.executeUpdate();
    }

    //READ
    public ArrayList<Imovel>findByTipoLike(String t ) throws SQLException {
        ArrayList<Imovel> lista = new ArrayList<>();
        String query = """
        SELECT id_ imovel, id_cliente, id_corretor, endereco, tipo, descricao, area, valor_venda, valor_aluguel, ano construcao
        FROM imovel
        WHERE tipo LIKE ?
        """;
        PreparedStatement st = this.bd.prepareStatement(query);
        st.setString(1, "%" + t + "%");
        ResultSet res = st.executeQuery();
        while(res.next()) {
            int id_imovel = res.getInt("id_imovel");
            int id_cliente = res.getInt("id_cliente");
            int id_corretor = res.getInt("id_corretor");
            String endereco= res.getString("endereco");
            String tipo = res.getString("tipo");
            String descricao= res.getString("descricao");
            double area = res.getDouble("area");
            double valor_venda = res.getDouble("valor_venda");
            double valor_aluguel = res.getDouble("valor_aluguel");
            int ano_construcao = res.getInt("ano_construcao");

            Cliente cliente = clienteDAO.findById(id_cliente);
            Corretor corretor = corretorDAO.findById(id_corretor);

            Imovel imovel = new Imovel(id_imovel, cliente, corretor, endereco, tipo, descricao, area, valor_venda, valor_aluguel, ano_construcao);
            lista.add(imovel);
        }
        return lista;
    }

    public Imovel findById(int idImovel) throws SQLException {
        String query = """
        SELECT * FROM Imovel
        WHERE id_imovel = ?"
        """;

        PreparedStatement st = bd.prepareStatement(query);
        st.setInt(1, idImovel);
        ResultSet res = st.executeQuery();
        if (res.next()) {
            int id_cliente = res.getInt("id_cliente");
            int id_corretor = res.getInt("id_corretor");
            Cliente cliente = new ClienteDAO().findById(id_cliente); 
            Corretor corretor = new CorretorDAO().findById(id_corretor); 
        
            return new Imovel(
                res.getInt("id_imovel"),
                cliente,
                corretor,
                res.getString("endereco"),
                res.getString("tipo"),
                res.getString("descricao"),
                res.getDouble("area"),
                res.getDouble("valor_venda"),
                res.getDouble("valor_aluguel"),
                res.getInt("ano_construcao")
            );
        } else {
            throw new SQLException("Imovel com ID " + idImovel + " não encontrado.");
        }
    }

     public void delete(Imovel imovel) throws SQLException {
        String query  = """
        DELETE FROM imovel
        WHERE  id_imovel = ?
        """;
        PreparedStatement st = this.bd.prepareStatement(query);
        st.setInt(1, imovel.getIdImovel());
        st.executeUpdate();
    }

    public ArrayList<Imovel> getAll() throws SQLException {
		ArrayList<Imovel> lista = new ArrayList<>();
		String query = "SELECT id_imovel, endereco, tipo, descricao, area, valor_venda, valor_aluguel, ano_construcao FROM imovel";
		PreparedStatement st = this.bd.prepareStatement(query);
		ResultSet res = st.executeQuery();
		while (res.next()) {
            int id_imovel = res.getInt("id_imovel");
            int id_cliente = res.getInt("id_cliente");
            int id_corretor = res.getInt("id_corretor");
			String endereco = res.getString("endereco");
			String tipo = res.getString("tipo");
			String descricao = res.getString("descricao");
            double area = res.getDouble("area");
            double valor_venda = res.getDouble("valor_venda");
            double valor_aluguel = res.getDouble("valor_aluguel");
            int ano_construcao = res.getInt("ano_construcao"); 

            Cliente cliente = clienteDAO.findById(id_cliente);
            Corretor corretor = corretorDAO.findById(id_corretor);

			Imovel imovel = new Imovel(id_imovel, cliente, corretor, endereco, tipo, descricao, area, valor_venda, valor_aluguel, ano_construcao);
			lista.add(imovel);
		}
		return lista;
	}

}