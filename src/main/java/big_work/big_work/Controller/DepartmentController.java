package big_work.big_work.Controller;

import big_work.big_work.Pojo.Department;

import big_work.big_work.Pojo.Result;
import big_work.big_work.Service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j //日志注释
@CrossOrigin(origins = "http://localhost:5057") // 允许指定域名访问
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/admin/departments")
    public Result getAllDepartments() {
        return Result.success(departmentService.getAllDepartments());
    }

    @GetMapping("/admin/departments/{id}")
    public Result getDepartmentById(@PathVariable Integer id){
        return Result.success(departmentService.getDepartmentById(id));
    }

    @DeleteMapping("/admin/departments/{id}")
    public Result deleteDepartmentById(@PathVariable Integer id){
        departmentService.deleteDepartmentById(id);
        return  Result.success();
    }
    @PostMapping("/admin/departments")
    public Result addDepartment(@RequestBody Department department){
        departmentService.addDepartment(department);
        return Result.success();
    }

}
