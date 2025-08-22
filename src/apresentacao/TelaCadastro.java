package apresentacao;

import javax.swing.*;
import java.awt.*;

public class TelaCadastro extends JFrame {
    private JTextField campoNome;
    private JTextField campoCnpj;
    private JTextField campoEmail;
    private JTextField campoEndereco;
    private JTextField campoTelefone;

    private JButton botaoCadastrar;

    public TelaCadastro() {
        construirTela();
    }

    private void construirTela() {
        setSize(400, 400);
        setTitle("Cadastro de Clientes");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.adicionarCampos();
    }

    private void adicionarCampos() {
        JPanel form = new JPanel(new GridLayout(0, 2, 8, 8));
        form.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));

        campoNome = new JTextField(20);
        campoCnpj = new JTextField(20);
        campoEmail = new JTextField(20);
        campoEndereco = new JTextField(20);
        campoTelefone = new JTextField(20);

        form.add(new JLabel("Nome:")); form.add(campoNome);
        form.add(new JLabel("CNPJ:")); form.add(campoCnpj);
        form.add(new JLabel("Email:")); form.add(campoEmail);
        form.add(new JLabel("Endereco:")); form.add(campoEndereco);
        form.add(new JLabel("Telefone:")); form.add(campoTelefone);

        botaoCadastrar = new JButton("Cadastrar");
        JPanel botoes = new JPanel(new FlowLayout(FlowLayout.RIGHT, 8, 8));
        botoes.add(botaoCadastrar);

        add(form, BorderLayout.CENTER);
        add(botoes, BorderLayout.SOUTH);

        getRootPane().setDefaultButton(botaoCadastrar);
        pack();                   // calcula tamanho ideal
        setLocationRelativeTo(null); // centraliza

    }
}
