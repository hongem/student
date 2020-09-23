package com.example.demo.model;
import javax.persistence.*;

@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name_dept")
    private String name_dept;

    public int getId() {
        return id;
    }

    public int setId(int id) {
        this.id = id;
        return id;
    }

    public String getName_dept() {
        return name_dept;
    }

    public void setName_dept(String name_dept) {
        this.name_dept = name_dept;
    }
}
