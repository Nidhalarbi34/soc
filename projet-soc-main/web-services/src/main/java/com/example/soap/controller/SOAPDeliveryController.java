package com.example.soap.controller;

import com.example.soap.entity.DeliverySoap;
import com.example.rest.entity.Delivery;
import com.example.rest.services.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.ws.soap.server.endpoint.annotation.SoapAction;

@Endpoint
public class SOAPDeliveryController {

    private static final String NAMESPACE_URI = "http://example.com/soap";

    @Autowired
    private DeliveryService deliveryService;

    @SoapAction("findDeliveryById")
    @ResponsePayload
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getDeliveryByIdRequest")
    public DeliverySoap getDeliveryById(@RequestPayload String id) {
        return deliveryService.getDeliveryById(id)
                .map(delivery -> {
                    DeliverySoap soapDelivery = new DeliverySoap();
                    soapDelivery.setId(delivery.getId());
                    soapDelivery.setOrderId(delivery.getOrderId());
                    soapDelivery.setAgentAge(delivery.getAgentAge());
                    soapDelivery.setAgentRating(delivery.getAgentRating());
                    soapDelivery.setStoreLatitude(delivery.getStoreLatitude());
                    soapDelivery.setStoreLongitude(delivery.getStoreLongitude());
                    soapDelivery.setDropLatitude(delivery.getDropLatitude());
                    soapDelivery.setDropLongitude(delivery.getDropLongitude());
                    soapDelivery.setOrderDate(delivery.getOrderDate());
                    soapDelivery.setOrderTime(delivery.getOrderTime());
                    soapDelivery.setPickupTime(delivery.getPickupTime());
                    soapDelivery.setWeather(delivery.getWeather());
                    soapDelivery.setTraffic(delivery.getTraffic());
                    soapDelivery.setVehicle(delivery.getVehicle());
                    soapDelivery.setArea(delivery.getArea());
                    soapDelivery.setDeliveryTime(delivery.getDeliveryTime());
                    soapDelivery.setCategory(delivery.getCategory());
                    return soapDelivery;
                }).orElse(null);
    }
}
