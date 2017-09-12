package json.serialization.adapter.impl;

import json.serialization.adapter.JsonDataAdapter;
import json.serialization.serializer.JsonSerializer;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

/**
 * Converts all objects that extends java.util.Map to JSON Object
 */
public class MapAdapter implements JsonDataAdapter<Map> {
    @Override
    public Object toJson(Map o) throws JSONException {
        Map<Object, Object> map = o;

        JSONObject jsonObject = new JSONObject(o);

        for (Map.Entry entry : map.entrySet()) {
            jsonObject.put((String) entry.getKey(), JsonSerializer.serialize(entry.getValue()));
        }

        return jsonObject;

    }
}
