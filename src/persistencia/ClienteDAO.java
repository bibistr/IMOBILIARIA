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
        String query = "INSERT INTO cliente (nome_cliente, email, tel, data_nasc, cpf, endereco) VALUES(?, ?, ?, ?, ?, ? )";
        try (PreparedStatement st = this.bd.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
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
    }


  //UPDATE 
    public void update(Cliente cliente) throws SQLException {
        String query = """
        UPDATE cliente
        SET nome_cliente  = ?, endereco = ?, tel = ?, email = ?
        WHERE cpf = ?
        """;
        
        try (PreparedStatement st = this.bd.prepareStatement(query)) {
            st.setString(1, cliente.getNome());
            st.setString(2, cliente.getEndereco());
            st.setString(3, cliente.getEmail());
            st.setString(4, cliente.getTel());
            st.setString(5, cliente.getCpf());
            st.executeUpdate();
        }
    }

// READ/CONSULTA
    public ArrayList<Cliente>findByNomeLike(String n) throws SQLException {
        ArrayList<Cliente> lista = new ArrayList<>();
        String query = """
        SELECT * FROM cliente
        WHERE nome_cliente LIKE ?
        """;
        try (PreparedStatement st = this.bd.prepareStatement(query)) {
            st.setString(1, "%" + n + "%");
            try (ResultSet res = st.executeQuery()) {
                while(res.next()) {
                    int id_cliente = res.getInt("id_cliente");
                    String nome = res.getString("nome_cliente");
                    String email = res.getString("email");
                    String tel = res.getString("tel");
                    String data_nasc = res.getString("data_nasc");
                    String cpf = res.getString("cpf");
                    String endereco = res.getString("endereco");
                    Cliente cliente = new Cliente(id_cliente, nome, email, tel, data_nasc, cpf, endereco);
                    lista.add(cliente);
                }
                return lista;
            }
        }
    }

    public Cliente findById(int id_cliente) throws SQLException {
        String query = """
        SELECT * FROM cliente 
        WHERE id_cliente = ?
        """;
        try (PreparedStatement st = this.bd.prepareStatement(query)) {
            st.setInt(1, id_cliente);
            try (ResultSet res = st.executeQuery()) {
                if (res.next()) {
                return new Cliente(
                    res.getInt("id_cliente"),
                    res.getString("nome_cliente"),
                    res.getString("cpf"),
                    res.getString("endereco"),
                    res.getString("telefone"),
                    res.getString("email"),
                    res.getString("data_nascimento")
                    );
                } else {
                    throw new SQLException("Cliente com ID " + id_cliente + " não encontrado.");
                }
            }
        }
    }

    public Cliente findByCpfCliente(String cpf) throws SQLException {
        String query = """
        SELECT * FROM cliente 
        WHERE cpf = ?"
        """;
        try (PreparedStatement st = this.bd.prepareStatement(query)) {
            st.setString(1, cpf);
            try (ResultSet res = st.executeQuery()) {
                if (res.next()) {
                return new Cliente(
                    res.getInt("id_cliente"),
                    res.getString("nome_cliente"),
                    res.getString("cpf"),
                    res.getString("endereco"),
                    res.getString("telefone"),
                    res.getString("email"),
                    res.getString("data_nascimento")
                    );
                } else {
                    throw new SQLException("Cliente com cpf " + cpf + " não encontrado.");
                }
            }
        }
    }

    // DELETE
    public void delete(Cliente cliente) throws SQLException {
        String query = """
        DELETE FROM cliente
        WHERE cpf = ?
        """;
        try (PreparedStatement st = this.bd.prepareStatement(query)) {
            st.setString(1, cliente.getCpf());
            st.executeUpdate();
        }
    }


    //LISTA GERAL
    public ArrayList<Cliente> getAll() throws SQLException {
        ArrayList<Cliente> lista_geral = new ArrayList<>();
        String query = "SELECT id_cliente, nome, email, tel, data_nasc, cpf, endereco FROM cliente";
        try (PreparedStatement st = this.bd.prepareStatement(query)) {
            try (ResultSet res = st.executeQuery()) {
                while(res.next()) {
                    int id_cliente = res.getInt("id_cliente");
                    String nome_cliente = res.getString("nome_cliente");
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
        }
    }

}

