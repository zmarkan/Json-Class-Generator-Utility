package com.zmarkan.jsonizer.parser;

import java.util.ArrayList;

import com.zmarkan.jsonizer.models.JsonizerCommand;
import com.zmarkan.jsonizer.models.JsonizerCommand.CommandType;
import com.zmarkan.jsonizer.models.JsonizerCommandFactory;

public class JSONParser {
	
	public static final String QUOTATION = "\"";
	public static final String BRACKET_OPEN = "{";
	public static final String BRACKET_CLOSE = "}";
	public static final String BRACKET_OPEN_SQUARE = "[";
	public static final String BRACKET_CLOSE_SQUARE = "]";
	public static final String COMMA = ",";
	public static final String COLON = ":";
	public static final String JSON_NULL = "null";
	

	String completeJson;
	public JSONParser(String jsonString){
		
		completeJson = jsonString;
		
		StringBuilder stringBuilder = new StringBuilder(completeJson);
		
		
	}
	
	
	
	
	public ArrayList<JsonizerCommand> checkJsonAndFindCommands(StringBuilder stringBuilder){
		
		ArrayList<JsonizerCommand> commandsList = new ArrayList<JsonizerCommand>();
		
		boolean eof = false;
		int currentPosition = 0;
		int newPosition = 0;
		String currentFieldName;
		String currentFieldValues;
		
		//find first name
		
		
		while(!eof){
			
			currentPosition = stringBuilder.indexOf(QUOTATION, currentPosition);
			newPosition = stringBuilder.indexOf(QUOTATION, currentPosition+1);
			
			currentFieldName = stringBuilder.substring(currentPosition+1, newPosition).trim();
			
			//get the item
			currentPosition = stringBuilder.indexOf(COLON, newPosition) +1;
			newPosition = stringBuilder.indexOf(COMMA, currentPosition);
			
			//we might be at the last element
			if(newPosition < 0 ){
				newPosition = stringBuilder.indexOf(BRACKET_CLOSE, currentPosition);
				eof = true;
			}

			
			currentFieldValues = stringBuilder.substring(currentPosition, newPosition).trim();			
			commandsList.add(JsonizerCommandFactory.getNewCommand(resolveCommandType(currentFieldValues), currentFieldName));
			System.out.println("added: name: "+ currentFieldName + " type:  "+commandsList.get(commandsList.size()-1).type);
			currentPosition = newPosition;
			
		}
		
		return commandsList;
	}
	
	public JsonizerCommand.CommandType resolveCommandType(String jsonElement){
		//this be string
		if(jsonElement.startsWith(QUOTATION)){
			System.out.println("Found a String!");
			return JsonizerCommand.CommandType.STRING;
			
		}
		//null element, return object type
		else if(jsonElement.equalsIgnoreCase(JSON_NULL)){
			System.out.println("Found a null!");

			return JsonizerCommand.CommandType.NULL;
		}

		//try numbers
		else{
			try{
				long isLong = Long.parseLong(jsonElement);
				System.out.println("Found a long!");
				return JsonizerCommand.CommandType.LONG;
			}
			catch(NumberFormatException e){
				//TODO
			}
			
			try{
				double isDouble = Double.parseDouble(jsonElement);
				System.out.println("Found a double!");

				return CommandType.DOUBLE;
			}
			catch(NumberFormatException e){
				//TODO
			}
			
			//shouldn't get to that if only primitive types
			//TODO: find a better way to handle that
			System.out.println("Found a whoopsie!");

			return CommandType.NULL;
		}	
	}
}
