package com.example.demo.repository;

import com.example.demo.entity.ChiTietSp;
import com.example.demo.entity.Nsx;
import com.example.demo.entity.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface SanPhamRepository extends JpaRepository<SanPham, UUID> {
    @Query(" select c from SanPham c where c.ten like %?1%  or c.ma like %?2%")
    public List<SanPham> search(String ma, String ten);

    @Query(" select c from ChiTietSp c where c.sanPham.id = ?1 ")
    public ChiTietSp serachChiTietSp(UUID id);

}
