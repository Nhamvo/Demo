package com.example.demo.service.impl;

import com.example.demo.entity.DongSp;
import com.example.demo.entity.MauSac;
import com.example.demo.repository.DongSpRepository;
import com.example.demo.service.DongSpSeevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Service
public class DongSpImpl implements DongSpSeevice {
    @Autowired
    private DongSpRepository repository;
    @Override
    public List<DongSp> getAll() {
        return repository.findAll();
    }

    @Override
    public DongSp findById(UUID id) {
        DongSp mauSac= repository.findById(id).get();
        return mauSac;
    }

    @Override
    public void save(DongSp nsx) {
        repository.save(nsx);
    }

    @Override
    public List<DongSp> listSearch(String ma, String ten) {
        List<DongSp> listSearch = new ArrayList<>();
        listSearch = repository.search(ma, ten);
        return listSearch;
    }

    @Override
    public Page<DongSp> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void delete(DongSp nsx) {
        repository.delete(nsx);
    }
}
