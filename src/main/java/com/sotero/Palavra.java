package com.sotero;

import java.util.Objects;

/**
 * Classe para transporte de informacoes de totalizacao
 * de recorrencia de palavras
 * @author erton
 */
public class Palavra {

    private String palavra;
    private Integer quantidade;

    /**
     * Construtor
     * @param palavra
     */
    public Palavra(String palavra) {
        this.palavra = palavra;
    }

    /**
     * Construtor
     * @param palavra
     * @param quantidade
     */
    public Palavra(String palavra, Integer quantidade) {
        this.palavra = palavra;
        this.quantidade = quantidade;
    }

    /**
     *
     * @return
     */
    public String getPalavra() {
        return palavra;
    }

    /**
     *
     * @param palavra
     */
    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

    /**
     *
     * @return
     */
    public Integer getQuantidade() {
        return quantidade;
    }

    /**
     *
     * @param quantidade
     */
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Palavra{" +
                "palavra='" + palavra + '\'' +
                ", quantidade=" + quantidade +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Palavra)) return false;
        Palavra that = (Palavra) o;
        return Objects.equals(getPalavra(), that.getPalavra()) &&
                Objects.equals(getQuantidade(), that.getQuantidade());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getPalavra(), getQuantidade());
    }
}
