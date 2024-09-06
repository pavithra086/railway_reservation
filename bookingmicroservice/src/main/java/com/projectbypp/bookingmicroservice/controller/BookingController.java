package com.projectbypp.bookingmicroservice.controller;


import com.projectbypp.bookingmicroservice.model.Booking;
import com.projectbypp.bookingmicroservice.model.Train;
import com.projectbypp.bookingmicroservice.service.BookingService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookingController {

    Logger logger = LoggerFactory.getLogger(BookingController.class);
    @Autowired
    BookingService bookingService;




    @GetMapping("/view/{bookingId}")
    @ApiOperation(value = "View Booking details", notes = "View all booking for particular train number")
    public Optional<Booking> viewbooking(@PathVariable("bookingId") int bookingId) {
        logger.info("[view/bookingId] info message added");

        return bookingService.viewbooking(bookingId);
    }

    @GetMapping("/viewbooking/{trainNum}")
    @ApiOperation(value = "View Booking details", notes = "View all booking for particular train number")
    public List<Booking> viewbookingbyTid(@PathVariable("trainNum") int trainId) {
        logger.info("[viewbooking/trainNum] info message added");

        return bookingService.viewbookingbyTid(trainId);
    }


    @GetMapping("/listallbooking")

    public List<Booking> getBookings()
    {
        return bookingService.getBookings();
    }


    @PostMapping("/addbooking")

    public Booking addbooking(@RequestBody Booking booking) {
        logger.info("[addtrain] info message added");
        return bookingService.addbooking(booking);

    }
    @PutMapping("/update/{trainId}")
    public Booking updateBook(@RequestBody Booking booking,@PathVariable("trainId")int trainId)
    {
        logger.info("[update/trainId] info message added");
        return  bookingService.updateBook(trainId, booking);
    }

    //get all booking details by emailid


    @GetMapping("/listallbookings/{email}")
    public  List<Booking> findByEmail(@PathVariable("email")String email)
    {
        return bookingService.findByEmail(email);
    }
}