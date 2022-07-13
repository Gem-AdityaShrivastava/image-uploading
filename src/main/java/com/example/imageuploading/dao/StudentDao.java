package com.example.imageuploading.dao;

import com.example.imageuploading.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StudentDao extends JpaRepository <Student, UUID> {



}
