//package controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import java.util.Date;
//
//@Controller
//@RequestMapping
//public class WithdrawalController {
//    @Autowired
//    private WithdrawalService withdrawalService;
//
//    @RequestMapping(value = "/withdraw", method = RequestMethod.POST)
//    @ResponseBody
//    public String insert(@RequestParam("publisherId") Integer publisherId, @RequestParam("title") String title,
//                         @RequestParam("description") String description, @RequestParam("category") Integer category,
//                         @RequestParam("price") Double price, @RequestParam("counts") Integer counts,
//                         @RequestParam("starttime") Date starttime, @RequestParam("endtime") Date endtime) throws Exception {
//        withdrawalService.insertTask(publisherId, title, description, category, price, counts, starttime, endtime);
//        return "ok";
//    }
//}
