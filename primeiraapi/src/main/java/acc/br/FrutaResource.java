package acc.br;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import acc.br.model.Fruta;
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
	
	private static Logger log = LoggerFactory.getLogger(FrutaResource.class);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Fruta> list() {
    	log.info("Listando todas as frutas");
        return Fruta.listAll();
    }
    
    @POST
    @Transactional
    public Response novaFruta(Fruta fruta) {
    	log.info("Inserindo uma nova fruta");
        fruta.persist();
        return Response.status(Response.Status.CREATED).entity(fruta).build();
    }
    
    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deletar(@PathParam("id") Long id) {
    	log.info("Excluindo uma fruta");
        Fruta fruta = Fruta.findById(id);
        if (fruta == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        fruta.delete();
        return Response.noContent().build();
    }

}
