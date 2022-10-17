package com.school.department.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.school.department.entity.Course;
import com.school.department.entity.Teacher;

@SpringBootTest
class TeacherRepositoryTest {

 @Autowired
 private TeacherRepository teacherRepository;

 @Test
 public void saveTeacher() {

  Course courseDBA = Course.builder()
    .title("dba")
    .credit(6)
    .build();

  Course courseJava = Course.builder()
    .title("Java")
    .credit(6)
    .build();

  Teacher teacher = Teacher.builder()
    .firstName("momo")
    .lastName("momo")
    .build();

  teacherRepository.save(teacher);
 }
}