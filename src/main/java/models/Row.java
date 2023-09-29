package models;

import java.util.List;

/**
 * A record representing a row in a table with a key and a list of fields.
 */
public record Row(String key, List<Object> fields) {


	/**
	 * Creates and returns a new Row object with unmodifiable fields.
	 *
	 * @param key The key for the new Row.
	 * @param fields The list of fields for the new Row.
	 * @return A new Row with unmodifiable fields.
	 * @throws IllegalArgumentException if the fields parameter is null.
	 */
	public static Row unModFields(String key, List<Object> fields) {
		// Check if the fields parameter is null and throw an exception if it is.
		if (fields == null) {
			throw new IllegalArgumentException("Fields cannot be null.");
		}
		// Create a new Row object with the specified key and unmodifiable fields.
		return new Row(key, List.copyOf(fields));
	}


	/**
	 * Returns a string representation of the row.
	 *
	 * @return A string representing the row in the format "key: fields"
	 */
	@Override
	public String toString() {
		return key + ": " + fields;
	}

	/**
	 * Computes the hash code for the row.
	 *
	 * @return The hash code of the row
	 */
	@Override
	public int hashCode() {
		int result = key.hashCode();
		result = 31 * result + fields.hashCode();
		return result;
	}

	public int compareTo(Row other) {
		return this.key.compareTo(other.key);
	}

}