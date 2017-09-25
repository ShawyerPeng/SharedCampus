package controller;

import filter.JwtUtil;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.impl.crypto.MacProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import po.User;
import service.UserService;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/insert")
    @ResponseBody
    public String insert(@RequestParam("userName") String userName, @RequestParam("userPass") String userPass) {
        userService.insertUser(userName, userPass);
        return "true";
    }

    @RequestMapping("/check")
    @ResponseBody
    public boolean isExistsUserName(@RequestParam("userName") String userName) {
        return userService.isExistsUserName(userName);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public void delete(@RequestParam("userName") String userName, @RequestParam("userPass") String userPass) {
        userService.insertUser(userName, userPass);
    }

    @RequestMapping("/edit")
    @ResponseBody
    public void edit(@RequestParam("userName") String userName, @RequestParam("userPass") String userPass) {
        userService.insertUser(userName, userPass);
    }

    @RequestMapping("/getUser")
    @ResponseBody
    public User getUser(@RequestParam("userName") String userName) {
        return userService.getUserByUserName(userName);
    }

    @RequestMapping("/login")
    @ResponseBody
    public Map login(@RequestParam("userName") String userName, @RequestParam("userPass") String userPass) {
        Map<String, Object> map = new HashMap<>();
        boolean success = userService.isPassCorrect(userName, userPass);
        if (userName == null || userPass == null) {
            map.put("data", null);
            map.put("statusCode", "400");
            map.put("message", "未输入用户名或密码");
        }
        if (!success) {
            map.put("data", null);
            map.put("statusCode", "400");
            map.put("message", "密码错误");
        } else {
            String token = JwtUtil.generToken("Shawyer",null,null);
            map.put("data", token);
            map.put("statusCode", "200");
            map.put("message", "登陆成功");
        }
        return map;
    }
}
