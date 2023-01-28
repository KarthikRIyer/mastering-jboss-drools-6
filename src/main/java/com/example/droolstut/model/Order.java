package com.example.droolstut.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long orderId;
    private Date date;
    private Customer customer;
    private List<OrderLine> orderLines = new ArrayList<>();
    private OrderState state;
    private Discount discount;

    public Order() {
    }

    public double getTotal() {
        return this.getOrderLines().stream()
                .mapToDouble(item -> item.getItem().getSalePrice() * item.getQuantity())
                .sum();
    }

    public int getTotalItems() {
        return this.getOrderLines().stream()
                .mapToInt(item -> item.getQuantity())
                .sum();
    }

    public void setItems(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    public void increaseDiscount(double increase) {
        if (discount == null) {
            discount = new Discount(0.0);
        }
        discount.setPercentage(discount.getPercentage() + increase);
    }
}
