package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Cliente;

public class ClienteDAO{
    private Connection bd;

    public ClienteDAO() {
        this.bd = BancoDeDados.getBd();
    }

    public void create(Cliente cliente) throws SQLException {
        String query = "INSERT INTO cliente (nome, email, tel, data_nasc, cpf, endereco) VALUES(?, ?, ?, ?, ?, ? )";
        PreparedStatement st = this.bd.prepareStatement(query);
        st.setString(1, cliente.getNome());
        st.setString(6, cliente.getEndereco());
        st.setString(2, cliente.getEmail());
        st.setString(3, cliente.getTel());
        st.setString(4, cliente.getDataNasc());
        st.setString(5, cliente.getCpf());
        st.executeUpdate();

        try (ResultSet generatedKeys = st.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                int idGerado = generatedKeys.getInt(1); // Obtém o ID gerado
                cliente.setIdCliente(idGerado); //
            } else {
                throw new SQLException("Falha ao obter o ID gerado.");
            }
        }
    }


  //UPDATE 
    public void update(Cliente cliente) throws SQLException {
        String query = """
        UPDATE cliente
        SET nome  = ?, endereco = ?, tel = ?, email = ?
        WHERE cpf = ?
        """;
    
    PreparedStatement st = this.bd.prepareStatement(query);
    st.setString(1, cliente.getNome());
    st.setString(2, cliente.getEndereco());
    st.setString(3, cliente.getEmail());
    st.setString(4, cliente.getTel());
    st.setString(5, cliente.getCpf());
    st.executeUpdate();
    }

// READ/CONSULTA
    public ArrayList<Cliente>findByNomeLike(String n) throws SQLException {
        ArrayList<Cliente> lista = new ArrayList<>();
        String query = """
               SELECT * FROM cliente
               WHERE nome LIKE ?"
               """;

               PreparedStatement st = this.bd.prepareStatement(query);
               st.setString(1, "%" + n + "%");
               ResultSet res = st.executeQuery();
               while(res.next()) {
                int id_cliente = res.getInt("id_cliente");
                String nome = res.getString("nome");
                String endereco = res.getString("endereco");/////
                String email = res.getString("email");
                String tel = res.getString("tel");
                String data_nasc = res.getString("data_nasc");
                String cpf = res.getString("cpf");
                Cliente cliente = new Cliente(id_cliente, nome, endereco, email, tel, data_nasc, cpf);
                lista.add(cliente);
               }
               return lista;
    }



    // DELETE
    public void delete(Cliente cliente) throws SQLException {
        String query = """
        DELETE FROM cliente
        WHERE cpf = ?"
        """;
        PreparedStatement st = this.bd.prepareStatement(query);
        st.setString(1, cliente.getCpf());
        st.executeUpdate();
    }


    //LISTA GERAL
    public ArrayList<Cliente> getAll() throws SQLException {
        ArrayList<Cliente> lista_geral = new ArrayList<>();
        String query = "SELECT id_cliente, nome, email, tel, data_nasc, cpf, endereco FROM cliente";
        PreparedStatement st = this.bd.prepareStatement(query);
        ResultSet res = st.executeQuery();
        while(res.next()) {
            int id_cliente = res.getInt("id_cliente");
            String nome_cliente = res.getString("nome");
            String email_cliente = res.getString("email");
            String tel_cliente = res.getString("tel");
            String data_nasc = res.getString("data_nasc");
            String cpf =  res.getString("cpf");
            String endereco = res.getString("endereco");
            Cliente cliente = new Cliente(id_cliente, nome_cliente, email_cliente, tel_cliente, data_nasc, cpf, endereco);
            lista_geral.add(cliente);
        }
        return lista_geral;
    }

    public Cliente findById(int id_cliente) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }
}
