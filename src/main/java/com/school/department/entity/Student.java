package com.school.department.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
// creates the student table.
@Table(name = "student", uniqueConstraints = @UniqueConstraint(name = "emailId_Unique", columnNames = "email_address"))
public class Student {
 @Id
 @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1)
 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")

 private Long studentId;
 private String firstName;
 private String lastName;

 @Column(name = "email_address", nullable = false) // constraint for the emailId attribute.
 private String emailId;

 @Embedded
 private Guardian guardian;

}