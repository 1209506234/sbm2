package com.zb.sbm.controller;

import com.zb.sbm.entity.User;
import com.zb.sbm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    @Qualifier("userServiceRedisImpl")
    UserService userService;


    @RequestMapping(value = {"/list","/"})
    public String list(User user, Model model){
        System.out.println("list:"+user);
        Map<String,Object> condition = new HashMap<String,Object>();
        condition.put("user",user);
        List<User> users = userService.search(condition);

        model.addAttribute("users",users);
        System.out.println(11);
        return "list";
    }


    @RequestMapping("/get")
    public String get(String id, Model model){
        System.out.println("get:"+id);
        model.addAttribute("user",userService.get(id));
        return "view";
    }


    @RequestMapping("/modify")
    public String modify(User user){
        System.out.println("modify:"+user);
        System.out.println(userService.modify(user));
        return "forward:/";
    }

    @RequestMapping("/delete/{did}")
    @ResponseBody
    public String delete(@PathVariable("did")String id){
        System.out.println("delete:"+id);
        return "1";
    }
}
