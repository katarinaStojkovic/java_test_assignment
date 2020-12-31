package com.alasdoo.developercourseassignment.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class TeacherDTO implements Serializable {
    private Integer id;
    private String teacherName;
    private String teacherSurname;
    private String teacherEmail;
}
