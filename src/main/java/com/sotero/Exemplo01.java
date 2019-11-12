package com.sotero;

import com.sotero.ManipuladorArquivo;
import com.sotero.SeparadorPalavras;
import com.sotero.TotalizadorPalavras;

import java.io.IOException;
import java.util.ArrayList;

public class Exemplo01 {

    public static final int QUANTIDADE_PALAVRAS_PARA_RETORNO = 15;
    public static final String NOME_DO_ARQUIVO_DE_CONTEUDO = "exemplos/conteudo.txt";

    public static void main(String [] args) {


        try {

            ManipuladorArquivo.ler(NOME_DO_ARQUIVO_DE_CONTEUDO);
            ArrayList<String> varConteudo = ManipuladorArquivo.getConteudo();

            String expressaoAnalise = "";

            final int var_TamanhoConteudo = varConteudo.size();

            for ( int contador = 0; contador < var_TamanhoConteudo; contador++) {

                final String var_linhaDaVez = varConteudo.get(contador);

                expressaoAnalise += var_linhaDaVez;

            }

            SeparadorPalavras separador = new SeparadorPalavras( expressaoAnalise );
            separador.efetuaSeparacao();

            TotalizadorPalavras totalizador = new TotalizadorPalavras(separador.getPalavras());
            totalizador.totalizaComCortes();

            System.out.println(totalizador.getMaisRecorrentes(QUANTIDADE_PALAVRAS_PARA_RETORNO));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
