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
public class Customer implements Serializable {

    public enum Category {
        NA, GOLD, SILVER, BRONZE
    };
    private static final long serialVersionUID = 1L;

    private Long customerId;
    private Integer age;
    private String name;
    private String email;
    private Category category = Category.NA;

    public Customer() {
    }
}