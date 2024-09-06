package com.projectbypp.bookingmicroservice.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.*;

@Document(collection = "TrainDetails")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder

public class Train {

    @Id
    @Digits(integer = 5,fraction = 0)
    private int trainId;

    @NotEmpty(message = "required")
    @Pattern(regexp = "^[A-Za-z -]+$",message = "Only alphabets and - allowed")
    @Size(min = 3, max = 20,message = "min 3 max 20")
    private String trainName;


    @NotEmpty(message = "required")
    @Pattern(regexp = "^[A-Za-z -]+$",message = "Only alphabets and - allowed")
    @Size(min = 3, max = 20,message = "min 3 max 20")
    private String source;

    @NotEmpty(message = "required")
    @Pattern(regexp = "^[A-Za-z -]+$",message = "Only alphabets and - allowed")
    @Size(min = 3, max = 20,message = "min 3 max 20")
    private String destination;


    @NotNull
    @Digits(integer = 3,fraction = 1)
    private double price;

    @NotEmpty
    @Pattern(regexp = "[0-2][0-9]:[0-5][0-9]:[0-5][0-9]$",message = "time should be in 00:00:00 format")
    @Size(min = 8, max = 8,message = "time should be in 00:00:00 format")
    private String timeOfArrival;

    @NotEmpty
    @Pattern(regexp = "[0-2][0-9]:[0-5][0-9]:[0-5][0-9]$",message = "time should be in 00:00:00 format")
    @Size(min = 8, max = 8,message = "time should be in 00:00:00 format")
    private String timeOfDeparture;



    @NotEmpty
    private String[] days;

    @NotNull
    @Digits(integer = 4,fraction = 0)
    private int totalNumOfSeats;

    @NotEmpty
    @Pattern(regexp ="^[A-Za-z0-9 -]+$",message = "Only alphabets and digits allowed along -. No special characters allowed")
    @Size(min = 3, max = 20,message = "Only alphabets and digits allowed along -. No special characters allowed")
    private String className;



}
