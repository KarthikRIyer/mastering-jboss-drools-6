package com.example.droolstut.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Discount implements Serializable {

    private static final long serialVersionUID = 1L;


    private Double percentage;


    public Discount() {
    }

    public Discount(Double percentage) {
        this.percentage = percentage;
    }
}
