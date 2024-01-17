package ng.edu.binghamuni.mypro3.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;


import java.util.List;

@Entity(name = "drink")

public class Drink {
//    @OneToMany

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id;
    private String studentName;
    @Column(name = "course", nullable = true)
    private String course;

    @Column(name = "location", nullable = true)
    private String location;
    @Column(name = "fee", nullable = true)
    private String fee;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Drink(Long id, String studentName, String course, String location, String fee) {
//        this.studentName = ingredient;
        this.studentName = studentName;
        this.course = course;
        this.location = location;
        this.fee = fee;

        this.id = id;

    }
    public Drink(){

    }


    // GETTER
    public String getName() {
        return studentName;
    }

    public String getCapacity() {

        return course;
    }
    public String getType() {

        return location;
    }

//
//    public String getColor() {
//        return color;
//    }
//
//    public String getType() {
//        return Type;
//    }
//
//    public String getCompany() {
//        return company;
//    }
//
//    //SETTER
    public void setName(String studentName) {
        this.studentName = studentName;
    }
//
    public void setCapacity(String course) {
        this.course = course;
    }
//
//    public void setColor(String color) {
//        this.color = color;
//    }
//
    public void setType(String location) {
        this.location = location;
    }
//
//    public void setCompany(String company) {
//        this.company = company;
//    }

    public String getPrice() {
        return fee;
    }

    public void setPrice(String fee) {
        this.fee = fee;
    }

    }

