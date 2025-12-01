package controller;

import model.Animal;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe controladora responsável pela lógica de negócios
 * e manipulação dos dados dos animais, incluindo persistência em arquivo.
 */
public class AnimalController {
    private List<Animal> animais;
    private final String ARQUIVO_DADOS = "animais.dat";

    /**
     * Construtor da classe AnimalController.
     * Tenta carregar os dados existentes do arquivo.
     */
    public AnimalController() {
        this.animais = new ArrayList<>();
        carregarDados();
    }

    /**
     * Adiciona um novo animal à lista em memória.
     *
     * @param animal O objeto Animal a ser adicionado.
     */
    public void adicionarAnimal(Animal animal) {
        this.animais.add(animal);
    }

    /**
     * Retorna a lista de animais cadastrados.
     *
     * @return A lista de objetos Animal.
     */
    public List<Animal> listarAnimais() {
        return this.animais;
    }

    /**
     * Salva a lista de animais no arquivo (Serialização).
     */
    public void salvarDados() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARQUIVO_DADOS))) {
            oos.writeObject(animais);
            System.out.println("Dados salvos com sucesso em " + ARQUIVO_DADOS);
        } catch (IOException e) {
            System.err.println("Erro ao salvar os dados: " + e.getMessage());
        }
    }

    /**
     * Carrega a lista de animais do arquivo (Desserialização).
     */
    @SuppressWarnings("unchecked")
    private void carregarDados() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARQUIVO_DADOS))) {
            Object obj = ois.readObject();
            if (obj instanceof ArrayList) {
                this.animais = (List<Animal>) obj;
                System.out.println("Dados carregados com sucesso de " + ARQUIVO_DADOS);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo de dados não encontrado. Iniciando com lista vazia.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao carregar os dados: " + e.getMessage());
            this.animais = new ArrayList<>();
        }
    }

    /**
     * Valida as credenciais de login.
     *
     * @param login O login fornecido pelo usuário.
     * @param senha A senha fornecida pelo usuário.
     * @return true se o login e a senha forem válidos, false caso contrário.
     */
    public boolean validarLogin(String login, String senha) {
        return "user".equals(login) && "2025".equals(senha);
    }
}