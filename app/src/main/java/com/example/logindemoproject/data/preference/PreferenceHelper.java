package com.example.logindemoproject.data.preference;

import java.lang.reflect.Type;

public interface PreferenceHelper extends Session {
    void putString(String key, String value);

    void putInt(String key, Integer value);

    void putBoolean(String key, Boolean value);

    void putLong(String key, Long value);

    String getString(String key);

    int getInt(String key);

    boolean getBoolean(String key);

    long getLong(String key);

    boolean hasKey(String key);

    void saveKey(String key, String value);

    boolean clear();

    void saveObject(String key, Object o);

    <T> T getObejct(String key, Type type);

    void removeKey(String key);


}
