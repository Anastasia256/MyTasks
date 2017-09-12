package json.serialization.adapter;

import org.json.JSONException;

/**
 * JSONDataAdapter contains instructions how to serialize Java object to JSON representation
 * @param <T> determines type adapter works with
 */
public interface JsonDataAdapter<T> {
    Object toJson(T o) throws JSONException;
}
