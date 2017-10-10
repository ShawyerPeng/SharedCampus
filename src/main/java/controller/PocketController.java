package controller;

import dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import po.RestResult;
import po.User;
import service.PocketService;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/pocket")
public class PocketController {
    @Autowired
    private PocketService pocketService;

    @RequestMapping(value = "/balance", method = RequestMethod.POST)
    @ResponseBody
    public RestResult balance(@RequestBody Map<String, String> map) {
        RestResult result = new RestResult();
        Map<String, Object> data = new HashMap<>();

        Integer userId = Integer.parseInt(map.get("userId"));

        User user = pocketService.getUserByPrimaryKey(userId);

        if (user != null) {
            Double balance = user.getBalance();
            data.put("balance", balance);
            result.setData(data);
            result.setStatusCode(201);
            result.setMessage("钱包余额查询成功");
            return result;
        } else {
            result.setData(data);
            result.setStatusCode(400);
            result.setMessage("钱包余额查询失败");
            return result;
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public RestResult update(@RequestBody Map<String, String> map) {
        RestResult result = new RestResult();
        Map<String, Object> data = new HashMap<>();

        Integer userId = Integer.parseInt(map.get("userId"));
        Double amount = Double.parseDouble(map.get("amount"));

        Double oldBalance = pocketService.getUserByPrimaryKey(userId).getBalance();
        if (oldBalance - amount < 0) {
            result.setData(data);
            result.setStatusCode(400);
            result.setMessage("支付失败，钱包余额不足");
            return result;
        }

        User user = new User();
        user.setUserId(userId);
        int success = pocketService.updatePocket(user, amount);

        if (success == 1) {
            result.setData(data);
            result.setStatusCode(201);
            result.setMessage("钱包余额更新成功");
            return result;
        } else {
            result.setData(data);
            result.setStatusCode(400);
            result.setMessage("钱包余额更新失败");
            return result;
        }
    }
}
