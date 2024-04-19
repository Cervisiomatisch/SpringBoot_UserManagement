package de.ba.auth.auth.lib;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class JsonReader {
  
	/**
	 * The parameter will be converted into a JSONObject.
	 * Therefore no need to use try/catch in the caller method.
	 * 
	 * @param jsonstr
	 * @return JSONObject or null if ParserException is thrown
	 */
	static public JSONObject readJSONObject( Object object ) {
	  
	    if ( object == null || object.equals("") )
	        return new JSONObject();
	    
	    String jsonstr = String.valueOf(object);
	  
	    if ( jsonstr == null )
	    	return new JSONObject();
    
	    JSONParser parser = new JSONParser();
    
	    try {
	    	JSONObject jobj = (JSONObject) parser.parse( jsonstr );
	    	return jobj;
	    } catch (ParseException e) {
	    	e.printStackTrace();
	    }   
    
	    return new JSONObject();
	}

	/**
	 * The parameter will be converted into a JSONArray.
	 * Therefore no need to use try/catch in the caller method.
	 * 
	 * @param jsonstr
	 * @return JSONArray or null if ParserException is thrown
	 */
  	static public JSONArray readJSONArray( Object object ) {
	  
	    if ( object == null || object.equals("") )
	        return new JSONArray();
	    
	    String jsonstr = String.valueOf(object);
	    
	    JSONParser parser = new JSONParser();
	    if ( jsonstr == null )
	    	return new JSONArray();
	    try {
	    	JSONArray jarr = (JSONArray) parser.parse( jsonstr );
	    	return jarr;
	    } catch (ParseException e) {
	    	e.printStackTrace();
	    }   
	    return new JSONArray();
  	}
  	
} // EoC