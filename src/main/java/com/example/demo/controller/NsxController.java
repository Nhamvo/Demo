package com.example.demo.controller;

import com.example.demo.entity.Nsx;
import com.example.demo.service.NsxService;
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
public class NsxController {
    @Autowired
    private NsxService service;

    @GetMapping("/nsx/hien-thi")
    public String hienThi(Model model, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "4") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Nsx> cuaHangPage = service.getAll(pageable);
        model.addAttribute("list", cuaHangPage);
        model.addAttribute("dongSp", new Nsx());
        return "/nsx/viewNSX";
    }
    @GetMapping("/nsx/remove")
    public String delete(@RequestParam("id") UUID id, Model model) {
        Nsx nv = service.findById(id);
        service.delete(nv);
        return "redirect:/nsx/hien-thi";
    }
    @PostMapping("/nsx/add")
    public String add(@ModelAttribute("dongSp") @Valid Nsx nsx, BindingResult result, Model model,
                      @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "4") int size) {
        if (result.hasErrors()) {
            Pageable pageable = PageRequest.of(page, size);
            Page<Nsx> cuaHangPage = service.getAll(pageable);
            model.addAttribute("list", cuaHangPage);
            return "/nsx/viewNSX";
        }
        service.save(nsx);
        return "redirect:/nsx/hien-thi";
    }

    @GetMapping("/nsx/view-update")
    public String edit(Model model, @RequestParam("id") UUID id) {
        Nsx nsx = service.findById(id);
        model.addAttribute("dongSp", nsx);
        return "/nsx/viewUpdate";
    }

    @PostMapping("/nsx/update")
    public String update(@ModelAttribute("dongSp") @Valid Nsx nsx, BindingResult result) {
        if (result.hasErrors()) {
            return "/nsx/viewUpdate";
        }
        service.save(nsx);
        return "redirect:/nsx/hien-thi";
    }

    @GetMapping("/nsx/search")
    public String search(
            @RequestParam("ten") String ten,
            Model model) {
        List<Nsx> listSearch = service.listSearch(ten, ten);

        if (ten.isBlank()) {
            model.addAttribute("thongBao", "không được để trống");
            model.addAttribute("dongSp", new Nsx());
            model.addAttribute("list", service.getAll());
            return "/nsx/viewNSX";
        } else {
            if (listSearch.isEmpty()) {
                model.addAttribute("thongBao", "không tìm thấy");
                model.addAttribute("searchName", ten);
                model.addAttribute("dongSp", new Nsx());
                return "/nsx/viewNSX";
            }
            else {
                model.addAttribute("dongSp", new Nsx());
                model.addAttribute("list", listSearch);
                model.addAttribute("searchName", ten);
                return "/nsx/viewNSX";

            }
        }

    }
    }

