package com.expedia.json.utils;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * @author shareef on 27/10/2017
 *
 * json utility conversions and other things might be added here
 */
public class JsonUtils {

    /**
     * connect to url and get result as json you can get from it attribute
     *
     * @param sURL
     * @return
     */
    public static String getJSONFromUrl(String sURL) {
        String attribute = null;
        try {

            Client client = Client.create();

            WebResource webResource = client
                    .resource(sURL);

            ClientResponse response = webResource.accept("application/json")
                    .get(ClientResponse.class);

            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatus());
            }

            attribute = response.getEntity(String.class);
        } catch (Exception ex) {
            Logger.getLogger(JsonUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return attribute;
    }

    /**
     * connect to url and get result as json you can get from it attribute
     *
     * @param sURL
     * @param attributeToGet
     * @return
     */
    public static String getAttributeFromJSONUrl(String sURL, String attributeToGet) {
        String attribute = null;
        try {
            // Connect to the URL using java's native library
            URL url = null;
            try {
                url = new URL(sURL);
            } catch (MalformedURLException ex) {
                Logger.getLogger(JsonUtils.class.getName()).log(Level.SEVERE, null, ex);
            }
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();

            // Convert to a JSON object to print data
            JsonParser jp = new JsonParser(); //from gson
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent())); //Convert the input stream to a json element
            JsonObject rootobj = root.getAsJsonObject(); //May be an array, may be an object.
            attribute = rootobj.get(attributeToGet).toString();
        } catch (IOException ex) {
            Logger.getLogger(JsonUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return attribute;
    }

}
