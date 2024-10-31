package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Cliente;

public class ClienteDAO{
    private connection bd;

    public ClienteDAO() {
        this.bd = BancoDeDados.getBd();
    }

    public voide create(Cliente c) throws SQLException {
        String query = "INSERT INTO cliente VALUES(null,?, ?, ?, ?, ?, ? )";
        PreparedStatement st = this.bd.prepareStatement(query);
        st.setString(1, c.getNome());
        st.setString(6, c.getEndereco());
        st.setString(2, c.getEmail());
        st.setString(3, c.getTel());
        st.setString(4, c.getData_nasc());
        st.setString(5, c.getCpf());
        st.executeUpdate
    }

    public ArrayList<Cliente> getAll() throws SQLException {
        ArrayList<Cliente> lista = new ArrayList<Cliente>();
        String query = "SELECT nome, email, tel, data_nasc, cpf, endereco FROM cliente";
        PreparedStatement st = this.bd.prepareStatement(query);
        ResultSet res = st.executeQuery();
        while(res.next()) {
            String nome = res.getString("nome");
            String email = res.getString("email");
            String tel = res.getString("tel");
            String data_nasc = res.getString("data_nasc");
            String cpf =  res.getString("cpf");
            String endereco = res.getString("endereco");
            Cliente c = new Cliente(nome, email, tel, data_nasc, cpf, endereco);
            lista.add(c);
        }
        return lista;
    }
}