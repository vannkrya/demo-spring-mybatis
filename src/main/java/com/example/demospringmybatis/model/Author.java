package com.example.demospringmybatis.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private int authorId;
    private String name;
    private String gender;
}
