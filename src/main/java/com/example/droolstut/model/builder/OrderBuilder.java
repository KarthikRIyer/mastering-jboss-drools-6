package com.example.droolstut.model.builder;

import com.example.droolstut.model.Customer;
import com.example.droolstut.model.Order;
import com.example.droolstut.model.OrderState;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

public class OrderBuilder {

    private final Order instance;
    private Optional<OrderLineBuilder> orderLineBuilder = Optional.empty();

    public OrderBuilder(Customer customer) {
        this.instance = new Order();

        //default values for the new Order
        this.instance.setCustomer(customer);
        this.instance.setState(OrderState.PENDING);
        this.instance.setDate(new Date());
        this.instance.setItems(new ArrayList<>());

    }

    public OrderBuilder withSate(OrderState state){
        this.instance.setState(state);
        return this;
    }

    public OrderBuilder withDate(Date date){
        this.instance.setDate(date);
        return this;
    }

    public OrderLineBuilder newLine(){
        if (this.orderLineBuilder.isPresent()){
            this.instance.getOrderLines().add(this.orderLineBuilder.get().build());
        }
        this.orderLineBuilder = Optional.of(new OrderLineBuilder(this));
        return this.orderLineBuilder.get();
    }

    public Order build(){
        if (this.orderLineBuilder.isPresent()){
            this.instance.getOrderLines().add(this.orderLineBuilder.get().build());
        }
        return this.instance;
    }

    public OrderBuilder end(){
        return this;
    }
}
