package com.zmarkan.jsonizer.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.zmarkan.jsonizer.models.JsonizerCommand;
import com.zmarkan.jsonizer.models.JsonizerCommand.CommandType;
import com.zmarkan.jsonizer.parser.JSONParser;

public class TestJsonParser {

	JSONParser parser; 
	String exampleJson = "{ \"user\": \"zan\", \"number\": 42, \"double\": 10.002 }";
	@Before
	public void setUp() throws Exception {
		parser = new JSONParser(exampleJson);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCheckJsonAndFindCommands() {

		ArrayList<JsonizerCommand> commandsList = parser.checkJsonAndFindCommands(new StringBuilder(exampleJson));
		assertEquals("Commands list size should be 3! ", 3, commandsList.size());
		
		assertEquals("First name should be user!", "user", commandsList.get(0).fieldName);
		assertEquals("First type should be String!", CommandType.STRING, commandsList.get(0).type);
		
		assertEquals("First name should be number!", "number", commandsList.get(1).fieldName);
		assertEquals("First type should be long!", CommandType.LONG, commandsList.get(1).type);
		
		assertEquals("First name should be user!", "double", commandsList.get(2).fieldName);
		assertEquals("First type should be double!", CommandType.DOUBLE, commandsList.get(2).type);

		
	}
	
	@Test
	public void testResolveCommandType(){
		String shouldBeString = "\"How much wood would a woodchuck chuck if a woodchuck would chuck wood?\"";
		String shouldBeDouble = "2345.431";
		String shouldBeLong = "123456";
		String shouldBeNull = "null";
		
		assertEquals("Should be String!", CommandType.STRING, parser.resolveCommandType(shouldBeString));
		assertEquals("Should be double!", CommandType.DOUBLE, parser.resolveCommandType(shouldBeDouble));
		assertEquals("Should be long!", CommandType.LONG, parser.resolveCommandType(shouldBeLong));
		assertEquals("Should be null!", CommandType.NULL, parser.resolveCommandType(shouldBeNull));

		
	}

}
