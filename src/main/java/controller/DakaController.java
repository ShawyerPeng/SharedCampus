package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import po.Daka;
import po.RestResult;
import po.User;
import service.DakaService;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/daka")
public class DakaController {
    @Autowired
    private DakaService dakaService;

    @RequestMapping("/insert")
    @ResponseBody
    public Map<String, Object> insert(@RequestBody Daka daka) {
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> data = new HashMap<>();
        int success = dakaService.insertDaka(daka);
        if (success == 1) {
            map.put("data", data);
            map.put("statusCode", "200");
            map.put("message", "新增大咖成功");
            return map;
        } else {
            map.put("data", data);
            map.put("statusCode", "400");
            map.put("message", "新增大咖失败");
            return map;
        }
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Map<String, Object> delete(@RequestBody Daka daka) {
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> data = new HashMap<>();
        Integer dakaId = daka.getDakaId();
        int success = dakaService.deleteDaka(dakaId);
        if (success == 1) {
            map.put("data", data);
            map.put("statusCode", "200");
            map.put("message", "删除大咖成功");
            return map;
        } else {
            map.put("data", data);
            map.put("statusCode", "400");
            map.put("message", "删除大咖失败");
            return map;
        }
    }

    @RequestMapping("/update")
    @ResponseBody
    public Map<String, Object> update(@RequestBody Daka daka) {
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> data = new HashMap<>();
        int success = dakaService.updateDaka(daka);
        if (success == 1) {
            map.put("data", data);
            map.put("statusCode", "200");
            map.put("message", "更新大咖信息成功");
            return map;
        } else {
            map.put("data", data);
            map.put("statusCode", "400");
            map.put("message", "更新大咖信息失败");
            return map;
        }
    }

    @RequestMapping("/info")
    @ResponseBody
    public RestResult info(@RequestBody Daka daka) {
        RestResult result = new RestResult();
        Map<String, Object> data = new HashMap<>();

        Daka getDaka = dakaService.selectDakaByDakaId(daka.getDakaId());

        if (getDaka != null) {
            data.put("daka", getDaka);
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
