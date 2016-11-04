package it.unipv.phonebook.test;

import it.unipv.phonebook.dao.PhoneBookDAO;
import it.unipv.phonebook.model.PhoneBook;
import it.unipv.phonebook.view.PhoneBookBean;

import java.util.List;

import javax.inject.Inject;

import junit.framework.Assert;

import org.jboss.arquillian.junit.Arquillian;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class PhoneBookTest extends ArquillianTest {

	@Inject PhoneBookBean phoneBookBean;
	@Inject PhoneBookDAO phoneBookDAO;
	
	@Before
	public void cleanup() {
		// Here you should ensure that you clean away all Mario Rossi's for the test
	}
	
	@Test
	public void testPhoneBook() {
		
		// Set an element in the bean
		PhoneBook thePhoneBook = new PhoneBook();		
		thePhoneBook.setName("Mario");
		thePhoneBook.setSurname("Rossi");
		thePhoneBook.setPhoneNumber("1234567");
		phoneBookBean.setThePhoneBook(thePhoneBook);
		
		// Ask the bean to add, this simulates the user pressing "ADD" on the GUI
		phoneBookBean.add();
		
		// Now we check if the person was in fact added
		List<PhoneBook> phoneBooks = phoneBookDAO.findAll();
		boolean found = false;
		for(PhoneBook pb: phoneBooks) {
			if ("Mario".equals(pb.getName()) && "Rossi".equals(pb.getSurname())) {
				found = true;
				break;
			}
		}
		
		// Now we assert that the entry has indeed be found
		Assert.assertTrue("Mario was found", found);
		
	}
	
	
}
