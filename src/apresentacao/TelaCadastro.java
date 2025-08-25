package apresentacao;
import dominio.Empresa;
import dominio.EmpresaCadastro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaCadastro extends JFrame {
    private JTextField campoNome;
    private JTextField campoCnpj;
    private JTextField campoSenha;
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
        campoSenha = new JTextField(20);
        campoEmail = new JTextField(20);
        campoEndereco = new JTextField(20);
        campoTelefone = new JTextField(20);

        form.add(new JLabel("Nome:")); form.add(campoNome);
        form.add(new JLabel("CNPJ:")); form.add(campoCnpj);
        form.add(new JLabel("Senha:")); form.add(campoSenha);
        form.add(new JLabel("Email:")); form.add(campoEmail);
        form.add(new JLabel("Endereco:")); form.add(campoEndereco);
        form.add(new JLabel("Telefone:")); form.add(campoTelefone);

        add(form, BorderLayout.CENTER);
    }

    private void adicionarBotoes() {
        botaoCadastrar = new JButton("Cadastrar");
        JPanel botoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 8));
        botoes.add(botaoCadastrar);
        ActionListener acaoBotaoCadastrar = this.acaoBotaoCadastrarActionListener();
        botaoCadastrar.addActionListener(acaoBotaoCadastrar);

        getRootPane().setDefaultButton(botaoCadastrar);
        //Adiciona o ENTER como um atalho para o botãoCadastrar.

        add(botoes, BorderLayout.SOUTH);
    }

    private ActionListener acaoBotaoCadastrarActionListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Quando o botão é clicado, é disparado um evento que cria um novo objeto da classe Empresa, os parâmetros dentro da classe são setados de acordo com o que tem no campo de texto da GUI.
                Empresa empresa = new Empresa();
                empresa.setNome(campoNome.getText());
                empresa.setCnpj(campoCnpj.getText());
                empresa.setSenha(campoSenha.getText());
                empresa.setEmail(campoEmail.getText());
                empresa.setEndereco(campoEndereco.getText());
                empresa.setTelefone(campoTelefone.getText());

                //Após setar os nomes no objeto criado, também criamos um novo objeto da classe EmpresaCadastro, a fim de utilizar seu metodo 'cadastarEmpresa'.
                EmpresaCadastro cadastro = new EmpresaCadastro();
                cadastro.cadastrarEmpresa(empresa);

                //Limpar os campos após o INSERT:
                campoNome.setText("");
                campoCnpj.setText("");
                campoSenha.setText("");
                campoEmail.setText("");
                campoEndereco.setText("");
                campoTelefone.setText("");

                //Mensagem de confirmação:
                JOptionPane.showMessageDialog(null, "Empresa Cadastrada com sucesso!");
            }
        };
    }
}
