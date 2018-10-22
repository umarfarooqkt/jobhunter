package models;

import java.util.HashMap;

public class QueryMap {

	private static HashMap<String, String> map = new HashMap<String, String>();
	
	static {
		map.put("containsTitle", 
				"SELECT * FROM jobposting "
				+ "WHERE title = ?1 "
				+ "ORDER BY created_at ASC");
		map.put("containsCompany", 
				"SELECT * FROM jobposting "
				+ "WHERE company = ?1 "
				+ "ORDER BY created_at ASC");
		map.put("containsLocation", "SELECT * FROM jobposting "
				+ "WHERE location = ?1 "
				+ "ORDER BY created_at ASC");
		map.put("containsDate", "SELECT * FROM jobposting "
				+ "WHERE created_at = ?1 "
				+ "ORDER BY created_at ASC");
		map.put("containsType", "SELECT * FROM jobposting "
				+ "WHERE type = ?1 "
				+ "ORDER BY created_at ASC");
		map.put("descriptionMatches", "SELECT * FROM jobposting "
				+ "WHERE description like ?1 "
				+ "ORDER BY created_at ASC");
		map.put("titleMatches", "SELECT * FROM jobposting "
				+ "WHERE title like ?1 "
				+ "ORDER BY created_at ASC");
	}
	
	/**
	 * This method returns the corresponding queries to the key
	 * @param key
	 * @return {query}
	 */
	public static String getQuery(String key) {
		return map.get(key);
	}
}
