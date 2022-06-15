package br.unibh.sdm.backend_onlybank.tests;

import br.unibh.sdm.backend_onlybank.entidades.TipoCartao;
import br.unibh.sdm.backend_onlybank.persistencia.TipoCartaoRepository;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Classe de testes para a entidade Cliente.
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TipoCartaoTest {

    private static Logger LOGGER = LoggerFactory.getLogger(TipoCartaoTest.class);
    private SimpleDateFormat df = new SimpleDateFormat("dd/mm/yyyy");
	    
	@Autowired
	private TipoCartaoRepository repository;

	@Test
	public void teste1Criacao() throws ParseException {
		LOGGER.info("Criando objetos...");
		TipoCartao c1 = new TipoCartao("JUnit", "Ouro");
		repository.save(c1);
		Iterable<TipoCartao> lista = repository.findAll();
		assertNotNull(lista.iterator());
		for (TipoCartao conta : lista) {
			LOGGER.info(conta.toString());
		}
}
	
	@Test
	public void teste2Exclusao() throws ParseException {
		LOGGER.info("Excluindo objetos...");
		List<TipoCartao> lista = repository.findByBandeira("JUnit");
		for (TipoCartao tipoCartao : lista) {

			LOGGER.info("Excluindo Cliente id = "+ tipoCartao.getId());
			repository.delete(tipoCartao);
		}
		lista = repository.findByBandeira("JUnit");
		assertEquals(lista.size(), 0);
		LOGGER.info("Exclusão feita com sucesso");
	}
}
