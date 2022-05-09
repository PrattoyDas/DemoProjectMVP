package com.example.logindemoproject.data.preference;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import java.lang.reflect.Type;

public class AppPreferenceHelper implements PreferenceHelper {


    private final static String PREF_NAME = "wings_pref";
    private static final String SELECTED_POINT = "selected_point";

    private final SharedPreferences mPrefs;
    private Gson gson;

    public AppPreferenceHelper(Context context, Gson gson) {
        this.mPrefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    @Override
    public void putString(String key, String value) {
        mPrefs.edit().putString(key, value).apply();
    }

    @Override
    public void putInt(String key, Integer value) {
        mPrefs.edit().putInt(key, value).apply();
    }

    @Override
    public void putBoolean(String key, Boolean value) {
        mPrefs.edit().putBoolean(key, value).apply();
    }

    @Override
    public void putLong(String key, Long value) {
        mPrefs.edit().putLong(key, value).apply();
    }

    @Override
    public String getString(String key) {
        return mPrefs.getString(key, null);
    }

    @Override
    public int getInt(String key) {
        return mPrefs.getInt(key, -1);
    }

    @Override
    public boolean getBoolean(String key) {
        return mPrefs.getBoolean(key, false);
    }

    @Override
    public long getLong(String key) {
        return mPrefs.getLong(key, -1);
    }

    @Override
    public boolean hasKey(String key) {
        return mPrefs.contains(key);
    }

    @Override
    public void saveKey(String key, String value) {
        putString(key, value);
    }

    @Override
    public boolean clear() {
        return mPrefs.edit().clear().commit();
    }

    @Override
    public void saveObject(String key, Object o) {
        putString(key, gson.toJson(o));
    }

    @Override
    public <T> T getObejct(String key, Type type) {
        String json = getString(key);
        return gson.fromJson(json, type);
    }

    @Override
    public void removeKey(String key) {
        mPrefs.edit().remove(key).apply();
    }

    @Override
    public String getHeaderAuthorization() {
        return null;
    }

    @Override
    public void setHeaderAuthorization(String basicAuthToken) {

    }

    @Override
    public String getAuthUsername() {
        return null;
    }

    @Override
    public void setAuthUsername(String username) {

    }

    @Override
    public String getAuthEmployeeCode() {
        return null;
    }

    @Override
    public void setAuthEmployeeCode(String employeeCode) {

    }

    @Override
    public String getBatchNumber() {
        return null;
    }

    @Override
    public void setBatchNumber(String name) {

    }

    @Override
    public String getFcmToken() {
        return null;
    }

    @Override
    public void setFcmToken(String token) {

    }

    @Override
    public void setRegisteredToFCM(boolean isRegistered) {

    }

    @Override
    public boolean isRegisteredToGcm() {
        return false;
    }

    @Override
    public String getAppVersionName() {
        return null;
    }

    @Override
    public void setAppVersionName(String name) {

    }

    @Override
    public String getDSSelectedPoint() {
        return null;
    }

    @Override
    public void setDSSelectedPoint(String point) {

    }

    @Override
    public String getEmployeePointCodes() {
        return null;
    }

    @Override
    public void setEmployeePointCodes(String point) {

    }

    @Override
    public Boolean getIsOnlyDeliveryOfficer() {
        return null;
    }

    @Override
    public void setIsOnlyDeliveryOfficer(String text) {

    }

    @Override
    public String getAppVersion() {
        return null;
    }

    @Override
    public void setAppVersion(String text) {

    }

    @Override
    public String getSelectedPoint() {
        if (getString(SELECTED_POINT) != null) {
            return getString(SELECTED_POINT);
        } else {
            return "";
        }
    }

    @Override
    public void setSelectedPoint(String text) {
        putString(SELECTED_POINT, text);
    }

}
