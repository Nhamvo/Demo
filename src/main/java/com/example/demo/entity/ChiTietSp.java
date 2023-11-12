package com.example.demo.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Table(name = "ChiTietSP")
public class ChiTietSp {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @OneToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "IdSP", referencedColumnName = "id")
    private SanPham sanPham;

    @ManyToOne(fetch =FetchType.LAZY )
    @JoinColumn(name = "IdNsx",referencedColumnName = "id")
    private Nsx nsx;

    @ManyToOne(fetch =FetchType.LAZY )
    @JoinColumn(name = "IdMauSac",referencedColumnName = "id")
    private MauSac mauSac;

    @ManyToOne(fetch =FetchType.LAZY )
    @JoinColumn(name = "IdDongSp",referencedColumnName = "id")
    private DongSp dongSp;

    @NotNull(message = "khong duoc de trong")
    @Column(name = "NamBH")
    private Integer namBh;

    @NotBlank(message = "khong duoc de trong")
    @Column(name = "MoTa")
    private String moTa;

    @NotNull(message = "khong duoc de trong")
    @Column(name = "SoLuongTon")
    private Integer soLuongTon;

    @NotNull(message = "khong duoc de trong")
    @Column(name ="GiaNhap")
    private Float giaNhap;

    @NotNull(message = "khong duoc de trong")
    @Column(name = "GiaBan")
    private Float giaBan;

 private String hinhAnh;

}
