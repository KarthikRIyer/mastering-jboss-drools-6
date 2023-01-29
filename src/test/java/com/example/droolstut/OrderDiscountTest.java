package com.example.droolstut;

import com.example.droolstut.model.*;
import com.example.droolstut.model.builder.ModelFactory;
import com.example.droolstut.util.Util;
import org.junit.jupiter.api.Test;
import org.kie.api.runtime.KieSession;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class OrderDiscountTest {

	@Test
	void orderDiscountTest() {
		KieSession kieSession = Util.getDefaultKieSession();
		Order o = ModelFactory.getOrderWithFiveHighRangeItems();

		kieSession.insert(o.getCustomer());
		kieSession.insert(o.getOrderLines().get(0));
		kieSession.insert(o.getOrderLines().get(1));
		kieSession.insert(o.getOrderLines().get(2));
		kieSession.insert(o.getOrderLines().get(3));
		kieSession.insert(o.getOrderLines().get(4));
		kieSession.insert(o.getOrderLines().get(0).getItem());
		kieSession.insert(o.getOrderLines().get(1).getItem());
		kieSession.insert(o.getOrderLines().get(2).getItem());
		kieSession.insert(o.getOrderLines().get(3).getItem());
		kieSession.insert(o.getOrderLines().get(4).getItem());
		kieSession.insert(o);

//		kieSession.getFactHandles().forEach(x -> System.out.println(x.toExternalForm()));

		int fired = kieSession.fireAllRules();

//		assertEquals(8, fired);
		assertEquals(Customer.Category.SILVER, o.getCustomer().getCategory());
		assertNotNull(o.getDiscount());
		assertEquals(10.0, o.getDiscount().getPercentage());
		assertEquals(Item.Category.HIGH_RANGE, o.getOrderLines().get(0).getItem().getCategory());
		assertEquals(Item.Category.HIGH_RANGE, o.getOrderLines().get(1).getItem().getCategory());
		assertEquals(Item.Category.HIGH_RANGE, o.getOrderLines().get(2).getItem().getCategory());
		assertEquals(Item.Category.HIGH_RANGE, o.getOrderLines().get(3).getItem().getCategory());
		assertEquals(Item.Category.HIGH_RANGE, o.getOrderLines().get(4).getItem().getCategory());

		Collection<Coupon> coupons = Util.getFactsFromSession(kieSession, Coupon.class);
		coupons.forEach(x -> System.out.println(x));
//		assertEquals(1, coupons.size());
	}

}
