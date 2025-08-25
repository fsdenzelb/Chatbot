import apresentacao.TelaCadastro;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        //Iniciando a GUI dentro do EDT (Event Dispatch Thread).
        SwingUtilities.invokeLater(() -> new TelaCadastro().setVisible(true));
    }
}
