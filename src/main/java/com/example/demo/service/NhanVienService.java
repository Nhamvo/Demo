package com.example.demo.service;

import com.example.demo.entity.ChiTietSp;
import com.example.demo.entity.KhachHang;
import com.example.demo.entity.MauSac;
import com.example.demo.entity.NhanVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface NhanVienService {
    public List<NhanVien> getAll();
    public NhanVien findById(UUID id);
    void save(NhanVien nsx);
    List<NhanVien>listSearch(String ma,String ten);
    void delete(NhanVien nsx);
    Page<NhanVien> getAll(Pageable pageable);

}
