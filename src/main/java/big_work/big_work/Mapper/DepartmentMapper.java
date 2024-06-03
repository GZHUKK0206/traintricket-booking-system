package big_work.big_work.Mapper;

import big_work.big_work.Pojo.Department;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper
public interface DepartmentMapper {

    @Select("select * from departments")
    List<Department> getAllDepartment();

    @Select("select * from departments where DepartmentID=#{id};")
    Department getDepartmentById(Integer id);




    @Delete("DELETE FROM departments WHERE DepartmentID = #{id}")
    void deleteDepartment(Integer id);
    @Delete("DELETE FROM employees WHERE DepartmentID = #{id}")
    void deleteEmployeesByDepartmentId(Integer id);

    @Transactional
    default void deleteDepartmentById(Integer id) {
        // 首先，删除部门的员工
        deleteEmployeesByDepartmentId(id);
        // 然后，删除部门本身
        deleteDepartment(id);
    }

    @Insert("INSERT INTO departments (DepartmentName, EmployeeCount) VALUES (#{DepartmentName}, #{EmployeeCount})")
    void addDepartment(Department department);
}
