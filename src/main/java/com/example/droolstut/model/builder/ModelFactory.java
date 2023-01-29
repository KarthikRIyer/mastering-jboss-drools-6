package com.example.droolstut.model.builder;

import com.example.droolstut.model.*;
import com.example.droolstut.model.builder.OrderBuilder;

import java.time.Instant;
import java.util.Date;

public class ModelFactory {

    public static Order getOrderWithFiveHighRangeItems() {

        Order order = new Order();
        order.setOrderId(1L);
        order.setDate(Date.from(Instant.EPOCH));
        order.getOrderLines().add(new OrderLine(new Item("A", 600.0, 700.0), 1));
        order.getOrderLines().add(new OrderLine(new Item("B", 601.0, 701.0), 1));
        order.getOrderLines().add(new OrderLine(new Item("C", 602.0, 702.0), 1));
        order.getOrderLines().add(new OrderLine(new Item("D", 603.0, 703.0), 1));
        order.getOrderLines().add(new OrderLine(new Item("E", 604.0, 704.0), 1));
        order.setState(OrderState.PENDING);

        Customer customer = new Customer();
        customer.setCustomerId(1L);
        customer.setAge(40);
        customer.setName("John Doe");
        customer.setEmail("johndoe@example.com");

        order.setCustomer(customer);
        return order;
    }

//    public static Order getOrderWithFiveHighRangeItems() {
//
//        return new OrderBuilder(new Customer())
//                .newLine()
//                    .withItem()
//                        .withName("A")
//                        .withCost(700.0)
//                        .withSalePrice(800.0)
//                    .end()
//                    .withQuantity(1)
//                    .end()
//                .end()
//                .newLine()
//                    .withItem()
//                        .withName("B")
//                        .withCost(800.0)
//                        .withSalePrice(850.0)
//                    .end()
//                    .withQuantity(2)
//                    .end()
//                .end()
//                .newLine()
//                .withItem()
//                    .withName("C")
//                        .withCost(800.0)
//                        .withSalePrice(850.0)
//                    .end()
//                    .withQuantity(3)
//                    .end()
//                .end()
//                .newLine()
//                .withItem()
//                    .withName("D")
//                        .withCost(800.0)
//                        .withSalePrice(850.0)
//                    .end()
//                    .withQuantity(4)
//                    .end()
//                .end()
//                .newLine()
//                .withItem()
//                    .withName("E")
//                        .withCost(800.0)
//                        .withSalePrice(850.0)
//                    .end()
//                    .withQuantity(5)
//                    .end()
//                .end()
//                .build();
//    }

}
