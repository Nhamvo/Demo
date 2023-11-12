package com.example.demo.repository;

import com.example.demo.entity.KhachHang;
import com.example.demo.entity.MauSac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface KhachHangRepository extends JpaRepository<KhachHang, UUID> {
    @Query(" select c from KhachHang c where c.ten like %?1%  or c.ma like %?2% or c.sdt like %?3%")
    public List<KhachHang> search(String ma, String ten,String sdt);
}
