package it.unipv.phonebook.dao;

import it.unipv.phonebook.model.PhoneBook;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PhoneBookDAO {
	
	@PersistenceContext
	EntityManager em;

	public void add(PhoneBook phoneBook) {
		em.persist(phoneBook);
	}
	
	public List<PhoneBook> findAll() {
		
		// JPQL Query
		List<PhoneBook> phoneBooks =
				em.createQuery("select p from PhoneBook p", PhoneBook.class)
				.getResultList();
		
		return phoneBooks;
	}

}
