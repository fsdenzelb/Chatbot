package dominio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmpresaCadastro {
        public void cadastrarEmpresa(Empresa empresa){
        String sqlEmpresa = "INSERT INTO empresa (nome, cnpj, senha, email, endereco) VALUES (?, ?, ?, ?, ?)";

        try(Connection conexao = ConexaoDB.getConnection();
            PreparedStatement stmt = conexao.prepareStatement(sqlEmpresa)) {
            stmt.setString(1, empresa.getNome());
            stmt.setString(2, empresa.getCnpj());
            stmt.setString(3, empresa.getSenha());
            stmt.setString(4, empresa.getEmail());
            stmt.setString(5, empresa.getEndereco());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
