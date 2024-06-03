package big_work.big_work.Service.impl;

import big_work.big_work.Mapper.EmployeeMapper;
import big_work.big_work.Pojo.Employee;
import big_work.big_work.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    @Transactional
    public void addEmployee(Employee employee) {
        //System.out.println(employee.getEmployeeId());
        employeeMapper.addDepartmentNumberOfPeople(employee);
        employeeMapper.addEmployee(employee);

    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeMapper.getAllEmployee();
    }

    @Override
    @Transactional
    public void deleteEmployeeById(Integer id) {
        // 首先，删除员工
        employeeMapper.deleteDepartmentNumberOfPeople(id);
        employeeMapper.deleteEmployee(id);
        // 然后，更新部门的员工数量

    }


}
