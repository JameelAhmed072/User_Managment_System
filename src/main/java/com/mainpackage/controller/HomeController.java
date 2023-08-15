package com.mainpackage.controller;

import com.mainpackage.dao.UserDao;
import com.mainpackage.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;
@Controller
public class HomeController {
    @Autowired
    private UserDao userDao;
    @RequestMapping(path = "/home")
    public String Showhome(Model m){
        List<User> list = userDao.getAllUser();
        m.addAttribute("userlist",list);
        return "home";
    }
    @RequestMapping(path = "/addUser")
    public String addUser(){
        return "add_user";
    }
    @RequestMapping(path = "/createUser", method = RequestMethod.POST)
    public String createUser(@ModelAttribute User user, HttpSession session){
        System.out.println(user);
        int i = userDao.saveUser(user);
        session.setAttribute("msg","Registered Successfully");
        return "redirect:/home";
    }
    @RequestMapping(path = "/editUser/{id}")
    public String editUser(@PathVariable int id, Model m){

        User user = userDao.getUserById(id);
        m.addAttribute("user",user);
        return "edit_user";
    }
    @RequestMapping(path = "/updateUser",method = RequestMethod.POST)
    public String updateUser(@ModelAttribute User user,HttpSession session){

        userDao.update(user);
        session.setAttribute("msg","Update Successfully");
        return "redirect:/home";
    }
    @RequestMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable int id, HttpSession session){
        userDao.deleteUser(id);
        session.setAttribute("msg","User Deleted Successfully");
        return "redirect:/home";
    }

}
