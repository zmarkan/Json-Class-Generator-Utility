package com.zmarkan.jsonizer.test;

import static org.junit.Assert.*;

import javax.naming.NameAlreadyBoundException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.zmarkan.jsonizer.javamaker.JavaMaker;

public class TestJavaMaker {

	JavaMaker maker;
	String newline = System.getProperty("line.separator");
	
	
	@Before
	public void setUp() throws Exception {
		maker = new JavaMaker();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGenerateString() {
		
		String nameArgument1 = "name";
		String nameArgument2 = "name_surname";

		String nameExpectedOutput1 = "public String "+nameArgument1+";"+System.getProperty("line.separator");
		String nameExpectedOutput2 = "public String "+nameArgument2+";"+System.getProperty("line.separator");
		
		String output1 = maker.generateString(nameArgument1).toString();
		String output2 = maker.generateString(nameArgument2).toString();
		
		assertTrue("Should generate "+ nameExpectedOutput1, output1.equalsIgnoreCase(nameExpectedOutput1));
		assertTrue("Should generate "+ nameExpectedOutput2, output2.equalsIgnoreCase(nameExpectedOutput2));
		
	}
	
	@Test
	public void testGenerateLong() {
		
		String nameArgument1 = "number";
		String nameArgument2 = "user_number";

		String nameExpectedOutput1 = "public long "+nameArgument1+";"+System.getProperty("line.separator");
		String nameExpectedOutput2 = "public long "+nameArgument2+";"+System.getProperty("line.separator");
		
		String output1 = maker.generateLong(nameArgument1).toString();
		String output2 = maker.generateLong(nameArgument2).toString();
		
		assertTrue("Should generate "+ nameExpectedOutput1, output1.equalsIgnoreCase(nameExpectedOutput1));
		assertTrue("Should generate "+ nameExpectedOutput2, output2.equalsIgnoreCase(nameExpectedOutput2));
		
	}
	
	@Test
	public void testGenerateDouble() {
		
		String nameArgument1 = "number";
		String nameArgument2 = "user_number";

		String nameExpectedOutput1 = "public double "+nameArgument1+";"+System.getProperty("line.separator");
		String nameExpectedOutput2 = "public double "+nameArgument2+";"+System.getProperty("line.separator");
		
		String output1 = maker.generateDouble(nameArgument1).toString();
		String output2 = maker.generateDouble(nameArgument2).toString();
		
		assertTrue("Should generate "+ nameExpectedOutput1, output1.equalsIgnoreCase(nameExpectedOutput1));
		assertTrue("Should generate "+ nameExpectedOutput2, output2.equalsIgnoreCase(nameExpectedOutput2));
		
	}
	
	@Test
	public void testGenerateArrayList() {
		
		String nameArgument1 = "numbers";
		String nameArgument2 = "user_numbers";
		
		String typeArgument = "long";

		String nameExpectedOutput1 = "public ArrayList<"+typeArgument+"> "+nameArgument1+";"+System.getProperty("line.separator");
		String nameExpectedOutput2 = "public ArrayList<"+typeArgument+"> "+nameArgument2+";"+System.getProperty("line.separator");
		
		String output1 = maker.generateArrayList(nameArgument1, typeArgument).toString();
		String output2 = maker.generateArrayList(nameArgument2, typeArgument).toString();
		
		assertTrue("Should generate "+ nameExpectedOutput1, output1.equalsIgnoreCase(nameExpectedOutput1));
		assertTrue("Should generate "+ nameExpectedOutput2, output2.equalsIgnoreCase(nameExpectedOutput2));
		
	}
	
	@Test
	public void testGenerateWholeClass(){
		String classNameArgument = "User";
		String stringNameArgument = "user_name";
		String intNameArgument = "user_number";
		String expectedOutput1 = "public class "+classNameArgument+"{"+
				newline + "public String "+stringNameArgument+";"+newline +
				"public long "+intNameArgument+";"+newline+"}";
		
		StringBuilder outputBuilder = maker.generateClassOpen(classNameArgument);
		outputBuilder.append(maker.generateString(stringNameArgument).toString());
		outputBuilder.append(maker.generateLong(intNameArgument).toString());
		outputBuilder.append(maker.generateClassClose().toString());
		System.out.println(outputBuilder.toString());
		
		assertTrue("Should generate "+expectedOutput1, expectedOutput1.equalsIgnoreCase(outputBuilder.toString()));
	}
	
	
	
	

}
