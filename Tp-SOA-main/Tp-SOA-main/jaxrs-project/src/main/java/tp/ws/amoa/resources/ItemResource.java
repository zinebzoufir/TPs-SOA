package tp.ws.amoa.resources;

import java.util.List;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import tp.ws.amoa.model.Item;
import tp.ws.amoa.services.ItemsManager;

@Path("/items")
public class ItemResource {
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public long addItem(Item item) {
		return ItemsManager.addItem(item);
	}
	
	@GET
	@Path("/{itemId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Item getItemDetails(@PathParam("itemId") long id) {
		return ItemsManager.getItem(id);
	}
	
	@PUT
	@Path("/{itemId}")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public void updateItem(@PathParam("itemId") long id, Item item) {
		item.setId(id);
		ItemsManager.updateItem(item);
	}
	
	@DELETE
	@Path("/{itemId}")
	public void deleteItem(@PathParam("itemId") long id) {
		ItemsManager.deleteItem(id);
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Item> getAllItems(){
		return ItemsManager.getAll();
	}
}
