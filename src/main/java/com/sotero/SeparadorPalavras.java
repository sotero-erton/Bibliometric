package com.sotero;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Classe que separa as palavras de uma String
 * @author Erton Sotero
 */
public class SeparadorPalavras {

    private String texto;
    List<String> palavras = new ArrayList();

    /**
     * Construtor da Classe
     * @param expressao String contendo palavras a serem separadas
     */
    public SeparadorPalavras(String expressao) {
        this.texto = expressao;
    }

    /**
     * Metodo que analisa a expressao e efetua a separação das palavras
     * @return Verdadeiro se a analise chegar ate o fim sem erros
     */
    public boolean efetuaSeparacao() {

        int posicaoInicial;

        boolean textoEstaVazio = texto.isEmpty();

        if (textoEstaVazio) {

            return false;

        } else {

            posicaoInicial = verificaSeIniciaComEspaco();

            varreOTexto(posicaoInicial);

        }

        return true;
    }

    private int verificaSeIniciaComEspaco() {

        int posicaoInicial;

        if (texto.substring(0, 1).equals(" ")) {

            posicaoInicial = 1;

        } else {

            posicaoInicial = 0;

        }
        return posicaoInicial;
    }

    private void varreOTexto(int posicaoInicial) {

        int posicaoDoFimDaPalavra;
        int tamanhoDoTexto = texto.length();

        while (posicaoInicial < tamanhoDoTexto) {

            posicaoDoFimDaPalavra = separaPalavra(posicaoInicial);

            posicaoInicial = posicaoDoFimDaPalavra;
        }
    }

    private int separaPalavra(int PosicaoInicialLaco) {

        int posicaoAtualLaco = PosicaoInicialLaco;
    
        String palavraDaVez = "";
        String cadeiaDeCaracteres = texto.substring(PosicaoInicialLaco, posicaoAtualLaco + 1);
 
        int var_tamanhoDaCadeia = cadeiaDeCaracteres.length();
        String var_ultimoCaractere = cadeiaDeCaracteres.substring(var_tamanhoDaCadeia-1, var_tamanhoDaCadeia);
        
        while (!var_ultimoCaractere.equals(" ")) {

            cadeiaDeCaracteres = texto.substring(PosicaoInicialLaco, posicaoAtualLaco + 1);

            int fimDoTexto = texto.length();

            palavraDaVez = cadeiaDeCaracteres;

            posicaoAtualLaco++;

            
            if (posicaoAtualLaco >= fimDoTexto) {

                posicaoAtualLaco = adicionaPalavaALista(posicaoAtualLaco, palavraDaVez);

                return fimDoTexto;
            }

            var_tamanhoDaCadeia = cadeiaDeCaracteres.length();
            var_ultimoCaractere = cadeiaDeCaracteres.substring(var_tamanhoDaCadeia-1, var_tamanhoDaCadeia);
            
        }

        final String var_palavraASerAdcionada = palavraDaVez.substring(0, palavraDaVez.length()-1);

        posicaoAtualLaco = adicionaPalavaALista(posicaoAtualLaco, var_palavraASerAdcionada);

        return posicaoAtualLaco;

    }

    private int adicionaPalavaALista(int prm_posicaoAtualLaco, String prm_palavraDaVez) {

        if ( ! prm_palavraDaVez.isEmpty() ) {
            palavras.add(prm_palavraDaVez.toLowerCase());
        } else {
            prm_posicaoAtualLaco++;
        }
        return prm_posicaoAtualLaco;
    }

    /**
     * Retorna o total de palavras encontradas
     *
     * @return Numero total de palavras
     */
    public int getTotalDePalavras() {
        return palavras.size();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.texto);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SeparadorPalavras other = (SeparadorPalavras) obj;
        if (!Objects.equals(this.texto, other.texto)) {
            return false;
        }
        return true;
    }

    /**
     * Retorna a expressao
     * @return String contendo o valor atual da expressao
     */
    public String getTexto() {
        return texto;
    }

    /**
     * Determina um novo valor para a expressao
     * @param expressao Novo valor para expressao
     */
    public void setTexto(String expressao) {
        this.texto = expressao;
    }

    /**
     * Retorna a Lista de Palavras
     * @return String contendo a lista atual de palavras
     */
    public List<String> getPalavras() {
        return palavras;
    }

}
