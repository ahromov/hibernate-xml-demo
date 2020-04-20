package ua.lviv.lgs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.NativeQuery;

/**
 * A program that demonstrates using Hibernate framework to manage a
 * bidirectional many-to-many association in relational database.
 * 
 * @author Andrii Hromov
 *
 */
public class Main {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session = factory.openSession();

		session.beginTransaction();

		Card cardOne = new Card("Card One", (long) 20);
		Card cardTwo = new Card("Card Two", (long) 20);

		Item itemOne = new Item("Item One", (long) 10);
		Item itemTwo = new Item("Item Two", (long) 20);

		cardOne.addItem(itemOne);
		cardOne.addItem(itemTwo);

		cardTwo.addItem(itemOne);
		cardTwo.addItem(itemTwo);

		itemOne.addCard(cardOne);
		itemOne.addCard(cardTwo);

		itemTwo.addCard(cardOne);
		itemTwo.addCard(cardTwo);

		session.save(cardOne);
		session.save(cardTwo);

		session.getTransaction().commit();

		NativeQuery<Card> query = session.createSQLQuery("SELECT * FROM cards");
		query.addEntity(Card.class);
		query.getResultList().forEach(System.out::println);

		session.beginTransaction();

		session.remove(cardOne);

		session.getTransaction().commit();

		query.getResultList().forEach(System.out::println);

		session.close();

	}

}