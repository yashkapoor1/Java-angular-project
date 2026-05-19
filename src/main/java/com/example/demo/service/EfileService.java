
package com.example.demo.service;

import com.example.demo.model.EFileData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




import java.util.List;

@Service
public class EfileService {

    @Autowired
    private com.example.demo.repository.EfileRepository efileRepository;

    public  List<EFileData> search(String keyword) {
        return efileRepository.searchAll(keyword);
    }

    public List<EFileData> getAllFiles() {
        return  efileRepository.findAll();

    }
}