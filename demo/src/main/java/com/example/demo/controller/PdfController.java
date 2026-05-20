package com.example.demo.controller;



import com.example.demo.model.EFileDirectory;
import com.example.demo.service.PdfSearchService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class PdfController {

    @Autowired
    private PdfSearchService service;

    @GetMapping("/search")
    public List<EFileDirectory> search(
            @RequestParam String keyword) {

        return service.searchPdf(keyword);
    }

    @GetMapping("/pdf")
    public ResponseEntity<InputStreamResource> viewPdf(
            @RequestParam String path)
            throws Exception {

        File file = new File(path);

        InputStreamResource resource =
                new InputStreamResource(
                        new FileInputStream(file));

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "inline; filename=" + file.getName())
                .contentType(MediaType.APPLICATION_PDF)
                .body(resource);
    }
}