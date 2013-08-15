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
	@Before
	public void setUp() throws Exception {
		parser = new JSONParser(JSONParser.exampleJson);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCheckJsonAndFindCommands() {

		ArrayList<JsonizerCommand> commandsList = parser.checkJsonAndFindCommands(new StringBuilder(JSONParser.exampleJson));
		assertEquals("Commands list size should be 1! ", 1, commandsList.size());
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
