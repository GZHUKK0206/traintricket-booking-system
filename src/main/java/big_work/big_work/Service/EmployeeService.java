package big_work.big_work.Service;

import big_work.big_work.Pojo.Employee;

import java.util.List;

public interface EmployeeService {
    void addEmployee(Employee employee);

    List<Employee> getAllEmployees();

    void deleteEmployeeById(Integer id);
}
