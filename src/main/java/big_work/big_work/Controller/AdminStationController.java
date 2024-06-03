package big_work.big_work.Controller;

import big_work.big_work.Pojo.Department;
import big_work.big_work.Pojo.Result;
import big_work.big_work.Pojo.station;
import big_work.big_work.Service.AdminStationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j //日志注释
@CrossOrigin(origins = "http://localhost:5057") // 允许指定域名访问
public class AdminStationController {
    @Autowired
    private AdminStationService adminStationService;
    @GetMapping("/admin/station")
    public Result getAllStation(){
        return Result.success(adminStationService.getAllStation());
    }
    @PostMapping("/admin/station")
    public Result addStation(@RequestBody station station){
        adminStationService.addStation(station);
        return Result.success();
    }
}
