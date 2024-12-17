package com.example.soap.endpoint;

import com.example.soap.entity.DeliverySoap;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class DeliveryEndpoint {

    private static final String NAMESPACE_URI = "http://example.com/soap/entity/DeliverySoap";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "Delivery")
    @ResponsePayload
    public DeliverySoap processDelivery(@RequestPayload DeliverySoap request) {
        // Here, you can process the incoming SOAP message and construct a response.
        DeliverySoap response = new DeliverySoap();
        response.setId(request.getId());
        response.setOrderId(request.getOrderId());
        response.setDeliveryTime(calculateDeliveryTime(request));
        response.setCategory("Processed");

        return response;
    }

    private int calculateDeliveryTime(DeliverySoap delivery) {
        // Example: calculate delivery time based on mock data
        return 30; // Mocked delivery time in minutes
    }
}
