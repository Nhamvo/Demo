package com.example.demo.repository;

import com.example.demo.entity.DongSp;
import com.example.demo.entity.MauSac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface DongSpRepository extends JpaRepository<DongSp, UUID> {
    @Query(" select c from DongSp c where c.ten like %?1%  or c.ma like %?2%")
    public List<DongSp> search(String ma, String ten);
}
