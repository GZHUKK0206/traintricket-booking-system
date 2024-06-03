package big_work.big_work.Service.impl;

import big_work.big_work.Mapper.DepartmentMapper;
import big_work.big_work.Pojo.Department;
import big_work.big_work.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public List<Department> getAllDepartments() {
        return departmentMapper.getAllDepartment();
    }

    @Override
    public Department getDepartmentById(Integer id) {
        return departmentMapper.getDepartmentById(id);
    }

    @Override
    public void deleteDepartmentById(Integer id) {
        departmentMapper.deleteDepartmentById(id);
    }

    @Override
    public void addDepartment(Department department) {
        departmentMapper.addDepartment(department);
    }
}
