package com.example.demo.service;

import com.example.demo.entity.ChiTietSp;
import com.example.demo.entity.KhachHang;
import com.example.demo.entity.MauSac;
import com.example.demo.entity.Nsx;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface MauSacService {
    public List<MauSac> getAll();
    public MauSac findById(UUID id);
    void save(MauSac nsx);
    List<MauSac>listSearch(String ma,String ten);
    Page<MauSac> getAll(Pageable pageable);
    void delete(MauSac nsx);

}
