package com.example.droolstut;

import com.example.droolstut.model.Customer;
import com.example.droolstut.model.Item;
import com.example.droolstut.model.Order;
import com.example.droolstut.model.OrderLine;
import org.kie.api.KieServices;
import org.kie.api.cdi.KSession;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.Instant;
import java.util.Collection;
import java.util.Date;

@Service
public class RuleExecutionService {

    private static final Logger logger = LoggerFactory.getLogger(RuleExecutionService.class);

    @Autowired
    private KieSession kieSession;

    @PostConstruct
    public void executeRules() {
        logger.info("Bootstrapping the Rule Engine ...");
        generateCoupon();
    }

    private void generateCoupon() {
        Item item = new Item("A", 123.0, 234.0);
        Item item2 = new Item("B", 123.0*2, 234.0*2);
        Item item3 = new Item("C", 123.0*6, 234.0*6);
        Item item4 = new Item("D", 123.0, 234.0);
        Item item5 = new Item("E", 123.0, 234.0);
        Item item6 = new Item("F", 123.0, 234.0);

        Customer customer = new Customer();
        customer.setCustomerId(1L);
        customer.setAge(23);
        customer.setName("Karthik");
        customer.setEmail("email");

        Order order = new Order();
        order.setOrderId(1L);
        order.setDate(Date.from(Instant.now()));
        order.setCustomer(customer);
        order.getOrderLines().add(new OrderLine(item, 1));
        order.getOrderLines().add(new OrderLine(item2, 1));
        order.getOrderLines().add(new OrderLine(item3, 1));
        order.getOrderLines().add(new OrderLine(item4, 1));
        order.getOrderLines().add(new OrderLine(item5, 1));
        order.getOrderLines().add(new OrderLine(item6, 1));


        logger.info("Item Category: {}", item.getCategory());

        kieSession.insert(item);
        kieSession.insert(item2);
        kieSession.insert(item3);
        kieSession.insert(item4);
        kieSession.insert(item5);
        kieSession.insert(item6);
        kieSession.insert(customer);
        kieSession.insert(order);

        int fired = kieSession.fireAllRules();
        Collection<FactHandle> factHandles = kieSession.getFactHandles();
        logger.info("Number of rules executed: {}", fired);

        logger.info("Item 1 Category: {}", item.getCategory());
        logger.info("Item 2 Category: {}", item2.getCategory());
        logger.info("Item 3 Category: {}", item3.getCategory());
        logger.info("Customer Category: {}", customer.getCategory());
    }

}
