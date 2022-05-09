package com.example.logindemoproject.data.model;

import com.google.gson.annotations.SerializedName;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BatchOrder {

    @SerializedName("batch_number")
    private String batchNumber;

    @SerializedName("order_number")
    private String orderNumber;

    @SerializedName("package_price")
    private String packagePrice;


    @SerializedName("collection_amount")
    private String collectionAmount;

    @SerializedName("barcode")
    private String barcode;


    @SerializedName("retainer_username")
    private String retainerUsername;


    @SerializedName("date_created")
    private String dateCreated;

    @SerializedName("order_status")
    private String orderStatus;

    @SerializedName("batch_status")
    private String batchStatus = "";


    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public String getPackagePrice() {
        return packagePrice;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getRetainerUsername() {
        return retainerUsername;
    }

    public void setRetainerUsername(String retainerUsername) {
        this.retainerUsername = retainerUsername;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String text) throws ParseException {
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = dt.parse(text);
        SimpleDateFormat dt1 = new SimpleDateFormat("dd M | hh:mm A");
        assert date != null;
        this.dateCreated = String.valueOf(dt1);
    }


    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }


    public void setPackagePrice(String packagePrice) {
        this.packagePrice = packagePrice;
    }

    public String getBatchStatus() {
        return batchStatus;
    }

    public void setBatchStatus(String batchStatus) {
        this.batchStatus = batchStatus;
    }



    public String getCollectionAmount() {
        return collectionAmount;
    }

    public void setCollectionAmount(String collectionAmount) {
        this.collectionAmount = collectionAmount;
    }

}
