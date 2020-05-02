package d2hSubscriberapp.tests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;

import d2hSubscriber.businessLogic.SubscriptionPack;
import junit.framework.TestCase;

public class SubscriptionPackTest extends TestCase {

	SubscriptionPack sp;

	@Before
	public void setUp() {

		sp = new SubscriptionPack();
	}

	public void testApp() {
		test1();
		test2();
	}

	public void test1() {
		HashMap<String, Integer> packsandRate = new HashMap<String, Integer>();
		// it should return all the Packs which are being offered to client, So list
		// Size should be greater than or equal to 1
		packsandRate = sp.getpackRate();
		Boolean b = false;
		if (!packsandRate.isEmpty() || packsandRate.size() >= 1) {
			b = true;
		}
		Assert.assertTrue(b);
	}

	public void test2() {
		HashMap<String, List<String>> lst = new HashMap<String, List<String>>();
		// it should return all the Packs and Associated Channels which are being
		// offered to client, So list Size should be greater than or equal to 1
		lst = sp.getPacks();
		Boolean b = false;
		if (lst.size() >= 1) {
			b = true;
		}
		Assert.assertTrue(b);
	}
}
