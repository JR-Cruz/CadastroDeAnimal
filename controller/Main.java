package controller;

import view.LoginGUI;

/**
 * Classe principal para iniciar a aplicação.
 */
public class Main {
    public static void main(String[] args) {
        AnimalController controller = new AnimalController();
        
        LoginGUI login = new LoginGUI(controller);
        login.setVisible(true);
        
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            controller.salvarDados();
        }));
    }
}