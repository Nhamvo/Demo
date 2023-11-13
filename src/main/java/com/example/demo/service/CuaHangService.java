package com.example.demo.service;

import com.example.demo.entity.ChiTietSp;
import com.example.demo.entity.ChucVu;
import com.example.demo.entity.CuaHang;
import com.example.demo.entity.DongSp;
import com.example.demo.entity.KhachHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface CuaHangService {
    public List<CuaHang> getAll();
    public CuaHang findById(UUID id);
    void save(CuaHang nsx);
    List<CuaHang>listSearch(String ma,String ten);
    Page<CuaHang> getAll(Pageable pageable);
    void delete(CuaHang nsx);
//    Page<CuaHang> searchP( List<CuaHang> l,Pageable pageable);

}

