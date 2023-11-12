package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Table(name = "NhanVien")
public class NhanVien {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;


    @NotBlank(message = "Không được để trống")
    @Column(name = "Ma")
    private String ma;

    @NotBlank(message = "Không được để trống")
    @Column(name = "Ten")
    private String ten;

    @NotBlank(message = "Không được để trống")
    @Column(name = "TenDem")
    private String tenDem;

    @NotBlank(message = "Không được để trống")
    @Column(name = "Ho")
    private String ho;

    @Column(name = "GioiTinh")
    private Boolean gioiTinh;

    @NotBlank(message = "Không được để trống")
    @Column(name = "NgaySinh")
    private String ngaySinh;

    @NotBlank(message = "Không được để trống")
    @Column(name = "DiaChi")
    private String diaChi;

    @NotBlank(message = "Không được để trống")
    @Column(name = "Sdt")
    private String sdt;

    @NotBlank(message = "Không được để trống")
    @Column(name = "MatKhau")
    private String matKhau;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdCH",referencedColumnName = "id")
    private CuaHang cuaHang;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdCV",referencedColumnName = "id")
    private ChucVu chucVu;

    @Column(name = "TrangThai")
    private int trangThai;


}
