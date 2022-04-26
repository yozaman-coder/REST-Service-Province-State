package com.example.model;

import javax.persistence.*;

@Entity
@Table(name = "provinces")
public class Province {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProvinceID", nullable = false)
    private Integer provinceID;

    @Column(name = "ProvinceCode", length = 32)
    private String provinceCode;

    @Column(name = "ProvinceName", length = 64)
    private String provinceName;

    public Integer getProvinceID() {
        return provinceID;
    }

    public void setProvinceID(Integer id) {
        this.provinceID = id;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

}