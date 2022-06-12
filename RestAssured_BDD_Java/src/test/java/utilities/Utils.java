package utilities;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class Utils {
	//Global Setup Variables
	public static String path;
	public static String jsonPathTerm;


	//Sets base path
	public static void setBasePath(String basePathTerm) {
		RestAssured.basePath = basePathTerm;
	}

	//Reset Base URI (after test)
	public static void resetBaseURI() {
		RestAssured.baseURI = null;
	}

	//Reset base path
	public static void resetBasePath() {
		RestAssured.basePath = null;
	}

	//Sets ContentType
	public static void setContentType(ContentType Type) {
		RestAssured.given().contentType(Type);
	}

	//Sets Json path term
	public static void setJsonPathTerm(String jsonPath) {
		jsonPathTerm = jsonPath;
	}

	//Created search query path
	public static void createSearchQueryPath(String searchTerm, String param, String paramValue) {
		path = searchTerm + "/" + jsonPathTerm + "?" + param + "=" + paramValue;
	}

	//Returns response
	public static Response getResponse() {
		// System.out.print("path: " + path +"\n");
		return RestAssured.get(path);
	}

	//Returns JsonPath object
	public static JsonPath getJsonPath(Response res) {
		String json = res.asString();
		//System.out.print("returned json: " + json +"\n");
		return new JsonPath(json);
	}


//	public static HashMap jsonToMap(String t) throws JSONException {
//
//		HashMap<String, String> map = new HashMap<String, String>();
//		JSONObject jObject = new JSONObject(t);
//		Iterator<?> keys = jObject.keys();
//
//		while( keys.hasNext() ){
//			String key = (String)keys.next();
//			String value = jObject.getString(key); 
//			map.put(key, value);
//
//		}
//		return map;
//	}

//	public static Map<String,Object> parseJSONObjectToMap(JSONObject jsonObject) throws JSONException{
//		Map<String, Object> mapData = new HashMap<String, Object>();
//		Iterator<String> keysItr = jsonObject.keys();
//		while(keysItr.hasNext()) {
//			String key = keysItr.next();
//			Object value = jsonObject.get(key);
//
//			if(value instanceof JSONArray) {
//				value = parseJSONArrayToList((JSONArray) value);
//			}else if(value instanceof JSONObject) {
//				value = parseJSONObjectToMap((JSONObject) value);
//			}
//			mapData.put(key, value);
//		}
//		return mapData;
//	}
//
//	public static List<Object> parseJSONArrayToList(JSONArray array) throws JSONException {
//		List<Object> list = new ArrayList<Object>();
//		for(int i = 0; i < array.length(); i++) {
//			Object value = array.get(i);
//			if(value instanceof JSONArray) {
//				value = parseJSONArrayToList((JSONArray) value);
//			}else if(value instanceof JSONObject) {
//				value = parseJSONObjectToMap((JSONObject) value);
//			}
//			list.add(value);
//		}
//		return list;
//	}
//

}