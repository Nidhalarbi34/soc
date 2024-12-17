package com.example.rest.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "delivery_stats")
@Data
public class Delivery {

    @Id
    private String id;

    @Field("order_id")
    private String orderId;

    @Field("agent_age")
    private Integer agentAge;

    @Field("agent_rating")
    private Double agentRating;

    @Field("store_latitude")
    private Double storeLatitude;

    @Field("store_longitude")
    private Double storeLongitude;

    @Field("drop_latitude")
    private Double dropLatitude;

    @Field("drop_longitude")
    private Double dropLongitude;

    @Field("order_date")
    private String orderDate;

    @Field("order_time")
    private String orderTime;

    @Field("pickup_time")
    private String pickupTime;

    private String weather;

    private String traffic;

    private String vehicle;

    private String area;

    @Field("delivery_time")
    private Integer deliveryTime;

    private String category;
}
