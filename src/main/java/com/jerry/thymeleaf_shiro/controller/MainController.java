package com.jerry.thymeleaf_shiro.controller;

import com.jerry.thymeleaf_shiro.entity.User;
import com.jerry.thymeleaf_shiro.service.userService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletRequest;
import java.util.List;

@Controller
@RequestMapping("/main")
public class MainController {
    @Autowired
    private userService userService;
    @RequestMapping("/list")
    public String list(Model model)
    {
        List<User> users=userService.findAll();
        model.addAttribute("users",users);
        return "page/main";
    }
    @RequestMapping("/toAdd")
    @RequiresPermissions("add")
    public String toAdd()
    {
        return "page/userAdd";
    }

    @RequestMapping("/add")
    public ModelAndView add(ServletRequest request) {
        ModelAndView mv = new ModelAndView();
        User user = new User();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username.equals("") || password.equals("")) {
            mv.setViewName("redirect:/main/toAdd");
        }
        user.setUsername(username);
        user.setPassword(password);
        User user1 = userService.findByUsername(username);
        if (user1==null) {
            userService.createUser(user);
            mv.setViewName("redirect:/main/list");
        } else {
            mv.setViewName("redirect:/main/toAdd");
        }
        return mv;
    }
    @RequestMapping("/toEdit")
    @RequiresPermissions("edit")
public ModelAndView toEdit(Long id)
    {
        ModelAndView mv=new ModelAndView();
        User user=userService.findById(id);
        mv.addObject("user",user);
        mv.setViewName("page/userEdit");
        return mv;
    }
    @RequestMapping("/edit")
    public ModelAndView edit(ServletRequest request)
    {

        userService.changePassword(Long.valueOf(request.getParameter("id")),request.getParameter("password"));
        ModelAndView mv=new ModelAndView();
        mv.setViewName("redirect:/main/list");
        return mv;
    }

    @RequestMapping("/delete")
    @RequiresRoles("admin")
    public ModelAndView delete(Long id)
    {
        System.out.println(id);
        ModelAndView mv=new ModelAndView();
        userService.deleteUser_Role(id);
        userService.deleteUser(id);
        mv.setViewName("redirect:/main/list");
        return mv;
    }
}
