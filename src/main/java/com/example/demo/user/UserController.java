package com.example.demo.user;

import com.example.demo.entity.ChiTietSp;
import com.example.demo.entity.KhachHang;
import com.example.demo.entity.SanPham;
import com.example.demo.repository.ChiTietSpRepository;
import com.example.demo.repository.KhachHangRepository;
import com.example.demo.service.ChiTietSpService;
import com.example.demo.service.DongSpSeevice;
import com.example.demo.service.KhachHangService;
import com.example.demo.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class UserController {
    @Autowired
    KhachHangService khachHangService;
    @Autowired
    SanPhamService sanPham;

    @Autowired
    KhachHangRepository khachHangRepository;

    @Autowired
    private ChiTietSpService service;


    KhachHang kh = new KhachHang();

    @Autowired
    DongSpSeevice seevice;

    @Autowired
    ChiTietSpRepository chiTietSpRepository;

    List<KhachHang> list = new ArrayList<>();

    @GetMapping("/login")
    public String dangNhap(Model model) {
        return "/user/dangNhap";
    }

    @GetMapping("/dang-ki")
    public String dangKi() {
        return "/user/dangKi";
    }

    @PostMapping("user/add")
    public String add(Model model, @RequestParam("ma") String ma,
                      @RequestParam("matKhau") String matKhau,
                      @RequestParam("ten") String ten,
                      @RequestParam("sdt") String sdt,
                      RedirectAttributes redirectAttributes) {
        kh.setMa(ma);
        kh.setTen(ten);
        kh.setSdt(sdt);
        kh.setMatKhau(matKhau);
        try {
            khachHangService.save(kh);
            model.addAttribute("tb", "Đăng Kí Thành Công");
            return "/user/dangKi";
        } catch (Exception e) {
            String loi = e.getMessage();
            if (loi.contains("duplicate key value")) {
                redirectAttributes.addFlashAttribute("tb", "UserName này đã được sử dụng");
                return "redirect:/dang-ki";

            }


        }


        return "/user/dangKi";
    }

    @GetMapping("/user/ban-hang")
    public String chuyen(Model model,
                         @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "4") int size) {


        Pageable pageable = PageRequest.of(page, size);
        Page<ChiTietSp> cuaHangPage = service.getAll(pageable);
        model.addAttribute("listSp", cuaHangPage);
        return "ban_hang/index";
    }



    @PostMapping("/user/home")
    public String dangNhap(Model model,
                           @RequestParam("ma") String ma,
                           @RequestParam("matKhau") String matKhau,
                           RedirectAttributes redirectAttributes) {
        list = khachHangRepository.findAll();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMa().equals(ma) && list.get(i).getMatKhau().equals(matKhau)) {
                return "redirect:/user/ban-hang";

            }
        }
        if (ma.equals("admin") && matKhau.equals("123")) {
            return "redirect:/san-pham/hien-thi";

        }
        redirectAttributes.addFlashAttribute("tb", "Thông tin chưa chính xác");
        return "redirect:/login";
    }




    @GetMapping("/user/hien-thi-danh-muc")
    public String hienThiSp(Model model, @RequestParam("id") UUID id) {
        List<ChiTietSp> listSearch = chiTietSpRepository.search(id);
        if (listSearch.isEmpty()) {
            model.addAttribute("tb", "Không có sản phẩm");
            return "trangChu/index";
        } else {
            model.addAttribute("listSp", listSearch);
            return "trangChu/index";
        }


    }

}
