package com.expedia.json.security;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @author shareef on 27/10/2017
 */
public class SecureJson {

    static public String instanceToJson(Object instance) {
        try {
            ObjectMapper json = new ObjectMapper();
            json.registerModule(new SecurityModule());
            return json.writeValueAsString(instance);
        } catch (IOException e) {
            return "null";
        }
    }

}
