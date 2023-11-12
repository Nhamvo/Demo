package com.example.demo.service.impl;

import com.example.demo.entity.Nsx;
import com.example.demo.repository.NsxRepository;
import com.example.demo.service.NsxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class NsxImpl implements NsxService {
    @Autowired
    private NsxRepository repository;

    @Override
    public List<Nsx> getAll() {

        return repository.findAll();
    }

    @Override
    public Nsx findById(UUID id) {
        Nsx nsx = repository.findById(id).get();
        return nsx;
    }

    @Override
    public void save(Nsx nsx) {
        repository.save(nsx);

    }

    @Override
    public List<Nsx> listSearch( String ma,String ten) {
        List<Nsx> listSearch = new ArrayList<>();
        listSearch = repository.search(ma, ten);
        return listSearch;
    }

    @Override
    public Page<Nsx> getAll(Pageable pageable) {
        return repository.findAll(pageable);

    }

    @Override
    public void delete(Nsx nsx) {
        repository.delete(nsx);
    }
}
