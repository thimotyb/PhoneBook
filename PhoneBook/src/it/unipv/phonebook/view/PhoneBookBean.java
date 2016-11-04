package it.unipv.phonebook.view;

import it.unipv.phonebook.controllers.PhoneBookController;
import it.unipv.phonebook.dao.PhoneBookDAO;
import it.unipv.phonebook.model.PhoneBook;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class PhoneBookBean implements Serializable {

	@Inject PhoneBookController phoneBookController;
	@Inject PhoneBookDAO phoneBookDAO;
	
	private PhoneBook thePhoneBook;
	
	private List<PhoneBook> phoneBookItems;
	
	private Date startDate;
	
	@PostConstruct
	public void init() {
		thePhoneBook = new PhoneBook();
		phoneBookItems = phoneBookDAO.findAll();
	}
	
	public String add() {
		// This will use the controller to command
		// adding the current values to the PhoneBook
		try {
			phoneBookItems = phoneBookController.add(thePhoneBook);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	} 
	
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public List<PhoneBook> getPhoneBookItems() {
		return phoneBookItems;
	}
	public void setPhoneBookItems(List<PhoneBook> phoneBookItems) {
		this.phoneBookItems = phoneBookItems;
	}

	public PhoneBook getThePhoneBook() {
		return thePhoneBook;
	}

	public void setThePhoneBook(PhoneBook thePhoneBook) {
		this.thePhoneBook = thePhoneBook;
	}
	
}
