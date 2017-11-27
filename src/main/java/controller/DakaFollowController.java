package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import po.DakaFollow;
import po.PagedResult;
import service.DakaFollowService;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/dakaFollow")
public class DakaFollowController {
    @Autowired
    private DakaFollowService dakaFollowService;

    @RequestMapping("/follow")
    @ResponseBody
    public Map<String, Object> insert(@RequestBody DakaFollow dakaFollow) {
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> data = new HashMap<>();
        int success = dakaFollowService.insertDakaFollow(dakaFollow);
        if (success == 1) {
            map.put("data", data);
            map.put("statusCode", "200");
            map.put("message", "关注成功");
            return map;
        } else {
            map.put("data", data);
            map.put("statusCode", "400");
            map.put("message", "关注失败");
            return map;
        }
    }

    @RequestMapping("/unfollow")
    @ResponseBody
    public Map<String, Object> delete(@RequestBody DakaFollow dakaFollow) {
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> data = new HashMap<>();
        int success = dakaFollowService.deleteDakaFollow(dakaFollow.getDakaId(), dakaFollow.getFollowerId());
        if (success == 1) {
            map.put("data", data);
            map.put("statusCode", "200");
            map.put("message", "取消关注成功");
            return map;
        } else {
            map.put("data", data);
            map.put("statusCode", "400");
            map.put("message", "取消关注失败");
            return map;
        }
    }

    @RequestMapping("/getFollowerCount")
    @ResponseBody
    public Map<String, Object> getAllFollows(@RequestParam("dakaId") Integer dakaId) {
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> data = new HashMap<>();
        Integer followerCount = dakaFollowService.getFollowerCount(dakaId);
        data.put("followerCount", followerCount);
        map.put("data", data);
        map.put("statusCode", "200");
        map.put("message", "获取成功");
        return map;
    }

    @RequestMapping("/getAllDakaFollows")
    @ResponseBody
    public PagedResult<DakaFollow> getAllDakaFollows(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageNo") Integer pageSize) {
        return dakaFollowService.getAllDakaFollows(pageNo, pageSize);
    }
}