package com.example.soap.entity;

import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@XmlRootElement(name = "Delivery")
@Data
public class DeliverySoap {

    private String id;
    private String orderId;
    private Integer agentAge;
    private Double agentRating;
    private Double storeLatitude;
    private Double storeLongitude;
    private Double dropLatitude;
    private Double dropLongitude;
    private String orderDate;
    private String orderTime;
    private String pickupTime;
    private String weather;
    private String traffic;
    private String vehicle;
    private String area;
    private Integer deliveryTime;
    private String category;
}
