package big_work.big_work.Controller;

import big_work.big_work.Pojo.Result;
import big_work.big_work.Pojo.Train;
import big_work.big_work.Service.AdminTrainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j //日志注释
@CrossOrigin(origins = "http://localhost:5057") // 允许指定域名访问
public class AdminTrainController {
    @Autowired
    private AdminTrainService adminTrainService;
    @GetMapping("/admin/train")
    public Result getAllTrain(){
        return Result.success(adminTrainService.getAllTrain());
    }

    @DeleteMapping("/admin/train/{id}")
    public Result deleteDepartmentById(@PathVariable Integer id){
        adminTrainService.deleteTrainById(id);
        return  Result.success();
    }

    @PostMapping("/admin/train")
    public Result addTrain(@RequestBody Train train){
        adminTrainService.addTrain(train);
        return Result.success();
    }
}
