package com.example.demo.controller;

import com.example.demo.entity.ChiTietSp;
import com.example.demo.entity.ChucVu;
import com.example.demo.entity.KhachHang;
import com.example.demo.entity.Nsx;
import com.example.demo.service.ChucVuService;
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
public class ChucVuController {
    @Autowired
    private ChucVuService service;



    @GetMapping("/chuc-vu/hien-thi")
    public String hienThi(Model model, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "4") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<ChucVu> cuaHangPage = service.getAll(pageable);
        model.addAttribute("list", cuaHangPage);
        model.addAttribute("dongSp", new Nsx());
        return "/chucvu/viewChucVu";
    }

    @GetMapping("/chuc-vu/remove")
    public String delete(@RequestParam("id") UUID id, Model model) {
        ChucVu nv = service.findById(id);
        service.delete(nv);
        return "redirect:/chuc-vu/hien-thi";
    }

    @PostMapping("/chuc-vu/add")
    public String add(@ModelAttribute("dongSp") @Valid ChucVu nsx, BindingResult result, Model model,
                      @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "4") int size) {
        if (result.hasErrors()) {
            Pageable pageable = PageRequest.of(page, size);
            Page<ChucVu> cuaHangPage = service.getAll(pageable);
            model.addAttribute("list", cuaHangPage);            return "/chucvu/viewChucVu";
        }
        service.save(nsx);
        return "redirect:/chuc-vu/hien-thi";
    }

    @GetMapping("/chuc-vu/view-update")
    public String edit(Model model, @RequestParam("id") UUID id) {
        ChucVu nsx = service.findById(id);
        model.addAttribute("dongSp", nsx);
        return "/chucvu/viewUpdate";
    }

    @PostMapping("/chuc-vu/update")
    public String update(@ModelAttribute("dongSp") @Valid ChucVu nsx, BindingResult result) {
        if (result.hasErrors()) {
            return "/chucvu/viewChucVu";
        }
        service.save(nsx);
        return "redirect:/chuc-vu/hien-thi";
    }

    @GetMapping("/chuc-vu/search")
    public String search(
            @RequestParam("ten") String ten,
            Model model) {
        List<ChucVu> listSearch = service.listSearch(ten, ten);


        if (ten.isBlank()) {
            model.addAttribute("thongBao", "không được để trống");
            model.addAttribute("dongSp", new ChucVu());
            model.addAttribute("list", service.getAll());
            return "/chucvu/viewChucVu";
        } else {
            if (listSearch.isEmpty()) {
                model.addAttribute("thongBao", "không tìm thấy");
                model.addAttribute("searchName", ten);
                model.addAttribute("dongSp", new ChucVu());
                return "/chucvu/viewChucVu";
            }
            else {
                model.addAttribute("dongSp", new ChucVu());
                model.addAttribute("list", listSearch);
                model.addAttribute("searchName", ten);
                return "/chucvu/viewChucVu";

            }
        }

    }
}

