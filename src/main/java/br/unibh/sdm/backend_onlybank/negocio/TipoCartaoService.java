package br.unibh.sdm.backend_onlybank.negocio;

import br.unibh.sdm.backend_onlybank.entidades.TipoCartao;
import br.unibh.sdm.backend_onlybank.persistencia.TipoCartaoRepository;
import org.apache.commons.collections4.IteratorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Classe contendo a lógica de negócio para TipoCartao
 *
 */
@Service
public class TipoCartaoService {

    private static final Logger logger= LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    
    private final TipoCartaoRepository tipoCartaoRepository;

    public TipoCartaoService(TipoCartaoRepository tipoCartaoRepository){
        this.tipoCartaoRepository= tipoCartaoRepository;
    }
    
    public List<TipoCartao> getTipoCartao(){
        if(logger.isInfoEnabled()){
            logger.info("Buscando todos os objetos");
        }
        Iterable<TipoCartao> lista = this.tipoCartaoRepository.findAll();
        if (lista == null) {
        	return new ArrayList<TipoCartao>();
        }
        return IteratorUtils.toList(lista.iterator());
    }

    public TipoCartao getTipoCartaoById(Long id){
        if(logger.isInfoEnabled()){
            logger.info("Buscando TipoCartao com o codigo {}",id);
        }
        Optional<TipoCartao> retorno = this.tipoCartaoRepository.findById(id);
        if(!retorno.isPresent()){
            throw new RuntimeException("TipoCartao com o codigo "+id+" nao encontrada");
        }
        return retorno.get();
    }


    public TipoCartao saveTipoCartao(TipoCartao TipoCartao){
        if(logger.isInfoEnabled()){
            logger.info("Salvando TipoCartao com os detalhes {}",TipoCartao.toString());
        }
        return this.tipoCartaoRepository.save(TipoCartao);
    }
    
    public void deleteTipoCartao(Long codigo){
        if(logger.isInfoEnabled()){
            logger.info("Excluindo TipoCartao com id {}",codigo);
        }
        this.tipoCartaoRepository.deleteById(codigo);
    }

    public boolean isTipoCartaoExists(TipoCartao TipoCartao){
    	Optional<TipoCartao> retorno = this.tipoCartaoRepository.findById(TipoCartao.getId());
        return retorno.isPresent() ? true:  false;
    }

    public boolean isTipoCartaoExists(Long codigo){
    	Optional<TipoCartao> retorno = this.tipoCartaoRepository.findById(codigo);
        return retorno.isPresent() ? true:  false;
    }
}