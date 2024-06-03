package big_work.big_work.Controller;

import big_work.big_work.Pojo.Result;
import big_work.big_work.Pojo.seat;
import big_work.big_work.Service.SearchInformationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j //日志注释
@CrossOrigin(origins = "http://localhost:5057") // 允许指定域名访问
public class SearchInformation {

    @Autowired
    private SearchInformationService searchInformationService;
    @GetMapping("/train-info")
    public Result Search( @RequestParam String departure,
                          @RequestParam String destination,
                          @RequestParam String date){
        return Result.success(searchInformationService.Search(departure,destination,date));
    }

    @GetMapping("/available-seats")
    public Result getAvailableSeats(@RequestParam Integer trainId) {
        // 根据 trainId 查询可用座位
        List<seat> availableSeats = searchInformationService.getAvailableSeats(trainId);
        return Result.success(availableSeats);
    }
    
}
