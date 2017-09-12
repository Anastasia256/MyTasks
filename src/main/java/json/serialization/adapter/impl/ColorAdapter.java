package json.serialization.adapter.impl;

import json.serialization.adapter.JsonDataAdapter;
import org.json.JSONException;

import java.awt.*;
import java.lang.reflect.Field;

/**
 * Converts object of type java.awt.Color to it's String representation.
 * i.e. Color.GRAY = "(128,128,128)"
 */
public class ColorAdapter implements JsonDataAdapter<Color> {
    @Override
    public Object toJson(Color o) throws JSONException {
        return "(" + o.getGreen() + " " + o.getRed() + " " + o.getBlue() + ")";
    }
}
