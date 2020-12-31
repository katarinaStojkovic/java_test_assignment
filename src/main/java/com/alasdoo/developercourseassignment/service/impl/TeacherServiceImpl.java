package com.alasdoo.developercourseassignment.service.impl;

import com.alasdoo.developercourseassignment.dto.TeacherDTO;
import com.alasdoo.developercourseassignment.entity.Teacher;
import com.alasdoo.developercourseassignment.mapper.TeacherMapper;
import com.alasdoo.developercourseassignment.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl {

    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;

    public TeacherDTO findOne(Integer id) {
        Optional<Teacher> teacher = teacherRepository.findById(id);
        if (!teacher.isPresent()) {
            throw new IllegalArgumentException
                    ("Teacher with the following id = " + id + " is not found.");
        }
        return teacherMapper.transformToDTO(teacher.get());
    }

    public List<TeacherDTO> findAll() {
        return teacherRepository.findAll().stream().map(teacherMapper::transformToDTO).collect(Collectors.toList());
    }

    public TeacherDTO save(TeacherDTO teacherDTO) {
        Teacher teacher = teacherMapper.transformToEntity(teacherDTO);
        return teacherMapper.transformToDTO(teacherRepository.save(teacher));
    }

    public void remove(Integer id) throws IllegalArgumentException {
        Optional<Teacher> teacher = teacherRepository.findById(id);
        if (!teacher.isPresent()) {
            throw new IllegalArgumentException
                    ("Teacher with the following id = " + id + " is not found.");
        }
        teacherRepository.deleteById(id);
    }

    public TeacherDTO update(Integer id, TeacherDTO teacherDTO) {
        Optional<Teacher> oldTeacher = teacherRepository.findById(id);
        if (!oldTeacher.isPresent()) {
            throw new IllegalArgumentException
                    ("Teacher with the following id = " + id + " is not found.");
        }
        oldTeacher.get().setTeacherName(teacherDTO.getTeacherName());
        oldTeacher.get().setTeacherSurname(teacherDTO.getTeacherSurname());
        oldTeacher.get().setTeacherEmail(teacherDTO.getTeacherEmail());
        teacherRepository.save(oldTeacher.get());
        return teacherMapper.transformToDTO(oldTeacher.get());
    }

    public TeacherDTO findByTeacherNameAndTeacherSurname(String name, String surname) {
        Optional<Teacher> teacher = teacherRepository.findByTeacherNameAndTeacherSurname(name, surname);
        if (!teacher.isPresent()) {
            throw new IllegalArgumentException
                    ("Teacher with the following  name = " + name + "and surname =" + surname + "is not found.");
        }
        return teacherMapper.transformToDTO(teacher.get());
    }

    public TeacherDTO findByTeacherEmail(String email) {
        Optional<Teacher> teacher = teacherRepository.findByTeacherEmail(email);
        if (!teacher.isPresent()) {
            throw new IllegalArgumentException
                    ("Teacher with the following email = " + email + "is not found.");
        }
        return teacherMapper.transformToDTO(teacher.get());
    }
}
