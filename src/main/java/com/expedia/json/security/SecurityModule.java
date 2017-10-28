package com.expedia.json.security;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;

/**
 * @author shareef on 27/10/2017
 */
public class SecurityModule extends SimpleModule {

    @Override
    public void setupModule(SetupContext context) {
        super.setupModule(context);
        context.addBeanSerializerModifier(new BeanSerializerModifier() {
            @Override
            public JsonSerializer<?> modifySerializer(
                    SerializationConfig config,
                    BeanDescription desc,
                    JsonSerializer<?> serializer
            ) {
                if (desc.getBeanClass().isAssignableFrom(String.class)) {
                    return new JsonSecureSerializer((JsonSerializer<Object>) serializer);
                }
                return serializer;
            }
        });
    }

}