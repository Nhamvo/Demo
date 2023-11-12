package com.example.demo.service;

import com.example.demo.entity.ChiTietSp;
import com.example.demo.entity.ChucVu;
import com.example.demo.entity.KhachHang;
import com.example.demo.entity.Nsx;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface ChucVuService {
    public List<ChucVu> getAll();
    public ChucVu findById(UUID id);
    void save(ChucVu nsx);
    List<ChucVu>listSearch(String ma,String ten);
    Page<ChucVu> getAll(Pageable pageable);
    void delete(ChucVu nsx);
    //iudyfiuydhfiuyf
 }
