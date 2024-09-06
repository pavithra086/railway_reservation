package com.projectbypp.adminmanagementms.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "Co Passenger Details")
@ApiModel(description = "Details about the Passenger Model")
public class Passengers {


    @Pattern(regexp = "^[A-Za-z\\s]+$",message = "Only alphabets and spaces are allowed")
    @Size(min = 3, max = 15,message = "min 3 max 15 alphabets")
    @ApiModelProperty(notes = "The Co Passenger name.")
    private String passengersName;


    @Pattern(regexp = "^(?:Male|Female|Others)$"
            ,message = "Only Female, Male are allowed.")
    private String gender;

   @NotNull(message = "required")
   @Digits(integer = 3,fraction  =0)
    private int age;

}
