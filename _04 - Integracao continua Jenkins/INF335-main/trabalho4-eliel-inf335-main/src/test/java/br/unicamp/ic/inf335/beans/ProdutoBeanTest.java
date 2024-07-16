package br.unicamp.ic.inf335.beans;

import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class ProdutoBeanTest {
    private final String CODE = new String("2345meia78");
    private final String NAME = new String("Biscoito Molhado");
    private final String DESCRIPTION = new String("Apenas um biscoito molhado.");
    private final Double VALUE = 13.65;
    private final String STATE = new String("RJ");

    private ProdutoBean produto  = new ProdutoBean(CODE, NAME, DESCRIPTION, VALUE, STATE);

    @Test
    void testGettersSetters() {
        assert Objects.equals(produto.getValor(), VALUE);
        assert produto.getCodigo().equals(CODE);
        assert produto.getDescricao().equals(DESCRIPTION);
        assert produto.getNome().equals(NAME);
        assert produto.getEstado().equals(STATE);

        ProdutoBean testProduto = new ProdutoBean();
        testProduto.setCodigo(this.CODE);
        testProduto.setValor(this.VALUE);
        testProduto.setEstado(this.STATE);
        testProduto.setDescricao(this.DESCRIPTION);
        testProduto.setNome(this.NAME);

        assert produto.compareTo(testProduto) == 0;

        testProduto.setValor(VALUE + 1);
        assert produto.compareTo(testProduto) < 0;

        testProduto.setValor(VALUE - 1);
        assert produto.compareTo(testProduto) > 0;
    }

}