package br.unibh.sdm.backend_onlybank.persistencia;

import br.unibh.sdm.backend_onlybank.entidades.TipoCartao;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


/**
 * Esta classe estende o padrão CrudRepository 
 *
 */
public interface TipoCartaoRepository extends CrudRepository<TipoCartao, Long> {

	Optional<TipoCartao> findById(Long id);

	List<TipoCartao> findByBandeira(String bandeira);

	List<TipoCartao> findByModalidade(String modalidade);
	
}
