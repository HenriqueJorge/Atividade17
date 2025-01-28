package acc.br;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import acc.br.model.Fruta;
import acc.br.service.FrutaService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/frutas")
public class FrutaResource {
	
	@Inject
	FrutaService frutaService;
	
	private static Logger log = LoggerFactory.getLogger(FrutaResource.class);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Fruta> list() {
    	log.info("Listando todas as frutas");
        return frutaService.listarFrutas();
    }
    
    @POST
    @Transactional
    public Response novaFruta(Fruta fruta) {
    	log.info("Inserindo uma nova fruta");
        frutaService.criarFruta(fruta);
        return Response.status(Response.Status.CREATED).entity(fruta).build();
    }
    
    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deletar(@PathParam("id") Long id) {
    	log.info("Excluindo uma fruta");
    	frutaService.deletaFruta(id);
        return Response.noContent().build();
    }

}
