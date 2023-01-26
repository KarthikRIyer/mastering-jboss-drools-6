package com.example.droolstut.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Coupon {

    public enum CouponType {
        DISCOUNT, TWOFORONE, POINTS
    };

    private Customer customer;
    private Order order;
    private CouponType type;
    private Date validFrom;
    private Date validUntil;

    public Coupon() {
    }

    public Coupon(Customer customer, Order order, CouponType type) {
        this.customer = customer;
        this.order = order;
        this.type = type;
    }





}