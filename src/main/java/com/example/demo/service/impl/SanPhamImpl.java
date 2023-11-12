package com.example.demo.service.impl;

import com.example.demo.entity.ChiTietSp;
import com.example.demo.entity.Nsx;
import com.example.demo.entity.SanPham;
import com.example.demo.repository.SanPhamRepository;
import com.example.demo.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Service
public class SanPhamImpl implements SanPhamService {
    @Autowired
    private SanPhamRepository repository;
    @Override
    public List<SanPham> getAll() {
        return repository.findAll();
    }

    @Override
    public SanPham findById(UUID id) {
        SanPham nsx = repository.findById(id).get();
        return nsx;
    }

    @Override
    public void save(SanPham nsx) {
        repository.save(nsx);
    }

    @Override
    public List<SanPham> listSearch(String ma, String ten) {
        List<SanPham> listSearch = new ArrayList<>();
        listSearch = repository.search(ma, ten);
        return listSearch;
    }

    @Override
    public ChiTietSp serachChiTietSp(UUID id) {
        return repository.serachChiTietSp(id);
    }

    public Page<SanPham> getAllProducts(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Page<SanPham> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void delete(SanPham nsx) {
        repository.delete(nsx);
    }
}
