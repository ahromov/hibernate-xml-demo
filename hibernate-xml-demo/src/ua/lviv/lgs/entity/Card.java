package ua.lviv.lgs.entity;

import java.util.HashSet;
import java.util.Set;

public class Card {

	private long id;
	private String name;
	private Long count;

	private Set<Item> items = new HashSet<Item>();

	public Card(String name, Long count) {
		this.name = name;
		this.count = count;
	}

	public void addItem(Item item) {
		this.items.add(item);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public Set<Item> getItems() {
		return items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Card [id=" + id + ", name=" + name + ", count=" + count + ", items=" + items + "]";
	}

}