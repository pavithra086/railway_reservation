package com.projectbypp.bookingmicroservice.model;

import io.swagger.annotations.ApiModel;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "db_sequence")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Details about the Db Sequence Model")
@Getter
@Setter
@ToString
public class DbSequence {

    @Id
    private String bookingId;
    private int seq;
}
