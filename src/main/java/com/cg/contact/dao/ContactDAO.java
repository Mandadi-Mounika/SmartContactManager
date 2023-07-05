package com.cg.contact.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.contact.entity.Contact;

@Repository
public interface ContactDAO extends JpaRepository<Contact, Integer> {

}