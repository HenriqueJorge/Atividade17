package acc.br.service;

import java.util.List;

import acc.br.model.Fruta;
import acc.br.repository.FrutaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class FrutaService {
	
	  @Inject
	  FrutaRepository frutaRepository;

	  @Transactional
	  public void criarFruta(Fruta fruta) {
	    frutaRepository.persist(fruta);
	  }

	  public List<Fruta> listarFrutas() {
	    return frutaRepository.listAll();
	  }
	  
	  public void deletaFruta(Long id) {
		 Fruta fruta = Fruta.findById(id);
	       if (fruta != null) {
	    	   frutaRepository.deleteById(id);
	        }
	  }
}
