package d2hSubscriberapp.tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import d2hSubscriber.businessLogic.SubscriptionAmountCalculator;
import junit.framework.TestCase;

public class SubscriptionAmountCalculatorTest{

	SubscriptionAmountCalculator sac;

	@Before
	public void setUp() {
		sac = new SubscriptionAmountCalculator();
	}

	@Test
	public void test1() {
		int Subscribtion_period = 3, monthlyrate = 500;
		// it should return 500*3 = 1500
		int amt = sac.calcPackAmount(Subscribtion_period, monthlyrate);
		assertEquals(1500, amt);
	}

	@Test
	public void test2() {
		int Subscribtion_period = 3, monthlyrate = 500;
		// it should return 500*3 = 1500 - 10% Discount. AmountafterDiscount = 1350
		int amt = sac.calcPackAmountAfterDiscount(Subscribtion_period, monthlyrate);
		assertEquals(1350, amt);
	}
}
