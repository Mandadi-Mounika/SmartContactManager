package com.cg.contact.configure;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cg.contact.entity.Contact;
import com.cg.contact.entity.User;

@Service
public interface UserDetailsService {

	<SimpleGrantedAuthority> List<SimpleGrantedAuthority> getAuthorities();

	public User userRegister(User user) throws Exception;

	public User findUserByEmail(String email) throws Exception;

	public User addContactInUser(User user);

	public Page<Contact> getContactsList(int userId, Pageable pageable);

	public Contact getContactDetail(int cId);

	public Contact getContactById(int cId);

	public void deleteContact(User user, Contact contact);

	public Contact updateContactInUser(Contact contact);

	static List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

}
