package com.example.demo.controller;

import com.example.demo.entity.ChiTietSp;
import com.example.demo.entity.ChucVu;
import com.example.demo.entity.CuaHang;
import com.example.demo.entity.Nsx;
import com.example.demo.service.CuaHangService;
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
public class CuaHangController {
    @Autowired
    private CuaHangService service;
    @GetMapping("/cua-hang/hien-thi")
    public String hienThi(Model model, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "4") int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<CuaHang> cuaHangPage = service.getAll(pageable);
        model.addAttribute("list", cuaHangPage);
        model.addAttribute("dongSp", new CuaHang());
        return "/cua-hang/viewCuaHang";
    }

    @GetMapping("/cua-hang/remove")
    public String delete(@RequestParam("id") UUID id, Model model) {
        CuaHang nv = service.findById(id);
        service.delete(nv);
        return "redirect:/cua-hang/hien-thi";
    }

    @PostMapping("/cua-hang/add")
    public String add(@ModelAttribute("dongSp") @Valid CuaHang nsx, BindingResult result, Model model,
                      @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "4") int size) {
        if (result.hasErrors()) {
            Pageable pageable = PageRequest.of(page, size);
            Page<CuaHang> cuaHangPage = service.getAll(pageable);
            model.addAttribute("list", cuaHangPage);
            return "/cua-hang/viewCuaHang";
        }
        service.save(nsx);
        return "redirect:/cua-hang/hien-thi";
    }

    @GetMapping("/cua-hang/view-update")
    public String edit(Model model, @RequestParam("id") UUID id) {
        CuaHang nsx = service.findById(id);
        model.addAttribute("dongSp", nsx);
        return "/cua-hang/viewUpdate";
    }

    @PostMapping("/cua-hang/update")
    public String update(@ModelAttribute("dongSp") @Valid CuaHang nsx, BindingResult result) {
        if (result.hasErrors()) {
            return "/cua-hang/viewCuaHang";
        }
        service.save(nsx);
        return "redirect:/cua-hang/hien-thi";
    }


    @GetMapping("/cua-hang/search")
    public String search(
            @RequestParam("ten") String ten,
            Model model, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "4") int size) {
        List<CuaHang> listSearch = service.listSearch(ten, ten);
        Pageable pageable = PageRequest.of(page, size);
//        Page<CuaHang> cuaHangPage = service.searchP(listSearch,pageable);
        if (ten.isBlank()) {
            model.addAttribute("thongBao", "không được để trống");
            model.addAttribute("dongSp", new CuaHang());
            model.addAttribute("list", service.getAll());
            return "/cua-hang/viewCuaHang";
        } else {
            if (listSearch.isEmpty()) {
                model.addAttribute("thongBao", "không tìm thấy");
                model.addAttribute("searchName", ten);
                model.addAttribute("dongSp", new CuaHang());
                return "/cua-hang/viewCuaHang";
            }
            else {
                model.addAttribute("dongSp", new CuaHang());
//                model.addAttribute("list", cuaHangPage);
                return "/cua-hang/viewCuaHang";

            }
        }

    }
}
