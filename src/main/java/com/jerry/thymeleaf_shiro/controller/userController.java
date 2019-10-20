package com.jerry.thymeleaf_shiro.controller;

import com.jerry.thymeleaf_shiro.entity.User;
import com.jerry.thymeleaf_shiro.service.userService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletRequest;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/user")
public class userController {
    @Autowired
    private userService userService;

    @RequestMapping("/")
    public String index()
    {
        return "login";
    }

    @RequestMapping("/login")
    public ModelAndView login(ServletRequest request)
    {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        User user=new User(username,password);
        ModelAndView view=new ModelAndView();
        Subject subject= SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken(user.getUsername(),user.getPassword());
        if(!subject.isAuthenticated())
        {
            subject.login(token);
        }
        SavedRequest savedRequest= WebUtils.getSavedRequest(request);
        String url="";
        if(savedRequest!=null)
        {
            url="login";

        }else
        {
            url= "forward:/main/list";
        }
        view.setViewName(url);
        return view;

    }
    @RequestMapping("/register")
    public ModelAndView add(ServletRequest request)
    {
        ModelAndView view = new ModelAndView();
        User user=new User();
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        if (username.equals("") || password.equals("")) {
            view.setViewName("reg");
        }
        user.setUsername(username);
        user.setPassword(password);
        User user1=userService.findByUsername(username);
        System.out.println(user1==null);

        if(user1==null) {
            userService.createUser(user);
            view.setViewName("login");
        }else {
           view.setViewName("reg");
        }
        return view;
    }
    @RequestMapping("/logout")
    @ResponseBody
    public ModelAndView logout(User user)
    {
        Subject subject= SecurityUtils.getSubject();
        subject.logout();
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }
    @RequestMapping("/toReg")
    public String toReg()
    {
        return "reg";
    }
    @RequestMapping("/toLogin")
    public String toLogin()
    {
        return "login";
    }

}
