package com.example.demo.service;

import com.example.demo.model.EFileDirectory;
import org.antlr.v4.runtime.misc.Pair;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PdfSearchService {

    private static final String ROOT_DIR =
            System.getProperty("user.dir") + "/uploads";


    public List<EFileDirectory> searchPdf(String keyword) {

        List<EFileDirectory> results = new ArrayList<>();

        File root = new File(ROOT_DIR);

        searchRecursive(root, keyword.toLowerCase(), results);

        return results;
    }

    private void searchRecursive(File dir,
                                 String keyword,
                                 List<EFileDirectory> results) {

        File[] files = dir.listFiles();

        if (files == null) {
            return;
        }

        for (File file : files) {

            if (file.isDirectory()) {

                searchRecursive(file, keyword, results);

            } else {

                String name = file.getName().toLowerCase();

                if (name.endsWith(".pdf")
                        && name.contains(keyword)) {

                    //results.add(file.getName());
                    EFileDirectory eFileDirectory = new EFileDirectory();
                    eFileDirectory.setFileName(file.getName());
                    eFileDirectory.setFilePath(file.getAbsolutePath());
                    results.add(eFileDirectory);
                }
            }
        }
    }
}
