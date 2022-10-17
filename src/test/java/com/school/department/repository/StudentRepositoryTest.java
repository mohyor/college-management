package com.school.department.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.school.department.entity.Student;

@SpringBootTest
class StudentRepositoryTest {

  @Autowired
  private StudentRepository studentRepository;

  @Test
  public void saveStudent() {
    Student student = Student.builder()
        .emailId("shaddir@gmail.com")
        .firstName("Shabbir")
        .lastName("David")
        .build();

    studentRepository.save(student);
  }

  @Test
  public void saveStudentWithGuardian() {
    Guardian guardian = Guardian.builder()
        .email("test@gmail.com")
        .name("test")
        .mobile("123456789")
        .build();

    Student student = Student.builder()
        .firstName("momo")
        .emailId("null@null.com")
        .lastName("test")
        .guardian(null)
        .build();

    studentRepository.save(student);
  }

  @Test
  public void printAllStudents() {
    List<Student> studentList = studentRepository.findAll();
    System.out.println("List of students: " + studentList);
  }

 @Test
 public void printStudentsByFirstName() {
  List<Student> students = studentRepository.findByFirstName(firstName: "momo");
  System.out.println("List of students: " + students);
 }

 @Test
 public void printStudentByFirstNameContaining() {
  List<Student> students = studentRepository.findByFirstNameContaining(name: "mo");
  System.out.println("students: " + students);
 }

  @Test
  public void printStudentBasedOnGuardianName() {
    List<Student> students = studentRepository.findByGuardianName("momo");
    System.out.println("students: " + students);
  }

  @Test
  public void printGetStudentFirstNameByEmailAddress() {
    String firstName = studentRepository.getStudentFirstNameByEmailAddress("test@test.com");
    System.out.println("firstName: " + firstName);
  }

  @Test
  public void printGetStudentByEmailAddressNative() {
    Student student = studentRepository.getStudentByEmailAddressNative("test@test.com");
    System.out.println("student: " + student);
  }

  @Test
  public void printGetStudentByEmailAddressNativeNamedParam() {
    Student student = studentRepository.getStudentByEmailAddressNativeNamedParam("test@test.com");
  }

  @Test
  public void updateStudentNameByEmailIdTest() {
    studentRepository.updateStudentNameByEmailId("momo", "test@test.com");
  }

}
