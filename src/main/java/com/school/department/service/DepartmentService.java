package com.school.department.service;

import java.util.List;

import com.school.department.entity.Department;
import com.school.department.error.DepartmentNotFoundException;

public interface DepartmentService {
 public Department saveDepartment(Department department);

 public List<Department> fetchDepartmentList();

 public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

 public void deleteDepartmentById(Long departmentId);

 public Department updateDepartment(Long departmentId, Department department);

 Department fetchDepartmentByName(String departmentName);

}
