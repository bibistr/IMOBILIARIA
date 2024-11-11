package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Cliente;
import model.Contrato;
import model.Corretor;
import model.Imovel;

public class ContratoDAO {
    private Connection bd;
    private ClienteDAO clienteDAO;  
    private CorretorDAO corretorDAO;
    private ImovelDAO imovelDAO;

    public ContratoDAO() {
        this.bd = BancoDeDados.getBd();
        this.clienteDAO = new ClienteDAO(); 
        this.corretorDAO = new CorretorDAO();
        this.imovelDAO = new ImovelDAO();
    }

    public void create(Contrato contrato) throws SQLException {                                          
        String query = "INSERT INTO contrato (id_cliente, id_corretor, id_imovel, data_inicio, data_fim, comissao) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement st = this.bd.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
        st.setInt(1, contrato.getCliente().getIdCliente());
        st.setInt(2, contrato.getCorretor().getIdCorretor());
        st.setInt(3, contrato.getImovel().getIdImovel());
        st.setString(4, contrato.getDataInicio());
        st.setString(5, contrato.getDataFim());
        st.setDouble(6, contrato.getComissao());
        st.executeUpdate(); 

        try (ResultSet generatedKeys = st.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                int idGerado = generatedKeys.getInt(1); // Obtem o ID gerado
                contrato.setIdContrato(idGerado); // 
            } else {
                throw new SQLException("Falha ao obter o ID gerado.");
            }
        }
    }

    //UPDATE
    public void update (Contrato contrato) throws SQLException {
        String query = """
        UPDATE contrato
        SET data_inicio = ?, data_fim = ?
        WHERE  id_imovel = ?
        """;
        PreparedStatement st = this.bd.prepareStatement(query);
        st.setString(1, contrato.getDataInicio());
        st.setString(2, contrato.getDataFim());
        st.setInt(3,contrato.getImovel().getIdImovel());
        st.executeUpdate();
    }

    //CONSULTA
    ArrayList<Contrato>findByDataInicio(String d) throws SQLException {
        ArrayList<Contrato> lista = new ArrayList<>();
        String query = """
        SELECT * FROM contrato
        WHERE  data_inicio LIKE ?
        """;
        PreparedStatement st = this.bd.prepareStatement(query);
        st.setString(1, "%" + d + "%");
        ResultSet res = st.executeQuery();
        while(res.next()) {
            int id_contrato = res.getInt("id");
            int id_cliente = res.getInt("id_cliente");
            int id_corretor = res.getInt("id_corretor");
            int id_imovel = res.getInt("id_imovel");
            String data_inicio = res.getString("data_inicio");
            String data_fim = res.getString("data_fim");  
            double comissao = res.getDouble("comissao");

            Cliente cliente = clienteDAO.findById(id_cliente);
            Corretor corretor = corretorDAO.findById(id_corretor);
            Imovel imovel = imovelDAO.findById(id_imovel);

            Contrato contrato = new Contrato(id_contrato, cliente, corretor, imovel, data_inicio, data_fim, comissao);
            lista.add(contrato); 
        }
        return lista;
    }


    ///DELETE
    public void delete(Contrato contrato) throws SQLException {
        String query = """
        DELETE FROM contrato
        WHERE id_cliente = ?
        """;
        PreparedStatement st = this.bd.prepareStatement(query);
        st.setInt(1, contrato.getCliente().getIdCliente());
        st.executeUpdate();
    }


    public ArrayList<Contrato> getAll() throws SQLException {
        ArrayList<Contrato> listaContratos = new ArrayList<>();
        String query = "SELECT id_contrato, id_cliente, id_corretor, id_imovel, data_inicio, data_fim, comissao FROM contrato";
        PreparedStatement st = this.bd.prepareStatement(query);
        ResultSet res = st.executeQuery();
        while (res.next()) {
            int id_contrato = res.getInt("id_contrato");
            int id_cliente = res.getInt("id_cliente");
            int id_corretor = res.getInt("id_corretor");
            int id_imovel = res.getInt("id_imovel");
            //  arrumar isso
            String data_inicio = res.getString("data_inicio");
            String data_fim = res.getString("data_fim");
            double comissao = res.getDouble("comissao");

            Cliente cliente = clienteDAO.findById(id_cliente);
            Corretor corretor = corretorDAO.findById(id_corretor);
            Imovel imovel = imovelDAO.findById(id_imovel);

            Contrato contrato = new Contrato(id_contrato, cliente, corretor, imovel , data_inicio, data_fim, comissao); /////
            listaContratos.add(contrato);
        }
        return listaContratos;
    }

} 