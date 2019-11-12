package com.sotero;

import java.util.*;

/**
 *
 * @author erton
 */
public class TotalizadorPalavras {

    private List<String> palavras;

    private List<Palavra> palavrasTotalizadas = new ArrayList();

    private final List<String> listaNegra =
        Arrays.asList("a","à","ao","o","as","os","e","ou","que","em",
                      "de","da","do","dos","das","se","na","no","nos","com","um","uns","uma",
                      "umas","é","não","para","mas","por","foi","foram","como","mais",
                      "seu","sua","seus","suas","tem","sobre",
                      "no","na","nos","nas","são","entre","pela","ser","também",
                      "muito", "devemos", "isso", "isso,");

    /**
     * Efetua a totalizacao das palavras
     */
    public void totaliza() {

        if (palavras.size() != 0) {

            for (String palavra : palavras) {

                int quantidadePalavrasTotalizadas = palavrasTotalizadas.size();

                atualizaAContagemDaPalavra(palavra, quantidadePalavrasTotalizadas);

            }

            ordenaPalavrasTotalizadas();

        }

    }

    /**
     * Efetua a totalizacao das palavras
     */
    public void totalizaComCortes() {

        if (palavras.size() != 0) {

            for (String palavra : palavras) {

                if (!listaNegra.contains(palavra)) {

                    int quantidadePalavrasTotalizadas = palavrasTotalizadas.size();

                    atualizaAContagemDaPalavra(palavra, quantidadePalavrasTotalizadas);

                }

            }

            ordenaPalavrasTotalizadas();

        }

    }

    private void atualizaAContagemDaPalavra(String palavra, int quantidadePalavrasTotalizadas) {

        if (quantidadePalavrasTotalizadas == 0) {

            grava1naContagemDaPalavra(palavra);

        } else {

            Boolean naoEncontrou = true;

            naoEncontrou = verificaSeAPalavraJaFoiContada(palavra, quantidadePalavrasTotalizadas, naoEncontrou);

            seNaoTiverEncontradoContaUM(palavra, naoEncontrou);

        }
    }

    private void grava1naContagemDaPalavra(String palavra) {

        Palavra palavraObjetoTemporario = new Palavra(palavra, 1);

        palavrasTotalizadas.add(palavraObjetoTemporario);
    }

    private void seNaoTiverEncontradoContaUM(String palavra, Boolean naoEncontrou) {

        if (naoEncontrou) {

            grava1naContagemDaPalavra(palavra);

        }
    }

    private Boolean verificaSeAPalavraJaFoiContada(String palavra, int quantidadePalavrasTotalizadas,
            Boolean encontrouSimOuNao) {

        for (int contador = 0; contador < quantidadePalavrasTotalizadas; contador++) {

            Palavra palavraTotalizadaDaVez = palavrasTotalizadas.get(contador);

            if (palavra.equals(palavraTotalizadaDaVez.getPalavra())) {

                int totalMaisUM = palavraTotalizadaDaVez.getQuantidade() + 1;

                Palavra palavraObjetoTemporario = new Palavra(palavra, totalMaisUM);

                palavrasTotalizadas.set(contador, palavraObjetoTemporario);

                encontrouSimOuNao = false;

            }
        }

        return encontrouSimOuNao;

    }

    private void ordenaPalavrasTotalizadas() {
        palavrasTotalizadas.sort(new ComparadorDePalavras());
    }

    /**
     * Retorna uma String com as palavras de maior quantidade de repeticao
     *
     * @param numeroElementos Quantas palavras mais recorrentes deseja que selam
     *                        retornadas
     * @return Srtinge contendo as palavras com maior numero de repeticao
     */
    public String getMaisRecorrentes(int numeroElementos) {

        StringBuilder expressaoRetorno = new StringBuilder();

        int elemento = palavrasTotalizadas.size()-1;
        for ( int contador = 0; contador < numeroElementos; contador++ ) {

            expressaoRetorno.append(palavrasTotalizadas.get(elemento).getPalavra()).append(" ");

            elemento -= 1;

        }

        return expressaoRetorno.toString();

    }

    /**
     *
     * @param palavras
     */
    public TotalizadorPalavras(List<String> palavras) {
        this.palavras = palavras;
    }

    /**
     *
     * @return
     */
    public List<String> getPalavras() {
        return palavras;
    }

    /**
     *
     * @param palavras
     */
    public void setPalavras(List<String> palavras) {
        this.palavras = palavras;
    }

    /**
     *
     * @return
     */
    public List<Palavra> getPalavrasTotalizadas() {
        return palavrasTotalizadas;
    }

    @Override
    public String toString() {
        return "TotalizadorPalavras{" +
               "palavrasTotalizadas=" + palavrasTotalizadas +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TotalizadorPalavras)) return false;
        TotalizadorPalavras that = (TotalizadorPalavras) o;
        return Objects.equals(getPalavras(), that.getPalavras()) &&
               Objects.equals(getPalavrasTotalizadas(), that.getPalavrasTotalizadas());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getPalavras(), getPalavrasTotalizadas());
    }
}
