package com.cg.contact.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.contact.entity.Contact;
import com.cg.contact.service.contactServiceImpl;

@RequestMapping("api/contact1")
@RestController
public class ContactController {

	@Autowired
	private contactServiceImpl contactService;

	@GetMapping("/contacts/{contact_id}")
	public Contact getContactById(@PathVariable int contact_id) {
		return this.contactService.getContactById(contact_id);
	}

	@GetMapping("/contacts")
	public ResponseEntity<Contact> getContacts() {
		List<Contact> ContactImpl = contactService.getContacts();
		return new ResponseEntity(ContactImpl, HttpStatus.OK);
	}

	@PostMapping("/contacts")
	public ResponseEntity<Contact> addContacts(@RequestBody Contact contactDAO) {
		Contact contactImpl = contactService.addContacts(contactDAO);
		return new ResponseEntity(contactImpl, HttpStatus.CREATED);
	}

	@PutMapping("/contacts")
	public ResponseEntity<Contact> updateContacts(@RequestBody Contact contact) {
		Contact contactImpl = contactService.updateContacts(contact);
		return new ResponseEntity(contactImpl, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/contacts/{contact_Id}")
	public void deleteContactById(@PathVariable int contact_Id) {
		this.contactService.deleteContactById(contact_Id);

	}

}