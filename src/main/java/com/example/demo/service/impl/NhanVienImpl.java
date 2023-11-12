package com.example.demo.service.impl;

import com.example.demo.entity.MauSac;
import com.example.demo.entity.NhanVien;
import com.example.demo.repository.NhanVienRepository;
import com.example.demo.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Service
public class NhanVienImpl implements NhanVienService {
    @Autowired
    private NhanVienRepository repository;
    @Override
    public List<NhanVien> getAll() {
        return repository.findAll();
    }

    @Override
    public NhanVien findById(UUID id) {
        NhanVien mauSac= repository.findById(id).get();
        return mauSac;
    }

    @Override
    public void save(NhanVien nsx) {
        repository.save(nsx);
    }

    @Override
    public List<NhanVien> listSearch(String ma, String ten) {
        List<NhanVien> listSearch = new ArrayList<>();
        listSearch = repository.search(ma, ten);
        return listSearch;
    }

    @Override
    public void delete(NhanVien nsx) {
        repository.delete(nsx);
    }

    @Override
    public Page<NhanVien> getAll(Pageable pageable) {
        return repository.findAll(pageable);

    }
}
