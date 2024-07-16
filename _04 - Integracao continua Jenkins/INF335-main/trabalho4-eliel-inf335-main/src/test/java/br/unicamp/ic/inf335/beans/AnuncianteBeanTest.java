package br.unicamp.ic.inf335.beans;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.net.URL;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnuncianteBeanTest {

    private final AnuncianteBean bean = new AnuncianteBean();
    private ArrayList<AnuncioBean> anuncios;
    private AnuncianteBean anunciante;

    @BeforeEach
    void setUp() {
        anuncios = new ArrayList<>();
        anuncios.add(new AnuncioBean(new ProdutoBean("P001", "Produto A", "Descrição A", 100.0, "Novo"), new ArrayList<URL>(), 0.1));
        anuncios.add(new AnuncioBean(new ProdutoBean("P002", "Produto B", "Descrição B", 200.0, "Novo"), new ArrayList<URL>(), 0.2));

        this.anunciante = new AnuncianteBean("Wallace Eliel", "12345678910", anuncios);
    }

    @Test
    void testDefaultConstructor() {
        AnuncianteBean novoAnunciante = new AnuncianteBean();
        assertEquals("", novoAnunciante.getNome());
        assertEquals("", novoAnunciante.getCPF());
        assert (novoAnunciante.getAnuncios().isEmpty());
    }

    @Test
    void testParameterizedConstructor() {
        AnuncianteBean novoAnunciante = new AnuncianteBean("Wallace Eliel", "12345678910", anuncios);
        assertEquals("Wallace Eliel", novoAnunciante.getNome());
        assertEquals("12345678910", novoAnunciante.getCPF());
        assertEquals(2, anunciante.getAnuncios().size());
    }

    @Test
    void testGettersAndSetters() {
        anunciante.setNome("Eliel Wallace");
        anunciante.setCPF("10987654321");

        assertEquals("Eliel Wallace", anunciante.getNome());
        assertEquals("10987654321", anunciante.getCPF());
    }

    @Test
    void testValorMedioAnuncios() {
        assertEquals((100.0 * 0.9 + 200.0 * 0.8) / 2, anunciante.valorMedioAnuncios(), 0.01);

        anunciante.getAnuncios().clear(); // Remover anúncios
        assertEquals(0.0, anunciante.valorMedioAnuncios(), 0.01);
    }
}