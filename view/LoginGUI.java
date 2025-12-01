package view;

import controller.AnimalController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Tela de Login da aplicação, responsável por receber as credenciais.
 * O layout foi ajustado para se aproximar do design fornecido,
 * utilizando GridBagLayout para melhor controle de espaçamento e centralização.
 */
public class LoginGUI extends JFrame {
    private AnimalController controller;
    private JTextField loginField;
    private JPasswordField senhaField;
    private JButton entrarButton;
    private JButton limparButton;

    /**
     * Construtor da tela de Login.
     * @param controller O controlador de animais para validar o login.
     */
    public LoginGUI(AnimalController controller) {
        this.controller = controller;
        setTitle("Tela de Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setSize(350, 250);
        setLocationRelativeTo(null);

        loginField = new JTextField(18); 
        senhaField = new JPasswordField(18);
        entrarButton = new JButton("ENTRAR");
        limparButton = new JButton("LIMPAR");

        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(2, 5, 2, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        gbc.gridx = 0; gbc.gridy = 0; 
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(new JLabel("Login"), gbc);
        
        gbc.gridx = 0; gbc.gridy = 1;
        gbc.ipady = 5;
        mainPanel.add(loginField, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        gbc.ipady = 0;
        mainPanel.add(new JLabel("Senha"), gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        gbc.ipady = 5; 
        mainPanel.add(senhaField, gbc);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        
        Dimension buttonSize = new Dimension(100, 30);
        limparButton.setPreferredSize(buttonSize);
        entrarButton.setPreferredSize(buttonSize);
        
        buttonPanel.add(limparButton);
        buttonPanel.add(entrarButton);
        
        gbc.gridx = 0; gbc.gridy = 4;
        gbc.insets = new Insets(20, 5, 10, 5); 
        mainPanel.add(buttonPanel, gbc);
        
        this.add(mainPanel, BorderLayout.CENTER);

        entrarButton.addActionListener(new EntrarListener());
        limparButton.addActionListener(new LimparListener());
    }

    /**
     * Listener para o botão ENTRAR.
     * Implementa a validação de login e possível acesso à tela de Cadastro.
     */
    private class EntrarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String login = loginField.getText();
            String senha = new String(senhaField.getPassword());

            if (controller.validarLogin(login, senha)) {
                JOptionPane.showMessageDialog(LoginGUI.this, "Login efetuado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                dispose();
                AnimalGUI animalGUI = new AnimalGUI(controller);
                animalGUI.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(LoginGUI.this, "Login ou Senha inválidos. Tente novamente.", "Erro de Login", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Listener para o botão LIMPAR.
     * Limpa os campos de Login e Senha.
     */
    private class LimparListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            loginField.setText("");
            senhaField.setText("");
        }
    }
}