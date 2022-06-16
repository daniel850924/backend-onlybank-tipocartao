package br.unibh.sdm.backend_onlybank.rest;
import java.util.List;
import javax.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.unibh.sdm.backend_onlybank.entidades.TipoCartao;
import br.unibh.sdm.backend_onlybank.negocio.TipoCartaoService;

/**
 * Classe contendo as definições de serviços REST/JSON para TipoCartao
 *
 */
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "tipocartao")
public class TipoCartaoController {
   
    private final TipoCartaoService tipoCartaoService;

    public TipoCartaoController(TipoCartaoService tipoCartaoService){
        this.tipoCartaoService = tipoCartaoService;
    }

    @GetMapping
    public List<TipoCartao> getTipoCartao(){
        return tipoCartaoService.getTipoCartao();
    }
    
    @GetMapping(value="{id}")
    public TipoCartao getTipoCartaoById(@PathVariable Long id) throws Exception{
        if(!ObjectUtils.isEmpty(id)){
           return tipoCartaoService.getTipoCartaoById(id);
        }
        throw new Exception("TipoCartao com codigo "+id+" nao encontrada");
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public TipoCartao createTipoCartao(@RequestBody @NotNull TipoCartao tipoCartao) throws Exception {
         return tipoCartaoService.saveTipoCartao(tipoCartao);
    }
    
    @PutMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public TipoCartao updateTipoCartao(@PathVariable Long id,
                                  @RequestBody @NotNull TipoCartao tipoCartao) throws Exception {
    	if (!id.equals(tipoCartao.getId())) {
    		throw new Exception("Codigo "+id+" nao está correto");
    	}
    	if (!tipoCartaoService.isTipoCartaoExists(tipoCartao)) {
    		throw new Exception("TipoCartao com codigo "+id+" não existe");
    	}
        return tipoCartaoService.saveTipoCartao(tipoCartao);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "{id}")
    public boolean deleteTipoCartao(@PathVariable Long id) throws Exception {
    	if (!tipoCartaoService.isTipoCartaoExists(id)) {
    		throw new Exception("TipoCartao com codigo "+id+" não existe");
    	} 
    	tipoCartaoService.deleteTipoCartao(id);
        return true;
    }
}