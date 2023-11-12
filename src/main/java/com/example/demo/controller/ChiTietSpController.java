package com.example.demo.controller;

import com.example.demo.entity.ChiTietSp;
import com.example.demo.entity.KhachHang;
import com.example.demo.entity.NhanVien;
import com.example.demo.service.ChiTietSpService;
import com.example.demo.service.DongSpSeevice;
import com.example.demo.service.MauSacService;
import com.example.demo.service.NsxService;
import com.example.demo.service.SanPhamService;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.UUID;
@Controller
public class ChiTietSpController {

    @Autowired
    private ChiTietSpService service;

    @Autowired
    private SanPhamService sanPhamService;

    @Autowired
    private NsxService nsxService;

    @Autowired
    private MauSacService mauSacService;
    @Autowired
    private DongSpSeevice dongSpService;


    @GetMapping("/chitiet-sp/remove")
    public String delete(@RequestParam("id") UUID id, Model model) {
        ChiTietSp nv = service.findById(id);
        service.delete(nv);
        return "redirect:/chitiet-sp/hien-thi";
    }
    @GetMapping("chitiet-sp/hien-thi")
    public String hienThi(Model model,  @RequestParam(defaultValue = "0") int page,
                          @RequestParam(defaultValue = "4") int size) {
        if(!model.containsAttribute("dongSp")){
            model.addAttribute("dongSp",new ChiTietSp());
        }

        Pageable pageable = PageRequest.of(page, size);
        Page<ChiTietSp> cuaHangPage = service.getAll(pageable);
        model.addAttribute("list", cuaHangPage);

        model.addAttribute("listSp", sanPhamService.getAll());
        model.addAttribute("listNsx", nsxService.getAll());
        model.addAttribute("listMauSac", mauSacService.getAll());
        model.addAttribute("listDongSp", dongSpService.getAll());

        return "/chiTietSp/viewChiTietSp";
    }

    @PostMapping("chitiet-sp/save")
    public String add(@ModelAttribute("chiTiet") @Valid ChiTietSp nsx) {
//        if (result.hasErrors()) {
//            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.dongSp", result);
////            redirectAttributes.addFlashAttribute("dongSp", nsx);
//            return "redirect:/chitiet-sp/hien-thi";
//
//        }
//        try {



            // Xử lý khi id bằng null (ví dụ: thêm mới)
            service.save(nsx);


//        } catch (Exception e) {
//            String loi = e.getMessage();
//            if (loi.contains(" duplicate key value")) {
//                redirectAttributes.addFlashAttribute("tb", "Mã Không được trùng");
//
//                redirectAttributes.addFlashAttribute("chiTiet", new ChiTietSp());
//                redirectAttributes.addFlashAttribute("list", service.getAll());
//
//
//                return "/chiTietSp/viewChiTietSp";
//            }
//
//        }
        return "redirect:/san-pham/hien-thi";
    }

    }

//    @GetMapping("/nhan-vien/remove")
//    public String delete(@RequestParam("id") UUID id, Model model) {
//        NhanVien nv = service.findById(id);
//        service.delete(nv);
//        return "redirect:/nhan-vien/hien-thi";
//    }
//
//    @GetMapping("/nhan-vien/view-update")
//    public String viewUpdate(@RequestParam("id") UUID id, Model model) {
//        NhanVien nv = service.findById(id);
//        model.addAttribute("dongSp", nv);
//        model.addAttribute("list", service.getAll());
//        model.addAttribute("listCV", chucVuService.getAll());
//        model.addAttribute("listCH", cuaHangService.getAll());
//        return "nhanvien/viewUpdate";
//
//    }
//
//    @PostMapping("/nhan-vien/update")
//    public String update(@ModelAttribute("dongSp") @Valid NhanVien nsx, BindingResult result) {
//        if (result.hasErrors()) {
//            return "/nhanvien/viewUpdate";
//        }
//        service.save(nsx);
//        return "redirect:/nhan-vien/hien-thi";
//    }
//
//    @GetMapping("/nhan-vien/search")
//    public String search(
//            @RequestParam("ten") String ten,
//            Model model) {
//        List<NhanVien> listSearch = service.listSearch(ten, ten);
//
//        if (ten.isBlank()) {
//            model.addAttribute("thongBao", "không được để trống");
//
//            model.addAttribute("list", service.getAll());
//            model.addAttribute("dongSp",new NhanVien());
//
//            return "/nhanvien/viewNhanVien";
//        } else {
//            if (listSearch.isEmpty()) {
//                model.addAttribute("thongBao", "không tìm thấy");
//                model.addAttribute("searchName", ten);
//                model.addAttribute("dongSp",new NhanVien());
//
//                return "/nhanvien/viewNhanVien";
//            } else {
//
//                model.addAttribute("list", listSearch);
//                model.addAttribute("searchName", ten);
//                model.addAttribute("dongSp",new NhanVien());
//
//                return "/nhanvien/viewNhanVien";
//            }
//        }
//
//    }

