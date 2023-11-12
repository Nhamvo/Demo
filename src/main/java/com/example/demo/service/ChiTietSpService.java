package com.example.demo.service;

import com.example.demo.entity.ChiTietSp;
import com.example.demo.entity.KhachHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface ChiTietSpService {
    public List<ChiTietSp> getAll();
    public ChiTietSp findById(UUID id);
    void save(ChiTietSp nsx);
    boolean exitsById(UUID nsx);
    Page<ChiTietSp> getAll(Pageable pageable);
    void delete(ChiTietSp nsx);

}
