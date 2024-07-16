package br.unicamp.ic.inf335.beans;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ProdutoBeanTest {

    @Test
    public void testGetValor() {
        // Criando um produto de exemplo
        ProdutoBean produto = new ProdutoBean("P1", "Produto Teste P1", "Descrição do Produto P1", 100.0, "Novo");

        // Verificando o método getValor()
        assertEquals(100.0, produto.getValor(), 0.01); // Verifica se o valor é 100.0
    }

    @Test
    public void testCompareTo() {
        // Criando produtos de exemplo
        ProdutoBean produto1 = new ProdutoBean("P1", "Produto A", "Descrição A", 50.0, "Novo");
        ProdutoBean produto2 = new ProdutoBean("P2", "Produto B", "Descrição B", 100.0, "Usado");

        // Verificando a ordenação por valor
        assertTrue(produto1.compareTo(produto2) < 0); // produto1 deve ser menor que produto2
    }
}
