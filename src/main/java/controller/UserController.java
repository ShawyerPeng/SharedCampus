package controller;

import filter.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import po.RestResult;
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
    public RestResult register(@RequestBody User user) {
        String userName = user.getUserName();
        String userPass = user.getUserPass();

        RestResult result = new RestResult();
        Map<String, Object> data = new HashMap<>();

        if (userName == null || userPass == null) {
            result.setStatusCode(400);
            result.setMessage("未输入用户名或密码");
            return result;
        }

        int rowCount;
        int id;
        try {
            userService.insertUser(user);
            id = user.getUserId();
            rowCount = userService.selectRowCount();
        } catch (DuplicateKeyException e) {
            result.setStatusCode(400);
            result.setMessage("用户名已存在");
            return result;
        }
        if (rowCount != 0) {
            data.put("id", id);
            result.setData(data);
            result.setStatusCode(201);
            result.setMessage("注册成功");
            return result;
        }
        return result;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public RestResult login(@RequestBody User user) {
        String userName = user.getUserName();
        String userPass = user.getUserPass();

        RestResult result = new RestResult();
        Map<String, Object> data = new HashMap<>();

        if (userName == null || userPass == null) {
            result.setData(data);
            result.setStatusCode(400);
            result.setMessage("未输入用户名或密码");
            return result;
        }

        boolean exists = userService.isExistsUserName(userName);
        if (!exists) {
            result.setData(data);
            result.setStatusCode(400);
            result.setMessage("不存在此用户");
            return result;
        }

        boolean success = userService.isPassCorrect(userName, userPass);
        if (!success) {
            result.setData(data);
            result.setStatusCode(400);
            result.setMessage("密码错误");
            return result;
        } else {
            String token = JwtUtil.generToken("Shawyer", null, null);
            data.put("token", token);
            result.setData(data);
            result.setStatusCode(200);
            result.setMessage("登陆成功");
            return result;
        }
    }

    // http://localhost:8080/user/check?userName=admin
    @RequestMapping("/check")
    @ResponseBody
    public RestResult isExistsUserName(@RequestBody User user) {
        RestResult result = new RestResult();
        Map<String, Object> data = new HashMap<>();

        String userName = user.getUserName();
        boolean exists = userService.isExistsUserName(userName);
        if (exists) {
            data.put("isExists", true);
            result.setData(data);
            result.setStatusCode(200);
            result.setMessage("查询成功，存在此用户");
            return result;
        } else {
            data.put("isExists", false);
            result.setData(data);
            result.setStatusCode(200);
            result.setMessage("查询成功，不存在此用户");
            return result;
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public RestResult delete(@RequestBody User user) {
        RestResult result = new RestResult();
        Map<String, Object> data = new HashMap<>();

        String userName = user.getUserName();
        String userPass = user.getUserPass();
        int success = userService.deleteUser(userName, userPass);
        if (success == 1) {
            result.setData(data);
            result.setStatusCode(204);
            result.setMessage("删除成功");
            return result;
        } else {
            result.setData(data);
            result.setStatusCode(400);
            result.setMessage("删除失败");
            return result;
        }

    }

    @RequestMapping(value = "/changePass", method = RequestMethod.POST)
    @ResponseBody
    public RestResult changePass(@RequestBody User user) {
        RestResult result = new RestResult();
        Map<String, Object> data = new HashMap<>();

        String userName = user.getUserName();
        String newPass = user.getNewPass();
        int success = userService.changePass(userName, newPass);

        if (success == 1) {
            result.setData(data);
            result.setStatusCode(201);
            result.setMessage("密码修改成功");
            return result;
        } else {
            result.setData(data);
            result.setStatusCode(400);
            result.setMessage("密码修改失败");
            return result;
        }
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public RestResult edit(@RequestBody User user) {
        RestResult result = new RestResult();
        Map<String, Object> data = new HashMap<>();

        String userName = user.getUserName();
        String realname = user.getRealname();
        int gender = user.getGender();
        String phone = user.getPhone();
        String email = user.getEmail();
        String alipay = user.getAlipay();
        String iconimg = user.getIconimg();
        String info = user.getInfo();
        int success = userService.updateUser(userName, realname, gender, phone, email, alipay, iconimg, info);

        if (success == 1) {
            result.setData(data);
            result.setStatusCode(201);
            result.setMessage("用户信息修改成功");
            return result;
        } else {
            result.setData(data);
            result.setStatusCode(400);
            result.setMessage("用户信息修改失败");
            return result;
        }
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

    // http://localhost:8080/user/info?userName=admin
    @RequestMapping("/info")
    @ResponseBody
    public RestResult info(@RequestBody User user) {
        RestResult result = new RestResult();
        Map<String, Object> data = new HashMap<>();

        String userName = user.getUserName();
        User getUser = userService.getUserByUserName(userName);

        if (getUser != null) {
            data.put("user", getUser);
            result.setData(data);
            result.setStatusCode(201);
            result.setMessage("用户信息获取成功");
            return result;
        } else {
            result.setData(data);
            result.setStatusCode(400);
            result.setMessage("用户信息获取失败");
            return result;
        }
    }
}
