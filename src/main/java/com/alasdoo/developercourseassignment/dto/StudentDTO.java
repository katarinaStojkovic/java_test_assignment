package com.alasdoo.developercourseassignment.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class StudentDTO implements Serializable {
    private Integer id;
    private String name;
    private String surname;
    private String accountName;
    private String email;
    private String password;
    private Integer bankCardNumber;
}
