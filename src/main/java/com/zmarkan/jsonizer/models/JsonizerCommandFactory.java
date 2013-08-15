package com.zmarkan.jsonizer.models;

import com.zmarkan.jsonizer.models.JsonizerCommand.CommandType;

public class JsonizerCommandFactory {

	/**
	 * Instantiates a proper type of command
	 * */
	public static JsonizerCommand getNewCommand(JsonizerCommand.CommandType type, String fieldName){
		if(type == CommandType.OBJECT){
			return new JsonizerObjectCommand(type, fieldName);
			
		}
		else if(type == CommandType.ARRAY){
			//TODO:
			return null;
		}
		else{
			return new JsonizerCommand(type, fieldName);
		}
	}
}
