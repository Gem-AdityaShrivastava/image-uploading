package com.example.imageuploading.services;


import com.example.imageuploading.entity.Student;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;
import java.util.stream.Stream;

@Component
public interface StudentServices {
    Student store (MultipartFile fie) throws IOException;

    Student getFile(UUID id);

    Stream<Student> getAllFiles();


    Student updateTheData(MultipartFile file, UUID id) throws IOException;

    void deleteById(UUID id);
}
