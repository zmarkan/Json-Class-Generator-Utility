package com.zmarkan.jsonizer.models;

import java.util.ArrayList;

/**
 * A single command representation for the ClassMaker that handles a single JSon field
 * */
public class JsonizerCommand {

	public enum CommandType{
		LONG, DOUBLE, STRING, BOOLEAN, OBJECT, ARRAY, NULL
	};
	
	//we need a type and a name of a field to be able to generate it 
	public CommandType type;
	public String fieldName;
	
	public JsonizerCommand(CommandType type, String fieldName){
		this.type = type;
		this.fieldName = fieldName;
	}

	
}

