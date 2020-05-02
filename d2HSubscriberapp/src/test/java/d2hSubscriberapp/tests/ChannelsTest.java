package d2hSubscriberapp.tests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import d2hSubscriber.businessLogic.Channels;
import junit.framework.TestCase;

public class ChannelsTest{

	Channels ch;

	@Before
	public void setUp() {
		ch = new Channels();
	}

	@Test
	public void test1() {
		List<String> lst = new ArrayList<String>();
		// it should return all the Channels which are being offered to client, So list
		// Size should be greater than or equal to 1
		lst = ch.getChannels();
		Boolean b = false;
		if (lst.size() >= 1) {
			b = true;
		}
		Assert.assertTrue(b);
	}

	@Test
	public void test2() {
		HashMap<String, Integer> servicesandRate = new HashMap<String, Integer>();
		// it should return all the Channelswith rates which are being offered to client
		// Map Size should be greater than or equal to 1
		servicesandRate = ch.getChannelwithMonthlyrates();
		Boolean b = false;
		if (!servicesandRate.isEmpty() || servicesandRate.size() >= 1) {
			b = true;
		}
		Assert.assertTrue(b);
	}
}
