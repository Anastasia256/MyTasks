package json.serialization.adapter.impl;

import json.serialization.adapter.JsonDataAdapter;
import json.serialization.serializer.JsonSerializer;
import org.json.JSONArray;
import org.json.JSONException;

import java.util.Collection;

/**
 * Converts all objects that extends java.util.Collections to JSONArray
 */
public class CollectionAdapter implements JsonDataAdapter<Collection> {
    @Override
    public Object toJson(Collection o) throws JSONException {
        JSONArray array = new JSONArray();
        for (Object obj : o) {
            array.put(JsonSerializer.serialize(obj));
        }
        return array;
    }
}
