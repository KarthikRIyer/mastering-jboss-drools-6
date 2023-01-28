package com.example.droolstut;

import com.example.droolstut.model.Item;
import com.example.droolstut.util.Util;
import org.junit.jupiter.api.Test;
import org.kie.api.runtime.KieSession;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClassifyItemsTest {

	@Test
	void classifyItems() {
		KieSession kieSession = Util.getDefaultKieSession();
		Item item = new Item("A", 123.0, 234.0);
		kieSession.insert(item);
		int fired = kieSession.fireAllRules();
		assertEquals(1, fired);
		assertEquals(Item.Category.LOW_RANGE, item.getCategory());
	}

}
