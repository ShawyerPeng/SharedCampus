package controller;

import filter.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public Map register(@RequestParam("userName") String userName, @RequestParam("userPass") String userPass) {
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> data = new HashMap<>();
        if (userName == null || userPass == null) {
            map.put("data", data);
            map.put("statusCode", "400");
            map.put("message", "未输入用户名或密码");
            return map;
        }

        int rowCount;
        try {
            userService.insertUser(userName, userPass);
            rowCount = userService.selectRowCount();
        } catch (DuplicateKeyException e) {
            map.put("data", null);
            map.put("statusCode", "400");
            map.put("message", "用户名已存在");
            return map;
        }
        if (rowCount != 0) {
            map.put("data", null);
            map.put("statusCode", "200");
            map.put("message", "注册成功");
        }
        return map;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Map login(@RequestParam("userName") String userName, @RequestParam("userPass") String userPass) {
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> data = new HashMap<>();
        if (userName == null || userPass == null) {
            map.put("data", data);
            map.put("statusCode", "400");
            map.put("message", "未输入用户名或密码");
            return map;
        }

        boolean exists = userService.isExistsUserName(userName);
        if (!exists) {
            map.put("data", null);
            map.put("statusCode", "400");
            map.put("message", "不存在此用户");
            return map;
        }

        boolean success = userService.isPassCorrect(userName, userPass);
        if (!success) {
            map.put("data", null);
            map.put("statusCode", "400");
            map.put("message", "密码错误");
            return map;
        } else {
            String token = JwtUtil.generToken("Shawyer", null, null);
            data.put("token", token);
            map.put("data", data);
            map.put("statusCode", "200");
            map.put("message", "登陆成功");
            return map;
        }
    }

    // http://localhost:8080/user/check?userName=admin
    @RequestMapping("/check")
    @ResponseBody
    public Map isExistsUserName(@RequestParam("userName") String userName) {
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> data = new HashMap<>();
        boolean exists = userService.isExistsUserName(userName);
        if (exists) {
            map.put("data", data);
            map.put("statusCode", "200");
            map.put("message", "该用户存在");
            return map;
        } else {
            map.put("data", data);
            map.put("statusCode", "400");
            map.put("message", "不存在此用户");
            return map;
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public void delete(@RequestParam("userName") String userName, @RequestParam("userPass") String userPass) {
        userService.insertUser(userName, userPass);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public void edit(@RequestParam("userName") String userName, @RequestParam("userPass") String userPass) {
        userService.insertUser(userName, userPass);
    }

    // http://localhost:8080/user/getUser?userName=admin
    @RequestMapping("/getUser")
    @ResponseBody
    public User getUser(@RequestParam("userName") String userName) {
        return userService.getUserByUserName(userName);
    }

}
