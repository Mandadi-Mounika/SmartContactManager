package com.cg.contact.controller;


import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;
import java.time.LocalDateTime;

import javax.servlet.http.HttpSession;

import com.cg.contact.entity.Contact;
import com.cg.contact.entity.User;
import com.cg.contact.helper.Message;
import com.cg.contact.service.UserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping("api/user1")
public class UserController {

    @Autowired
    UserDetailsService userDetailsService;

    User currentLogInUserDetails = null;

    @ModelAttribute
    public void commonUserData(Model model, Principal principal) throws Exception {
        String userName = principal.getName();
        System.out.println("Logged In Username: " + userName);
        User currentLogInUserDetails = userDetailsService.findUserByEmail(userName);
        System.out.println(currentLogInUserDetails);
        model.addAttribute("user", currentLogInUserDetails);
        this.currentLogInUserDetails = currentLogInUserDetails;
    }

    @RequestMapping("/index")
    public String dashboard(Model model, Principal principal) {
        model.addAttribute("title", "User Dashboard");
        return "user/user_dashboard";
    }

    @GetMapping("/add-contact-form")
    public String addUserContact(Model model) {
        model.addAttribute("title", "Add contact : Smart contact Manager");
        model.addAttribute("contact", new Contact());
        return "user/add_contact_form";
    }

    @PostMapping("/process-contact")
    public String processAddContact(@Value(value = "") @ModelAttribute Contact contact, BindingResult result,
            @RequestParam("profileImage") MultipartFile mpFile, Principal principal, Model model, HttpSession session) {

        Path destPath = null;
        String originalFilename = null;
        String currDateTime = (LocalDateTime.now() + "").replace(":", "-");

        try {
            if (mpFile.isEmpty()) {
                System.out.println("File is empty");
                originalFilename = "contact_profile.png";
            } else {
                originalFilename = currDateTime + "@" + mpFile.getOriginalFilename();
            }

            File savedFile = new ClassPathResource("/static/image").getFile();
            destPath = Paths.get(savedFile.getAbsolutePath() + File.separator + originalFilename);
            System.out.println("Image path: " + destPath);

            contact.setImage(originalFilename);
            contact.setUser(currentLogInUserDetails);

            currentLogInUserDetails.getContacts().add(contact);

            User addedContactResult = userDetailsService.addContactInUser(currentLogInUserDetails);

            if (addedContactResult != null) {
                Files.copy(mpFile.getInputStream(), destPath, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("After successful contact added: " + addedContactResult);
            }

            session.setAttribute("message", new Message("Contact saved successfully.....!!", "success"));
            model.addAttribute("contact", new Contact());
            return "user/add_contact_form";

        } catch (Exception e) {
            System.out.println("Error: " + e);
            e.printStackTrace();
            model.addAttribute("contact", contact);
            
        }
		return currDateTime;
    }
    @PostMapping("/register")
	public ResponseEntity<User> registerUser(@RequestBody User user) {
		try {
			User registeredUser = userDetailsService.userRegister(user);
			return ResponseEntity.ok(registeredUser);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@GetMapping("/{email}")
	public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
		try {
			User user = userDetailsService.findUserByEmail(email);
			if (user != null) {
				return ResponseEntity.ok(user);
			} else {
				return ResponseEntity.notFound().build();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PostMapping("/{userId}/contacts")
	public ResponseEntity<User> addContactToUser(@PathVariable int userId, @RequestBody User user) {
		try {
			User updatedUser = userDetailsService.addContactInUser(user);
			if (updatedUser != null) {
				return ResponseEntity.ok(updatedUser);
			} else {
				return ResponseEntity.notFound().build();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@GetMapping("/{userId}/contacts")
	public ResponseEntity<Page<Contact>> getContactsByUser(@PathVariable int userId, Pageable pageable) {
		Page<Contact> contacts = userDetailsService.getContactsList(userId, pageable);
		return ResponseEntity.ok(contacts);
	}

	@GetMapping("/contacts/{contactId}")
	public ResponseEntity<Contact> getContactById(@PathVariable int contactId) {
		Contact contact = userDetailsService.getContactById(contactId);
		if (contact != null) {
			return ResponseEntity.ok(contact);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping("/contacts")
	public ResponseEntity<Contact> updateContact(@RequestBody Contact contact) {
		Contact updatedContact = userDetailsService.updateContactInUser(contact);
		if (updatedContact != null) {
			return ResponseEntity.ok(updatedContact);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}