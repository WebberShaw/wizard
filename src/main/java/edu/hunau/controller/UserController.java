package edu.hunau.controller;

import edu.hunau.model.User;
import edu.hunau.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/get")
    public Result getLogin(HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        user.setPassword(null);
        if(user!=null){
            return new Result(Code.OK,user);
        }
        return new Result(Code.ERR,false,"您未登录");
    }

    @PostMapping("/login")
    public Result login(@RequestBody User user, HttpServletRequest request){
        System.out.println(user);
        User login = userService.login(user);



        if(login!=null){
            HttpSession session = request.getSession();
            System.out.println(session);
            session.setAttribute("user",login);
            return new Result(Code.OK,user);
        }else {
            return new Result(Code.ERR,null,"登录失败，请检查用户名或密码");
        }
    }

    @GetMapping("/{tel}")
    public Result checkTel(@PathVariable String tel){
        User user = new User();
        user.setTel(tel);
        if(tel.length()!=11||tel.charAt(0)!='1'){

            return new Result(Code.ERR,false,"电话号码格式有误");
        }else if(!userService.checkTele(user)){
            return new Result(Code.ERR,false,"该电话号码已经注册，换一个吧！");

        }

        return new Result(Code.OK,true,"欧耶，该电话号码可以注册");

    }

    @PostMapping
    public Result register(@RequestBody User user){
        String tel = user.getTel();
        String password = user.getPassword();

        if(tel.length()!=11||tel.charAt(0)!='1'){

            return new Result(Code.ERR,false,"电话号码格式有误");
        }else if(!userService.checkTele(user)){
            return new Result(Code.ERR,false,"该电话号码已经注册，换一个吧！");

        }
        if(password.length()<8){
            return new Result(Code.ERR,false,"密码不足8位，就这？");
        }
        try {
            userService.addUser(user);
        }catch (Exception e){
            return new Result(Code.ERR,false,"注册失败，请联系管理员");
        }

        return new Result(Code.OK,true,"注册成功，3秒后跳转至登录页面");



    }

    @GetMapping("/check")
    public Result checkLogin(HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if(user!=null){
            return new Result(Code.IS_LOGIN,user);
        }

        return new Result(Code.NOT_LOGIN,null);

    }



}
