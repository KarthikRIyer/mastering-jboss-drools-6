package com.example.droolstut.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class OrderLine implements Serializable {

    private static final long serialVersionUID = 1L;

    private Item item;
    private Integer quantity;

}