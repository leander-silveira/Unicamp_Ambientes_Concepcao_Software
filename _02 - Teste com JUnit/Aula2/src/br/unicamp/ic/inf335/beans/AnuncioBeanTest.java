package br.unicamp.ic.inf335.beans;

import static org.junit.Assert.assertEquals;

import java.net.URL;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;


public class AnuncioBeanTest {

    @Test
    public void testGetValor() {
        // Criando um produto de exemplo
        ProdutoBean produto = new ProdutoBean("P1", "Produto Teste P1", "Descrição do Produto P1", 100.0, "Novo");

        // Criando um anúncio de exemplo
        ArrayList<URL> fotos = new ArrayList<>();
        AnuncioBean anuncio = new AnuncioBean(produto, fotos, 0.1); // 10% de desconto

        // Verificando o método getValor()
        assertEquals(90.0, anuncio.getValor(), 0.01); // Verifica se o valor com desconto é 90.0
    }
}
