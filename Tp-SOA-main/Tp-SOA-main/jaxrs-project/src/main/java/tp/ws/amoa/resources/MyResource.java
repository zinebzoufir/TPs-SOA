package tp.ws.amoa.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
//    @GET
//    @Produces(MediaType.TEXT_PLAIN)
//    public String getIt() {
//        return "Got it!";
//    }
//    
//    @POST
//    @Produces(MediaType.TEXT_PLAIN)
//    	public String postIt() {
//    		return "POST HTTP METHOD";
//    	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/filiere/{f}")
	public String getWithParams(@PathParam("f") String f) {
		return "VOTRE FILIERE EST : " + f + " (PATH PARAM)";
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getWithQueryParams(@QueryParam("filiere") String f) {
		return "VOTRE FILIERE EST : " +f + " (QUERY PATH PARAM)";
	}
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public String postIt(){
		return "POST HTTP Method";
	}
	
    }

