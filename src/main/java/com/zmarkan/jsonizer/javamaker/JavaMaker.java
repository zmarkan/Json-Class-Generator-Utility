package com.zmarkan.jsonizer.javamaker;

import javax.sound.sampled.Line;

/**
 * @author zan
 * Class that has all methods required to generate Java code (incl. getters and setters) from JSON
 * */
public class JavaMaker {
	
	//static vars to help create java code
	public static final String TYPE_STRING = "String";
	public static final String TYPE_INT = "int";
	public static final String TYPE_DOUBLE = "double";
	public static final String TYPE_LONG = "long";
	public static final String TYPE_ARRAYLIST ="ArrayList";
	public static final String TYPE_CLASS = "class";
	public static final String TYPE_OBJECT = "Object";
	
	public static final String KEYWORD_PUBLIC = "public";
	public static final String KEYWORD_PRIVATE = "private";
	
	public static final String OTHER_SPACE = " ";
	public static final String OTHER_NEWLINE = System.getProperty("line.separator");
	public static final String OTHER_SEMICOLON = ";";
	public static final String OTHER_LT = "<";
	public static final String OTHER_GT = ">";
	public static final String OTHER_PAREN_OPEN = "(";
	public static final String OTHER_PAREN_CLOSE = ")";
	public static final String OTHER_BRACKET_OPEN = "{";
	public static final String OTHER_BRACKET_CLOSE = "}";
	
	public static enum METHOD_TYPE{
		LONG, DOUBLE, STRING, ARRAYLIST
	}
	
	

	public static StringBuilder generateString(String name){
		StringBuilder builder = new StringBuilder();
		builder.append(KEYWORD_PUBLIC);
		builder.append(OTHER_SPACE);
		builder.append(TYPE_STRING);
		builder.append(OTHER_SPACE);
		builder.append(name);
		builder.append(OTHER_SEMICOLON);
		builder.append(OTHER_NEWLINE);
		return builder;
	}
	
	public static StringBuilder generateLong(String name){
		StringBuilder builder = new StringBuilder();
		builder.append(KEYWORD_PUBLIC);
		builder.append(OTHER_SPACE);
		builder.append(TYPE_LONG);
		builder.append(OTHER_SPACE);
		builder.append(name);
		builder.append(OTHER_SEMICOLON);
		builder.append(OTHER_NEWLINE);
		return builder;
	}
	
	public static StringBuilder generateDouble(String name){
		StringBuilder builder = new StringBuilder();
		builder.append(KEYWORD_PUBLIC);
		builder.append(OTHER_SPACE);
		builder.append(TYPE_DOUBLE);
		builder.append(OTHER_SPACE);
		builder.append(name);
		builder.append(OTHER_SEMICOLON);
		builder.append(OTHER_NEWLINE);
		return builder;
	}
	public static StringBuilder generateObject(String name){
		StringBuilder builder = new StringBuilder();
		builder.append(KEYWORD_PUBLIC);
		builder.append(OTHER_SPACE);
		builder.append(TYPE_OBJECT);
		builder.append(OTHER_SPACE);
		builder.append(name);
		builder.append(OTHER_SEMICOLON);
		builder.append(OTHER_NEWLINE);
		return builder;
	}
	
	public static StringBuilder generateArrayList(String name, String type){
		StringBuilder builder = new StringBuilder();
		builder.append(KEYWORD_PUBLIC);
		builder.append(OTHER_SPACE);
		builder.append(TYPE_ARRAYLIST);
		builder.append(OTHER_LT);
		builder.append(type);
		builder.append(OTHER_GT);
		builder.append(OTHER_SPACE);
		builder.append(name);
		builder.append(OTHER_SEMICOLON);
		builder.append(OTHER_NEWLINE);
		return builder;
	}

	/**
	 * Generates the starting declaration of a class
	 * Needs to be concluded by generateClassClose after end of implementation
	 * */
	public static StringBuilder generateClassOpen(String name){
		
		//TODO: support package management
		StringBuilder builder = new StringBuilder();
		builder.append(KEYWORD_PUBLIC);
		builder.append(OTHER_SPACE);
		builder.append(TYPE_CLASS);
		builder.append(OTHER_SPACE);
		builder.append(name);
		builder.append(OTHER_BRACKET_OPEN);
		builder.append(OTHER_NEWLINE);
		return builder;
	}
	
	
	/**
	 * Just creates a newline and closing bracket for class body
	 * */
	public static StringBuilder generateClassClose(){
		StringBuilder builder = new StringBuilder();
		builder.append(OTHER_BRACKET_CLOSE);
		return builder;
	}
	
	
	//Methods that just write return String instead of other things
	public static String outputGenerateString(String name){
		return generateString(name).toString();
	}
	public static String outputGenerateLong(String name){
		return generateLong(name).toString();
	}
	public static String outputGenerateDouble(String name){
		return generateDouble(name).toString();
	}
	public static String outputGenerateArrayList(String name, String type){
		return generateArrayList(name, type).toString();
	}
	
	
	
	
	
	

}
