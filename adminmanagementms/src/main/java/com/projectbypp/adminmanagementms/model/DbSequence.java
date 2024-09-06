package com.projectbypp.adminmanagementms.model;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "db_sequence")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Details about the Db Sequence Model")
public class DbSequence {

    @Id
    private String id;
    private int seq;
}
