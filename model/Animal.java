package model;

import java.io.Serializable;

/**
 * Classe que representa o modelo de um Animal.
 * Implementa Serializable para permitir o armazenamento em arquivo.
 */
public class Animal implements Serializable {
    private String nome;
    private String raca;
    private String especie;
    private String nomeTutor;

    /**
     * Construtor padrão da classe Animal.
     * * @param nome O nome do animal.
     * @param raca A raça do animal.
     * @param especie A espécie do animal (Cachorro, Gato, Pássaro, Peixe, Outros).
     * @param nomeTutor O nome do tutor/dono do animal.
     */
    public Animal(String nome, String raca, String especie, String nomeTutor) {
        this.nome = nome;
        this.raca = raca;
        this.especie = especie;
        this.nomeTutor = nomeTutor;
    }

    public String getNome() {
        return nome;
    }

    public String getRaca() {
        return raca;
    }

    public String getEspecie() {
        return especie;
    }

    public String getNomeTutor() {
        return nomeTutor;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public void setNomeTutor(String nomeTutor) {
        this.nomeTutor = nomeTutor;
    }

    /**
     * Retorna uma representação em String do objeto Animal.
     *
     * @return String com os dados do animal.
     */
    @Override
    public String toString() {
        return "Animal{" +
               "nome='" + nome + '\'' +
               ", raca='" + raca + '\'' +
               ", especie='" + especie + '\'' +
               ", nomeTutor='" + nomeTutor + '\'' +
               '}';
    }
}