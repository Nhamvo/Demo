package com.example.demo.repository;

import com.example.demo.entity.NhanVien;
import com.example.demo.entity.Nsx;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface NhanVienRepository extends JpaRepository<NhanVien, UUID> {
    @Query(" select c from NhanVien c where c.ten like %?1%  or c.ma like %?2%")
    public List<NhanVien> search(String ma, String ten);
}
