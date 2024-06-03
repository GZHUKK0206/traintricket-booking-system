package big_work.big_work.Service;

import big_work.big_work.Pojo.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> getAllDepartments();

    Department getDepartmentById(Integer id);

    void deleteDepartmentById(Integer id);

    void addDepartment(Department department);
}
