package tp.ws.amoa.services;

import java.util.ArrayList;
import java.util.List;

import tp.ws.amoa.model.Item;

public class ItemsManager {
	private static List<Item> items = new ArrayList<>();
	
	public static long addItem(Item item) {
		long id = items.size() + 1;
		item.setId(id);
		items.add(item);
		return id;
	}
	
	public static Item getItem(long id) {
		for(Item item : items) {
			if(item.getId() == id) {
				return item;
			}
		}
		return null;
	}
	
	public static void updateItem(Item item) {
		int index = items.indexOf(getItem(item.getId()));
		items.remove(index);
		items.add(index, item);
	}
	
	public static void deleteItem(long id) {
		items.remove(getItem(id));
	}
	
	public static List<Item> getAll(){
		return items;
	}
}
