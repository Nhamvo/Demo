package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerIndex {

    @GetMapping("trang-chu/hien-thi")
    public String hienThi(Model model){
        return "/trangChu/index";
    }
}
