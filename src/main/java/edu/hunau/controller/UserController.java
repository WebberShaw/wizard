package edu.hunau.controller;

import edu.hunau.model.User;
import edu.hunau.service.UserService;
import edu.hunau.utils.SenderUtil;
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
            login.setPassword(null);
            return new Result(Code.OK,login);
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
    public Result register(@RequestBody User user,HttpServletRequest request){
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
        HttpSession session = request.getSession();
        Object verifyCodeTimeObj = session.getAttribute("verifyCodeTime");
        long verifyCodeTime =0;
        if(verifyCodeTimeObj!=null){
            verifyCodeTime=(long)verifyCodeTimeObj;
        }
        Object verifyCodeObj = session.getAttribute("verifyCode");
        int verifyCode =0;
        if(verifyCodeObj!=null){
            verifyCode=(int)verifyCodeObj;
        }else {
            return new Result(Code.ERR,false,"请先完成手机号码验证");
        }
        long gapTime=(System.currentTimeMillis()-verifyCodeTime)/1000;
        if(verifyCode==0){
            return new Result(Code.ERR,false,"手机号码验证失败");
        } else if (user.getVerifyCode()!=verifyCode) {
            return new Result(Code.ERR,false,"验证码错误");
        } else if (gapTime>180) {
            System.out.println(gapTime);
            return new Result(Code.ERR,false,"验证码已过期，请重试");
        }

        try {
            userService.addUser(user);
        }catch (Exception e){
            return new Result(Code.ERR,false,"注册失败，请联系管理员");
        }
        user.setPassword(null);
        return new Result(Code.OK,user,"注册成功，3秒后跳转至资料完善页面");



    }

    @GetMapping("/verifycode/{tel}")
    public Result sendRegisterVerifyCode(@PathVariable String tel, HttpServletRequest request){
        User user= new User();
        user.setTel(tel);

        Boolean isUnique = userService.checkTele(user);
        if(!isUnique){
            return new Result(Code.ERR,null,"该号码已被注册");
        }

        try {
            HttpSession session = request.getSession();
            if(session.getAttribute("verifyCode")!=null){
                Object verifyCodeTimeObj = session.getAttribute("verifyCodeTime");
                long verifyCodeTime =0;
                if(verifyCodeTimeObj!=null){
                    verifyCodeTime = (long)verifyCodeTimeObj;
                }else {
                    return new Result(Code.ERR,null,"上次发送时间未记录，请联系管理员");
                }
                long gapTime=(System.currentTimeMillis()-verifyCodeTime)/1000;
                if(gapTime<60){
                    return new Result(Code.ERR,null,"验证码已发送,请耐心等待，或在"+(60-gapTime)+"秒后重试");
                }
            }
            int verifyCode = userService.sendMessageCode(tel, SenderUtil.REGISTER_TEXT_MESSAGE_CODE);
            if(verifyCode!=0) {
                session.setAttribute("verifyCode", verifyCode);
            }else {
                return new Result(Code.ERR,null,"发送失败，请联系管理员");
            }
            session.setAttribute("verifyCodeTime",System.currentTimeMillis());


            return new Result(Code.OK,null,"发送成功，请注意查收，180秒内有效");
        }catch (Exception e){
            System.out.println(e);
            return new Result(Code.ERR,null,"发送失败，请联系管理员");
        }
    }

    @Deprecated//该方法已经过时，建议采用getLogin的/get路径进行请求
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
