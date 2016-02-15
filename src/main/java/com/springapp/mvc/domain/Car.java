package com.springapp.mvc.domain;

import javax.persistence.*;

/**
 * Created by dn070290gsn on 23.06.2015.
 */
@Entity
@Table(name="cars")

public class Car {


    @Id
    @Column(name="id")
    @GeneratedValue
    private Integer id;

    @Column(name="mark")
    private String mark;

    @Column(name="model")
    private String model;

    public Integer getId() {
        return id;
    }

    public String getMark() {
        return mark;
    }

    public String getModel() {
        return model;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
