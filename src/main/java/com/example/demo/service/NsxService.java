package com.example.demo.service;

import com.example.demo.entity.ChiTietSp;
import com.example.demo.entity.KhachHang;
import com.example.demo.entity.Nsx;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface NsxService {
    public List<Nsx>getAll();
    public Nsx findById(UUID id);
    void save(Nsx nsx);
    List<Nsx>listSearch(String ma,String ten);
    Page<Nsx> getAll(Pageable pageable);
    void delete(Nsx nsx);

}
