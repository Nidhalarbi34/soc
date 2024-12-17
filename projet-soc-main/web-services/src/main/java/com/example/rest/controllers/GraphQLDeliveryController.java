package com.example.rest.controllers;

import com.example.rest.entity.Delivery;
import com.example.rest.services.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class GraphQLDeliveryController {

    @Autowired
    private DeliveryService deliveryService;

    @QueryMapping
    public List<Delivery> getAllDeliveries() {
        return deliveryService.getAllDeliveries();
    }

    @QueryMapping
    public Delivery getDeliveryById(@Argument String id) {
        return deliveryService.getDeliveryById(id).orElse(null);
    }

    @MutationMapping
    public Delivery createDelivery(@Argument("input") DeliveryInput input) {
        Delivery delivery = mapToDelivery(input);
        return deliveryService.createDelivery(delivery);
    }

    @MutationMapping
    public Delivery updateDelivery(@Argument String id, @Argument("input") DeliveryInput input) {
        Delivery delivery = mapToDelivery(input);
        return deliveryService.updateDelivery(id, delivery);
    }

    @MutationMapping
    public Boolean deleteDelivery(@Argument String id) {
        deliveryService.deleteDelivery(id);
        return true;
    }

    // Helper method to map DeliveryInput to Delivery entity
    private Delivery mapToDelivery(DeliveryInput input) {
        Delivery delivery = new Delivery();
        delivery.setOrderId(input.getOrderId());
        delivery.setAgentAge(input.getAgentAge());
        delivery.setAgentRating(input.getAgentRating());
        delivery.setStoreLatitude(input.getStoreLatitude());
        delivery.setStoreLongitude(input.getStoreLongitude());
        delivery.setDropLatitude(input.getDropLatitude());
        delivery.setDropLongitude(input.getDropLongitude());
        delivery.setOrderDate(input.getOrderDate());
        delivery.setOrderTime(input.getOrderTime());
        delivery.setPickupTime(input.getPickupTime());
        delivery.setWeather(input.getWeather());
        delivery.setTraffic(input.getTraffic());
        delivery.setVehicle(input.getVehicle());
        delivery.setArea(input.getArea());
        delivery.setDeliveryTime(input.getDeliveryTime());
        delivery.setCategory(input.getCategory());
        return delivery;
    }

    // Define the DeliveryInput class for mapping GraphQL input
    public static class DeliveryInput {
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
        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public Integer getAgentAge() {
            return agentAge;
        }

        public void setAgentAge(Integer agentAge) {
            this.agentAge = agentAge;
        }

        public Double getAgentRating() {
            return agentRating;
        }

        public void setAgentRating(Double agentRating) {
            this.agentRating = agentRating;
        }

        public Double getStoreLatitude() {
            return storeLatitude;
        }

        public void setStoreLatitude(Double storeLatitude) {
            this.storeLatitude = storeLatitude;
        }

        public Double getStoreLongitude() {
            return storeLongitude;
        }

        public void setStoreLongitude(Double storeLongitude) {
            this.storeLongitude = storeLongitude;
        }

        public Double getDropLatitude() {
            return dropLatitude;
        }

        public void setDropLatitude(Double dropLatitude) {
            this.dropLatitude = dropLatitude;
        }

        public Double getDropLongitude() {
            return dropLongitude;
        }

        public void setDropLongitude(Double dropLongitude) {
            this.dropLongitude = dropLongitude;
        }

        public String getOrderDate() {
            return orderDate;
        }

        public void setOrderDate(String orderDate) {
            this.orderDate = orderDate;
        }

        public String getOrderTime() {
            return orderTime;
        }

        public void setOrderTime(String orderTime) {
            this.orderTime = orderTime;
        }

        public String getPickupTime() {
            return pickupTime;
        }

        public void setPickupTime(String pickupTime) {
            this.pickupTime = pickupTime;
        }

        public String getWeather() {
            return weather;
        }

        public void setWeather(String weather) {
            this.weather = weather;
        }

        public String getTraffic() {
            return traffic;
        }

        public void setTraffic(String traffic) {
            this.traffic = traffic;
        }

        public String getVehicle() {
            return vehicle;
        }

        public void setVehicle(String vehicle) {
            this.vehicle = vehicle;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public Integer getDeliveryTime() {
            return deliveryTime;
        }

        public void setDeliveryTime(Integer deliveryTime) {
            this.deliveryTime = deliveryTime;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }
        // Getters and setters omitted for brevity
    }
}
