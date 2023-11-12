package com.example.demo.service.impl;

import com.example.demo.entity.DongSp;
import com.example.demo.entity.KhachHang;
import com.example.demo.entity.NhanVien;
import com.example.demo.repository.KhachHangRepository;
import com.example.demo.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Service
public class KhachHangImpl implements KhachHangService {
    @Autowired
    private KhachHangRepository repository;
    @Override
    public List<KhachHang> getAll() {
        return repository.findAll();
    }

    @Override
    public KhachHang findById(UUID id) {
        KhachHang mauSac= repository.findById(id).get();
        return mauSac;
    }

    @Override
    public void save(KhachHang nsx) {
        repository.save(nsx);

    }

    @Override
    public List<KhachHang> listSearch(String ma, String ten,String sdt) {
        List<KhachHang> listSearch = new ArrayList<>();
        listSearch = repository.search(ma, ten,sdt);
        return listSearch;
    }

    @Override
    public void delete(KhachHang nsx) {
        repository.delete(nsx);
    }

    @Override
    public Page<KhachHang> getAll(Pageable pageable) {
        return repository.findAll(pageable);

    }

}
