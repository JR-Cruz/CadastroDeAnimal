package view;

import controller.AnimalController;
import model.Animal;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Tela de Cadastro de Animal, responsável por receber os dados
 * e exibir a lista de animais cadastrados.
 *  */
public class AnimalGUI extends JFrame {
    private AnimalController controller;

    private JTextField nomeField;
    private JTextField racaField;
    private JTextField nomeTutorField;
    private JComboBox<String> especieComboBox;
    private JButton cadastrarButton;
    private JButton limparCadastroButton;

    private JTable animalTable;
    private DefaultTableModel tableModel;

    /**
     * Construtor da tela de Cadastro de Animal.
     * * @param controller O controlador de animais para manipulação dos dados.
     */
    public AnimalGUI(AnimalController controller) {
        this.controller = controller;
        setTitle("Cadastro e Listagem de Animais");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 450);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        JPanel cadastroPanel = new JPanel(new GridBagLayout());
        cadastroPanel.setBorder(BorderFactory.createTitledBorder("Cadastro de Animal"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0; gbc.gridy = 0; gbc.anchor = GridBagConstraints.WEST;
        cadastroPanel.add(new JLabel("Nome:"), gbc);
        nomeField = new JTextField(20);
        gbc.gridx = 1; gbc.gridy = 0; gbc.fill = GridBagConstraints.HORIZONTAL;
        cadastroPanel.add(nomeField, gbc);

        gbc.gridx = 0; gbc.gridy = 1; gbc.fill = GridBagConstraints.NONE;
        cadastroPanel.add(new JLabel("Raça:"), gbc);
        racaField = new JTextField(20);
        gbc.gridx = 1; gbc.gridy = 1; gbc.fill = GridBagConstraints.HORIZONTAL;
        cadastroPanel.add(racaField, gbc);

        gbc.gridx = 0; gbc.gridy = 2; gbc.fill = GridBagConstraints.NONE;
        cadastroPanel.add(new JLabel("Nome do Tutor:"), gbc);
        nomeTutorField = new JTextField(20);
        gbc.gridx = 1; gbc.gridy = 2; gbc.fill = GridBagConstraints.HORIZONTAL;
        cadastroPanel.add(nomeTutorField, gbc);

        gbc.gridx = 0; gbc.gridy = 3; gbc.fill = GridBagConstraints.NONE;
        cadastroPanel.add(new JLabel("Espécie:"), gbc);
        String[] especies = {"Cachorro", "Gato", "Pássaro", "Peixe", "Outros"};
        especieComboBox = new JComboBox<>(especies);
        gbc.gridx = 1; gbc.gridy = 3; gbc.fill = GridBagConstraints.HORIZONTAL;
        cadastroPanel.add(especieComboBox, gbc);
        
        limparCadastroButton = new JButton("LIMPAR");
        cadastrarButton = new JButton("CADASTRAR"); 

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(limparCadastroButton);
        buttonPanel.add(cadastrarButton);
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2; gbc.fill = GridBagConstraints.NONE;
        cadastroPanel.add(buttonPanel, gbc);

        String[] colunas = {"Nome", "Raça", "Espécie", "Tutor"};
        tableModel = new DefaultTableModel(colunas, 0);
        animalTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(animalTable);
        
        add(cadastroPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        carregarDadosNaTabela();
        
        cadastrarButton.addActionListener(new CadastrarListener());
        limparCadastroButton.addActionListener(new LimparCadastroListener());
    }

    /**
     * Listener para o botão CADASTRAR.
     * Implementa a validação de preenchimento e o cadastro do animal.
     */
    private class CadastrarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String nome = nomeField.getText().trim();
            String raca = racaField.getText().trim();
            String nomeTutor = nomeTutorField.getText().trim();
            String especie = (String) especieComboBox.getSelectedItem();

            if (nome.isEmpty() || raca.isEmpty() || nomeTutor.isEmpty() || especie == null || especie.isEmpty()) {
                JOptionPane.showMessageDialog(AnimalGUI.this, 
                        "Todos os campos devem ser preenchidos para o cadastro!", 
                        "Erro de Validação", JOptionPane.WARNING_MESSAGE);
                return;
            }

            Animal novoAnimal = new Animal(nome, raca, especie, nomeTutor);
            controller.adicionarAnimal(novoAnimal);

            JOptionPane.showMessageDialog(AnimalGUI.this, 
                    "DADOS CADASTRADOS COM SUCESSO!", 
                    "Sucesso", JOptionPane.INFORMATION_MESSAGE);

            adicionarLinhaNaTabela(novoAnimal);
            
            limparCampos();
        }
    }

    /**
     * Listener para o botão LIMPAR do formulário de cadastro.
     * Limpa todos os campos do formulário.
     */
    private class LimparCadastroListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            limparCampos();
        }
    }
    
    /**
     * Limpa os campos de texto e reseta o JComboBox.
     */
    private void limparCampos() {
        nomeField.setText("");
        racaField.setText("");
        nomeTutorField.setText("");
        especieComboBox.setSelectedIndex(0); 
    }
    
    /**
     * Carrega todos os dados da lista do controller para a JTable.
     */
    private void carregarDadosNaTabela() {
        tableModel.setRowCount(0);
        List<Animal> animais = controller.listarAnimais();
        for (Animal animal : animais) {
            adicionarLinhaNaTabela(animal);
        }
    }
    
    /**
     * Adiciona uma única linha à JTable.
     * * @param animal O objeto Animal cujos dados serão adicionados.
     */
    private void adicionarLinhaNaTabela(Animal animal) {
        Object[] rowData = {
            animal.getNome(),
            animal.getRaca(),
            animal.getEspecie(),
            animal.getNomeTutor()
        };
        tableModel.addRow(rowData);
    }
}