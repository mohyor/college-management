package com.school.department.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.school.department.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

 List<Student> findByFirstName(String firstName);

 List<Student> findByFirstNameContaining(String name);

 List<Student> findByLastNameNotNull();

 List<Student> findByGuardianName(String guardianName);

 Student findByFirstNameAndLastName(String firstName, String lastName);

 // JPQL Query
 @Query("SELECT s FROM student s WHERE S.emailId = ?1")
 Student getStudentByEmailAddress(String emailId);

 @Query("SELECT s.firstName FROM student s WHERE s.emailId = ?1")
 String getStudentFirstNameByEmailAddress(String emailId);

 // Native Query
 @Query(value = "SELECT * FROM student s WHERE s.email_address = ?1", nativeQuery = true)
 Student getStudentByEmailAddressNative(String emailId);

 // Native Query Parameters
 @Query(value = "SELECT * FROM student s WHERE s.email_address = :emailId", nativeQuery = true)
 Student getStudentByEmailAddressNativeNamedParam(@Param("emailId") String emailId);

 @Modifying
 @Transactional
 @Query(value = "UPDATE student SET first_name = ?1 WHERE email_address = ?2", nativeQuery = true)
 int updateStudentNameByEmailId(String firstName, String emailId);

}
