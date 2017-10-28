package com.expedia.web.types;

import com.expedia.json.security.SecureJson;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * this class make it very easy to deal with web utility directly from the class
 * instance, just extend this class and the new class will have all the web
 * utility methods encapsulated inside the class instances.
 *
 * @author shareef on 27/10/2017
 */
public class Webinizer extends ObjectAnalyzer {
    @JsonIgnore
    private static final String YYYY_MM_DD_T_HH_MM_SS_SSS_Z = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    @JsonIgnore
    private static final String JSON_ERROR = "JSON Error";

    /**
     * convert the object to a JSON string
     *
     * @return JSON string or "null" as string if failed
     */
    public String toJSON() {
        return SecureJson.instanceToJson(this);
    }

    /**
     * set object values from a JSON string, if process failed the original
     * object values will not be changed.
     *
     * @param string JSON string
     * @return true if process is success
     */
    public boolean fromJSON(String string) {
        if (string != null && !string.isEmpty()) {
            ObjectMapper json = new ObjectMapper();
            DateFormat dateFormat = new SimpleDateFormat(YYYY_MM_DD_T_HH_MM_SS_SSS_Z);
            dateFormat.setTimeZone(TimeZone.getDefault());
            json.setDateFormat(dateFormat);
            json.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
            Webinizer object;
            try {
                string = new JSONParser().parse(string).toString(); // it is required only for previously saved charts (before security update)
                object = json.readValue(string, this.getClass());
            } catch (IOException ex) {
                Logger.getLogger(JSON_ERROR).log(Level.SEVERE, "JSON Error: {0}", ex.getMessage());
                return false;
            } catch (ParseException ex) {
                Logger.getLogger(JSON_ERROR).log(Level.SEVERE, "JSON Parse Error: {0}", ex.getMessage());
                return false;
            }
            return this.setThis(object);
        }
        return false;
    }
}
