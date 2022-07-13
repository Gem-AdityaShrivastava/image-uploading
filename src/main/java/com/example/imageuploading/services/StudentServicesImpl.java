package com.example.imageuploading.services;

import com.example.imageuploading.dao.StudentDao;
import com.example.imageuploading.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;
import java.util.stream.Stream;

@Service
public class StudentServicesImpl implements StudentServices {
    private static Logger Log = LoggerFactory.getLogger(StudentServices.class);

    @Autowired
    private StudentDao studentDao;

    @Override
    public Student store(MultipartFile file) throws IOException{

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Student student = new Student (fileName, file.getContentType(), file.getBytes());
        return studentDao.save(student);
    }

    @Override
    @Cacheable(cacheNames = "student" , key ="#id")
    public Student getFile(UUID id){
        Log.info("fetching from db");
        return studentDao.findById(id).get();
    }

    @Override
    public Stream<Student> getAllFiles(){
        Log.info("fetching from db");
        return studentDao.findAll().stream();}

    @Override
    @CachePut(cacheNames="student" , key="#id")
    public Student updateTheData(MultipartFile file, UUID id) throws IOException {

        Student s1 = studentDao.findById(id).get();

        s1.setName(file.getOriginalFilename());
        s1.setType(file.getContentType());
        s1.setData(file.getBytes());

        return studentDao.save(s1);
    }

    @Override
    @CacheEvict(cacheNames = "student" , key="#id", allEntries = true)
    public void deleteById(UUID id){
        studentDao.deleteById(id);

    }

//    @Scheduled(fixedDelay= 15000, initialDelay = 60000)
//    @CacheEvict(cacheNames = "student", key="#id", allEntries = true)
//    public void deleteCache(){
//        Log.info("Cache Deleted");
//
//    }





}
