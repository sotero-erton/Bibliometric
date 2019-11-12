package com.sotero;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.net.URL;
import java.util.ArrayList;

/**
 *
 * @author Carlos Augusto Moreno e Erton Sotero
 * @version 1.0
 *
 * Classe responsável por manipular o tratamento de arquivo
 * no Framework, ela trata da leitura de arquivos já
 * criados, como também escreve o que for lido em outro
 * arquivo.
 */
public class ManipuladorArquivo {

    /**
     * Constante utilizada pela classe
     */
    public static final String VAZIO = "";

    private static String arquivoDestino;

    private static ArrayList<String> conteudo
        = new ArrayList<>();

    /**
     * Metodo especializado na leitura de arquivos
     *
     * @param prmArquivoDeLeitura Nome e Caminho do arquivo
     * a ser lido
     * @throws IOException Erro de entrada e saida de dados
     */
    public static void ler(String prmArquivoDeLeitura)
    throws IOException {

        conteudo.clear();

        File nomeCompletoArquivo =
            determinaEnderecoAbsoluto(prmArquivoDeLeitura);

        try (BufferedReader memoriaIntermediariaLeitura
                    = new BufferedReader(
                new FileReader(
                    nomeCompletoArquivo))) {

            String linha = VAZIO;

            while (true) {

                linha = memoriaIntermediariaLeitura.readLine();

                if (linha != null) {

                    novaLinhaAoConteudo(linha);

                } else {
                    break;
                }

            }
        }

    }

    /**
     * Determina endereco absoluto de um recurso, para o
     * contexto de memoria que esta sendo executado.
     *
     * @param prmArquivoDeLeitura Arquivo com endereco dentro
     * dos pacotes do projeto para determinar o nome absoluto
     * no conexto de memoria de execucao
     * @return
     */
    public static File determinaEnderecoAbsoluto(
        String prmArquivoDeLeitura) {

        File nomeCompletoArquivo;

        ClassLoader contextoDeCarregamento =
            Thread.currentThread().getContextClassLoader();

        URL enderecoRelativoArquivo =
            contextoDeCarregamento.getResource(
                prmArquivoDeLeitura);


        if ( enderecoRelativoArquivo == null ) {

            File varArquivo = new File(prmArquivoDeLeitura);

            nomeCompletoArquivo = varArquivo.getAbsoluteFile();

        } else {

            nomeCompletoArquivo =
                new File(enderecoRelativoArquivo.getPath());

        } // Fim do if...

        // Fim do if...
        return nomeCompletoArquivo;
    }

    /**
     * Metodo especializado na escrita em arquivos
     *
     * @throws IOException Erro de entrada e saida de dados
     * @throws Exception Erro generico
     */
    public static void escrever() throws IOException,
        Exception {

        File varArquivoDestino = new File(
            getArquivoDestino());

        FileWriter arquivoDeEscrita = new FileWriter(
            varArquivoDestino.getAbsoluteFile());

        try (BufferedWriter memoriaIntermediariaEscrita
                    = new BufferedWriter(arquivoDeEscrita)) {

            // Verifica se o arquivo existe...
            if (!varArquivoDestino.exists()) {

                // Cria o arquivo...
                varArquivoDestino.createNewFile();

            }

            // Grava conteudo no arquivo...
            for (String linhaDeConteudo : conteudo) {

                // Grava linha no arquivo...
                memoriaIntermediariaEscrita.write(
                    linhaDeConteudo);

                // Adiciona uma linha ao arquivo...
                memoriaIntermediariaEscrita.newLine();

            } // Fim do for...

        } // Fim do try

    }

    /**
     * Metodo especializado na escrita em arquivos
     * @param prmConteudo Conteudo que deve ser gravado
     * @throws IOException Erro de entrada e saida de dados
     * @throws Exception Erro generico
     */
    public static void escrever( StringWriter prmConteudo )
    throws IOException, Exception {

        File varArquivoDestino = new File(
            getArquivoDestino());

        FileWriter arquivoDeEscrita = new FileWriter(
            varArquivoDestino.getAbsoluteFile());

        try (BufferedWriter memoriaIntermediariaEscrita
                    = new BufferedWriter(arquivoDeEscrita)) {

            // Verifica se o arquivo existe...
            if (!varArquivoDestino.exists()) {

                // Cria o arquivo...
                varArquivoDestino.createNewFile();

            }

            // Grava linha no arquivo...
            memoriaIntermediariaEscrita.write(
                prmConteudo.toString());

        } // Fim do try

    }

    /**
     * Metodo especializado na escrita em arquivos
     * @param varLinha Linha a ser adcionada
     * @throws IOException Erro de entrada e saida de dados
     */
    public static void escreveNovasLinhas(String varLinha)
    throws IOException {

        File varArquivoDestino = new File(
            getArquivoDestino());

        // O true coloca o arquivo no modo e append...
        FileWriter arquivoDeEscrita = new FileWriter(
            varArquivoDestino.getAbsoluteFile(), true);

        
        
        try (BufferedWriter memoriaIntermediariaEscrita
                    = new BufferedWriter(arquivoDeEscrita)) {

            // Verifica se o arquivo existe...
            if (!varArquivoDestino.exists()) {

                // Cria o arquivo...
                varArquivoDestino.createNewFile();

            }

            // Grava linha no arquivo...
            memoriaIntermediariaEscrita.write(
                varLinha);

            // Adiciona uma linha ao arquivo...
            memoriaIntermediariaEscrita.newLine();

        } // Fim do try

    }

    /**
     * Get the value of conteudo
     *
     * @return the value of conteudo
     */
    public static ArrayList<String> getConteudo() {
        return conteudo;
    }

    /**
     * Set the value of conteudo
     *
     * @param conteudo new value of conteudo
     */
    public static void setConteudo(
        ArrayList<String> conteudo) {

        ManipuladorArquivo.conteudo = conteudo;
    }

    /**
     * @return the arquivoDestino
     */
    public static String getArquivoDestino() {
        return arquivoDestino;
    }

    /**
     * @param prmArquivoDestino the arquivoDestino to set
     */
    public static void setArquivoDestino(
        String prmArquivoDestino) {

        arquivoDestino = prmArquivoDestino;
    }

    /**
     * Agrega uma nova linha ao conteudo...
     *
     * @param prmNovaLinha
     */
    public static void novaLinhaAoConteudo(
        String prmNovaLinha) {

        getConteudo().add(prmNovaLinha);

    } // Fim do metodo novaLinhaAoConteudo...

    /**
     * Limpa totalmente o conteudo...
     */
    public static void limpaConteudo() {

        getConteudo().clear();

    } // Fim do metodo limpaConteudo...

}
