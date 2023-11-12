package com.example.demo.controller;

import com.example.demo.entity.ChiTietSp;
import com.example.demo.entity.DongSp;
import com.example.demo.entity.MauSac;
import com.example.demo.service.DongSpSeevice;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@Controller
public class DongSpController {
    @Autowired
    private DongSpSeevice service;

    @GetMapping("/dong-sp/hien-thi")
    public String hienThi(Model model, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "4") int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<DongSp> cuaHangPage = service.getAll(pageable);
        model.addAttribute("list", cuaHangPage);
        model.addAttribute("dongSp", new DongSp());
        return "/dongsp/viewDongSp";
    }
    @GetMapping("/dong-sp/remove")
    public String delete(@RequestParam("id") UUID id, Model model) {
        DongSp nv = service.findById(id);
        service.delete(nv);
        return "redirect:/dong-sp/hien-thi";
    }
    @PostMapping("/dong-sp/add")
    public String add(@ModelAttribute("dongSp") @Valid DongSp nsx, BindingResult result, Model model,
                      @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "4") int size) {
        if (result.hasErrors()) {
            Pageable pageable = PageRequest.of(page, size);
            Page<DongSp> cuaHangPage = service.getAll(pageable);
            model.addAttribute("list", cuaHangPage);            return "/dongsp/viewDongSp";
        }
        service.save(nsx);
        return "redirect:/dong-sp/hien-thi";
    }

    @GetMapping("/dong-sp/view-update")
    public String edit(Model model, @RequestParam("id") UUID id) {
        DongSp nsx = service.findById(id);
        model.addAttribute("dongSp", nsx);
        return "/dongsp/viewUpdate";
    }

    @PostMapping("/dong-sp/update")
    public String update(@ModelAttribute("dongSp") @Valid DongSp nsx, BindingResult result) {
        if (result.hasErrors()) {
            return "/dongsp/viewUpdate";
        }
        service.save(nsx);
        return "redirect:/dong-sp/hien-thi";
    }

    @GetMapping("/dong-sp/search")
    public String search(
            @RequestParam("ten") String ten,
            Model model) {
        List<DongSp> listSearch = service.listSearch(ten, ten);

        if (ten.isBlank()) {
            model.addAttribute("thongBao", "không được để trống");
            model.addAttribute("dongSp", new DongSp());
            model.addAttribute("list", service.getAll());
            return "/dongsp/viewDongSp";
        } else {
            if (listSearch.isEmpty()) {
                model.addAttribute("thongBao", "không tìm thấy");
                model.addAttribute("searchName", ten);
                model.addAttribute("dongSp", new DongSp());
                return "/dongsp/viewDongSp";
            }
            else {
                model.addAttribute("dongSp", new DongSp());
                model.addAttribute("list", listSearch);
                model.addAttribute("searchName", ten);
                return "/dongsp/viewDongSp";

            }
        }

    }
}
