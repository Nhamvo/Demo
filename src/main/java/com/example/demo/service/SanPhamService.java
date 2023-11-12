package com.example.demo.service;

import com.example.demo.entity.ChiTietSp;
import com.example.demo.entity.KhachHang;
import com.example.demo.entity.Nsx;
import com.example.demo.entity.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface SanPhamService {
    public List<SanPham> getAll();
    public SanPham findById(UUID id);
    void save(SanPham nsx);
    List<SanPham>listSearch(String ma,String ten);
    public ChiTietSp serachChiTietSp(UUID id);
    public Page<SanPham> getAllProducts(Pageable pageable) ;
    Page<SanPham> getAll(Pageable pageable);
    void delete(SanPham nsx);

}
