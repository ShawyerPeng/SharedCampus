package controller;

import filter.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import po.User;
import service.UserService;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public Map register(@RequestBody User user) {
        String userName = user.getUserName();
        String userPass = user.getUserPass();
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
    @RequestMapping(value = "/register2", method = RequestMethod.POST)
    @ResponseBody
    public Map register2(@RequestParam("userName") String userName, @RequestParam("userPass") String userPass) {
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
    public Map login(@RequestBody User user) {
        String userName = user.getUserName();
        String userPass = user.getUserPass();
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
    @RequestMapping(value = "/login2", method = RequestMethod.POST)
    @ResponseBody
    public Map login2(@RequestParam("userName") String userName, @RequestParam("userPass") String userPass) {
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

    @RequestMapping("/check")
    @ResponseBody
    public Map isExistsUserName(@RequestBody User user) {
        String userName = user.getUserName();
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
    // http://localhost:8080/user/check?userName=admin
    @RequestMapping("/check2")
    @ResponseBody
    public Map isExistsUserName2(@RequestParam("userName") String userName) {
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
    public void delete(@RequestBody User user) {
        String userName = user.getUserName();
        String userPass = user.getUserPass();
        userService.deleteUser(userName, userPass);
    }
    @RequestMapping(value = "/delete2", method = RequestMethod.POST)
    @ResponseBody
    public void delete2(@RequestParam("userName") String userName, @RequestParam("userPass") String userPass) {
        userService.deleteUser(userName, userPass);
    }

    @RequestMapping(value = "/changePass", method = RequestMethod.POST)
    @ResponseBody
    public void changePass(@RequestBody User user) {
        String userName = user.getUserName();
        String newPass = user.getNewPass();
        userService.changePass(userName, newPass);
    }
    @RequestMapping(value = "/changePass2", method = RequestMethod.POST)
    @ResponseBody
    public void changePass2(@RequestParam("userName") String userName, @RequestParam("newPass") String newPass) {
        userService.changePass(userName, newPass);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public void edit(@RequestBody User user) {
        String userName = user.getUserName();
        String realname = user.getRealname();
        int gender = user.getGender();
        String phone = user.getPhone();
        String email = user.getEmail();
        String alipay = user.getAlipay();
        String iconimg = user.getIconimg();
        String info = user.getInfo();
        userService.updateUser(userName, realname, gender, phone, email, alipay, iconimg, info);
    }
    @RequestMapping(value = "/edit1", method = RequestMethod.POST)
    @ResponseBody
    public void edit1(@RequestBody User user) {
        String userName = user.getUserName();
        String userPass = null;
        String realname = user.getRealname();
        int gender = user.getGender();
        String phone = user.getPhone();
        String email = user.getEmail();
        String alipay = user.getAlipay();
        String iconimg = user.getIconimg();
        String info = user.getInfo();
        Date createdTime = null;
        Date lastLogin = null;
        Integer honesty = null;
        Double balance = null;
        userService.updateUser1(userName, userPass, realname, gender, phone, email, alipay, iconimg, info, createdTime, lastLogin, honesty, balance);
    }
    @RequestMapping(value = "/edit2", method = RequestMethod.POST)
    @ResponseBody
    public void edit2(@RequestParam("userName") String userName, @RequestParam("userPass") String userPass,
                     @RequestParam("realname") String realname, @RequestParam("gender") Integer gender,
                     @RequestParam("phone") String phone, @RequestParam("email") String email,
                     @RequestParam("alipay") String alipay, @RequestParam("iconimg") String iconimg,
                     @RequestParam("info") String info, @RequestParam("createdTime") Date createdTime,
                     @RequestParam("lastLogin") Date lastLogin, @RequestParam("honesty") Integer honesty,
                     @RequestParam("balance") Double balance) {
        userService.updateUser1(userName, userPass, realname, gender, phone, email, alipay, iconimg, info, createdTime, lastLogin, honesty, balance);
    }

    @RequestMapping("/getUser")
    @ResponseBody
    public User getUser(@RequestBody User user) {
        String userName = user.getUserName();
        return userService.getUserByUserName(userName);
    }
    // http://localhost:8080/user/getUser?userName=admin
    @RequestMapping("/getUser2")
    @ResponseBody
    public User getUser2(@RequestParam("userName") String userName) {
        return userService.getUserByUserName(userName);
    }

    @RequestMapping("/info")
    @ResponseBody
    public User info(@RequestBody User user) {
        String userName = user.getUserName();
        return userService.getUserByUserName(userName);
    }
}
