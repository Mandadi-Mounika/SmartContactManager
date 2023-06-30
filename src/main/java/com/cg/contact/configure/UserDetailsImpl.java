package com.cg.contact.configure;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cg.contact.entity.Contact;
import com.cg.contact.entity.User;

public class UserDetailsImpl<GrantedAuthority, SimpleGrantedAuthority> implements UserDetailsService {

	private User user;

	public UserDetailsImpl(User user) {
		super();
		this.user = user;
	}

	public String getPassword() {
		return user.getPassword();
	}

	public String getUsername() {
		return user.getEmail();
	}

	public boolean isAccountNonExpired() {
		return true;
	}

	public boolean isAccountNonLocked() {
		return true;
	}

	public boolean isCredentialsNonExpired() {
		return true;
	}

	public boolean isEnabled() {
		return true;
	}

	public <SimpleGrantedAuthority> List<SimpleGrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User userRegister(User user) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUserByEmail(String email) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User addContactInUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Contact> getContactsList(int userId, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contact getContactDetail(int cId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contact getContactById(int cId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteContact(User user, Contact contact) {
		// TODO Auto-generated method stub

	}

	@Override
	public Contact updateContactInUser(Contact contact) {
		// TODO Auto-generated method stub
		return null;
	}

}