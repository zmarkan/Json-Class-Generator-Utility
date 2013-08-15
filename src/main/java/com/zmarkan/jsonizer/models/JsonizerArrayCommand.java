package com.zmarkan.jsonizer.models;

public class JsonizerArrayCommand extends JsonizerCommand {


	public JsonizerCommand.CommandType arrayContentType;
	
	public JsonizerArrayCommand(CommandType type, String fieldName) {
		super(type, fieldName);
		//TODO: needs to be checked for its contents
	}

}
