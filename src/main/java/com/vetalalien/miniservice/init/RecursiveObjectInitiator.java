package com.vetalalien.miniservice.init;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Stream;

public class RecursiveObjectInitiator {

    private static final Logger logger = LoggerFactory.getLogger(RecursiveObjectInitiator.class);

    private static final RecursiveObjectInitiator INSTANCE = new RecursiveObjectInitiator();

    public static RecursiveObjectInitiator getInstance() {
        return INSTANCE;
    }

    private final Set<Object> notNumberWrappers = new LinkedHashSet<>();

    private final ConcurrentMap<Class<?>, Object> classesCache = new ConcurrentHashMap<>();

    {
        notNumberWrappers.add(String.class);
        notNumberWrappers.add(Boolean.class);
        notNumberWrappers.add(Date.class);
        notNumberWrappers.add(LocalDate.class);
        notNumberWrappers.add(LocalDateTime.class);
        notNumberWrappers.add(LocalTime.class);
        notNumberWrappers.add(ZonedDateTime.class);

    }

    /**
     * Threadsafe initiating instance by empty constructor from class, retrieving from cache if already exists in cache,
     * else add to cache after initiating
     *
     * @param clazz instance class
     * @param <T>   instance type
     * @return instance object
     */
    public <T> T initiate(Class<T> clazz) {
        Objects.requireNonNull(clazz, "Can't initiate object by null class");
        logger.debug("Empty object initiation for \"{}\"", clazz.getCanonicalName());
        if (classesCache.containsKey(clazz)) {
            return getFromCache(clazz);
        } else {
            synchronized (clazz) {
                if (classesCache.containsKey(clazz)) {
                    return getFromCache(clazz);
                }
                return createInstance(clazz);
            }
        }
    }

    /**
     * Empty instance initiation with inner links
     *
     * @param clazz instance class
     * @param <T>   instance type
     * @return instance object
     */
    protected  <T> T createInstance(Class<T> clazz) {
        logger.debug("Creating new instance for \"{}\"", clazz.getCanonicalName());
        T instance = newInstance(clazz);

        Stream<Field> allFieldsStream = Arrays.stream(clazz.getDeclaredFields());
        allFieldsStream
                .filter(this::needToHandle)
                .peek(f -> initiateField(instance, f))
                .count();

        putToCache(clazz, instance);

        return instance;
    }

    /**
     * Wrapper for empty {@link Constructor#newInstance(Object...)}
     *
     * @param clazz
     * @param <T>
     * @return
     */
    protected <T> T newInstance(Class<T> clazz) {
        try {
            Constructor<T> emptyConstructor = clazz.getConstructor();
            makeAccessible(emptyConstructor);
            return emptyConstructor.newInstance();
        } catch (InstantiationException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException("Empty constructor is required",e);
        }
    }

    /**
     * Decision for handle field
     *
     * @param field field for check
     * @return true if need to handle, else if need to ignore
     */
    protected boolean needToHandle(Field field) {
        return !(field.isSynthetic() || field.getType().isPrimitive()
                || notNumberWrappers.contains(field.getType())
                || Number.class.isAssignableFrom(field.getType()));
    }

    /**
     * Field initialization
     *
     * @param instance instance with this field
     * @param field    field for initialization
     * @param <T>      instance type
     */
    public <T> void initiateField(T instance, Field field) {
        Class<?> fieldType = field.getType();
        if (getValue(instance, field) != null) {
            return;
        }

        if (List.class.isAssignableFrom(fieldType)) {
            setValue(field, instance, Collections.emptyList());
        } else if (Set.class.isAssignableFrom(fieldType)) {
            setValue(field, instance, Collections.emptySet());
        } else if (Map.class.isAssignableFrom(fieldType)) {
            setValue(field, instance, Collections.emptyMap());
        } else if (Collection.class.isAssignableFrom(fieldType)){
            setValue(field, instance, Collections.emptyList());
        } else if (fieldType.isEnum()) {
            logger.debug("Ignoring enum field initialization name = {}, type \"{}\"", field.getName(),
                    fieldType.getCanonicalName());
            return;
        } else {
            logger.debug("Initiating for link field of \"{}\" type", fieldType.getCanonicalName());
            Object linkedInstance = fieldType.isAssignableFrom(instance.getClass()) ? instance : initiate(fieldType);
            setValue(field, instance, linkedInstance);
        }
    }

    /**
     * Wrapper for {@link Field#get(Object)}
     *
     * @param instance
     * @param f
     * @param <T>
     * @return
     */
    protected <T> Object getValue(T instance, Field f) {
        try {
            makeAccessible(f);
            return f.get(instance);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Wrapper for {@link Field#set(Object, Object)}
     *
     * @param field
     * @param instance
     * @param value
     */
    protected void setValue(Field field, Object instance, Object value) {
        makeAccessible(field);
        try {
            field.set(instance, value);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Wrapper for {@link Field#setAccessible(boolean)}
     * with true value
     *
     * @param object
     */
    protected void makeAccessible(AccessibleObject object) {
        if (!object.isAccessible()) {
            object.setAccessible(true);
        }
    }

    /**
     * Trying put to cache by key
     *
     * @param clazz    key
     * @param instance value
     * @param <T>      value type
     */
    protected <T> void putToCache(Class<T> clazz, T instance) {
        logger.debug("Trying put instance for class \"{}\" in cache", clazz.getCanonicalName());
        classesCache.putIfAbsent(clazz, instance);
    }

    /**
     * Getting value from cache by key
     *
     * @param clazz key
     * @param <T>   key and value type
     * @return value by key
     */
    @SuppressWarnings("unchecked")
    public <T> T getFromCache(Class<T> clazz) {
        logger.debug("Retrieving object for class \"{}\" from cache", clazz.getCanonicalName());
        return (T) classesCache.get(clazz);
    }

}
