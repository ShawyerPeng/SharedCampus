//package controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import pojo.Message;
//
//@Controller
//@RequestMapping("/chat")
//public class JellyController {
//
//    @RequestMapping(value = "/register", method = RequestMethod.POST)
//    @ResponseBody
//    public void register(@RequestParam("username") String username, @RequestParam("password") String password) throws Exception {
////        ClientStrap clientStrap = new ClientStrap();
////        clientStrap
//        ClientStrap.register(username, password);
//    }
//
//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    @ResponseBody
//    public String login(@RequestParam("username") String username, @RequestParam("password") String password) throws Exception {
//        return ClientStrap.login(username, password);
//    }
//
//    @RequestMapping(value = "/logout", method = RequestMethod.POST)
//    @ResponseBody
//    public void logout() throws Exception {
//        ClientStrap.logout();
//    }
//
//    @RequestMapping(value = "/message", method = RequestMethod.GET)
//    @ResponseBody
//    public void message(@RequestParam("receiver") String receiver, @RequestParam("content") String content) throws Exception {
//        Message message = ClientStrap.personMessage(receiver, content);
//    }
//
//}
