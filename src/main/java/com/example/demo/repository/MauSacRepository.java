package com.example.demo.repository;

import com.example.demo.entity.ChucVu;
import com.example.demo.entity.MauSac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface MauSacRepository extends JpaRepository<MauSac, UUID> {
    @Query(" select c from MauSac c where c.ten like %?1%  or c.ma like %?2%")
    public List<MauSac> search(String ma, String ten);
}
