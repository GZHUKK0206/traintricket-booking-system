package big_work.big_work.Mapper;

import big_work.big_work.Pojo.Employee;
import org.apache.ibatis.annotations.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper
public interface EmployeeMapper {


    @Insert("INSERT INTO employees (name, departmentId) VALUES (#{name}, #{departmentId})")
    void addEmployee(Employee employee);

    @Select("select a.EmployeeID,a.Name,b.DepartmentName from employees as a inner join departments as b where a.departmentId=b.DepartmentID ")
    List<Employee> getAllEmployee();

    @Delete("DELETE FROM employees WHERE EmployeeID = #{id}")
    void deleteEmployee(Integer id);

    @Update("UPDATE departments SET employeeCount = employeeCount +1 WHERE DepartmentID = #{departmentId}")
    void addDepartmentNumberOfPeople(Employee employee);

    @Update("UPDATE departments SET employeeCount = employeeCount - 1 WHERE DepartmentID = (SELECT DepartmentID FROM employees WHERE EmployeeID = #{id})")
    void deleteDepartmentNumberOfPeople(Integer id);


}
