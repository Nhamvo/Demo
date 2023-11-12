package com.example.demo.service;

import com.example.demo.entity.ChiTietSp;
import com.example.demo.entity.KhachHang;
import com.example.demo.entity.MauSac;
import com.example.demo.entity.NhanVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface KhachHangService {
    public List<KhachHang> getAll();
    public KhachHang findById(UUID id);
    void save(KhachHang nsx);
    List<KhachHang>listSearch(String ma,String ten,String sdt);
    void delete(KhachHang nsx);
    Page<KhachHang> getAll(Pageable pageable);

}
