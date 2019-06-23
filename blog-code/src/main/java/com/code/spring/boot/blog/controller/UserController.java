package com.code.spring.boot.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.code.spring.boot.blog.domain.User;
import com.code.spring.boot.blog.respository.UserRepository;

/*
 * 
 * */
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ModelAndView list(Model model){
        model.addAttribute("userList",userRepository.findAll());
      model.addAttribute("title","用户管理");
        return new ModelAndView("users/list","userModel",model);
    }

    /**
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping("{id}")
    public ModelAndView view(@PathVariable("id") Long id, Model model){

        User user=userRepository.findById(id).get();
        model.addAttribute("user",user);
        model.addAttribute("title","查看用户");
        return new ModelAndView("users/view","userModel",model);
    }

    @GetMapping("/form")
    public ModelAndView createForm( Model model){

        model.addAttribute("user",new User(null,null,null));
        model.addAttribute("title","创建用户");
        return new ModelAndView("users/form","userModel",model);
    }
    @PostMapping
    public ModelAndView saveOrUpdate(User user){
        user=userRepository.save(user);
        return new ModelAndView("redirect:/users");
    }
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id){
        userRepository.deleteById(id);
        return new ModelAndView("redirect:/users");
    }

    @GetMapping("/modify/{id}")
    public ModelAndView modify(@PathVariable("id") Long id,Model model){
        User user=userRepository.findById(id).get();
        model.addAttribute("user",user);
        model.addAttribute("title","修改用户");
        return new ModelAndView("users/form","userModel",model);
    }
}