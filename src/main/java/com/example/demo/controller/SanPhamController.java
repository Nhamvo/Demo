package com.example.demo.controller;

import com.example.demo.entity.ChiTietSp;
import com.example.demo.entity.Nsx;
import com.example.demo.entity.SanPham;
import com.example.demo.service.ChiTietSpService;
import com.example.demo.service.DongSpSeevice;
import com.example.demo.service.MauSacService;
import com.example.demo.service.NsxService;
import com.example.demo.service.SanPhamService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
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
public class SanPhamController {


    @Autowired
    private NsxService nsxService;

    @Autowired
    private MauSacService mauSacService;
    @Autowired
    private DongSpSeevice dongSpService;
    @Autowired
    private SanPhamService service;

    @GetMapping("/san-pham/hien-thi")
    public String hienThi(Model model, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "4") int size) {


        Pageable pageable = PageRequest.of(page, size);
        Page<SanPham> cuaHangPage = service.getAll(pageable);
        model.addAttribute("list", cuaHangPage);
        model.addAttribute("dongSp", new SanPham());
        return "/san-pham/viewSanPham";
    }
    @GetMapping("/san-pham/remove")
    public String delete(@RequestParam("id") UUID id, Model model) {
        SanPham nv = service.findById(id);
        service.delete(nv);
        return "redirect:/san-pham/hien-thi";
    }


    @PostMapping("/san-pham/add")
    public String add(@ModelAttribute("dongSp") @Valid SanPham nsx, BindingResult result, Model model,
                      @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "4") int size) {
        if (result.hasErrors()) {
            Pageable pageable = PageRequest.of(page, size);
            Page<SanPham> cuaHangPage = service.getAll(pageable);
            model.addAttribute("list", cuaHangPage);
            return "/san-pham/viewSanPham";
        }
        service.save(nsx);
        return "redirect:/san-pham/hien-thi";
    }

    @GetMapping("/san-pham/view-update")
    public String edit(Model model, @RequestParam("id") UUID id) {
        SanPham nsx = service.findById(id);
        model.addAttribute("dongSp", nsx);
        return "/san-pham/viewUpdate";
    }

    @PostMapping("/san-pham/update")
    public String update(@ModelAttribute("dongSp") @Valid SanPham nsx, BindingResult result) {
        if (result.hasErrors()) {
            return "/san-pham/viewUpdate";
        }
        service.save(nsx);
        return "redirect:/san-pham/hien-thi";
    }

    @GetMapping("/san-pham/search")
    public String search(
            @RequestParam("ten") String ten,
            Model model) {
        List<SanPham> listSearch = service.listSearch(ten, ten);

        if (ten.isBlank()) {
            model.addAttribute("thongBao", "không được để trống");
            model.addAttribute("dongSp", new SanPham());
            model.addAttribute("list", service.getAll());
            return "/san-pham/viewSanPham";
        } else {
            if (listSearch.isEmpty()) {
                model.addAttribute("thongBao", "không tìm thấy");
                model.addAttribute("searchName", ten);
                model.addAttribute("dongSp", new SanPham());
                return "/san-pham/viewSanPham";

            } else {
                model.addAttribute("dongSp", new SanPham());
                model.addAttribute("list", listSearch);
                model.addAttribute("searchName", ten);
                return "/san-pham/viewSanPham";


            }
        }

    }

    @GetMapping("/san-pham/chi-tiet")
    public String chiTietSp(Model model, @RequestParam("id") UUID id) {
        ChiTietSp sp = service.serachChiTietSp(id);


        SanPham s = service.findById(id);
        model.addAttribute("sp", s);

        model.addAttribute("listNsx", nsxService.getAll());
        model.addAttribute("listMauSac", mauSacService.getAll());
        model.addAttribute("listDongSp", dongSpService.getAll());
        model.addAttribute("chiTiet", sp == null ? new ChiTietSp() : sp);
        return "/chiTietSp/viewChiTietSp";
    }


}
