package json.serialization.serializer;

import json.serialization.adapter.JsonDataAdapter;
import json.serialization.adapter.UseDataAdapter;
import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.util.*;


/**
 * JsonSerializer converts Java objects to JSON representation
 */
public class JsonSerializer {

    /**
     * simpleTypes contains java classes for which we should not make any|deeper serialization and we should
     * return object as is and use toString() method to get it serialized representation.
     */
    private static Set<Class> simpleTypes = new HashSet<>(Arrays.asList(
            JSONObject.class,
            JSONArray.class,
            String.class,
            Integer.class,
            Short.class,
            Long.class,
            Byte.class,
            Double.class,
            Float.class,
            Character.class,
            Boolean.class,
            int.class,
            short.class,
            long.class,
            byte.class,
            double.class,
            float.class,
            char.class,
            boolean.class)
    );

    /**
     * Main method to convert Java object to JSON. If type of the object is part of the simpleTypes
     * object itself will be returned.
     * If object is null String value "null" returned.
     *
     * @param o object to serialize
     * @return JSON representation of the object.
     */
    public static Object serialize(Object o) {
        if (null == o) {
            return "null";
        }
        if (simpleTypes.contains(o.getClass())) {
            return o;
        } else {
            try {
                return toJsonObject(o);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    /**
     * Converts Java object to JSON. Uses reflection to access object fields.
     * Uses JSONDataAdapter to serialize complex values. Ignores @Ignore annotated fields.
     *
     * @param o object to serialize to JSON
     * @return JSON object
     * @throws IllegalAccessException
     * @throws InstantiationException
     */

    @SuppressWarnings("unchecked")
    private static JSONObject toJsonObject(Object o) throws Exception {
        Map<String, Object> resultMap = new HashMap<>();

        Class clazz = o.getClass();
        Field[] fields = clazz.getDeclaredFields();
        AccessibleObject.setAccessible(fields, true);

        for (Field field : fields) {
            if (!(field.isAnnotationPresent(Ignore.class))) {
                Object value = field.get(o);
                if (field.isAnnotationPresent(UseDataAdapter.class)) {
                    UseDataAdapter annotation = field.getAnnotation(UseDataAdapter.class);
                    JsonDataAdapter adapter = annotation.value().newInstance();
                    resultMap.put(field.getName(), adapter.toJson(field.get(o)));
                } else  resultMap.put(field.getName(), value.toString());
            }
        }
        return new JSONObject(resultMap);
    }
}
