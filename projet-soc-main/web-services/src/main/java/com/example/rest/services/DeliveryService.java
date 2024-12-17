package com.example.rest.services;

import com.example.rest.entity.Delivery;
import com.example.rest.repositories.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryService {

    @Autowired
    private DeliveryRepository deliveryRepository;


    public List<Delivery> getAllDeliveries() {
        return deliveryRepository.findAll();
    }

    public Optional<Delivery> getDeliveryById(String id) {
        return deliveryRepository.findById(id);
    }

    public Delivery createDelivery(Delivery delivery) {
        return deliveryRepository.save(delivery);
    }

    public Delivery updateDelivery(String id, Delivery updatedDelivery) {
        return deliveryRepository.findById(id).map(existingDelivery -> {
            existingDelivery.setAgentAge(updatedDelivery.getAgentAge());
            existingDelivery.setAgentRating(updatedDelivery.getAgentRating());
            existingDelivery.setStoreLatitude(updatedDelivery.getStoreLatitude());
            existingDelivery.setStoreLongitude(updatedDelivery.getStoreLongitude());
            existingDelivery.setDropLatitude(updatedDelivery.getDropLatitude());
            existingDelivery.setDropLongitude(updatedDelivery.getDropLongitude());
            existingDelivery.setOrderDate(updatedDelivery.getOrderDate());
            existingDelivery.setOrderTime(updatedDelivery.getOrderTime());
            existingDelivery.setPickupTime(updatedDelivery.getPickupTime());
            existingDelivery.setWeather(updatedDelivery.getWeather());
            existingDelivery.setTraffic(updatedDelivery.getTraffic());
            existingDelivery.setVehicle(updatedDelivery.getVehicle());
            existingDelivery.setArea(updatedDelivery.getArea());
            existingDelivery.setDeliveryTime(updatedDelivery.getDeliveryTime());
            existingDelivery.setCategory(updatedDelivery.getCategory());
            return deliveryRepository.save(existingDelivery);
        }).orElseThrow(() -> new RuntimeException("Delivery with ID " + id + " not found"));
    }

    public void deleteDelivery(String id) {
        if (deliveryRepository.existsById(id)) {
            deliveryRepository.deleteById(id);
        } else {
            throw new RuntimeException("Delivery with ID " + id + " does not exist");
        }
    }
}
