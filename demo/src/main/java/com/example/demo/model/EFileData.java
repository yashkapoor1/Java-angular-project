package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "e_file")
public class EFileData {

    @Id

        private int S_No;

    @Column(name = "Diary_No")
    private String diaryNumber;

    @Column(name = "Reg_No")
    private String regNo;

    @Column(name = "Title_Name")
    private String titleName;

    @Column(name = "State")
    private String stateName;

    @Column(name = "district")
    private String districtName;

    public EFileData() {
    }

    public int getSerialNumber() {
        return S_No;
    }

    public void setSerialNumber(int serialNumber) {
        this.S_No =serialNumber;
    }

    public String getDiaryNumber() {
        return diaryNumber;
    }

    public void setDiaryNumber(String diaryNumber) {
        this.diaryNumber = diaryNumber;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }
}