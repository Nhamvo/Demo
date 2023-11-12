package com.example.demo.repository;

import com.example.demo.entity.ChiTietSp;
import com.example.demo.entity.ChucVu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ChiTietSpRepository extends JpaRepository<ChiTietSp, UUID> {
//    @Query(" select c from ChiTietSp c where c.giaBan =?1 ")
//    public List<ChiTietSp> search(Float giaBan);
    @Query("select c from ChiTietSp c where c.dongSp.id =?1")
    public List<ChiTietSp> search(UUID id);
}
