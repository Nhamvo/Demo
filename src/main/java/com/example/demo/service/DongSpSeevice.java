package com.example.demo.service;

import com.example.demo.entity.ChiTietSp;
import com.example.demo.entity.DongSp;
import com.example.demo.entity.KhachHang;
import com.example.demo.entity.MauSac;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface DongSpSeevice {
    public List<DongSp> getAll();
    public DongSp findById(UUID id);
    void save(DongSp nsx);
    List<DongSp>listSearch(String ma,String ten);
    Page<DongSp> getAll(Pageable pageable);
    void delete(DongSp nsx);

}
