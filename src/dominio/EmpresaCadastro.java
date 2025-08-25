package dominio;

import java.sql.*;

public class EmpresaCadastro {
        public void cadastrarEmpresa(Empresa empresa) {
            //Preparo de metodos SQL alocados em uma variável em String utilizando '?' como placeholders, que é um marcado de posição.
        String sqlEmpresa = "INSERT INTO empresa (nome, cnpj, senha, email, endereco) VALUES (?, ?, ?, ?, ?)";
        String sqlTelefone = "INSERT INTO telefones_empresa (empresa_id, telefone) VALUES (?, ?)";

        try(Connection conexao = ConexaoDB.getConnection();
            PreparedStatement stmt = conexao.prepareStatement(sqlEmpresa, Statement.RETURN_GENERATED_KEYS)) {
            //Cada marcador será substituído abaixo de acordo com sua posição (ordem crescente).
            //Inserir empresa:
            stmt.setString(1, empresa.getNome());
            stmt.setString(2, empresa.getCnpj());
            stmt.setString(3, empresa.getSenha());
            stmt.setString(4, empresa.getEmail());
            stmt.setString(5, empresa.getEndereco());
            //Executa o INSERT.
            stmt.executeUpdate();

            //Recupera o ID gerado pela empresa:
            ResultSet key = stmt.getGeneratedKeys();  //Armazena as chaves geradas pelo banco no último INSERT.
            int empresaId = -1; //Ainda não possui um ID válido.
            if (key.next()) {  //Se houver um ID gerado, retorna TRUE.
                empresaId = key.getInt(1); //Pega o valor da coluna 1 do ResultSet, que no caso é o ID autoincrementado.
            }

            //Inserir o telefone:
            if(empresaId != -1 && empresa.getTelefone() != null) {
                try (PreparedStatement stmtTelefone = conexao.prepareStatement(sqlTelefone)) {
                    stmtTelefone.setInt(1, empresaId);
                    stmtTelefone.setString(2, empresa.getTelefone());
                    stmtTelefone.executeUpdate();
                }
            }
        } catch (SQLException e) {
            //Caso aconteça algum erro, imprime no console o erro.
            e.printStackTrace();
        };
    }
}
