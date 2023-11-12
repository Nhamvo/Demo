package com.example.demo.service.impl;

import com.example.demo.entity.ChucVu;
import com.example.demo.entity.Nsx;
import com.example.demo.repository.ChucVuRepository;
import com.example.demo.service.ChucVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ChucVuImpl implements ChucVuService {
    @Autowired
    private ChucVuRepository repository;

    @Override
    public List<ChucVu> getAll() {
        return repository.findAll();
    }

    @Override
    public ChucVu findById(UUID id) {
        ChucVu nsx = repository.findById(id).get();
        return nsx;
    }

    @Override
    public void save(ChucVu nsx) {
        repository.save(nsx);

    }

    @Override
    public List<ChucVu> listSearch(String ma, String ten) {
        List<ChucVu> listSearch = new ArrayList<>();
        listSearch=repository.search(ma,ten);
        return listSearch;
    }

    @Override
    public Page<ChucVu> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void delete(ChucVu nsx) {
        repository.delete(nsx);
    }
}
