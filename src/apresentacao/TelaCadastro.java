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
        setTitle("Cadastro de Clientes");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        this.adicionarCampos();
        this.adicionarBotoes();

        pack();
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void adicionarCampos() {
        JPanel form = new JPanel(new GridLayout(0, 2, 8, 8));
        //JPanel é como um contâiner utilizado para organizar os elementos dentro de interface. Essa nova instância de JPanel está criando, por consequência, um GridLayout, que organiza os elementos dentro do painel.
        /*Rows: 0 -> O layout vai calcular automaticamente o número de linhas, baseado na quantidade de componentes adicionados e no número de colunas. Aqui está definido como 0, ou seja, as linhas vão crescer conforme você adiciona mais componentes.
        Cols: 2 -> 2 elementos por coluna.
        HGap: 8 -> Espaçamento horizontal (em pixels) entre as colunas.
        VGap: 8 -> Espaçamento vertical (em pixels entre as linhas.*/

        form.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        //Apenas adicionando uma borda nas 4 direções.

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

        add(form, BorderLayout.CENTER);
    }

    private void adicionarBotoes() {
        botaoCadastrar = new JButton("Cadastrar");
        JPanel botoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 8));
        botoes.add(botaoCadastrar);

        getRootPane().setDefaultButton(botaoCadastrar);
        //Adiciona o ENTER como um atalho para o botãoCadastrar.

        add(botoes, BorderLayout.SOUTH);
    }
}
