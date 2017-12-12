package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import po.Collect;
import po.Follow;
import po.PagedResult;
import service.FollowService;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/follow")
public class FollowController {
    @Autowired
    private FollowService followService;

    @RequestMapping("/insert")
    @ResponseBody
    public Map<String, Object> insert(@RequestBody Follow follow) {
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> data = new HashMap<>();
        int success = followService.insertFollow(follow);
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

    @RequestMapping("/delete")
    @ResponseBody
    public Map<String, Object> delete(@RequestBody Follow follow) {
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> data = new HashMap<>();
        Integer followId = follow.getFollowId();
        int success = followService.deleteFollow(followId);
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

    @RequestMapping("/getFolloweds")
    @ResponseBody
    public PagedResult<Follow> getFolloweds(@RequestParam("followerId") Integer followerId, @RequestParam("pageNo") Integer pageNo, @RequestParam("pageNo") Integer pageSize) {
        return followService.getAllFollows(pageNo, pageSize);
    }

    @RequestMapping("/getFollowers")
    @ResponseBody
    public PagedResult<Follow> getFollowers(@RequestParam("followedId") Integer followedId, @RequestParam("pageNo") Integer pageNo, @RequestParam("pageNo") Integer pageSize) {
        return followService.getAllFollows(pageNo, pageSize);
    }

    @RequestMapping("/getAllFollows")
    @ResponseBody
    public PagedResult<Follow> getAllFollows(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageNo") Integer pageSize) {
        return followService.getAllFollows(pageNo, pageSize);
    }
}