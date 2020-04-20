package ua.lviv.lgs.entity;

import java.util.HashSet;
import java.util.Set;

public class Item {

	private long id;
	private String name;
	private Long count;

	private Set<Card> cards = new HashSet<Card>();

	public Item(String name, Long count) {
		this.name = name;
		this.count = count;
	}

	public void addCard(Card card) {
		this.cards.add(card);
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

	public void setName(String username) {
		this.name = username;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public Set<Card> getCards() {
		return cards;
	}

	public void setCards(Set<Card> cards) {
		this.cards = cards;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", count=" + count + "]";
	}

}
