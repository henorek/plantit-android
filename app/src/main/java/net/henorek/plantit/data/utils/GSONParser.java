package net.henorek.plantit.data.utils;

import android.support.annotation.Nullable;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by Jarek Jankowski on 2016-01-20.
 * jarosz1994@gmail.com
 */
public class GSONParser {
    public static <T> String save(T object){
        Gson gson = new Gson();
        return gson.toJson(object);
    }

    public static <T> T parse(String json,Class<T> clazz){
        Gson gson = createGson();
        return gson.fromJson(json, clazz);
    }

    public static @Nullable
    <T> ArrayList<T> parseArray(String json, Class<T[]> clazz){
        Gson gson = createGson();
        T[] objectArray = gson.fromJson(json, clazz);
        return objectArray != null ? new ArrayList<T>(Arrays.asList(objectArray)) : null;
    }

    public static class JsonDateDeserializer implements JsonDeserializer<Date> {
        public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            String s = json.getAsJsonPrimitive().getAsString();
            return jsonDateToJavaDate(s);
        }
    }

    public static class JsonStringDeserializer implements JsonDeserializer<String> {
        public String deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            String s = json.getAsJsonPrimitive().getAsString();
            if (s != null && s.equalsIgnoreCase("null"))
                return "";
            else
                return s;
        }
    }

    private static Gson createGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Date.class, new JsonDateDeserializer());
        gsonBuilder.registerTypeAdapter(String.class, new JsonStringDeserializer());
        return gsonBuilder.create();
    }

    public static Date jsonDateToJavaDate(String jsonDate) {
        try {
            int openIndex = jsonDate.indexOf('(');
            int closeIndex = jsonDate.indexOf(')');
            String fullDate = jsonDate.substring(openIndex + 1, closeIndex);

            int charIndex = fullDate.indexOf('+');

            String dateString = fullDate.substring(0, charIndex);
            long dateMiliseconds = Long.parseLong(dateString)+(2*1000*3600);
            return new Date(dateMiliseconds);

        } catch (Throwable e) {
            return null;
        }
    }

}
