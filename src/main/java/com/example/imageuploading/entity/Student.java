package com.example.imageuploading.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;


@Entity
@Table(name="files")
public class Student implements Serializable {


    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name="UUID" , strategy = "org.hibernate.id.UUIDGenerator")

    @Column(name="Student_Id" ,columnDefinition = "varchar(50)")
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID id ;

    private String name ;

    private String type;

    @Lob
    private  byte [] data ;

    public Student() {
    }

    public Student(String name, String type, byte[] data) {
        this.name = name;
        this.type = type;
        this.data = data;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
