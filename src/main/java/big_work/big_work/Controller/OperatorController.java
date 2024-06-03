package big_work.big_work.Controller;

import big_work.big_work.Pojo.Operator;
import big_work.big_work.Pojo.Result;
import big_work.big_work.Pojo.UpdateUserRequest;
import big_work.big_work.Service.OperatorService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



import static big_work.big_work.utils.Jwtutils.generateToken;


@RestController
@Slf4j //日志注释
@CrossOrigin(origins = "http://localhost:5057") // 允许指定域名访问
public class OperatorController {
    @Autowired
    private OperatorService operatorService;





    @PostMapping("/admin/login")
    public Result login(@RequestBody Operator operator) {
        Operator a = operatorService.login(operator);

        if (a != null) {
            // 生成 JWT 令牌
            String token = generateToken(a);

            // 返回登录成功和令牌给客户端
            return Result.success(token);
        } else {
            return Result.error("用户名或密码错误");
        }
    }

    @PostMapping("/admin/register")
    public Result register(@RequestBody Operator operator){
        operatorService.register(operator);
        return Result.success();
    }

    @PutMapping("/admin/exit")
    public Result exit(@RequestBody UpdateUserRequest request){
        String oldName = request.getOldName();
        String newName = request.getNewName();
        System.out.println(newName);
        operatorService.exit(newName,oldName);
        return Result.success();
    }

}
