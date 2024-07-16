package br.unicamp.ic.inf335.beans;
import static org.junit.Assert.assertEquals;

import java.net.URL;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class AnuncianteBeanTest {
    
    private AnuncianteBean anunciante;
    
    @Before
    public void setUp() {
        anunciante = new AnuncianteBean("João", "123456789", new ArrayList<>());
        
        // Adiciona alguns anúncios de exemplo para testes
        ArrayList<AnuncioBean> anuncios = new ArrayList<>();
        ProdutoBean produto1 = new ProdutoBean("001", "Produto 1", "Descrição do Produto 1", 100.0, "Novo");
        AnuncioBean anuncio1 = new AnuncioBean(produto1, new ArrayList<>(), 0.1);
        anuncios.add(anuncio1);
        
        ProdutoBean produto2 = new ProdutoBean("002", "Produto 2", "Descrição do Produto 2", 150.0, "Usado");
        AnuncioBean anuncio2 = new AnuncioBean(produto2, new ArrayList<>(), 0.2);
        anuncios.add(anuncio2);
        
        anunciante.setAnuncios(anuncios);
    }
    
    @Test
    public void testAddAnuncio() {
        // Verifica se o tamanho da lista de anúncios aumenta após adicionar um novo anúncio
        int tamanhoAntes = anunciante.getAnuncios().size();
        ProdutoBean produto3 = new ProdutoBean("003", "Produto 3", "Descrição do Produto 3", 200.0, "Novo");
        AnuncioBean novoAnuncio = new AnuncioBean(produto3, new ArrayList<>(), 0.15);
        
        anunciante.addAnuncio(novoAnuncio);
        
        assertEquals(tamanhoAntes + 1, anunciante.getAnuncios().size());
    }
    
    @Test
    public void testRemoveAnuncio() {
        // Verifica se o tamanho da lista de anúncios diminui após remover um anúncio
        int tamanhoAntes = anunciante.getAnuncios().size();
        
        anunciante.removeAnuncio(0);
        
        assertEquals(tamanhoAntes - 1, anunciante.getAnuncios().size());
    }
    
    @Test
    public void testValorMedioAnuncios() {
        // Verifica se o cálculo do valor médio dos anúncios está correto
        Double valorMedio = anunciante.valorMedioAnuncios();
        Double expectedValorMedio = (100.0 - (100.0 * 0.1) + 150.0 - (150.0 * 0.2)) / 2;
        
        assertEquals(expectedValorMedio, valorMedio, 0.001); // Aceita uma margem de erro de 0.001 para números decimais
    }
}


