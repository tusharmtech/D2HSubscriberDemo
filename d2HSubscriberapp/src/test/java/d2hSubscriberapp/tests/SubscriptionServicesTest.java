package d2hSubscriberapp.tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;

import d2hSubscriber.businessLogic.SubscriptionServices;
import junit.framework.TestCase;

public class SubscriptionServicesTest extends TestCase {

	SubscriptionServices ss;

	@Before
	public void setUp() {
		ss = new SubscriptionServices();
	}

	public void testApp() {
		test1();
		test2();
	}

	public void test1() {
		List<String> lst = new ArrayList<String>();
		// it should return all the Services which are being offered to client, So list
		// Size should be greater than or equal to 1
		lst = ss.getServices();
		Boolean b = false;
		if (lst.size() >= 1) {
			b = true;
		}
		Assert.assertTrue(b);
	}

	public void test2() {
		HashMap<String, Integer> servicesandRate = new HashMap<String, Integer>();
		// it should return all the Services which are being offered to client, So list
		// Size should be greater than or equal to 1
		servicesandRate = ss.getServiceswithMonthlyrates();
		Boolean b = false;
		if (!servicesandRate.isEmpty() || servicesandRate.size() >= 1) {
			b = true;
		}
		Assert.assertTrue(b);
	}
}
