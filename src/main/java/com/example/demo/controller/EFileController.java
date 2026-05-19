package com.example.demo.controller;

import com.example.demo.model.EFileData;
import com.example.demo.service.EfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/efile")
@CrossOrigin(origins = "http://localhost:8085")
public class EFileController {

    @Autowired
    private EfileService efileService;

    @GetMapping("/all")
    public List<EFileData> getAllFiles() {
        return efileService.getAllFiles();
    }

    @GetMapping("/search")
    public List<EFileData> search(@RequestParam String keyword) {
        return efileService.search(keyword);
    }
}