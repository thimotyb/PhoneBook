package it.unipv.phonebook.controllers;

import it.unipv.phonebook.dao.PhoneBookDAO;
import it.unipv.phonebook.model.PhoneBook;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;

import org.apache.log4j.Logger;

@Stateless
public class PhoneBookController {

	@Inject PhoneBookDAO phoneBookDAO;
	Logger logger = Logger.getLogger(PhoneBookController.class);
	
	@PostConstruct
	public void init() {
		logger.info("PhoneBook Controller is up!");
	}
	
	public List<PhoneBook> add(PhoneBook thePhoneBook) throws Exception {
		
		// Validation here
		if (thePhoneBook.getName() == null || thePhoneBook.getName().isEmpty()) {
			throw new Exception("Name not present");
		}
		if (thePhoneBook.getSurname() == null || thePhoneBook.getSurname().isEmpty()) {
			throw new Exception("Surname not present");
		}
		
		// Some process handling here
		phoneBookDAO.add(thePhoneBook);
		
		List<PhoneBook> items = phoneBookDAO.findAll();
		
		return items;
		
	}
	
	

}
