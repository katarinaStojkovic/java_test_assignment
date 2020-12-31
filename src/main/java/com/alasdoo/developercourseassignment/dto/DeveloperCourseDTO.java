package com.alasdoo.developercourseassignment.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
public class DeveloperCourseDTO implements Serializable {

    private Integer id;
    private String developerCourseName;
    private Integer costPerClass;
    private Integer classesPerWeek;

}
