package duke.groundbreaker;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("stones")
@RequestScoped
public class StonesResource {

    @Inject
    @ConfigProperty(name = "stone", defaultValue = "none")
    private String infinityStone;

    @GET
    @Produces(APPLICATION_JSON)
    public Response getStone() {
        Stone stone = new Stone(infinityStone);

        return Response.ok(stone).build();
    }
}