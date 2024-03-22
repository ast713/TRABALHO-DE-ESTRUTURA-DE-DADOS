import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class CadastroClientes {
    private HashMap<String, Cliente> tabelaHash;

    /**
     * Construtor da classe CadastroClientes.
     */
    public CadastroClientes() {
        tabelaHash = new HashMap<>();

        // Configurando a interface gráfica
        JFrame frame = new JFrame("Cadastro de Clientes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(640, 480);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel labelNome = new JLabel("Nome:");
        labelNome.setBounds(10, 10, 80, 25);
        panel.add(labelNome);

        JTextField fieldNome = new JTextField(20);
        fieldNome.setBounds(100, 10, 280, 25);
        panel.add(fieldNome);

        JLabel labelCPF = new JLabel("CPF:");
        labelCPF.setBounds(10, 40, 80, 25);
        panel.add(labelCPF);

        JTextField fieldCPF = new JTextField(20);
        fieldCPF.setBounds(100, 40, 280, 25);
        panel.add(fieldCPF);

        JLabel labelEmail = new JLabel("Email:");
        labelEmail.setBounds(10, 70, 80, 25);
        panel.add(labelEmail);

        JTextField fieldEmail = new JTextField(20);
        fieldEmail.setBounds(100, 70, 280, 25);
        panel.add(fieldEmail);

        JLabel labelTelefone = new JLabel("Telefone:");
        labelTelefone.setBounds(10, 100, 80, 25);
        panel.add(labelTelefone);

        JTextField fieldTelefone = new JTextField(20);
        fieldTelefone.setBounds(100, 100, 280, 25);
        panel.add(fieldTelefone);

        // Adicionando um checkbox para a opção de receber promoções via e-mail
        JLabel labelPromocoes = new JLabel("Receber promoções via email:");
        labelPromocoes.setBounds(10, 130, 180, 25);
        panel.add(labelPromocoes);

        JCheckBox checkboxPromocoes = new JCheckBox();
        checkboxPromocoes.setBounds(200, 130, 20, 25);
        panel.add(checkboxPromocoes);

        JButton buttonCadastrar = new JButton("Cadastrar");
        buttonCadastrar.setBackground(Color.white);
        buttonCadastrar.setForeground(Color.black);
        buttonCadastrar.setBounds(10, 160, 100, 25);
        buttonCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = fieldNome.getText();
                String cpf = fieldCPF.getText();
                String email = fieldEmail.getText();
                String telefone = fieldTelefone.getText();
                boolean receberPromocoes = checkboxPromocoes.isSelected(); // Verifica se o checkbox está marcado

                Cliente cliente = new Cliente(nome, cpf, email, telefone, receberPromocoes);
                tabelaHash.put(cpf, cliente);
                JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
            }
        });
        panel.add(buttonCadastrar);

        JLabel labelBuscarCPF = new JLabel("Buscar por CPF:");
        labelBuscarCPF.setBounds(10, 190, 120, 25);
        panel.add(labelBuscarCPF);

        JTextField fieldBuscarCPF = new JTextField(20);
        fieldBuscarCPF.setBounds(130, 190, 130, 25);
        panel.add(fieldBuscarCPF);

        JButton buttonBuscar = new JButton("Buscar");
        buttonBuscar.setBackground(Color.white);
        buttonBuscar.setForeground(Color.black);
        buttonBuscar.setBounds(270, 190, 100, 25);
        buttonBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cpfBusca = fieldBuscarCPF.getText();
                Cliente cliente = tabelaHash.get(cpfBusca);
                if (cliente != null) {
                    JOptionPane.showMessageDialog(null, "Cliente encontrado:\nNome: " + cliente.getNome() + "\nCPF: " + cliente.getCpf() + "\nEmail: " + cliente.getEmail() + "\nTelefone: " + cliente.getTelefone() + "\nReceber promoções via email: " + (cliente.isReceberPromocoes() ? "Sim" : "Não"));
                } else {
                    JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
                }
            }
        });
        panel.add(buttonBuscar);

        frame.add(panel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CadastroClientes();
            }
        });
    }
}
