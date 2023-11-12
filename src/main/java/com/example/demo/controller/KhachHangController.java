package com.example.demo.controller;

import com.example.demo.entity.DongSp;
import com.example.demo.entity.KhachHang;
import com.example.demo.entity.NhanVien;
import com.example.demo.entity.Nsx;
import com.example.demo.service.KhachHangService;
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
public class KhachHangController {
    @Autowired
    private KhachHangService service;
    @GetMapping("/khach-hang/hien-thi")
    public String hienThi(Model model, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "4") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<KhachHang> cuaHangPage = service.getAll(pageable);
        model.addAttribute("list", cuaHangPage);        model.addAttribute("dongSp", new KhachHang());
        return "/khachhang/viewKhachHang";
    }

    @PostMapping("/khach-hang/add")
    public String add(@ModelAttribute("dongSp") @Valid KhachHang nsx, BindingResult result, Model model,
                      @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "4") int size) {
        if (result.hasErrors()) {
            Pageable pageable = PageRequest.of(page, size);
            Page<KhachHang> cuaHangPage = service.getAll(pageable);
            model.addAttribute("list", cuaHangPage);            return "/khachhang/viewKhachHang";
        }
        service.save(nsx);
        return "redirect:/khach-hang/hien-thi";
    }

    @GetMapping("/khach-hang/view-update")
    public String edit(Model model, @RequestParam("id") UUID id) {
        KhachHang nsx = service.findById(id);
        model.addAttribute("dongSp", nsx);
        return "/khachhang/viewUpdate";
    }

    @PostMapping("/khach-hang/update")
    public String update(@ModelAttribute("dongSp") @Valid KhachHang nsx, BindingResult result) {
        if (result.hasErrors()) {
            return "/khachhang/viewUpdate";
        }
        service.save(nsx);
        return "redirect:/khach-hang/hien-thi";
    }

    @GetMapping("/khach-hang/remove")
    public String delete(@RequestParam("id") UUID id, Model model) {
        KhachHang nv = service.findById(id);
        service.delete(nv);
        return "redirect:/khach-hang/hien-thi";
    }

    @GetMapping("/khach-hang/search")
    public String search(
            @RequestParam("ten") String ten,
            Model model) {
        List<KhachHang> listSearch = service.listSearch(ten, ten,ten);

        if (ten.isBlank()) {
            model.addAttribute("thongBao", "không được để trống");
            model.addAttribute("dongSp", new KhachHang());
            model.addAttribute("list", service.getAll());
            return "/khachhang/viewKhachHang";
        } else {
            if (listSearch.isEmpty()) {
                model.addAttribute("thongBao", "không tìm thấy");
                model.addAttribute("searchName", ten);
                model.addAttribute("dongSp", new KhachHang());
                return "/khachhang/viewKhachHang";
            }
            else {
                model.addAttribute("dongSp", new KhachHang());
                model.addAttribute("list", listSearch);
                model.addAttribute("searchName", ten);
                return "/khachhang/viewKhachHang";

            }
        }

    }
}
