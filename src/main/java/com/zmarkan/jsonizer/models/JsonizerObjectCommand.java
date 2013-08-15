package com.zmarkan.jsonizer.models;

import java.util.ArrayList;

import com.zmarkan.jsonizer.models.JsonizerCommand.CommandType;

/**
 * This represents a full object and may have any number of other variables
 * */
public class JsonizerObjectCommand extends JsonizerCommand {

	public ArrayList<JsonizerCommand> classVariables;
	
	public JsonizerObjectCommand(CommandType type, String fieldName){
		super(type, fieldName);
		classVariables = new ArrayList<JsonizerCommand>();
	}
}
