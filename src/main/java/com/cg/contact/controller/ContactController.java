package com.cg.contact.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.contact.entity.Contact;
import com.cg.contact.exception.ContactNotFoundException;
import com.cg.contact.service.contactServiceImpl;

@RequestMapping("/api")
@RestController
public class ContactController {

	@Autowired
	public contactServiceImpl contactServiceimpl;

	@GetMapping("/contacts/{contact_id}")
	public Contact getContactById(@PathVariable int contact_id) throws ContactNotFoundException {
		return this.contactServiceimpl.getContactByid(contact_id);
	}

	@GetMapping("/contacts")
	public List<Contact> getContacts() {
		List<Contact> ContactImpl = contactServiceimpl.getContacts1();
		return ContactImpl;
	}

	@PostMapping("/contacts")
	public Contact addContacts(@RequestBody Contact contacts) {
		Contact contactImpl = contactServiceimpl.addcontacts(contacts);
		return contactImpl;
	}

	@PutMapping("/contacts")
	public Contact updateContacts(@RequestBody Contact contact) {
		Contact contactImpl = contactServiceimpl.updatecontacts(contact);
		return contactImpl;
	}

	@DeleteMapping("/contacts/{contact_Id}")
	public String deleteContactById(@PathVariable int contact_Id) throws ContactNotFoundException {
		this.contactServiceimpl.deletecontactById(contact_Id);
		return "Contact Deleted Successfully.....";

	}

}