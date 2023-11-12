package com.example.demo.repository;

import com.example.demo.entity.ChucVu;
import com.example.demo.entity.Nsx;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ChucVuRepository extends JpaRepository<ChucVu, UUID> {
    @Query(" select c from ChucVu c where c.ten like %?1%  or c.ma like %?2%")
    public List<ChucVu> search(String ma, String ten);
}
