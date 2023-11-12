package com.example.demo.repository;

import com.example.demo.entity.CuaHang;
import com.example.demo.entity.DongSp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface CuaHangRepository extends JpaRepository<CuaHang, UUID> {
    @Query(" select c from CuaHang c where c.ten like %?1%  or c.ma like %?2%")
    public List<CuaHang> search(String ma, String ten);
}
