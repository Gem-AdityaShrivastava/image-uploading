package com.example.imageuploading.controller;


import com.example.imageuploading.entity.ResponseMessage;
import com.example.imageuploading.entity.Student;
import com.example.imageuploading.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@RestController
public class StudentController {

    @Autowired
    private StudentServices studentServices;


    @PostMapping("/upload")
    public ResponseEntity uploadFile(@RequestParam("file") MultipartFile file){

        String mess ="";
        try {
            studentServices.store(file);
            mess = "Upload the File Successfully:" + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(mess);

        }catch(Exception e){

            mess = "Coud not upload File :" + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(mess);

        }
    }



    @GetMapping("/files")
    public ResponseEntity<List<ResponseMessage>> getListFiles(){

        List<ResponseMessage> files = studentServices.getAllFiles().map(dbFile->{
            String fileDownloadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/files/")
                    .path((dbFile.getId()).toString())
                    .toUriString();
            return new ResponseMessage(
                    dbFile.getName(),
                    fileDownloadUri,
                    dbFile.getType(),
                    dbFile.getData().length);
        }).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(files);
    }

    @GetMapping("/files/{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable UUID id) {
        Student student = studentServices.getFile(id);
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(student.getType())).body(student.getData());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateTheData(@RequestParam("file") MultipartFile file, @PathVariable UUID id) throws IOException {

        Student studentUpdate = studentServices.updateTheData(file , id);
        return ResponseEntity.accepted().contentType(MediaType.parseMediaType(studentUpdate.getType())).body(studentUpdate.getData());

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteData(@PathVariable  UUID id){
        studentServices.deleteById(id);
        return ResponseEntity.accepted().build();
    }
}
