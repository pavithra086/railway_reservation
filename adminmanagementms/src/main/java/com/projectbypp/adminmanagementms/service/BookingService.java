package com.projectbypp.adminmanagementms.service;


import com.projectbypp.adminmanagementms.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class BookingService {

    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<Booking[]> viewbookingbyTid(int trainId) throws HttpClientErrorException {
        Booking[] response= restTemplate.getForEntity("http://Booking-management-service/book/viewbooking/"
               +trainId ,Booking[].class).getBody();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
