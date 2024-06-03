package big_work.big_work.Controller;

import big_work.big_work.Pojo.Employee;
import big_work.big_work.Pojo.Result;
import big_work.big_work.Service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j //日志注释
@CrossOrigin(origins = "http://localhost:5057") // 允许指定域名访问
//@CrossOrigin(origins = "http://localhost:8081") // 允许指定域名访问
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // 添加员工信息
    @PostMapping("/admin/employees")
    public Result addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
        return Result.success();
    }

    // 查看员工列表
    @GetMapping("/admin/employees")
    public Result getAllEmployees() {
        return Result.success(employeeService.getAllEmployees());
    }


    @DeleteMapping("/admin/employees/{id}")
    public Result deleteEmployeeById(@PathVariable Integer id)
    {
        employeeService.deleteEmployeeById(id);
        return Result.success();
    }

    /*// 编辑员工信息
    @PutMapping("/employees/{employeeId}")
    public Employee updateEmployee(@PathVariable Long employeeId, @RequestBody Employee employee) {
        return employeeService.updateEmployee(employeeId, employee);
    }*/

   /* // 删除员工信息
    @DeleteMapping("/employees/{employeeId}")
    public void deleteEmployee(@PathVariable Long employeeId) {
        employeeService.deleteEmployee(employeeId);
    }*/



    /*// 查询员工信息
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable Long employeeId) {
        return employeeService.getEmployeeById(employeeId);
    }*/

}
