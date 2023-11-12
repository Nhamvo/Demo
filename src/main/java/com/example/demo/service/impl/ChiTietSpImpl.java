package com.example.demo.service.impl;

import com.example.demo.entity.ChiTietSp;
import com.example.demo.entity.ChucVu;
import com.example.demo.repository.ChiTietSpRepository;
import com.example.demo.service.ChiTietSpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Service
public class ChiTietSpImpl implements ChiTietSpService {
@Autowired
private ChiTietSpRepository repository;

    @Override
    public List<ChiTietSp> getAll() {
        return repository.findAll();
    }

    @Override
    public ChiTietSp findById(UUID id) {
        ChiTietSp nsx = repository.findById(id).get();
        return nsx;
    }

    @Override
    public void save(ChiTietSp nsx) {
        repository.save(nsx);

    }

    @Override
    public boolean exitsById(UUID nsx) {
        return repository.existsById(nsx);
    }

    @Override
    public Page<ChiTietSp> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void delete(ChiTietSp nsx) {
        repository.delete(nsx);
    }


//    @Override
//    public List<ChiTietSp> listSearch(String ma, String ten) {
//        List<ChiTietSp> listSearch = new ArrayList<>();
//        listSearch=repository.search(ma,ten);
//        return listSearch;
//    }
}
