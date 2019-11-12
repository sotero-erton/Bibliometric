package com.sotero;

import java.util.Comparator;

/**
 * Comparador de totais de recorrencia de palavras
 * @author erton
 */
public class ComparadorDePalavras implements Comparator<Palavra> {

    @Override
    public int compare(Palavra p1, Palavra p2) {

        if ( p1.getQuantidade() < p2.getQuantidade() ) {
            return -1;
        } else if ( p1.getQuantidade() > p2.getQuantidade() ) {
            return +1;
        } else {
            return 0;
        }

    }
}
