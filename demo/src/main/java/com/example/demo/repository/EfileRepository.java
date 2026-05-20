package com.example.demo.repository;

import com.example.demo.model.EFileData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EfileRepository extends JpaRepository<EFileData, Long> {

    @Query("""
    SELECT e FROM EFileData e
    WHERE e.diaryNumber LIKE LOWER(CONCAT('%', :keyword, '%'))
            OR e.regNo LIKE LOWER(CONCAT('%', :keyword, '%'))
            OR e.titleName LIKE LOWER(CONCAT('%', :keyword, '%'))
            OR e.stateName LIKE LOWER(CONCAT('%', :keyword, '%'))
            OR e.districtName LIKE LOWER(CONCAT('%', :keyword, '%'))
            """)
    List<EFileData> searchAll(@Param("keyword") String keyword);
}