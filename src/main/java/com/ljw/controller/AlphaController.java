package com.ljw.controller;

import com.ljw.service.AlphaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * @author lanjuwen
 * @create 2022-04-04  11:08
 */
@Controller
@RequestMapping("/alpha")
public class AlphaController {

    @Autowired
    private AlphaService alphaService;

    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello() {
        return "hello spring-boot";
    }

    @RequestMapping("/data")
    @ResponseBody
    public String getData() {
        return alphaService.find();
    }

    @RequestMapping("http")
    public void http(HttpServletRequest req, HttpServletResponse resp) {
        // 获取请求数据
        System.out.println(req.getMethod());
        System.out.println(req.getServletPath());
        Enumeration<String> headers = req.getHeaderNames();
        while (headers.hasMoreElements()) {
            String name = headers.nextElement();
            String value = req.getHeader(name);
            System.out.println(name + ":" + value);
        }
        System.out.println(req.getParameter("code"));

        // 返回响应数据
        resp.setContentType("text/html;charset=utf-8");
        try (PrintWriter writer = resp.getWriter();) {
            writer.write("<h1>hello</h1>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // get请求 /students?cur=1&limit=2
    @RequestMapping(path = "/students", method = RequestMethod.GET)
    @ResponseBody
    public String getStudents(
            @RequestParam(name = "cur", required = false, defaultValue = "1") int cur,
            @RequestParam(name = "limit", required = false, defaultValue = "1") int limit) {
        System.out.println(cur);
        System.out.println(limit);
        return "some students";
    }

    // /student/123
    @RequestMapping(path="/students/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String getStudent(@PathVariable("id") int id) {
        return "student";
    }

    // post请求
    @RequestMapping(path = "/student", method = RequestMethod.POST)
    @ResponseBody
    public String saveStudent(
            @RequestParam(name = "name") String nam,
            @RequestParam(name = "age") String age) {
        System.out.println(nam);
        System.out.println(age);
        return "success";
    }

    // 响应html数据: 方式一 modelAndView
    @RequestMapping(path = "/teacher", method = RequestMethod.GET)
    public ModelAndView getTeacher() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("name", "张三");
        mav.addObject("age", 30);
        mav.setViewName("/demo/view");
        return mav;
    }

    // 响应html数据： 方式二 model
    @RequestMapping(path = "/school", method = RequestMethod.GET)
    public String getSchool(Model model) {
        model.addAttribute("name", "ljw");
        model.addAttribute("age", 18);
        return "/demo/view";
    }

    // 异步请求中(当前网页不刷新)，响应json数据
    // java对象->json格式->js对象
    @RequestMapping(path = "/emp", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getEmp(){
        Map<String, Object> map = new HashMap<>();
        map.put("name", "zhangsan");
        map.put("name", 18);
        map.put("salary", 20);
        return map;
    }

    @RequestMapping(path = "/emps", method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String, Object>> getEmps(){
        List<Map<String, Object>> list = new ArrayList<>();

        Map<String, Object> map = new HashMap<>();
        map.put("name", "zhangsan");
        map.put("name", 18);
        map.put("salary", 20);
        list.add(map);

        map = new HashMap<>();
        map.put("name", "ljw");
        map.put("name", 25);
        map.put("salary", 25);
        list.add(map);

        map = new HashMap<>();
        map.put("name", "qiuyang");
        map.put("name", 18);
        map.put("salary", 20);
        list.add(map);

        return list;
    }

}
