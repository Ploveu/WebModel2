package com.guo.webmodel2.controller;

import com.guo.webmodel2.model.UserModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class LoginController {

    @RequestMapping("/admin/CheckLogin")
    @ResponseBody
    public String CheckLogin(String email, String password, HttpServletRequest request){
        UserModel user = new UserModel(email,password,"李大锤子","Administrator");
        System.out.println(user);
        request.getSession().setAttribute("USERINFO",user);
        return "success";

    }

    @RequestMapping("/admin/GetUserInfo")
    @ResponseBody
    public UserModel GetUserInfo(HttpServletRequest request){
        UserModel user = (UserModel) request.getSession().getAttribute("USERINFO");
        System.out.println("获取用户信息"+user);
        return user;
    }
///**
//* List<String>传参
//* @param listString
//* @return
//*/
//      @RequestMapping("/listString")
//      @ResponseBody
//      public void listString(@RequestParam("listString[]") List<String> listString){
//                 System.out.println("listString:"+listString.toString());
//             }
//
//
///**
//* List<User>传参
//* @param listUser
//* @return
//*/
//              @RequestMapping("/listUsers")
//      @ResponseBody
//      public void listUsers(@RequestBody List<User> listUser){
//                 System.out.println("username:"+listUser.get(0).getUsername());
//             }
//
//
///**
//* User[]传参
//* @param arrayUsers
//* @return
//*/
//              @RequestMapping("/arrayUsers")
//      @ResponseBody
//      public void arrayUsers(@RequestBody User[] arrayUsers){
//                 System.out.println("username:"+arrayUsers[0].getUsername());
//             }
//
//
///**
//* List<Map<String,Object>>传参
//* @param listMap
//* @return
//*/
//              @RequestMapping("/listMap")
//      @ResponseBody
//      public void listMap(@RequestBody List<Map<String, String>> listMap){
//                 System.out.println("username:"+listMap.get(0).get("username"));
//             }
//
///**
//* User对象传参
//* @param arrayUsers
//* @return
//*/
//              @RequestMapping("/users")
//      @ResponseBody
//      public void users(@RequestBody User users){
//                 System.out.println("username:"+users.getUsername());
//                 System.out.println("username:"+users.getList().get(0).getUsername());
//             }
}
