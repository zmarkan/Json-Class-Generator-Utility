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
	
	public static final String exampleJson = "{ \"user\": \"zan\", \"number\": 42, \"double\": 10.002 }";

	String completeJson;
	public JSONParser(String jsonString){
		
		completeJson = jsonString;
		
		StringBuilder stringBuilder = new StringBuilder(completeJson);
		
		
	}
	
	
	
	
	public ArrayList<JsonizerCommand> checkJsonAndFindCommands(StringBuilder stringBuilder){
		
		ArrayList<JsonizerCommand> commandsList = new ArrayList<JsonizerCommand>();
		
		boolean eof = false;
		int currentPosition = 0;
		while(!eof){
			//find first name
			currentPosition = stringBuilder.indexOf(QUOTATION);
			int newPosition = stringBuilder.indexOf(QUOTATION, currentPosition+1);
			
			String currentFieldName = stringBuilder.substring(currentPosition+1, newPosition).trim();
			
			//get the item
			currentPosition = stringBuilder.indexOf(COLON, newPosition) +1;
			newPosition = stringBuilder.indexOf(COMMA, currentPosition);
			
			String currentFieldValues = stringBuilder.substring(currentPosition, newPosition).trim();
			System.out.println(currentFieldName);
			System.out.println(currentFieldValues);
			
			commandsList.add(JsonizerCommandFactory.getNewCommand(CommandType.STRING, currentFieldName));
			
			eof = true;		
		}
		
		
		
		
		return commandsList;
	}
	
	public JsonizerCommand.CommandType resolveCommandType(String jsonElement){
		boolean isError = false;
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
				isError = true;
			}
			
			try{
				double isDouble = Double.parseDouble(jsonElement);
				System.out.println("Found a double!");

				return CommandType.DOUBLE;
			}
			catch(NumberFormatException e){
				isError = true;
			}
			
			//shouldn't get to that if only primitive types
			//TODO: find a better way to handle that
			System.out.println("Found a whoopsie!");

			return CommandType.NULL;
		}	
	}
}
