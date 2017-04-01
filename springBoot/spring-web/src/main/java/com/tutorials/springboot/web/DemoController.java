package com.tutorials.springboot.web;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;


/**
 * Created by id on 3/30/2017.
 * <p>
 * <p>
 * 1. 映射请求的方式 GET, HEAD, POST, PUT, PATCH, DELETE, OPTIONS, TRACE
 * 2. 传参的方式
 * 3. 返回数据到视图的方式
 */
@Controller
public class DemoController {

    /**
     * 映射请求的2种类型的注解
     * a. @RequestMapping
     * b. @GetMapping, @PostMapping, @PutMapping, @DeleteMapping
     */
    @RequestMapping(value = "/page1", method = RequestMethod.GET)
    public String page1() {
        return "page1";
    }

    @GetMapping("/page1a")
    public String page1a() {
        return "page1";
    }


    /**
     * 参数传递的5种方式
     * 1. request.getParameter
     * 2. @Param注解获取请求参数
     * 3. @PathVariable获取请求URL路径上的参数
     * 4. @RequestBody 绑定输入的JSON到对象获取POST数据
     * 5. @ModelAttribute 绑定输入Form字段到对象获取POST数据
     */
    @GetMapping("/param1")
    public String param1(HttpServletRequest request) {
        System.out.println(request.getParameter("param"));
        return "page1";
    }

    @GetMapping("/param2")
    public String param2(@RequestParam("param") String param) {
        System.out.println(param);
        return "page1";
    }

    @GetMapping("/param3/{param}")
    public String param3(@PathVariable String param) {
        System.out.println(param);
        return "page1";
    }

    @GetMapping("/param4page")
    public String param4page() {
        return "param4page";
    }


    /**
     * Form input
     */
    @PostMapping(value = "/param4")
    public String param4(@ModelAttribute User user) {
        System.out.println(user.getName() + " " + user.getAge());
        return "page1";
    }

    @GetMapping("/param5page")
    public String param5page() {
        return "param5page";
    }

    /**
     * AJAX JSON input
     */
    @PostMapping(value = "/param5")
    public String param5(@RequestBody User user) {
        System.out.println(user.getName() + " " + user.getAge());
        return "page1";
    }

    /**
     * 输入校验
     */
    @PostMapping(value = "/param6")
    public String validForm(@RequestBody @Valid User user, BindingResult br, ModelMap map) {
        // 手动校验
        if (user.getName().contains("kevin")) {
            br.reject("userNameExist", "用户名已经被注册");
            map.put("error", br.getAllErrors());
            return "page1";
        }

        System.out.println(user.getName() + " " + user.getAge());
        return "page1";
    }


    /**
     * 输出参数到页面(以下的参数类型都是一样的效果)
     * Map, ModelMap, Model, ModelAndView
     */
    @GetMapping("/outPage")
    public String outPage(ModelMap map) {
        map.put("test1", "annie");
        return "outPage";
    }


    /**
     * 视图类型
     * a. 普通页面视图: return "viewName"
     * b. redirect: return "redirect:page"
     */
    @GetMapping("/redirect")
    public String redirect(RedirectAttributes att) {
        att.addFlashAttribute("att1", "red annie and kev");
        return "redirect:/hip";
    }

    @GetMapping("/hip")
    public String hipPage() {
        return "hip";
    }


    /**
     * Rest 输出
     */
    @GetMapping("/rest1")
    @ResponseBody
    public Object rest1() {
        User u = new User();
        u.setName("kevin and annie 1");
        u.setAge(29);
        return u;
    }

    @GetMapping("/rest2")
    public Object rest2() {
        User u = new User();
        u.setName("kevin and annie 2");
        u.setAge(29);
        return ResponseEntity.ok(u);
    }


    public static class User {

        @NotEmpty(message = "用户名不能为空")
        @Length(min = 4, max = 20, message = "用户名4-20个字符")
        private String name;

        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

}
