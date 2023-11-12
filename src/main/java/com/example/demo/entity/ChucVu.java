package com.example.demo.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Table(name = "ChucVu")

public class ChucVu {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private UUID id;

    @NotBlank(message = "Không được để trống")
    @Column(name = "Ma")
    private String ma;

    @NotBlank(message = "Không được để trống")
    @Column(name = "Ten")
    private String ten;


//    @OneToMany(mappedBy = "chucVu", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<NhanVien> list;

//    @OneToMany(fetch = FetchType.LAZY)
//    private List<NhanVien>listNv;


}
