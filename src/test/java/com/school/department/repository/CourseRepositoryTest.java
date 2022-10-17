package com.school.department.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.school.department.entity.Course;
import com.school.department.entity.Student;
import com.school.department.entity.Teacher;

@SpringBootTest
class CourseRepositoryTest {

 @Autowired
 private CourseRepository courseRepository;

 @Test
 public void printCourses() {
  List<Course> courses = courseRepository.findAll();
  System.out.println("Courses: " + courses);
 }

 @Test
 public void saveCourseWithTeacher() {
  Teacher teacher = Teacher.builder()
    .firstName("momo")
    .lastName("momo")
    .build();

  Course course = Course
    .builder()
    .title("momo")
    .credit(7)
    .teacher(teacher)
    .build();

  courseRepository.save(course);
 }

 @Test
 public void findAllPagination() {
  Pageable firstPageWithThreeRecords = PageRequest.of(0, 3);
  Pageable secondPageWithTwoRecords = PageRequest.of(1, 2);

  List<Course> courses = courseRepository.findAll(secondPageWithTwoRecords).getContent();

  long totalElements = courseRepository.findAll(secondPageWithTwoRecords).getTotalElements();
  long totalPages = courseRepository.findAll(secondPageWithTwoRecords).getTotalPages();

  System.out.println("totalPages = " + totalPages);
  System.out.println("totalElements = " + totalElements);
  System.out.println("courses = " + courses);
 }

 @Test
 public void findAllSorting() {
  Pageable sortByTitle = PageRequest.of(0, 2, Sort.by("title"));
  Pageable sortByCreditDesc = PageRequest.of(0, 2, Sort.by("credit").descending());
  Pageable sortByTitleAndCreditDesc = PageRequest.of(0, 2, Sort.by("title").descending().and(Sort.by("credit")));

  List<Course> courses = courseRepository.findAll(sortByTitle).getContent();
  System.out.println("courses: " + courses);
 }

 @Test
 public void printfindByTitleContaining() {
  Pageable firstPageTenRecords = PageRequest.of(0, 10);
  List<Course> courses = courseRepository.findByTitleContaining("b", firstPageTenRecords).getContent();
  System.out.println("courses: " + courses);
 }

 @Test
 public void saveCourseWithStudentAndTeacher() {
  Teacher teacher = Teacher.builder()
    .firstName("momo")
    .lastName("momo")
    .build();

  Student student = Student.builder()
    .firstName("momo")
    .lastName("momo")
    .emailId("test@gmail.com")
    .build();

  Course course = Course.builder()
    .title("momo")
    .credit(10)
    .teacher(teacher)
    .build();

  course.addStudents(student);
  courseRepository.save(course);
 }
}
