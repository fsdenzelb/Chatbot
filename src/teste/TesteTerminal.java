package teste;

import dominio.EmpresaCadastro;

import java.util.Scanner;

public class TesteTerminal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o telefone: ");
        String telefone = scanner.next();

        int EmpresaID = EmpresaCadastro.buscarEmpresaTelefone(telefone);
        if (EmpresaID == -1) {
            System.out.println("Telefone não encontrado.");
            return;
        }

        System.out.print("Informe a senha: ");
        String senha = scanner.next();

        boolean senhaValida = EmpresaCadastro.validarSenha(EmpresaID, senha);
        if (senhaValida) {
            System.out.println("Usuário autenticado!");
        } else {
            System.out.println("Senha invalida!");
        }
    }
}
