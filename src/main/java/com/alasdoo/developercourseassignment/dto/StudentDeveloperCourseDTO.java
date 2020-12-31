package com.alasdoo.developercourseassignment.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
public class StudentDeveloperCourseDTO implements Serializable {

    private Integer id;
    private Integer studentId;
    private Integer developerCourseId;
    private Integer classesBought;
}
