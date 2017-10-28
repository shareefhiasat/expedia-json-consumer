package com.expedia.web.types;

import com.expedia.reflect.utils.Reflect;
import com.expedia.utils.StringsUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * this class make it very easy to deal with java reflection directly from the
 * class instance, java reflection is a way to dynamically use any object
 * properties and methods on runtime using these parameters and methods names,
 * just extend this class and the new class will have all the reflection methods
 * encapsulated inside the class instances.
 *
 * @author shareef on 27/10/2017
 */
public abstract class ObjectAnalyzer implements Cloneable, Serializable {
    @JsonIgnore
    private static final long serialVersionUID = 3567653491060394677L;

    @JsonIgnore
    private int hashCode = super.hashCode();

    /**
     * get object property value using the property name
     *
     * @param propertyName property name to get
     * @return property value
     */
    @JsonIgnore
    public final Object get(String propertyName) {
        try {
            Class<?> type = this.getField(propertyName).getType();
            boolean isBoolean = type == boolean.class || type == Boolean.class;
            String getter = ((isBoolean) ? "is" : "get") + StringsUtil.capitalizeFirst(propertyName);
            Object fieldValue = null;
            if (this.getMethod(getter) != null) {
                fieldValue = this.getMethod(getter).invoke(this);
            }
            return fieldValue;
        } catch (IllegalAccessException | InvocationTargetException | IllegalArgumentException ex) {
            return null;
        }
    }

    /**
     * set object property value using the property name and value
     *
     * @param propertyName  property name to set
     * @param propertyValue property value to set
     * @return true if success and false if not
     */
    @JsonIgnore
    public final boolean set(String propertyName, Object propertyValue) {
        try {
            String setter = "set" + StringsUtil.capitalizeFirst(propertyName);
            Field field = this.getField(propertyName);
            if (this.getMethod(setter, field.getType()) != null) {
                this.getMethod(setter, field.getType()).invoke(this, propertyValue);
            }
            return true;
        } catch (IllegalAccessException | InvocationTargetException | IllegalArgumentException ex) {
            Logger.getLogger(ObjectAnalyzer.class.getName()).log(Level.SEVERE, "Reflection issue getField", ex);
            return false;
        }
    }

    /**
     * get the object class fields as an array
     *
     * @return array of class fields
     */
    @JsonIgnore
    public final Field[] getFields() {
        Class clazz = this.getClass();

        ArrayList<Field> fields = new ArrayList<>();
        while (clazz != null && clazz != JsonObject.class) {
            fields.addAll(Arrays.asList(clazz.getDeclaredFields()));
            clazz = clazz.getSuperclass();
        }
        Field[] fieldsArray = new Field[fields.size()];
        fieldsArray = fields.toArray(fieldsArray);
        return fieldsArray;
    }

    /**
     * get the object class field using field name
     *
     * @param name field name to return
     * @return class field
     */
    @JsonIgnore
    protected final Field getField(String name) {

        Class clazz = this.getClass();
        Field field = null;
        while (clazz != null && clazz != JsonObject.class && field == null) {
            try {
                field = clazz.getDeclaredField(name);
            } catch (NoSuchFieldException | SecurityException ex) {
                Logger.getLogger(ObjectAnalyzer.class.getName()).log(Level.INFO, "getField", ex);
            }
            clazz = clazz.getSuperclass();
        }
        return field;
    }

    /**
     * get object class method using method name and parameters
     *
     * @param name           method name to return
     * @param parameterTypes parameters types
     * @return class method
     */
    @JsonIgnore
    @SuppressWarnings("unchecked")
    protected final Method getMethod(String name, Class<?>... parameterTypes) {

        Class clazz = this.getClass();
        Method method = null;
        while (clazz != null && clazz != JsonObject.class && method == null) {
            try {
                method = clazz.getDeclaredMethod(name, parameterTypes);
            } catch (NoSuchMethodException | SecurityException ex) {
//                Logger.getLogger(ObjectAnalyzer.class.getName()).log(Level.INFO, "getMethod", ex);
            }
            clazz = clazz.getSuperclass();
        }
        return method;
    }

    /**
     * set this object properties values using another object from the same
     * class, if the process didn't success the object will keep its original
     * values.
     *
     * @param <T>    this object class type
     * @param object object to get values from
     * @return true if success or false if not
     */
    @JsonIgnore
    @SuppressWarnings("unchecked")
    protected final <T> boolean setThis(T object) {
        try {
            T clone = (T) this.clone();
            if (this.fill(object)) {
                return true;
            } else {
                this.fill(clone);
                return false;
            }
        } catch (CloneNotSupportedException ex) {
            return false;
        }
    }

    /**
     * set fill object properties values using another object from the same
     * class, this method is used by the setThis method, the only different that
     * the setThis method will reset the object to it's original values if the
     * process didn't success but this method will not.
     *
     * @param <T>    this object class type
     * @param object object to get values from
     * @return true if success or false if not
     */
    private <T> boolean fill(T object) {
        ObjectAnalyzer refactorObject = (ObjectAnalyzer) object;
        for (Field field : this.getFields()) {
            boolean isStatic = Reflect.isStatic(field);
            boolean isFinal = Reflect.isFinal(field);

            if (isStatic || isFinal)
                continue;
            if ("hashCode".equals(field.getName()))
                continue;

            try {
                String fieldName = field.getName();
                this.set(fieldName, refactorObject.get(fieldName));
            } catch (Exception ex) {
                return false;
            }
        }
        return true;
    }

    /**
     * set the object hash code, hash code is a unique id set and used by java
     * JVM to compare objects, by default object hash code is private and cannot
     * be set but this method let you set the object hash code, changing hash
     * code could be useful if you want to fake the java JVM that two objects
     * are equals
     *
     * @param hashCode the object hash code
     */
    public void setHashCode(int hashCode) {
        this.hashCode = hashCode;
    }

    /**
     * get the object hash code,hash code is a unique id set and used by java
     * JVM to compare objects, by default object hash code is private and cannot
     * be set but this method let you set the object hash code, changing hash
     * code could be useful if you want to fake the java JVM that two objects
     * are equals
     *
     * @return object hash code
     */
    public int getHashCode() {
        return hashCode;
    }

    @Override
    public int hashCode() {
        return this.getHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ObjectAnalyzer other = (ObjectAnalyzer) obj;
        return this.getHashCode() == other.getHashCode();
    }

    @Override
    public ObjectAnalyzer clone() throws CloneNotSupportedException {
        return (ObjectAnalyzer) super.clone();
    }

}
