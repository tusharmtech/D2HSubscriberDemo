package d2hSubscriber.businessLogic;

import java.util.HashMap;
import java.util.List;

public class SubscriptionPack {

	Channels ch;
	List<String> Goldchannels;
	List<String> SilverChannels;
	HashMap<String, List<String>> subPacks = new HashMap<String, List<String>>();
	HashMap<String, Integer> subsPackMonthlyRates = new HashMap<String, Integer>();
	private static int  GoldRate = 100 , SilverRate = 50;
	// add Default Pack
	public SubscriptionPack() {
		ch = new Channels();
		Goldchannels = ch.getGoldPackchannels();
		SilverChannels = ch.getSilverPackchannels();
		subPacks.put("Gold", Goldchannels);
		subPacks.put("Silver", SilverChannels);
		subsPackMonthlyRates.put("Gold", GoldRate);
		subsPackMonthlyRates.put("Silver", SilverRate);
	}

	public HashMap<String, List<String>> getPacks() {
		return subPacks;
	}

	public HashMap<String, Integer> getpackRate() {
		return subsPackMonthlyRates;
	}

	public void displayPack() {
		System.out.println("Packs are:" + getPacks().toString());
	}
}
