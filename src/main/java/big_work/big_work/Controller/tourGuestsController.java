package big_work.big_work.Controller;


import big_work.big_work.Pojo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import big_work.big_work.Service.tourGuestsService;

import java.util.List;


import static big_work.big_work.utils.Jwtutils.generateTokenGuest;

@RestController
@Slf4j //日志注释
@CrossOrigin(origins = "http://localhost:5057") // 允许指定域名访问
public class tourGuestsController {
    @Autowired
    private tourGuestsService tourGuestsService;

    @PostMapping("/tour/register")
    public Result tourRegister(@RequestBody Guest guest){
        tourGuestsService.tourRegister(guest);
        return Result.success();

    }
    @PostMapping("/tour/login")
    public Result login(@RequestBody Guest guest) {
        Guest a = tourGuestsService.login(guest);

        if (a != null) {
            // 生成 JWT 令牌
            String token = generateTokenGuest(a);

            // 返回登录成功和令牌给客户端
            return Result.success(token);
        } else {
            return Result.error("用户名或密码错误");
        }
    }

    @GetMapping("/tour/information/{username}")
    public Result tourInformation(@PathVariable String username) {
        Guest  guests=  tourGuestsService.tourInformation(username);
        List<Order> ordersList = tourGuestsService.getOrdersList(guests.getOrders());

        // 将处理后的订单数据设置到Guest对象中
        guests.setOrder(ordersList);
        return Result.success(guests);
    }


    @PostMapping("/tour/book-ticket")
    public Result bookticket(@RequestBody BookingRequest bookingRequest){
        System.out.println(bookingRequest); // 打印 GuestID 以确认其值是否正确
        tourGuestsService.bookticket(bookingRequest);
        return Result.success();
    }

}
