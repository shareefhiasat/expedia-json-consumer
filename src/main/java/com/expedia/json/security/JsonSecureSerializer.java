package com.expedia.json.security;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import org.springframework.web.util.HtmlUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


/**
 * @author shareef on 27/10/2017
 */
class JsonSecureSerializer extends JsonSerializer<String> implements ContextualSerializer {

    private final JsonSerializer<Object> defaultSerializer;
    //not good practice to make exceptions but until i have answer from expedia i will keep it
        private static final Set<String> IGNORE_ESCAPE = new HashSet<>(Arrays.asList("hotelName", "hotelInfo", "localizedHotelName"));

    JsonSecureSerializer(JsonSerializer<Object> serializer) {
        defaultSerializer = serializer;
    }

    @Override
    public void serialize(String value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        defaultSerializer.serialize(value, gen, provider);
    }

    @Override
    public JsonSerializer<?> createContextual(SerializerProvider prov, BeanProperty property) throws JsonMappingException {
        if (property != null && IGNORE_ESCAPE.contains(property.getName())) {
            return this;
        }
        return new JsonEscapeSerializer(defaultSerializer);
    }
}

/**
 * @author shareef on 27/10/2017
 *
 */
class JsonEscapeSerializer extends JsonSerializer<String> {

    private final JsonSerializer<Object> defaultSerializer;

    JsonEscapeSerializer(JsonSerializer<Object> serializer) {
        defaultSerializer = serializer;
    }

    @Override
    public void serialize(String value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        defaultSerializer.serialize(HtmlUtils.htmlEscape(value), gen, provider);
    }

}