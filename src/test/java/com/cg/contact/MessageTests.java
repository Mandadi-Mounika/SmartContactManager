package com.cg.contact;

import org.junit.Assert;
import org.junit.Test;
import com.cg.contact.helper.Message;

public class MessageTests {

	private static final Object message = null;

	@Test
	public void testGetContent() {
		// Arrange
		String content = "Hello";
		String type = "Info";
		Message message = new Message(content, type);

		// Act
		String result = message.getContent();

		// Assert
		Assert.assertEquals(content, result);
	}

	@Test
	public void testSetContent() {
		// Arrange
		String content = "Hello";
		String type = "Info";
		Message message = new Message(content, type);

		// Act
		String newContent = "New content";
		message.setContent(newContent);

		// Assert
		Assert.assertEquals(newContent, message.getContent());
	}

	@Test
	public void testGetType() {
		// Arrange
		String content = "Hello";
		String type = "Info";
		Message message = new Message(content, type);

		// Act
		String result = message.getType();

		// Assert
		Assert.assertEquals(type, result);
	}

	@Test
	public void testSetType() {
		// Arrange
		String content = "Hello";
		String type = "Info";
	}
	


}
