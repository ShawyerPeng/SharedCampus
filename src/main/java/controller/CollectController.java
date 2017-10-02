package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import po.Collect;
import po.Order;
import po.PagedResult;
import service.CollectService;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/collect")
public class CollectController {
    @Autowired
    private CollectService collectService;

    @RequestMapping("/insert")
    @ResponseBody
    public Map<String, Object> insert(@RequestBody Collect collect) {
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> data = new HashMap<>();
        int success = collectService.insertCollect(collect);
        if (success == 1) {
            map.put("data", data);
            map.put("statusCode", "200");
            map.put("message", "收藏添加成功");
            return map;
        } else {
            map.put("data", data);
            map.put("statusCode", "400");
            map.put("message", "收藏添加失败");
            return map;
        }
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Map<String, Object> delete(@RequestBody Collect collect) {
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> data = new HashMap<>();
        Integer collectId = collect.getCollectId();
        int success = collectService.deleteCollect(collectId);
        if (success == 1) {
            map.put("data", data);
            map.put("statusCode", "200");
            map.put("message", "收藏删除成功");
            return map;
        } else {
            map.put("data", data);
            map.put("statusCode", "400");
            map.put("message", "收藏删除失败");
            return map;
        }
    }

    @RequestMapping("/getAllCollects")
    @ResponseBody
    public PagedResult<Collect> getAllCollects(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageNo") Integer pageSize) {
        return collectService.getAllCollects(pageNo, pageSize);
    }
}
