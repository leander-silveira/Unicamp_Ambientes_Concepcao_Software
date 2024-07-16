package br.unicamp.ic.inf335.beans;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

class AnuncioBeanTest {
    private final String CODE = new String("2345meia78");
    private final String NAME = new String("Biscoito Molhado");
    private final String DESCRIPTION = new String("Apenas um biscoito molhado.");
    private final Double VALUE = 13.65;
    private final String STATE = new String("RJ");

    private final ProdutoBean PRODUCT  = new ProdutoBean(CODE, NAME, DESCRIPTION, VALUE, STATE);
    private final ArrayList<URL> PIC_URL = new ArrayList<URL>();
    private final Double DISCOUNT = 0.5;
    private final Double DISCOUNTED_VALUE = VALUE - (VALUE * DISCOUNT);
    private final AnuncioBean AD = new AnuncioBean(PRODUCT, PIC_URL, DISCOUNT);

    @Test
    void testDiscountApplied() {
        assert AD.getValor().equals(DISCOUNTED_VALUE);
    }

    @Test
    void testZeroDiscount() {
        AnuncioBean ad = new AnuncioBean(PRODUCT, PIC_URL, 0.0);
        assert ad.getValor().equals(VALUE);
    }

    @Test
    void testTotalDiscount() {
        AnuncioBean ad = new AnuncioBean(PRODUCT, PIC_URL, 1.0);
        assert ad.getValor().equals(0.0);
    }
}