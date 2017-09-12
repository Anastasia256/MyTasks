package json.serialization.adapter.impl;

import json.serialization.adapter.JsonDataAdapter;
import org.json.JSONException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Converts object of type java.time.LocalDate to Sting by using ISO 8601 format
 */
public class LocalDateAdapter implements JsonDataAdapter<LocalDate> {
    @Override
    public Object toJson(LocalDate o) throws JSONException {
        return o.format( DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}
