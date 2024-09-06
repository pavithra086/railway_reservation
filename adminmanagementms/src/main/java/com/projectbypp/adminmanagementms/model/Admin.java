package com.projectbypp.adminmanagementms.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "AdminDetails")

public class Admin {

    @Transient
    public static final String SEQUENCE_NAME="user_sequence";

    @Id
    private int adminId;
    private String userName;

    @NotEmpty(message = "required")
    @Pattern(regexp = "^[A-Za-z\\s]+$",message = "Only alphabets and spaces are allowed")
    @Size(min = 3, max = 15,message = "min 3 max 15 alphabets")
    private String name;

    @NotEmpty(message = "required")
    @Pattern(regexp = "^(?=.[a-z])(?=.[A-Z])(?=.\\d)(?=.[@$!%?&()])[A-Za-z\\d@$!%?&()]{8,20}$"
            ,message = "Password should contain min 8 characters and max 20 characters are allowed.\n" +
            "Password should contain at least one digit.\n" +
            "Password should contain at least one upper case alphabet.\n" +
            "Password should contain at least one lower case alphabet.\n" +
            "Password should contain at least one special character \n" +
            "Password shouldn't contain any white space.")
    private String password;

    @NotEmpty(message = "required")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,20}$"
            ,message = "Email should be in the format abc@gmail.com")
    private String email;

    @NotEmpty(message = "required")
    @Pattern(regexp = "^\\d{10}$",message = "Phone number should be of 10 digits")
    private String phone;

    @NotEmpty(message = "required")
    @Pattern(regexp = "^[A-Za-z0-9 \\-:/()]+$",message = "Address can have alphabets and numbers.\n"
            +"White space,colon,round bracket,forward slash and - is allowed.\n"+"No other special characters allowed.")
    @Size(min = 10, max = 50,message = "min 10 max 50 characters allowed")
    private String address;


    public Admin(int i, String nvhbjkh, String s, String s1, String s2, String adcsfvhf) {
    }
}