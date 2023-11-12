package com.example.demo.service.impl;

import com.example.demo.entity.MauSac;
import com.example.demo.entity.Nsx;
import com.example.demo.repository.MauSacRepository;
import com.example.demo.service.MauSacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class MauSacImpl implements MauSacService {
    @Autowired
    MauSacRepository repository;


    @Override
    public List<MauSac> getAll() {

        return repository.findAll();
    }

    @Override
    public MauSac findById(UUID id) {
        MauSac mauSac= repository.findById(id).get();
        return mauSac;
    }

    @Override
    public void save(MauSac nsx) {
        repository.save(nsx);


    }

    @Override
    public List<MauSac> listSearch(String ma, String ten) {
        List<MauSac> listSearch = new ArrayList<>();
        listSearch = repository.search(ma, ten);
        return listSearch;
    }

    @Override
    public Page<MauSac> getAll(Pageable pageable) {
        return repository.findAll(pageable);

    }

    @Override
    public void delete(MauSac nsx) {
        repository.delete(nsx);
    }
}
