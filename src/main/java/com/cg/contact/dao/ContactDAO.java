package com.cg.contact.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.contact.entity.Contact;


public interface ContactDAO extends JpaRepository<Contact, Integer >{
	

}