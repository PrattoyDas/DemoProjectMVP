package com.example.logindemoproject.data.preference;

public interface Session {

    String getHeaderAuthorization();

    void setHeaderAuthorization(String basicAuthToken);

    String getAuthUsername();

    void setAuthUsername(String username);

    String getAuthEmployeeCode();

    void setAuthEmployeeCode(String employeeCode);

    String getBatchNumber();

    void setBatchNumber(String name);

    String getFcmToken();

    // FCM
    void setFcmToken(String token);

    void setRegisteredToFCM(boolean isRegistered);

    boolean isRegisteredToGcm();

    String getAppVersionName();

    // System
    void setAppVersionName(String name);

    String getDSSelectedPoint();

    // System
    void setDSSelectedPoint(String point);

    String getEmployeePointCodes();

    void setEmployeePointCodes(String point);

    // is only delivery officer

    Boolean getIsOnlyDeliveryOfficer();

    void setIsOnlyDeliveryOfficer(String text);


    // is only delivery officer

    String getAppVersion();

    void setAppVersion(String text);

    // System
    String getSelectedPoint();


    void setSelectedPoint(String point);

}
