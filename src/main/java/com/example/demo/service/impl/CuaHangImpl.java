package com.example.demo.service.impl;

import com.example.demo.entity.ChucVu;
import com.example.demo.entity.CuaHang;
import com.example.demo.entity.DongSp;
import com.example.demo.repository.CuaHangRepository;
import com.example.demo.service.CuaHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Service
public class CuaHangImpl implements CuaHangService {
    @Autowired
    private CuaHangRepository repository;
    @Override
    public List<CuaHang> getAll() {
        return repository.findAll();
    }

    @Override
    public CuaHang findById(UUID id) {
        CuaHang nsx = repository.findById(id).get();
        return nsx;
    }

    @Override
    public void save(CuaHang nsx) {
        repository.save(nsx);
    }

    @Override
    public List<CuaHang> listSearch(String ma, String ten) {
        List<CuaHang> listSearch = new ArrayList<>();
        listSearch = repository.search(ma, ten);
        return listSearch;
    }

    @Override
    public Page<CuaHang> getAll(Pageable pageable) {
        return repository.findAll(pageable);

    }

    @Override
    public void delete(CuaHang nsx) {
        repository.delete(nsx);
    }
 
//    @Override
//    public Page<CuaHang> searchP(List<CuaHang> list, Pageable pageable) {
//        List<CuaHang> k = new
//        return searchP(list,pageable);
//    }

}
